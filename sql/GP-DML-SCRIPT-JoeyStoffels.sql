
/*================================================================*/
/* Database name:  GameParadise			                          */
/* DBMS name:      Microsoft SQL Server 2017                      */
/* Created on:     23/11/2017						              */
/* Made by:        Martijn de Geus, Nick Hartjes en Joey Stoffels */
/*================================================================*/

/*================================================================*/
/* Initialisation						                          */
/*================================================================*/

USE gameparadise
GO

/*================================================================*/
/* Start DML.   						                          */
/*================================================================*/

DELETE FROM Damage
DELETE FROM RentedConsoles
DELETE FROM RentedGames
DELETE FROM Rental
DELETE FROM PurchasedConsoles
DELETE FROM PurchasedGames
DELETE FROM GameTypesPerGame
DELETE FROM CategoriesPerGame
DELETE FROM Console
DELETE FROM ConsoleCatalogus
DELETE FROM Game
DELETE FROM GameCatalogus
DELETE FROM Type
DELETE FROM Brand
DELETE FROM Status
DELETE FROM GameType
DELETE FROM AgeCategory
DELETE FROM Category
DELETE FROM Purchase
DELETE FROM Customer
DELETE FROM Publisher
DELETE FROM RolesPerEmployee
DELETE FROM Employee
DELETE FROM Role

INSERT INTO Role VALUES
	('admin'),
	('verkoop'),
	('reparatie'),
	('manager');

INSERT INTO Employee VALUES
	('hveen', 'Harry', 'van Veen', 'pUM0H1cxALP_yVVOdvSP', '01-02-1989'),
	('kgroot', 'Karel', 'de Groot', '46kRUZfTndF@7U7J9F3P', '09-10-1992'),
	('sboer', 'Saskia', 'de Boer', 'Pw9wQiO1fTQY*s0F3Y9k', '03-11-1965'),
	('jwitt', 'Johan', 'de Witt', 'ejMCv3(nYTjxTSrqxy2a', '04-12-1970'),
	('sschouten', 'Sjon', 'Schouten', 'YWXszUFier40d^cvdJpC', '09-12-1987');

INSERT INTO RolesPerEmployee VALUES
	('hveen', 'admin'),
	('hveen', 'verkoop'),
	('kgroot', 'verkoop'),
	('kgroot', 'reparatie'),
	('sboer', 'admin'),
	('sboer', 'verkoop'),
	('sboer', 'reparatie'),
	('sboer', 'manager'),
	('jwitt', 'reparatie'),
	('jwitt', 'verkoop'),
	('sschouten', 'reparatie'),
	('sschouten', 'verkoop');

INSERT INTO Publisher VALUES 
	('Electronic Arts'),
	('Activision'),
	('Ubisoft'),
	('Microsoft');

INSERT INTO Customer VALUES 
	('wilfried.kanen1984@gmail.com', 'Wilfried', 'Kanen', 'K. Bouterlaan', '31', '6092AH', 'Arnhem', '0612345678', '02-01-1984', 'kapsalon123', 'M', '0241234567'),
	('piet.saman32@gmail.com', 'Piet', 'Saman', 'Grote Dorpstraat', '18', '3411KA', 'Amstelveen', '0611234112', '10-17-1998', 'PietjePuk!!2', 'M', '0314235112'),
	('karin119@gmail.com', 'Karin', 'de Vries', 'Keulensedwarsstraat', '109', '4511SD', 'Teuge', '0623111235', '07-27-2002', 'vlinderhetkonijn1', 'F', '0957728573');

INSERT INTO Purchase VALUES 
	('wilfried.kanen1984@gmail.com', '11-30-2017 20:15:05'),
	('piet.saman32@gmail.com', '11-25-2017 15:13:11'),
	('karin119@gmail.com', '12-01-2017 09:18:44'),
	('wilfried.kanen1984@gmail.com', '10-25-2017 10:12:01'),
	('piet.saman32@gmail.com', '09-24-2017 17:23:19'),
	('karin119@gmail.com', '11-02-2017 09:08:11');

INSERT INTO Category VALUES 
	('Actie'),
	('Simulatie'),
	('Racen');

INSERT INTO AgeCategory VALUES 
	('8+'),
	('12+'),
	('16+'),
	('18+');

INSERT INTO GameType VALUES 
	('Singleplayer'),
	('Multiplayer'),
	('Online');

