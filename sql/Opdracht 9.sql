-- Opdracht 9: Bouw Rapporten in Access (INDIVIDUEEL!).

USE GAMEPARADISE

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
SELECT * FROM ARTIKEL
GO

-- B. Lijst met Spellen die niet verhuurd zijn in 2016.
CREATE VIEW Opdr9B_NietVerhuurdIn2016 AS
SELECT * FROM ARTIKEL
GO

-- C. Omzetten van iedere maand van de jaren 2012 tot en met 2017.
CREATE VIEW Opdr9C_OmzettenVanIedereMaand2012Tot2017 AS
SELECT * FROM ARTIKEL
GO


-- D. Overzicht van de top 10 van populairste spellen.
CREATE VIEW Opdr9D_Top10PopulairsteSpellen AS
SELECT * FROM ARTIKEL
GO

-- E. Consoles die in reparatie staan.
CREATE VIEW Opdr9E_ConsolesDieInReparatieStaan AS
SELECT * FROM ARTIKEL
GO

-- F. Omzetten per klant in een jaar, gesorteerd van hoog naar laag. Verdeel de klanten in Gold, Silver, Bronze zoals beschreven in de casus.
CREATE VIEW Opdr9F_OmzettenPerKlantInEenJaar AS
SELECT * FROM ARTIKEL
GO

-- G. Inkoophoeveelheid (aantal artikelen) en totaalbedrag per jaar.
CREATE VIEW Opdr9G_Inkoophoeveelheid AS
SELECT * FROM ARTIKEL
GO