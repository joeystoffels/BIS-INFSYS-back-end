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
  A.UITGEVER,
  HO.HUURSTATUS
FROM ARTIKEL A
  INNER JOIN ARTIKELENVERHUUR AV ON A.BARCODE = AV.BARCODE
  INNER JOIN HUUROVEREENKOMST HO ON AV.STARTDATUM = HO.STARTDATUM
WHERE HO.HUURSTATUS = 'VERHUURD';

-- 9B: Lijst met spellen die niet verhuurd zijn in 2016.
SELECT
  A.TITEL,
  A.UITGEVER
FROM ARTIKEL A
WHERE A.TITEL NOT IN (
  SELECT A2.TITEL
  FROM ARTIKELENVERHUUR AV
    LEFT JOIN ARTIKEL A2 ON A2.BARCODE = AV.BARCODE
    LEFT JOIN HUUROVEREENKOMST HO ON AV.STARTDATUM = HO.STARTDATUM
    WHERE HO.HUURSTATUS = 'VERHUURD' AND
        YEAR(HO.STARTDATUM) = 2016
        AND A2.SPEL_OF_CONSOLE = 'SPEL'
)
GROUP BY A.TITEL, A.UITGEVER;


-- 9C: Omzetten van iedere maand van de jaren 2012 tot en met 2017.
CREATE VIEW HELPER AS
  SELECT
    (CASE
     WHEN YEAR(A1.DATUM) IS NULL
       THEN CASE
            WHEN YEAR(B2.DATUM) IS NULL
              THEN CASE
                   WHEN YEAR(C3.DATUM) IS NULL
                     THEN 'ERROR'
                   ELSE YEAR(C3.DATUM)
                   END
            ELSE YEAR(B2.DATUM)
            END
     ELSE YEAR(A1.DATUM)
     END) AS 'JAAR',
    (CASE
     WHEN MONTH(A1.DATUM) IS NULL
       THEN CASE
            WHEN MONTH(B2.DATUM) IS NULL
              THEN CASE
                   WHEN MONTH(C3.DATUM) IS NULL
                     THEN 'ERROR'
                   ELSE MONTH(C3.DATUM)
                   END
            ELSE MONTH(B2.DATUM)
            END
     ELSE MONTH(A1.DATUM)
     END) AS 'MAAND',
    (ISNULL(A1.[VERHUUR], 0) +
     ISNULL(B2.[VERKOOP], 0) +
     ISNULL(C3.[REPARATIE], 0)) AS 'OMZET'
  FROM
    (SELECT AV.STARTDATUM AS 'DATUM', SUM(CONVERT(INT, HO.[EINDDATUM] - HO.[STARTDATUM]) * A.[PRIJS_PER_D]) AS 'VERHUUR'
     FROM ARTIKEL A
       INNER JOIN ARTIKELENVERHUUR AV ON A.[BARCODE] = AV.[BARCODE]
       INNER JOIN HUUROVEREENKOMST HO ON AV.[EMAILADRES] = HO.EMAILADRES AND AV.[STARTDATUM] = HO.[STARTDATUM]
     GROUP BY AV.STARTDATUM) AS A1
    FULL JOIN

    (SELECT AK.DATUM AS 'DATUM', SUM(A.[PRIJS]) AS 'VERKOOP'
     FROM ARTIKEL A
       INNER JOIN ARTIKELENVERKOOP AK ON A.[BARCODE] = AK.[BARCODE]
       INNER JOIN VERKOOPOVEREENKOMST VO ON AK.[EMAILADRES] = VO.[EMAILADRES] AND AK.[DATUM] = VO.[DATUM]
     GROUP BY AK.DATUM) AS B2 ON A1.DATUM = B2.DATUM
    FULL JOIN

    (SELECT R.STARTDATUM AS 'DATUM', SUM(R.[KOSTEN]) AS 'REPARATIE'
     FROM REPARATIE R
     GROUP BY R.STARTDATUM) AS C3 ON B2.DATUM = C3.DATUM
  GROUP BY
    (CASE
     WHEN YEAR(A1.DATUM) IS NULL
       THEN CASE
            WHEN YEAR(B2.DATUM) IS NULL
              THEN CASE
                   WHEN YEAR(C3.DATUM) IS NULL
                     THEN 'ERROR'
                   ELSE YEAR(C3.DATUM)
                   END
            ELSE YEAR(B2.DATUM)
            END
     ELSE YEAR(A1.DATUM)
     END),
    (CASE
     WHEN MONTH(A1.DATUM) IS NULL
       THEN CASE
            WHEN MONTH(B2.DATUM) IS NULL
              THEN CASE
                   WHEN MONTH(C3.DATUM) IS NULL
                     THEN 'ERROR'
                   ELSE MONTH(C3.DATUM)
                   END
            ELSE MONTH(B2.DATUM)
            END
     ELSE MONTH(A1.DATUM)
     END),
    (ISNULL(A1.[VERHUUR], 0) +
     ISNULL(B2.[VERKOOP], 0) +
     ISNULL(C3.[REPARATIE], 0))
GO

SELECT
  JAAR,
  MAAND,
  SUM(OMZET) AS 'OMZET'
FROM
  HELPER GROUP BY JAAR, MAAND
  ORDER BY JAAR, MAAND
GO


-- 9D: Overzicht van de top 10 van populairste spellen.



-- 9E: Consoles die in reparatie staan.

-- 9F: Omzetten per klant in een jaar, gesorteerd van hoog naar laag. Verdeel de klanten in Gold, Silver, Bronze zoals beschreven in de casus.

-- 9G: Inkoophoeveelheid (aantal artikelen) en totaalbedrag per jaar.