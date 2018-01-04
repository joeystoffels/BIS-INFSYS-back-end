/*================================================================*/
/* Database name:  GameParadise			                          */
/* DBMS name:      Microsoft SQL Server 2017                      */
/* Created on:     20/12/2017							          */
/* Made by:        Martijn de Geus, Nick Hartjes en Joey Stoffels */
/*================================================================*/

-- Foreign keys uit origineel aangeleverd document

-- Deze is verwijderd in het alteration script, en komt later weer terug
-- ALTER TABLE Artikel ADD CONSTRAINT FK_ARTIKEL_IS_CONSOLE foreign key (MERK, TYPE) references CONSOLE (MERK, TYPE);

--
ALTER TABLE ARTIKEL DROP CONSTRAINT FK_ARTIKEL_SPEL;
ALTER TABLE ARTIKEL ADD CONSTRAINT FK_ARTIKEL_IS_SPEL foreign key (TITEL, UITGEVER, JAAR_UITGAVE) REFERENCES SPEL (TITEL, UITGEVER, JAAR_UITGAVE) ON UPDATE CASCADE ON DELETE NO ACTION;
GO

-- Deze is verwijderd in het alteration script, en komt later weer terug
-- ALTER TABLE Klant ADD CONSTRAINT FK_KLANT_CONSOLE foreign key (MERK_EIGEN_CONSOLE, TYPE_EIGEN_CONSOLE) references CONSOLE (MERK, TYPE);

-- ALTER TABLE Huurovereenkomst ADD CONSTRAINT FK_HUUROVEREENKOMST_ARTIKEL foreign key (BARCODE) references ARTIKEL (BARCODE);

-- 
ALTER TABLE HUUROVEREENKOMST DROP CONSTRAINT FK_HUUROVEREENKOMST_KLANT;
ALTER TABLE HUUROVEREENKOMST ADD CONSTRAINT FK_HUUROVEREENKOMST_KLANT foreign key (EMAILADRES) references KLANT (EMAILADRES) ON UPDATE CASCADE ON DELETE NO ACTION;

-- 
ALTER TABLE KLANTTELEFOONNR DROP CONSTRAINT FK_KLANTTELEFOONNUMMER_HEEFT_NUMMER;
ALTER TABLE KLANTTELEFOONNR ADD CONSTRAINT FK_KLANTTELEFOONNUMMER_HEEFT_NUMMER foreign key (TELNUMMER) references TELEFOONNUMMER (TELNUMMER) ON UPDATE CASCADE ON DELETE NO ACTION;

--
ALTER TABLE KLANTTELEFOONNR DROP CONSTRAINT FK_KLANTTELEFOONNUMMER_HOORT_BIJ_KLANT;
ALTER TABLE KLANTTELEFOONNR ADD CONSTRAINT FK_KLANTTELEFOONNUMMER_HOORT_BIJ_KLANT foreign key (EMAILADRES) references KLANT (EMAILADRES) ON UPDATE CASCADE ON DELETE NO ACTION;

--
ALTER TABLE VERKOOPOVEREENKOMST DROP CONSTRAINT FK_KOOP_AAN_KLANT;
ALTER TABLE VERKOOPOVEREENKOMST ADD CONSTRAINT FK_KOOP_AAN_KLANT foreign key (EMAILADRES) references KLANT (EMAILADRES) ON UPDATE CASCADE ON DELETE NO ACTION;

-- ALTER TABLE Koopovereenkomst ADD CONSTRAINT FK_KOOP_ARTIKEL foreign key (BARCODE) references ARTIKEL (BARCODE);

-- 
ALTER TABLE INKOOPOVEREENKOMST DROP CONSTRAINT FK_INKOOP_VAN_KLANT;
ALTER TABLE INKOOPOVEREENKOMST ADD CONSTRAINT FK_INKOOP_VAN_KLANT foreign key (EMAILADRES) references KLANT (EMAILADRES) ON UPDATE CASCADE ON DELETE NO ACTION;

-- ALTER TABLE Inkoopovereenkomst ADD CONSTRAINT FK_INKOOP_VAN_ARTIKEL foreign key (BARCODE) references ARTIKEL (BARCODE);

-- 
ALTER TABLE MEDEWERKERROL DROP CONSTRAINT FK_MEDEWERKER_IS_ROL;
ALTER TABLE MEDEWERKERROL ADD CONSTRAINT FK_MEDEWERKER_IS_ROL foreign key (ROL) references ROL (ROL) ON UPDATE CASCADE ON DELETE NO ACTION;