INSERT INTO Status VALUES
	('Afgeschreven'),
	('Nieuw'),
	('Gebruikt'),
	('In reparatie'),
	('Beschadigd'),
	('Verhuurd'),
	('Verkocht'),
	('Wachten op reparatie');

INSERT INTO Brand VALUES
	('Sony'),
	('Nintendo'),
	('Microsoft');

INSERT INTO Type VALUES
	('Playstation 4'),
	('XBOX One'),
	('Switch');
	
INSERT INTO GameCatalogus VALUES
	('Battlefield 1', 'Electronic Arts', '10-21-2016', 'Battlefield 1 is een first-person shooter ontwikkeld door EA DICE. Het spel werd uitgegeven door Electronic Arts en kwam op 21 oktober 2016 uit voor PlayStation 4, Windows en Xbox One. Het spel speelt zich af in de Eerste Wereldoorlog.', 19.99, '18+'),
	('Call of Duty: Black ops III', 'Activision', '11-03-2017', 'Call of Duty: Black Ops III is een computerspel uit de Call of Duty-reeks. Het spel is ontwikkeld door Treyarch en is het vervolg op Call of Duty: Black Ops II.', 35.50, '16+'),
	('Destiny', 'Activision', '09-09-2014', 'Destiny is een first-person shooter ontwikkeld door Bungie. Het spel wordt uitgegeven door Activision en kwam op 9 september 2014 uit voor PlayStation 3, PlayStation 4, Xbox 360 en Xbox One.', 49.99, '12+'),
	('Microsoft Flight Simulator X', 'Microsoft', '10-13-2006', 'Microsoft Flight Simulator is een computerprogramma voor Microsoft Windows dat het vliegen met allerlei soorten vliegtuigen simuleert.', 25.00, '8+'),
	('Tom Clancys The Division', 'Ubisoft', '03-08-2016', 'Tom Clancys The Division is een third-person shooter die via internet gespeeld kan worden. Het spel werd ontwikkeld door Ubisoft Massive, Ubisoft Reflections, Ubisoft Red Storm en Ubisoft Annecy.', 33.00, '18+'),
	('Need for Speed Payback', 'Electronic Arts', '11-10-2017', 'Need for Speed is een reeks computerspelen die door EA Games op de markt zijn gebracht voor verschillende platforms, waaronder Windows, Mac, Nintendo-, Xbox- en PlayStation-consoles.', 19.95, '12+');

INSERT INTO Game VALUES
	('9543534233334', 'Battlefield 1', 'Electronic Arts', '10-21-2016', 29.95, 'Verhuurd'),
	('7483504300034', 'Call of Duty: Black ops III', 'Activision', '11-03-2017', 49.95, 'Verhuurd'),
	('8948328432943', 'Destiny', 'Activision', '09-09-2014', 59.95, 'Verhuurd'),
	('5232754559163', 'Microsoft Flight Simulator X', 'Microsoft', '10-13-2006', 39.95, 'Verkocht'),
	('8211752690303', 'Tom Clancys The Division', 'Ubisoft', '03-08-2016', 49.95, 'Verkocht'),
	('3243283243243', 'Need for Speed Payback', 'Electronic Arts', '11-10-2017', 24.95, 'Verkocht');

INSERT INTO ConsoleCatalogus VALUES
	('Sony', 'Playstation 4', 349.95),
	('Microsoft', 'XBOX One', 289.95),
	('Nintendo', 'Switch', 229.99);

INSERT INTO Console VALUES
	('7728364482373', 'Sony', 'Playstation 4', 349.95, null, 'Verhuurd'),
	('9812321711123', 'Microsoft', 'XBOX One', 289.95, 'Gebruikerssporen aanwezig', 'Verhuurd'),
	('2131232432432', 'Nintendo', 'Switch', 229.99, null, 'Verhuurd'),
	('4932843298442', 'Sony', 'Playstation 4', 349.95, null, 'Verkocht'),
	('6546433543231', 'Sony', 'Playstation 4', 349.95, null, 'Verkocht'),
	('8523243256443', 'Nintendo', 'Switch', 229.9, null, 'Verkocht'),
	('9865765456778', 'Microsoft', 'XBOX One', 289.95, null, 'In reparatie'),
	('3727118273849', 'Microsoft', 'XBOX One', 289.95, null, 'In reparatie'),
	('8293847583921', 'Nintendo', 'Switch', 289.95, null, 'Wachten op reparatie');

