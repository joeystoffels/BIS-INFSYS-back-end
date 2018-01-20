--USE GAMEPARADISE

-- Master view:
-- 8A: Klanten overzicht.
CREATE VIEW OPDRACHT_8A AS
  SELECT *
  FROM KLANT;
GO


-- Detail view:
-- 8B: Huurhistorie van de klant.
CREATE VIEW OPDRACHT_8B AS
  SELECT
    K.EMAILADRES,
    HO.STARTDATUM,
    A.BARCODE,
    (CONVERT(INT, HO.EINDDATUM - HO.STARTDATUM) * A.PRIJS_PER_D) AS 'BEDRAG'
  FROM
    ARTIKELENVERHUUR AV
    INNER JOIN ARTIKEL A ON A.BARCODE = AV.BARCODE
    INNER JOIN KLANT K ON K.EMAILADRES = AV.EMAILADRES AND K.EMAILADRES = AV.EMAILADRES
    INNER JOIN HUUROVEREENKOMST HO ON HO.EMAILADRES = AV.EMAILADRES AND HO.STARTDATUM = AV.STARTDATUM
  WHERE HO.HUURSTATUS = 'VERHUURD';
GO


-- 8C: Koophistorie van de klant
CREATE VIEW OPDRACHT_8C AS
  SELECT
    K.EMAILADRES,
    VO.DATUM,
    A.BARCODE,
    A.PRIJS AS 'BEDRAG'
  FROM
    ARTIKELENVERKOOP AK
    INNER JOIN ARTIKEL A ON A.BARCODE = AK.BARCODE
    INNER JOIN KLANT K ON K.EMAILADRES = AK.EMAILADRES AND K.EMAILADRES = AK.EMAILADRES
    INNER JOIN VERKOOPOVEREENKOMST VO ON VO.EMAILADRES = AK.EMAILADRES AND VO.DATUM = AK.DATUM;
GO


-- 8D: Omzet van de klant per jaar.
-- User Defined Function for omzetPerJaar
-- Remove old function: DROP FUNCTION omzetPerJaar
-- Remove old view: DROP VIEW OPDRACHT_8D
-- Test: SELECT * FROM omzetPerJaar (2015)
CREATE FUNCTION omzetPerJaar(@input INT)
  RETURNS @returnTable TABLE
  (
    EMAILADRES    VARCHAR(100) NOT NULL,
    OMZET_VERHUUR SMALLMONEY            DEFAULT 0,
    OMZET_VERKOOP SMALLMONEY            DEFAULT 0,
    OMZET         INT          NOT NULL DEFAULT 0
  )
AS
  BEGIN
    DECLARE @tempTable TABLE
    (
      EMAILADRES    VARCHAR(100) NOT NULL,
      OMZET_VERHUUR SMALLMONEY            DEFAULT 0,
      OMZET_VERKOOP SMALLMONEY            DEFAULT 0,
      OMZET         SMALLMONEY   NOT NULL DEFAULT 0
    )

    INSERT INTO @returnTable
      SELECT
        (CASE
         WHEN VERKOOP.EMAILADRES IS NULL
           THEN VERHUUR.EMAILADRES
         ELSE VERKOOP.EMAILADRES
         END)                                                                 AS 'EMAILADRES',
        ISNULL(VERHUUR.OMZET_VERHUUR, 0)                                      AS 'OMZET_VERHUUR',
        ISNULL(VERKOOP.OMZET_VERKOOP, 0)                                      AS 'OMZER_VERKOOP',
        (ISNULL(VERHUUR.OMZET_VERHUUR, 0) + ISNULL(VERKOOP.OMZET_VERKOOP, 0)) AS 'TOTAAL'
      FROM
        (SELECT
           B.EMAILADRES,
           SUM(B.BEDRAG) AS OMZET_VERHUUR
         FROM
           OPDRACHT_8B B
         WHERE YEAR(B.STARTDATUM) = @input
         GROUP BY B.EMAILADRES) AS VERHUUR
        FULL JOIN
        (SELECT
           C.EMAILADRES,
           SUM(C.BEDRAG) AS OMZET_VERKOOP
         FROM
           OPDRACHT_8C C
         WHERE YEAR(C.DATUM) = @input
         GROUP BY C.EMAILADRES) AS VERKOOP ON VERHUUR.EMAILADRES = VERKOOP.EMAILADRES;
    RETURN
  END
GO

