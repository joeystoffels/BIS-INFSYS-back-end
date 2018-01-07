/*================================================================*/
/* Database name:  GameParadise			                          */
/* DBMS name:      Microsoft SQL Server 2017                      */
/* Created on:     23/11/2017									  */
/* Made by:        Martijn de Geus, Nick Hartjes en Joey Stoffels */
/*================================================================*/

/*================================================================*/
/* Initialisation						                          */
/*================================================================*/
USE master
GO

IF EXISTS(select * from sys.databases where name='gameparadise')
DROP DATABASE gameparadise

CREATE DATABASE gameparadise
GO

USE gameparadise
GO

/*================================================================*/
/* Start DDL.   						                          */
/*================================================================*/

CREATE TABLE Category (
 CategoryName VARCHAR(30) NOT NULL
);

ALTER TABLE Category ADD CONSTRAINT PK_Category PRIMARY KEY (CategoryName);


CREATE TABLE Customer (
 Emailadres VARCHAR(50) NOT NULL,
 FirstName VARCHAR(30) NOT NULL,
 LastName VARCHAR(30) NOT NULL,
 Streetname VARCHAR(50) NOT NULL,
 HouseNumber VARCHAR(10) NOT NULL,
 PostalCode CHAR(6) NOT NULL,
 City VARCHAR(50) NOT NULL,
 MobilePhone CHAR(10) NOT NULL,
 DateOfBirth DATE NOT NULL,
 Password VARCHAR(30) NOT NULL,
 Gender CHAR(1),
 Phone CHAR(10)
);

ALTER TABLE Customer ADD CONSTRAINT PK_Customer PRIMARY KEY (Emailadres);


CREATE TABLE Purchase (
 Emailadres VARCHAR(50) NOT NULL,
 PurchaseDatetime DATETIME NOT NULL
);

ALTER TABLE Purchase ADD CONSTRAINT PK_Purchase PRIMARY KEY (Emailadres,PurchaseDatetime);


CREATE TABLE AgeCategory (
 AgeCategoryName VARCHAR(30) NOT NULL
);

ALTER TABLE AgeCategory ADD CONSTRAINT PK_AgeCategory PRIMARY KEY (AgeCategoryName);


CREATE TABLE Employee (
 Login VARCHAR(30) NOT NULL,
 FirstName VARCHAR(30) NOT NULL,
 LastName VARCHAR(30) NOT NULL,
 Password VARCHAR(30) NOT NULL,
 DateOfBirth DATE
);

ALTER TABLE Employee ADD CONSTRAINT PK_Employee PRIMARY KEY (Login);


CREATE TABLE Brand (
 BrandName VARCHAR(30) NOT NULL
);

ALTER TABLE Brand ADD CONSTRAINT PK_Brand PRIMARY KEY (BrandName);


CREATE TABLE Role (
 RoleName VARCHAR(30) NOT NULL
);

ALTER TABLE Role ADD CONSTRAINT PK_Role PRIMARY KEY (RoleName);


CREATE TABLE RolesPerEmployee (
 Login VARCHAR(30) NOT NULL,
 RoleName VARCHAR(30) NOT NULL
);

ALTER TABLE RolesPerEmployee ADD CONSTRAINT PK_RolesPerEmployee PRIMARY KEY (Login,RoleName);


CREATE TABLE GameType (
 GameTypeName VARCHAR(30) NOT NULL
);

ALTER TABLE GameType ADD CONSTRAINT PK_GameType PRIMARY KEY (GameTypeName);


CREATE TABLE Status (
 StatusName VARCHAR(30) NOT NULL
);

ALTER TABLE Status ADD CONSTRAINT PK_Status PRIMARY KEY (StatusName);


CREATE TABLE Type (
 TypeName VARCHAR(30) NOT NULL
);

ALTER TABLE Type ADD CONSTRAINT PK_Type PRIMARY KEY (TypeName);


CREATE TABLE Publisher (
 PublisherName VARCHAR(30) NOT NULL
);

ALTER TABLE Publisher ADD CONSTRAINT PK_Publisher PRIMARY KEY (PublisherName);


CREATE TABLE ConsoleCatalogus (
 BrandName VARCHAR(30) NOT NULL,
 TypeName VARCHAR(30) NOT NULL,
 CurrentPrice DECIMAL(6,2) NOT NULL
);

