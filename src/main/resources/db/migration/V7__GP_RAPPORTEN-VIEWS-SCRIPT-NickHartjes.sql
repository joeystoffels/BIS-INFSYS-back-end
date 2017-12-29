-- Opdracht 9: Bouw Rapporten in Access (INDIVIDUEEL!).

Drop view if exists dbo.Opdr9A_OverzichtMomenteelVerhuurd;
Drop view if exists dbo.Opdr9B_NietVerhuurdIn2016;
Drop view if exists dbo.Opdr9C_OmzettenVanIedereMaand2012Tot2017;
Drop view if exists dbo.Opdr9D_Top10PopulairsteSpellen;
Drop view if exists dbo.Opdr9E_ConsolesDieInReparatieStaan;
Drop view if exists dbo.Opdr9F_OmzettenPerKlantInEenJaar;
Drop view if exists dbo.Opdr9G_Inkoophoeveelheid;
GO

-- A. Overzicht van artikelen die momenteel verhuurd zijn.
CREATE VIEW Opdr9A_OverzichtMomenteelVerhuurd AS
SELECT A.BARCODE
      , A.MERK
      , A.TYPE
      , A.TITEL
      , A.PRIJS
      , A.PRIJS_PER_D
      , A.SPEL_OF_CONSOLE
      , A.JAAR_UITGAVE
      , A.UITGEVER
FROM HUUROVEREENKOMST AS HO
INNER JOIN ARTIKELENVERHUUR AS AV ON (HO.STARTDATUM = AV.STARTDATUM AND HO.EMAILADRES = AV.EMAILADRES)
INNER JOIN ARTIKEL AS A ON AV.BARCODE = A.BARCODE
WHERE HO.STARTDATUM <= GETDATE() AND HO.EINDDATUM >= GETDATE() AND HO.HUURSTATUS = 'VERHUURD';
GO

-- B. Lijst met Spellen die niet verhuurd zijn in 2016.
-- Wat is de definitie van verhuurd, en artikelen of spellen ?
CREATE VIEW Opdr9B_NietVerhuurdIn2016 AS
SELECT A.BARCODE
      , A.MERK
      , A.TYPE
      , A.TITEL
      , A.PRIJS
      , A.PRIJS_PER_D
      , A.SPEL_OF_CONSOLE
      , A.JAAR_UITGAVE
      , A.UITGEVER
FROM ARTIKEL AS A
WHERE A.SPEL_OF_CONSOLE = 'SPEL' AND A.BARCODE NOT IN (
    SELECT A.BARCODE
    FROM ARTIKEL AS A
    LEFT JOIN ARTIKELENVERHUUR AS AV ON A.BARCODE = AV.BARCODE
    WHERE (A.SPEL_OF_CONSOLE = 'SPEL' AND YEAR(AV.STARTDATUM) = 2016)
)
GO