-- Create omzetPerJaar view
CREATE VIEW OPDRACHT_8D AS
  SELECT
    (CASE
     WHEN A.EMAILADRES IS NULL
       THEN CASE
            WHEN B.EMAILADRES IS NULL
              THEN CASE
                   WHEN C.EMAILADRES IS NULL
                     THEN CASE
                          WHEN D.EMAILADRES IS NULL
                            THEN 'ERROR'
                          ELSE D.EMAILADRES
                          END
                   ELSE C.EMAILADRES
                   END
            ELSE B.EMAILADRES
            END
     ELSE A.EMAILADRES
     END)                                                                               AS 'EMAILADRES',
    --ISNULL(A.OMZET_VERHUUR, 0) AS 'VERHUUR_2014',
    --ISNULL(A.OMZET_VERKOOP, 0) AS 'VERKOOP_2014',
    ISNULL(A.OMZET, 0)                                                                  AS 'OMZET_2014',
    --ISNULL(B.OMZET_VERHUUR, 0) AS 'VERHUUR_2015',
    --ISNULL(B.OMZET_VERKOOP, 0) AS 'VERKOOP_2015',
    ISNULL(B.OMZET, 0)                                                                  AS 'OMZET_2015',
    --ISNULL(C.OMZET_VERHUUR, 0) AS 'VERHUUR_2016',
    --ISNULL(C.OMZET_VERKOOP, 0) AS 'VERKOOP_2016',
    ISNULL(C.OMZET, 0)                                                                  AS 'OMZET_2016',
    --ISNULL(D.OMZET_VERHUUR, 0) AS 'VERHUUR_2017',
    --ISNULL(D.OMZET_VERKOOP, 0) AS 'VERKOOP_2017',
    ISNULL(D.OMZET, 0)                                                                  AS 'OMZET_2017',
    (ISNULL(A.OMZET, 0) + ISNULL(B.OMZET, 0) + ISNULL(C.OMZET, 0) + ISNULL(D.OMZET, 0)) AS 'TOTALE_OMZET'
  FROM omzetPerJaar(2014) AS A
    FULL JOIN (SELECT *
               FROM omzetPerJaar(2015)) AS B ON A.EMAILADRES = B.EMAILADRES
    FULL JOIN (SELECT *
               FROM omzetPerJaar(2016)) AS C ON B.EMAILADRES = C.EMAILADRES OR A.EMAILADRES = C.EMAILADRES
    FULL JOIN (SELECT *
               FROM omzetPerJaar(2017)) AS D
      ON C.EMAILADRES = D.EMAILADRES OR B.EMAILADRES = D.EMAILADRES OR A.EMAILADRES = D.EMAILADRES;
GO


-- 8E: Klantstatus van de klant.
-- Klant is goud bij omzet van >500, zilver bij >250 en brons bij >100
-- CASUS: Op basis daarvan krijgt een klant een status van Gold, Silver of Bronze.
-- Het totaal bestede bedrag over de afgelopen 12 maanden is hiervoor bepalend:
-- Gold klanten hebben 150 euro besteed, Silver 100 en Bronze 50.
CREATE VIEW OPDRACHT_8E_HELPER AS
  SELECT
    K.EMAILADRES,
    (CASE
     WHEN ISNULL(X.OMZET, 0) < 150
       THEN CASE
            WHEN ISNULL(X.OMZET, 0) < 100
              THEN CASE
                   WHEN ISNULL(X.OMZET, 0) < 50
                     THEN 'BASIS'
                   ELSE 'BRONS'
                   END
            ELSE 'ZILVER'
            END
     ELSE 'GOUD'
     END)              AS 'STATUS',
    ISNULL(X.OMZET, 0) AS 'OMZET'
  FROM
    (SELECT
       (CASE
        WHEN VERKOOP.EMAILADRES IS NULL
          THEN VERHUUR.EMAILADRES
        ELSE VERKOOP.EMAILADRES
        END)                                                                 AS 'EMAILADRES',
       ISNULL(VERHUUR.OMZET_VERHUUR, 0)                                      AS 'OMZET_VERHUUR',
       ISNULL(VERKOOP.OMZET_VERKOOP, 0)                                      AS 'OMZER_VERKOOP',
       (ISNULL(VERHUUR.OMZET_VERHUUR, 0) + ISNULL(VERKOOP.OMZET_VERKOOP, 0)) AS 'OMZET'
     FROM
       (SELECT
          B.EMAILADRES,
          SUM(B.BEDRAG) AS OMZET_VERHUUR
        FROM
          OPDRACHT_8B B
        WHERE DATEDIFF(MONTH, B.STARTDATUM, GETDATE()) <= 12
        GROUP BY B.EMAILADRES) AS VERHUUR
       FULL JOIN
       (SELECT
          C.EMAILADRES,
          SUM(C.BEDRAG) AS OMZET_VERKOOP
        FROM
          OPDRACHT_8C C
        WHERE DATEDIFF(MONTH, C.DATUM, GETDATE()) <= 12
        GROUP BY C.EMAILADRES) AS VERKOOP ON VERHUUR.EMAILADRES = VERKOOP.EMAILADRES) AS X
    RIGHT JOIN KLANT K ON X.EMAILADRES = K.EMAILADRES;
GO

CREATE VIEW OPDRACHT_8E AS
  SELECT
    EMAILADRES,
    STATUS
  FROM OPDRACHT_8E_HELPER;
GO