ALTER TABLE ConsoleCatalogus ADD CONSTRAINT PK_ConsoleCatalogus PRIMARY KEY (BrandName,TypeName);


CREATE TABLE Console (
 Barcode CHAR(13) NOT NULL,
 BrandName VARCHAR(30) NOT NULL,
 TypeName VARCHAR(30) NOT NULL,
 Price DECIMAL(6,2) NOT NULL,
 Comment VARCHAR(254),
 StatusName VARCHAR(30)
);

ALTER TABLE Console ADD CONSTRAINT PK_Console PRIMARY KEY (Barcode);


CREATE TABLE GameCatalogus (
 Title VARCHAR(30) NOT NULL,
 PublisherName VARCHAR(30) NOT NULL,
 YearOfRelease DATE NOT NULL,
 Description VARCHAR(254) NOT NULL,
 CurrentPrice DECIMAL(6,2) NOT NULL,
 AgeCategoryName VARCHAR(30)
);

ALTER TABLE GameCatalogus ADD CONSTRAINT PK_GameCatalogus PRIMARY KEY (Title,PublisherName,YearOfRelease);


CREATE TABLE GameTypesPerGame (
 GameTypeName VARCHAR(30) NOT NULL,
 Title VARCHAR(30) NOT NULL,
 PublisherName VARCHAR(30) NOT NULL,
 YearOfRelease DATE NOT NULL
);

ALTER TABLE GameTypesPerGame ADD CONSTRAINT PK_GameTypesPerGame PRIMARY KEY (GameTypeName,Title,PublisherName,YearOfRelease);


CREATE TABLE Rental (
 Emailadres VARCHAR(50) NOT NULL,
 StartDatetime DATETIME NOT NULL,
 Deposit DECIMAL(6,2) NOT NULL,
 Price DECIMAL(6,2) NOT NULL,
 EndDatetime DATETIME NOT NULL,
 Status VARCHAR(30) NOT NULL
);

ALTER TABLE Rental ADD CONSTRAINT PK_Rental PRIMARY KEY (Emailadres,StartDatetime);


CREATE TABLE Game (
 Barcode CHAR(13) NOT NULL,
 Title VARCHAR(30) NOT NULL,
 PublisherName VARCHAR(30) NOT NULL,
 YearOfRelease DATE NOT NULL,
 Price DECIMAL(6,2) NOT NULL,
 StatusName VARCHAR(30)
);

ALTER TABLE Game ADD CONSTRAINT PK_Game PRIMARY KEY (Barcode);


CREATE TABLE Damage (
 DamageNr INT NOT NULL,
 Barcode CHAR(13) NOT NULL,
 Login VARCHAR(30) NOT NULL,
 Emailadres VARCHAR(50) NOT NULL,
 DamageCost DECIMAL(6,2) NOT NULL,
 PredictedReady DATE NOT NULL,
 Status VARCHAR(30) NOT NULL
);

ALTER TABLE Damage ADD CONSTRAINT PK_Damage PRIMARY KEY (DamageNr);


CREATE TABLE RentedConsoles (
 Barcode CHAR(13) NOT NULL,
 Emailadres VARCHAR(50) NOT NULL,
 StartDatetime DATETIME NOT NULL
);

ALTER TABLE RentedConsoles ADD CONSTRAINT PK_RentedConsoles PRIMARY KEY (Barcode,Emailadres,StartDatetime);


CREATE TABLE CategoriesPerGame (
 CategoryName VARCHAR(30) NOT NULL,
 Title VARCHAR(30) NOT NULL,
 PublisherName VARCHAR(30) NOT NULL,
 YearOfRelease DATE NOT NULL
);

ALTER TABLE CategoriesPerGame ADD CONSTRAINT PK_CategoriesPerGame PRIMARY KEY (CategoryName,Title,PublisherName,YearOfRelease);


CREATE TABLE PurchasedConsoles (
 Barcode CHAR(13) NOT NULL,
 Emailadres VARCHAR(50) NOT NULL,
 PurchaseDatetime DATETIME NOT NULL
);

ALTER TABLE PurchasedConsoles ADD CONSTRAINT PK_PurchasedConsoles PRIMARY KEY (Barcode,Emailadres,PurchaseDatetime);


