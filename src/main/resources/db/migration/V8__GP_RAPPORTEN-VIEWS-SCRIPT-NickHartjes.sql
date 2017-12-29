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
    A.BARCODE,
    A.MERK,
    A.TYPE,
    A.TITEL,
    A.PRIJS,
    A.PRIJS_PER_D,
    A.SPEL_OF_CONSOLE,
    A.JAAR_UITGAVE,
    A.UITGEVER
  FROM ARTIKEL AS A
  WHERE A.SPEL_OF_CONSOLE = 'SPEL' AND A.BARCODE NOT IN (
    SELECT A.BARCODE
    FROM ARTIKEL AS A
      LEFT JOIN ARTIKELENVERHUUR AS AV ON A.BARCODE = AV.BARCODE
    WHERE (A.SPEL_OF_CONSOLE = 'SPEL' AND YEAR(AV.STARTDATUM) = 2016)
  )
GO

-- C. Omzetten van iedere maand van de jaren 2012 tot en met 2017.
CREATE VIEW Opdr9C_OmzettenVanIedereMaand2012Tot2017 AS

  SELECT
    -- Verkoop: Tel alle prijzen bij elkaar op, wanneer er een datum van verkoopovereenkomst is.
    SUM(CASE WHEN VO.DATUM IS NOT NULL
      THEN A.PRIJS
        ELSE 0 END)
    +
    -- Vehuur: Tel alle dagen x verhuurprijs voor wanneer de status op verhuur staat.
    SUM(CASE WHEN HO.HUURSTATUS = 'VERHUURD'
      THEN DATEDIFF(D, HO.STARTDATUM, HO.EINDDATUM) * A.PRIJS_PER_D
        ELSE 0 END)
    +
    -- Reparatie: Alle omzet gemaakt bij reparatie
    SUM(CASE WHEN R.KOSTEN IS NOT NULL
      THEN R.KOSTEN
        ELSE 0 END)
      AS 'omzet'
  FROM ARTIKEL AS A
    LEFT JOIN REPARATIE AS R ON A.BARCODE = R.BARCODE
    LEFT JOIN ARTIKELENVERKOOP AS AV ON A.BARCODE = AV.BARCODE
    LEFT JOIN ARTIKELENVERHUUR AS AVR ON A.BARCODE = AVR.BARCODE
    LEFT JOIN HUUROVEREENKOMST AS HO ON AVR.EMAILADRES = HO.EMAILADRES AND AVR.STARTDATUM = HO.STARTDATUM
    LEFT JOIN VERKOOPOVEREENKOMST AS VO ON AV.EMAILADRES = VO.EMAILADRES AND AV.DATUM = VO.DATUM


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