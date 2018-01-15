-- 9A: Overzicht van artikelen die momenteel verhuurd zijn.
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
FROM ARTIKEL A
  INNER JOIN ARTIKELENVERHUUR AV ON A.BARCODE = AV.BARCODE
  INNER JOIN HUUROVEREENKOMST HO ON AV.STARTDATUM = HO.STARTDATUM
WHERE HO.HUURSTATUS = 'VERHUURD';


-- 9B: Lijst met spellen die niet verhuurd zijn in 2016.
SELECT
  A.BARCODE,
  A.MERK,
  A.TYPE,
  A.TITEL,
  A.PRIJS,
  A.PRIJS_PER_D,
  A.SPEL_OF_CONSOLE,
  A.JAAR_UITGAVE,
  A.UITGEVER,
  HO.STARTDATUM,
  HO.EINDDATUM,
  HO.HUURSTATUS
FROM ARTIKEL A
  FULL JOIN ARTIKELENVERHUUR AV ON A.BARCODE = AV.BARCODE
  INNER JOIN HUUROVEREENKOMST HO ON AV.STARTDATUM = HO.STARTDATUM
WHERE HO.HUURSTATUS != 'VERHUURD' AND YEAR(HO.STARTDATUM) = 2016 AND YEAR(HO.EINDDATUM) = 2016;


-- 9C: Omzetten van iedere maand van de jaren 2012 tot en met 2017.

-- 9D: Overzicht van de top 10 van populairste spellen.

-- 9E: Consoles die in reparatie staan.

-- 9F: Omzetten per klant in een jaar, gesorteerd van hoog naar laag. Verdeel de klanten in Gold, Silver, Bronze zoals beschreven in de casus.

-- 9G: Inkoophoeveelheid (aantal artikelen) en totaalbedrag per jaar.