CREATE TABLE RentedGames (
 Barcode CHAR(13) NOT NULL,
 Emailadres VARCHAR(50) NOT NULL,
 StartDatetime DATETIME NOT NULL
);

ALTER TABLE RentedGames ADD CONSTRAINT PK_RentedGames PRIMARY KEY (Barcode,Emailadres,StartDatetime);


CREATE TABLE PurchasedGames (
 Barcode CHAR(13) NOT NULL,
 Emailadres VARCHAR(50) NOT NULL,
 PurchaseDatetime DATETIME NOT NULL
);

ALTER TABLE PurchasedGames ADD CONSTRAINT PK_PurchasedGames PRIMARY KEY (Barcode,Emailadres,PurchaseDatetime);

/*================================================================*/
/* Add FOREIGN KEYS 					                          */
/*================================================================*/


ALTER TABLE Purchase ADD CONSTRAINT FK_PurchaseCustomer FOREIGN KEY (Emailadres) REFERENCES Customer (Emailadres) ON UPDATE NO ACTION ON DELETE NO ACTION;


ALTER TABLE RolesPerEmployee ADD CONSTRAINT FK_RolesPerEmployeeEmployee FOREIGN KEY (Login) REFERENCES Employee (Login) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE RolesPerEmployee ADD CONSTRAINT FK_RolesPerEmployeeRole FOREIGN KEY (RoleName) REFERENCES Role (RoleName) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE ConsoleCatalogus ADD CONSTRAINT FK_ConsoleCatalogusBrand FOREIGN KEY (BrandName) REFERENCES Brand (BrandName) ON UPDATE CASCADE ON DELETE NO ACTION;
ALTER TABLE ConsoleCatalogus ADD CONSTRAINT FK_ConsoleCatalogusType FOREIGN KEY (TypeName) REFERENCES Type (TypeName) ON UPDATE CASCADE ON DELETE NO ACTION;


ALTER TABLE Console ADD CONSTRAINT FK_ConsoleConsoleCatalogus FOREIGN KEY (BrandName,TypeName) REFERENCES ConsoleCatalogus (BrandName,TypeName) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE Console ADD CONSTRAINT FK_ConsoleStatus FOREIGN KEY (StatusName) REFERENCES Status (StatusName) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE GameCatalogus ADD CONSTRAINT FK_GameCatalogusPublisher FOREIGN KEY (PublisherName) REFERENCES Publisher (PublisherName) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE GameCatalogus ADD CONSTRAINT FK_GameCatalogusAgeCategory FOREIGN KEY (AgeCategoryName) REFERENCES AgeCategory (AgeCategoryName) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE GameTypesPerGame ADD CONSTRAINT FK_GameTypesPerGameGameType FOREIGN KEY (GameTypeName) REFERENCES GameType (GameTypeName) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE GameTypesPerGame ADD CONSTRAINT FK_GameTypesPerGameGameCatalogus FOREIGN KEY (Title,PublisherName,YearOfRelease) REFERENCES GameCatalogus (Title,PublisherName,YearOfRelease) ON UPDATE CASCADE ON DELETE NO ACTION;


ALTER TABLE Rental ADD CONSTRAINT FK_RentalCustomer FOREIGN KEY (Emailadres) REFERENCES Customer (Emailadres) ON UPDATE CASCADE ON DELETE NO ACTION;


ALTER TABLE Game ADD CONSTRAINT FK_GameGameCatalogus FOREIGN KEY (Title,PublisherName,YearOfRelease) REFERENCES GameCatalogus (Title,PublisherName,YearOfRelease) ON UPDATE CASCADE ON DELETE NO ACTION;
ALTER TABLE Game ADD CONSTRAINT FK_GameStatus FOREIGN KEY (StatusName) REFERENCES Status (StatusName) ON UPDATE CASCADE ON DELETE NO ACTION;


ALTER TABLE Damage ADD CONSTRAINT FK_DamageConsole FOREIGN KEY (Barcode) REFERENCES Console (Barcode) ON UPDATE CASCADE ON DELETE NO ACTION;
ALTER TABLE Damage ADD CONSTRAINT FK_DamageEmployee FOREIGN KEY (Login) REFERENCES Employee (Login) ON UPDATE CASCADE ON DELETE NO ACTION;
ALTER TABLE Damage ADD CONSTRAINT FK_DamageCustomer FOREIGN KEY (Emailadres) REFERENCES Customer (Emailadres) ON UPDATE CASCADE ON DELETE NO ACTION;