-- 
ALTER TABLE MEDEWERKERROL DROP CONSTRAINT FK_MEDEWERKER_HEEFT_ROL;
ALTER TABLE MEDEWERKERROL ADD CONSTRAINT FK_MEDEWERKER_HEEFT_ROL foreign key (INLOGNAAM) references MEDEWERKER (INLOGNAAM) ON UPDATE CASCADE ON DELETE NO ACTION;

-- 
ALTER TABLE REPARATIE DROP CONSTRAINT FK_REPARATIE_DOOR_MEDEWERKER;
ALTER TABLE REPARATIE ADD CONSTRAINT FK_REPARATIE_DOOR_MEDEWERKER foreign key (INLOGNAAM) references MEDEWERKER (INLOGNAAM) ON UPDATE CASCADE ON DELETE NO ACTION;

-- ALTER TABLE REPARATIE ADD CONSTRAINT FK_REPARATIE_BIJ_HUUROVEREENKOMST foreign key (BARCODE, STARTDATUM) references ARTIKELENVERHUUR (BARCODE, STARTDATUM);

-- Deze is verwijderd aangezien wij alles hebben omgeschreven naar koppeltabellen.
-- ALTER TABLE Spel ADD CONSTRAINT FK_SPEL_HOORT_BIJ_SPELCATEGORIE foreign key (CATEGORIE) references CATEGORIE (CATEGORIE);


-- Foreign keys uit alterations

-- 
ALTER TABLE ARTIKEL DROP CONSTRAINT FK_ARTIKEL_IS_CONSOLE;
ALTER TABLE ARTIKEL ADD CONSTRAINT FK_ARTIKEL_IS_CONSOLE FOREIGN KEY (MERK, [TYPE]) REFERENCES CONSOLE (MERK_NAAM, TYPE_NAAM) ON UPDATE CASCADE ON DELETE NO ACTION;

-- 
ALTER TABLE KLANT DROP CONSTRAINT FK_KLANT_CONSOLE;
ALTER TABLE KLANT ADD CONSTRAINT FK_KLANT_CONSOLE FOREIGN KEY (MERK_EIGEN_CONSOLE, TYPE_EIGEN_CONSOLE) REFERENCES CONSOLE (MERK_NAAM, TYPE_NAAM) ON UPDATE CASCADE ON DELETE NO ACTION;

-- 
ALTER TABLE CATEGORIEPERSPEL DROP CONSTRAINT FK_SPEL;
ALTER TABLE CATEGORIEPERSPEL ADD CONSTRAINT FK_SPEL FOREIGN KEY (TITEL, UITGEVER, JAAR_UITGAVE) REFERENCES SPEL (TITEL, UITGEVER, JAAR_UITGAVE) ON UPDATE CASCADE ON DELETE NO ACTION;
GO

--
ALTER TABLE CATEGORIEPERSPEL DROP CONSTRAINT FK_CATEGORIE;
ALTER TABLE CATEGORIEPERSPEL ADD CONSTRAINT FK_CATEGORIE FOREIGN KEY (CATEGORIE) REFERENCES CATEGORIE (CATEGORIE) ON UPDATE CASCADE ON DELETE NO ACTION;

-- 
ALTER TABLE SPELTYPEPERSPEL DROP CONSTRAINT FK_SPELTYPE_PER_SPEL;
ALTER TABLE SPELTYPEPERSPEL ADD CONSTRAINT FK_SPELTYPE_PER_SPEL FOREIGN KEY (TITEL, UITGEVER, JAAR_UITGAVE) REFERENCES SPEL (TITEL, UITGEVER, JAAR_UITGAVE) ON UPDATE CASCADE ON DELETE NO ACTION;

--
ALTER TABLE SPELTYPEPERSPEL DROP CONSTRAINT FK_SPELTYPE_PER_SPEL;
ALTER TABLE SPELTYPEPERSPEL ADD CONSTRAINT FK_SPELTYPE_PER_SPEL FOREIGN KEY (TITEL, UITGEVER, JAAR_UITGAVE) REFERENCES SPEL (TITEL, UITGEVER, JAAR_UITGAVE) ON UPDATE CASCADE ON DELETE NO ACTION;
GO

