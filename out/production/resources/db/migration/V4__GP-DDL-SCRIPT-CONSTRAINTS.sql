/*================================================================*/
/* Database name:  GameParadise			                          */
/* DBMS name:      Microsoft SQL Server 2017                      */
/* Created on:     20/12/2017							          */
/* Made by:        Martijn de Geus, Nick Hartjes en Joey Stoffels */
/*================================================================*/

USE GAMEPARADISE
GO

-- Opdracht 2: CONSTRAINTS TOEVOEGEN (GROEP)
-- Probeer de volgende constraints (business rules) te definiëren in de CREATE TABLE statements:
-- a. Het geslacht van een klant moet ‘M’ (man) of ‘V’ (vrouw) zijn.
ALTER TABLE KLANT
ADD CONSTRAINT CH_GESLACHT CHECK (GESLACHT IN ('M','V'))

-- b. De einddatum van een verhuur moet later zijn dan de begindatum van een verhuur.
ALTER TABLE HUUROVEREENKOMST
ADD CONSTRAINT CH_EINDATUM_NA_BEGINDATUM CHECK (STARTDATUM < EINDDATUM);

-- c. De betaaldatum (startdatum) van een schade moet eerder of gelijk zijn t.o.v. de gereeddatum van een schade.
ALTER TABLE REPARATIE
ADD CONSTRAINT CH_GEREED_GELIJK_OF_NA_BEGINDATUM CHECK (STARTDATUM <= DATUM_GEREED);

-- d. Het adres van een klant moet uniek zijn.
ALTER TABLE KLANT
ADD UNIQUE (STRAATNAAM, HUISNUMMER, POSTCODE, WOONPLAATS);

-- e1. Probeer nog minimaal 3 voor de hand liggende (en dus realistische) constraints te vinden uit de casus, beschrijf deze en realiseer deze indien mogelijk.
-- Het wachtwoord moet minimaal een lente hebben van 6 , en heeft minimaal 1 nummer nodig
ALTER TABLE KLANT
ADD CONSTRAINT CH_WACHTWOORD CHECK (WACHTWOORD LIKE '%[0-9]%' AND LEN(WACHTWOORD) >= 6);

-- e2. Het telefoonnummer moet uit 11 characters bestaan
ALTER TABLE TELEFOONNUMMER
ADD CONSTRAINT CH_TELNUMMERLENGTE CHECK (LEN(TELNUMMER)=11);

-- e3. Het emailadres moet een correcte syntax hebben
ALTER TABLE KLANT
ADD CONSTRAINT CH_EMAILADRES CHECK (EMAILADRES LIKE '%_@%_._%');

-- e4. De postcode bestaat uit 4 cijfers en 2 letters.
ALTER TABLE KLANT
ADD CONSTRAINT CH_POSTCODE CHECK (LEFT(POSTCODE, 4) NOT LIKE '%[A-Z]%' AND RIGHT(POSTCODE, 2) NOT LIKE '%[0-9]%');