ALTER TABLE RentedConsoles ADD CONSTRAINT FK_RentedConsolesConsole FOREIGN KEY (Barcode) REFERENCES Console (Barcode) ON UPDATE CASCADE ON DELETE NO ACTION;
ALTER TABLE RentedConsoles ADD CONSTRAINT FK_RentedConsolesRental FOREIGN KEY (Emailadres,StartDatetime) REFERENCES Rental (Emailadres,StartDatetime) ON UPDATE CASCADE ON DELETE NO ACTION;


ALTER TABLE CategoriesPerGame ADD CONSTRAINT FK_CategoriesPerGameCategory FOREIGN KEY (CategoryName) REFERENCES Category (CategoryName) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE CategoriesPerGame ADD CONSTRAINT FK_CategoriesPerGameGameCatalogus FOREIGN KEY (Title,PublisherName,YearOfRelease) REFERENCES GameCatalogus (Title,PublisherName,YearOfRelease) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE PurchasedConsoles ADD CONSTRAINT FK_PurchasedConsolesConsole FOREIGN KEY (Barcode) REFERENCES Console (Barcode) ON UPDATE CASCADE ON DELETE NO ACTION;
ALTER TABLE PurchasedConsoles ADD CONSTRAINT FK_PurchasedConsolesPurchase FOREIGN KEY (Emailadres,PurchaseDatetime) REFERENCES Purchase (Emailadres,PurchaseDatetime) ON UPDATE CASCADE ON DELETE NO ACTION;


ALTER TABLE RentedGames ADD CONSTRAINT FK_RentedGamesGame FOREIGN KEY (Barcode) REFERENCES Game (Barcode) ON UPDATE CASCADE ON DELETE NO ACTION;
ALTER TABLE RentedGames ADD CONSTRAINT FK_RentedGamesRental FOREIGN KEY (Emailadres,StartDatetime) REFERENCES Rental (Emailadres,StartDatetime) ON UPDATE CASCADE ON DELETE NO ACTION;


ALTER TABLE PurchasedGames ADD CONSTRAINT FK_PurchasedGamesGame FOREIGN KEY (Barcode) REFERENCES Game (Barcode) ON UPDATE CASCADE ON DELETE NO ACTION;
ALTER TABLE PurchasedGames ADD CONSTRAINT FK_PurchasedGamesPurchase FOREIGN KEY (Emailadres,PurchaseDatetime) REFERENCES Purchase (Emailadres,PurchaseDatetime) ON UPDATE CASCADE ON DELETE NO ACTION;

/*==============================================================*/
/* Add check contraints									*/
/*==============================================================*/

-- Mobile phone starts with 06
ALTER TABLE Customer
ADD CONSTRAINT CH_MobileStart CHECK ( SUBSTRING( MobilePhone,1,2) = '06');

-- Mobile phone has an length of exactly 10
ALTER TABLE Customer
ADD CONSTRAINT CH_MobileLength CHECK (LEN(MobilePhone)=10);

-- PostalCode starts with 4 numbers and 2 chars
ALTER TABLE Customer
ADD CONSTRAINT CH_PostalCode CHECK (PostalCode like '[0-9][0-9][0-9][0-9][A-Z][A-Z]');

-- Gender can contain M(ale), F(emale) or (N)eutral
ALTER TABLE Customer
ADD CONSTRAINT CH_Gender CHECK (Gender IN ('M','F', 'N'))

-- Day of Birth is after 01-01-1900
ALTER TABLE Customer
ADD CONSTRAINT CH_Date CHECK (DateOfBirth >= '1900-01-01');

-- Check if the email has an correct syntax
ALTER TABLE Customer
ADD CONSTRAINT CH_Emailadres  CHECK(Emailadres LIKE '%___@___%.__%')

-- Password needs to have a minimal length of 6, needs 1 number.
ALTER TABLE Employee
ADD CONSTRAINT CH_Password CHECK (Password like '%[0-9]%' and LEN(Password) >= 6);