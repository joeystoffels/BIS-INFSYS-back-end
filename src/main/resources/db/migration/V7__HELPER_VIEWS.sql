DROP VIEW IF EXISTS dbo.HistorieHuur;
DROP VIEW IF EXISTS dbo.HistorieKoop;
DROP VIEW IF EXISTS dbo.HistorieReparatie;
DROP VIEW IF EXISTS dbo.KlantStatus;
DROP VIEW IF EXISTS dbo.Omzet;
GO

CREATE VIEW HistorieHuur AS
  SELECT
    A.BARCODE,
    A.MERK,
    A.[TYPE],
    A.TITEL,
    A.UITGEVER,
    A.JAAR_UITGAVE,
    HO.STARTDATUM                                            AS 'DATUM',
    DATEDIFF(D, HO.STARTDATUM, HO.EINDDATUM) * A.PRIJS_PER_D AS 'PRIJS',
    HO.EMAILADRES,
    'HUUR'                                                   AS 'SOORT'
  FROM HUUROVEREENKOMST AS HO
    INNER JOIN ARTIKELENVERHUUR AS AVR ON HO.EMAILADRES = AVR.EMAILADRES AND HO.STARTDATUM = AVR.STARTDATUM
    INNER JOIN ARTIKEL A ON AVR.BARCODE = A.BARCODE;
GO

CREATE VIEW HistorieKoop AS
  SELECT
    A.BARCODE,
    A.MERK,
    A.[TYPE],
    A.TITEL,
    A.UITGEVER,
    A.JAAR_UITGAVE,
    VO.DATUM,
    A.PRIJS,
    VO.EMAILADRES,
    'KOOP' AS 'SOORT'
  FROM VERKOOPOVEREENKOMST AS VO
    LEFT JOIN ARTIKELENVERKOOP AV ON VO.EMAILADRES = AV.EMAILADRES AND VO.DATUM = AV.DATUM
    LEFT JOIN ARTIKEL A ON AV.BARCODE = A.BARCODE
GO

CREATE VIEW HistorieReparatie AS
  SELECT
    A.BARCODE,
    A.MERK,
    A.[TYPE],
    A.TITEL,
    A.UITGEVER,
    A.JAAR_UITGAVE,
    R.STARTDATUM AS 'DATUM',
    R.KOSTEN     AS 'PRIJS',
    R.EMAILADRES,
    'REPARATIE'  AS 'SOORT'
  FROM REPARATIE AS R
    INNER JOIN ARTIKEL A ON R.BARCODE = A.BARCODE
GO


--   GameParadise houdt bij hoe vaak een klant al gehuurd of gekocht heeft.
--   Op basis daarvan krijgt een klant een status van Gold, Silver of Bronze.
--   Het totaal bestede bedrag over de afgelopen 12 maanden is hiervoor bepalend:
--   Gold klanten hebben 150 euro besteed, Silver 100 en Bronze 50.

CREATE VIEW KlantStatus AS
  SELECT
    EMAILADRES,
    SUM(PRIJS)       AS 'OMZET',
    CASE
    WHEN SUM(PRIJS) >= 150
      THEN 'Gold'
    WHEN SUM(PRIJS) >= 100
      THEN 'Silver'
    ELSE 'Brons' END AS 'STATUS'
  FROM (
         SELECT *
         FROM HistorieKoop AS KH
         WHERE KH.DATUM > DATEADD(YEAR, -1, GETDATE())
         UNION ALL
         SELECT *
         FROM HistorieHuur AS HH
         WHERE HH.DATUM > DATEADD(YEAR, -1, GETDATE())
       ) AS OVERZICHT
  GROUP BY EMAILADRES
GO


-- Overzicht van alle transacties die omzet gecrieerd hebben
CREATE VIEW Omzet AS
  SELECT
    BARCODE,
    MERK,
    [TYPE],
    TITEL,
    UITGEVER,
    JAAR_UITGAVE,
    DATUM,
    PRIJS,
    EMAILADRES,
    SOORT
  FROM (
         SELECT
           BARCODE,
           MERK,
           [TYPE],
           TITEL,
           UITGEVER,
           JAAR_UITGAVE,
           DATUM,
           PRIJS,
           EMAILADRES,
           SOORT
         FROM HistorieKoop
         UNION ALL
         SELECT
           BARCODE,
           MERK,
           [TYPE],
           TITEL,
           UITGEVER,
           JAAR_UITGAVE,
           DATUM,
           PRIJS,
           EMAILADRES,
           SOORT
         FROM HistorieHuur
         UNION ALL
         SELECT
           BARCODE,
           MERK,
           [TYPE],
           TITEL,
           UITGEVER,
           JAAR_UITGAVE,
           DATUM,
           PRIJS,
           EMAILADRES,
           SOORT
         FROM HistorieReparatie
       ) AS OVERZICHT
GO