-- Opdracht 9: Bouw Rapporten in Access (INDIVIDUEEL!).

USE GAMEPARADISE

DROP VIEW IF EXISTS dbo.Opdr9A_OverzichtMomenteelVerhuurd;
DROP VIEW IF EXISTS dbo.Opdr9B_NietVerhuurdIn2016;
DROP VIEW IF EXISTS dbo.Opdr9C_OmzettenVanIedereMaand2012Tot2017;
DROP VIEW IF EXISTS dbo.Opdr9D_Top10PopulairsteSpellen;
DROP VIEW IF EXISTS dbo.Opdr9E_ConsolesDieInReparatieStaan;
DROP VIEW IF EXISTS dbo.Opdr9F_OmzettenPerKlantInEenJaar;
DROP VIEW IF EXISTS dbo.Opdr9G_Inkoophoeveelheid;
GO

-- A. Overzicht van artikelen die momenteel verhuurd zijn.
CREATE VIEW Opdr9A_OverzichtMomenteelVerhuurd AS
  SELECT
    A.BARCODE,
    A.MERK,
    A.TYPE,
    A.TITEL,
    A.PRIJS,
    A.PRIJS_PER_D,
    A.SPEL_OF_CONSOLE,
    A.JAAR_UITGAVE,
    A.UITGEVER
  FROM HUUROVEREENKOMST AS HO
    INNER JOIN ARTIKELENVERHUUR AS AV ON (HO.STARTDATUM = AV.STARTDATUM AND HO.EMAILADRES = AV.EMAILADRES)
    INNER JOIN ARTIKEL AS A ON AV.BARCODE = A.BARCODE
  WHERE HO.STARTDATUM <= GETDATE() AND HO.EINDDATUM >= GETDATE() AND HO.HUURSTATUS = 'VERHUURD';
GO

-- B. Lijst met Spellen die niet verhuurd zijn in 2016.
-- Wat is de definitie van verhuurd, en artikelen of spellen ?
CREATE VIEW Opdr9B_NietVerhuurdIn2016 AS
  SELECT
    A.TITEL,
    A.UITGEVER,
    A.JAAR_UITGAVE
  FROM ARTIKEL AS A
  WHERE A.SPEL_OF_CONSOLE = 'SPEL' AND A.TITEL + A.UITGEVER + STR(A.JAAR_UITGAVE) NOT IN (
    SELECT A.TITEL + A.UITGEVER + STR(A.JAAR_UITGAVE)
    FROM ARTIKEL AS A
      LEFT JOIN ARTIKELENVERHUUR AS AV ON A.BARCODE = AV.BARCODE
    WHERE (A.SPEL_OF_CONSOLE = 'SPEL' AND YEAR(AV.STARTDATUM) = 2016)
  )
  GROUP BY A.TITEL, A.UITGEVER, A.JAAR_UITGAVE
GO