-- 
ALTER TABLE SPELTYPEPERSPEL DROP CONSTRAINT FK_SPELTYPE;
ALTER TABLE SPELTYPEPERSPEL ADD CONSTRAINT FK_SPELTYPE FOREIGN KEY (SPELTYPE) REFERENCES SPELTYPE (SPELTYPE) ON UPDATE CASCADE ON DELETE NO ACTION;

-- staat al bovenaan
-- ALTER TABLE ARTIKEL ADD CONSTRAINT FK_ARTIKEL_SPEL FOREIGN KEY (TITEL, UITGEVER, JAAR_UITGAVE) REFERENCES SPEL (TITEL, UITGEVER, JAAR_UITGAVE) ON UPDATE CASCADE ON DELETE NO ACTION;

--
ALTER TABLE CONSOLE DROP CONSTRAINT FK_MERK_CONSOLES;
ALTER TABLE CONSOLE ADD CONSTRAINT FK_MERK_CONSOLE FOREIGN KEY (MERK_NAAM) REFERENCES CONSOLE_MERK (MERK_NAAM) ON UPDATE CASCADE ON DELETE NO ACTION;

--
ALTER TABLE CONSOLE DROP CONSTRAINT FK_TYPE_CONSOLES;
ALTER TABLE CONSOLE ADD CONSTRAINT FK_TYPE_CONSOLE FOREIGN KEY (TYPE_NAAM) REFERENCES CONSOLE_TYPE (TYPE_NAAM) ON UPDATE CASCADE ON DELETE NO ACTION;

--
ALTER TABLE ARTIKELENVERHUUR DROP CONSTRAINT FK_ARTIKEL;
ALTER TABLE ARTIKELENVERHUUR
	ADD CONSTRAINT FK_ARTIKELENVERHUUR_ARTIKEL FOREIGN KEY (BARCODE) REFERENCES ARTIKEL (BARCODE) ON UPDATE CASCADE ON DELETE NO ACTION;

-- DELETE laten cascaden?
ALTER TABLE ARTIKELENVERHUUR
	ADD CONSTRAINT FK_ARTIKELENVERHUUR_HUUROVEREENKOMST FOREIGN KEY (EMAILADRES, STARTDATUM) REFERENCES HUUROVEREENKOMST (EMAILADRES, STARTDATUM) ON UPDATE NO ACTION ON DELETE CASCADE;

-- DELETE laten cascaden?
ALTER TABLE ARTIKELENVERKOOP
	ADD CONSTRAINT FK_ARTIKELENVERKOOP_VERKOOPOVEREENKOMST FOREIGN KEY (EMAILADRES, DATUM) REFERENCES VERKOOPOVEREENKOMST (EMAILADRES, DATUM) ON UPDATE NO ACTION ON DELETE CASCADE;

-- 
ALTER TABLE ARTIKELENVERKOOP DROP CONSTRAINT FK_ARTIKELENVERKOOP_ARTIKEL;
ALTER TABLE ARTIKELENVERKOOP
	ADD CONSTRAINT FK_ARTIKELENVERKOOP_ARTIKEL FOREIGN KEY (BARCODE) REFERENCES ARTIKEL (BARCODE) ON UPDATE CASCADE ON DELETE NO ACTION;

-- DELETE laten cascaden?
ALTER TABLE ARTIKELENINKOOP DROP CONSTRAINT FK_ARTIKELENINKOOP_INKOOPOVEREENKOMST;
ALTER TABLE ARTIKELENINKOOP
	ADD CONSTRAINT FK_ARTIKELENINKOOP_INKOOPOVEREENKOMST FOREIGN KEY (EMAILADRES, DATUM) REFERENCES INKOOPOVEREENKOMST (EMAILADRES, DATUM) ON UPDATE NO ACTION ON DELETE CASCADE;

-- 
ALTER TABLE ARTIKELENINKOOP DROP CONSTRAINT FK_ARTIKELENINKOOP_ARTIKEL;
ALTER TABLE ARTIKELENINKOOP
	ADD CONSTRAINT FK_ARTIKELENINKOOP_ARTIKEL FOREIGN KEY (BARCODE) REFERENCES ARTIKEL (BARCODE) ON UPDATE CASCADE ON DELETE NO ACTION;

-- 
ALTER TABLE REPARATIE DROP CONSTRAINT FK_REPARATIE_ARTIKEL;
ALTER TABLE REPARATIE
	ADD CONSTRAINT FK_REPARATIE_ARTIKEL FOREIGN KEY (BARCODE) REFERENCES ARTIKEL (BARCODE) ON UPDATE CASCADE ON DELETE NO ACTION;