INSERT INTO CategoriesPerGame VALUES
	('Actie', 'Battlefield 1', 'Electronic Arts', '10-21-2016'),
	('Actie', 'Call of Duty: Black ops III', 'Activision', '11-03-2017'),
	('Actie', 'Destiny', 'Activision', '09-09-2014'),
	('Simulatie', 'Microsoft Flight Simulator X', 'Microsoft', '10-13-2006'),
	('Actie', 'Tom Clancys The Division', 'Ubisoft', '03-08-2016'),
	('Racen', 'Need for Speed Payback', 'Electronic Arts', '11-10-2017');
	
INSERT INTO GameTypesPerGame VALUES 	
	('Singleplayer', 'Battlefield 1', 'Electronic Arts', '10-21-2016'),
	('Singleplayer', 'Call of Duty: Black ops III', 'Activision', '11-03-2017'),
	('Singleplayer', 'Destiny', 'Activision', '09-09-2014'),
	('Singleplayer', 'Microsoft Flight Simulator X', 'Microsoft', '10-13-2006'),
	('Singleplayer', 'Tom Clancys The Division', 'Ubisoft', '03-08-2016'),
	('Singleplayer', 'Need for Speed Payback', 'Electronic Arts', '11-10-2017'),
	('Multiplayer', 'Battlefield 1', 'Electronic Arts', '10-21-2016'),
	('Multiplayer', 'Call of Duty: Black ops III', 'Activision', '11-03-2017'),
	('Multiplayer', 'Tom Clancys The Division', 'Ubisoft', '03-08-2016'),
	('Online', 'Battlefield 1', 'Electronic Arts', '10-21-2016'),
	('Online', 'Call of Duty: Black ops III', 'Activision', '11-03-2017'),
	('Online', 'Tom Clancys The Division', 'Ubisoft', '03-08-2016');

INSERT INTO PurchasedGames VALUES
	('5232754559163', 'wilfried.kanen1984@gmail.com', '11-30-2017 20:15:05'),
	('8211752690303', 'piet.saman32@gmail.com', '11-25-2017 15:13:11'),
	('3243283243243', 'karin119@gmail.com', '12-01-2017 09:18:44');

INSERT INTO PurchasedConsoles VALUES
	('4932843298442', 'wilfried.kanen1984@gmail.com', '10-25-2017 10:12:01'),
	('6546433543231', 'piet.saman32@gmail.com', '09-24-2017 17:23:19'),
	('8523243256443', 'karin119@gmail.com', '11-02-2017 09:08:11');

INSERT INTO Rental VALUES
	('wilfried.kanen1984@gmail.com', '11-24-2017 12:31:12', 5.00, 7.50, '12-24-2017 12:31:12', 'Gereserveerd'),
	('wilfried.kanen1984@gmail.com', '11-08-2017 18:29:33', 5.00, 7.50, '12-08-2017 18:29:33', 'Verhuurd'),
	('karin119@gmail.com', '10-15-2017 16:12:55', 5.00, 7.50, '11-15-2017 16:12:55', 'Te laat'),
	('wilfried.kanen1984@gmail.com', '09-02-2017 11:38:20', 25.00, 75.00, '10-02-2017 11:38:20', 'Ingeleverd'),
	('piet.saman32@gmail.com', '10-29-2017 18:39:20', 25.00, 34.95, '11-29-2017 18:39:20', 'Te laat'),
	('karin119@gmail.com', '11-30-2017 15:38:22', 25.00, 39.95, '12-30-2017 15:38:22', 'Verhuurd');

INSERT INTO RentedGames VALUES
	('9543534233334', 'wilfried.kanen1984@gmail.com', '11-24-2017 12:31:12'),
	('7483504300034', 'wilfried.kanen1984@gmail.com', '11-08-2017 18:29:33'),
	('8948328432943', 'karin119@gmail.com', '10-15-2017 16:12:55');

INSERT INTO RentedConsoles VALUES
	('7728364482373', 'wilfried.kanen1984@gmail.com', '09-02-2017 11:38:20'),
	('9812321711123', 'piet.saman32@gmail.com', '10-29-2017 18:39:20'),
	('2131232432432', 'karin119@gmail.com', '11-30-2017 15:38:22');

INSERT INTO Damage VALUES
	(1, '9865765456778', 'kgroot', 'wilfried.kanen1984@gmail.com', 49.50, '12-05-2017', 'In reparatie'),
	(2, '3727118273849', 'sschouten', 'piet.saman32@gmail.com', 30.00, '12-20-2017', 'In reparatie'),
	(3, '8293847583921', 'sboer', 'piet.saman32@gmail.com', 132.95, '08-11-2017', 'Wachten op reparatie');