-- C. Omzetten van iedere maand van de jaren 2012 tot en met 2017.
CREATE VIEW Opdr9C_OmzettenVanIedereMaand2012Tot2017 AS
  SELECT
    MAAND,
    JAAR,
    SUM(OMZET) AS 'OMZET'
  FROM (
         -- Omzetten van maand/jaar van verhuur
         SELECT
           MONTH(HO.STARTDATUM) AS 'MAAND',
           YEAR(HO.STARTDATUM)  AS 'JAAR',
           (SELECT SUM(DATEDIFF(D, HO1.STARTDATUM, HO1.EINDDATUM) * A.PRIJS_PER_D)
            FROM HUUROVEREENKOMST AS HO1
              LEFT JOIN ARTIKELENVERHUUR AS AVR ON HO1.EMAILADRES = AVR.EMAILADRES AND HO1.STARTDATUM = AVR.STARTDATUM
              LEFT JOIN ARTIKEL A ON AVR.BARCODE = A.BARCODE
            WHERE MONTH(HO1.STARTDATUM) = MONTH(HO.STARTDATUM)
                  AND YEAR(HO1.STARTDATUM) = YEAR(HO.STARTDATUM)
           )                    AS 'OMZET'
         FROM HUUROVEREENKOMST AS HO
           LEFT JOIN ARTIKELENVERHUUR AS AVR ON HO.EMAILADRES = AVR.EMAILADRES AND HO.STARTDATUM = AVR.STARTDATUM
           LEFT JOIN ARTIKEL A ON AVR.BARCODE = A.BARCODE
         GROUP BY MONTH(HO.STARTDATUM), YEAR(HO.STARTDATUM)
         UNION ALL
         -- Omzetten van maand/jaar van verkoop
         SELECT
           MONTH(VO.DATUM) AS 'MAAND',
           YEAR(VO.DATUM)  AS 'JAAR',
           (SELECT SUM(A.PRIJS)
            FROM VERKOOPOVEREENKOMST AS VO1
              LEFT JOIN ARTIKELENVERKOOP AS AV ON VO1.EMAILADRES = AV.EMAILADRES AND VO1.DATUM = AV.DATUM
              LEFT JOIN ARTIKEL AS A ON AV.BARCODE = A.BARCODE
            WHERE MONTH(VO.DATUM) = MONTH(VO1.DATUM)
                  AND YEAR(VO.DATUM) = YEAR(VO1.DATUM)
           )               AS 'OMZET'
         FROM VERKOOPOVEREENKOMST AS VO
           LEFT JOIN ARTIKELENVERKOOP AS AV ON VO.EMAILADRES = AV.EMAILADRES AND VO.DATUM = AV.DATUM
           LEFT JOIN ARTIKEL AS A ON AV.BARCODE = A.BARCODE
         GROUP BY MONTH(VO.DATUM), YEAR(VO.DATUM)
         UNION ALL
         -- Omzetten van maand/jaar van reparatie
         SELECT
           MONTH(R.STARTDATUM) AS 'MAAND',
           YEAR(R.STARTDATUM)  AS 'JAAR',
           (SELECT SUM(R1.KOSTEN)
            FROM REPARATIE AS R1
              INNER JOIN ARTIKELENVERHUUR AS AV1 ON R1.BARCODE = AV1.BARCODE AND R1.STARTDATUM = AV1.STARTDATUM
            WHERE MONTH(R.STARTDATUM) = MONTH(R1.STARTDATUM)
                  AND YEAR(R.STARTDATUM) = YEAR(R1.STARTDATUM)
           )                   AS 'OMZET'
         FROM REPARATIE AS R
           LEFT JOIN ARTIKELENVERHUUR AS AV ON R.BARCODE = AV.BARCODE AND R.STARTDATUM = AV.STARTDATUM) AS TABEL
  GROUP BY MAAND, JAAR
  HAVING JAAR >= 2012 AND JAAR <= 2017;
GO






--
--   SELECT
--     -- Verkoop: Tel alle prijzen bij elkaar op, wanneer er een datum van verkoopovereenkomst is.
--     SUM(CASE WHEN VO.DATUM IS NOT NULL
--       THEN A.PRIJS
--         ELSE 0 END)
--     +
--     -- Vehuur: Tel alle dagen x verhuurprijs voor wanneer de status op verhuur staat.
--     SUM(CASE WHEN HO.HUURSTATUS = 'VERHUURD'
--       THEN DATEDIFF(D, HO.STARTDATUM, HO.EINDDATUM) * A.PRIJS_PER_D
--         ELSE 0 END)
--     +
--     -- Reparatie: Alle omzet gemaakt bij reparatie
--     SUM(CASE WHEN R.KOSTEN IS NOT NULL
--       THEN R.KOSTEN
--         ELSE 0 END)
--       AS 'omzet'
--   FROM ARTIKEL AS A
--     LEFT JOIN REPARATIE AS R ON A.BARCODE = R.BARCODE
--     LEFT JOIN ARTIKELENVERKOOP AS AV ON A.BARCODE = AV.BARCODE
--     LEFT JOIN ARTIKELENVERHUUR AS AVR ON A.BARCODE = AVR.BARCODE
--     LEFT JOIN HUUROVEREENKOMST AS HO ON AVR.EMAILADRES = HO.EMAILADRES AND AVR.STARTDATUM = HO.STARTDATUM
--     LEFT JOIN VERKOOPOVEREENKOMST AS VO ON AV.EMAILADRES = VO.EMAILADRES AND AV.DATUM = VO.DATUM


GO


-- D. Overzicht van de top 10 van populairste spellen.
CREATE VIEW Opdr9D_Top10PopulairsteSpellen AS
  SELECT *
  FROM ARTIKEL;
GO

-- E. Consoles die in reparatie staan.
CREATE VIEW Opdr9E_ConsolesDieInReparatieStaan AS
  SELECT *
  FROM ARTIKEL;
GO

-- F. Omzetten per klant in een jaar,  gesorteerd van hoog naar laag. Verdeel de klanten in Gold,  Silver,  Bronze zoals beschreven in de casus.
CREATE VIEW Opdr9F_OmzettenPerKlantInEenJaar AS
  SELECT *
  FROM ARTIKEL;
GO

-- G. Inkoophoeveelheid (aantal artikelen) en totaalbedrag per jaar.
CREATE VIEW Opdr9G_Inkoophoeveelheid AS
  SELECT *
  FROM ARTIKEL;
GO