-- Opdracht 8: Implementeer een ontworpen scherm in Access met een Master-Detail-oplossing (INDIVIDUEEL!)

DROP VIEW IF EXISTS dbo.Opdr8_Omzet;
DROP VIEW IF EXISTS dbo.Opdr8_OmzetPerKlantPerJaar;

DROP VIEW IF EXISTS dbo.Opdr8_KlantOverzicht;
GO

-- Master view:
-- Klanten overzicht
--
-- Detail view:
-- huurhistorie
-- omzet v/d klant /jaar
-- klantstatus

-- Omzet per klant per jaar
CREATE VIEW Opdr8_OmzetPerKlantPerJaar AS
  SELECT
    EMAILADRES,
    YEAR(DATUM) AS 'JAAR',
    SUM(PRIJS) AS 'OMZET'
  FROM Omzet
  GROUP BY EMAILADRES, YEAR(DATUM)
GO

-- Overzicht van alle klanten
CREATE VIEW Opdr8_KlantOverzicht AS
  SELECT
    K.EMAILADRES,
    K.MERK_EIGEN_CONSOLE,
    K.TYPE_EIGEN_CONSOLE,
    K.VOORNAMEN,
    K.ACHTERNAAM,
    K.STRAATNAAM,
    K.HUISNUMMER,
    K.POSTCODE,
    K.WOONPLAATS,
    K.GEBOORTEDATUM,
    K.GESLACHT,
    K.WACHTWOORD,
    CASE
    WHEN KS.OMZET IS NULL
      THEN 0
    ELSE KS.OMZET END  AS 'OMZET',
    CASE
    WHEN KS.STATUS IS NULL
      THEN 'Brons'
    ELSE KS.STATUS END AS 'STATUS'
  FROM KLANT AS K
    LEFT JOIN KlantStatus AS KS ON K.EMAILADRES = KS.EMAILADRES
GO