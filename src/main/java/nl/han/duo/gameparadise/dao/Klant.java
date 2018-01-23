package nl.han.duo.gameparadise.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.han.duo.gameparadise.dto.opdracht_7.*;
import nl.han.duo.gameparadise.dto.opdracht_8.*;
import nl.han.duo.gameparadise.dto.opdracht_9.*;

import javax.persistence.*;

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "OPDRACHT_7A",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_7A.class,
                                columns = {
                                        @ColumnResult(name = "OMZET_JANUARI_2015", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_7B",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_7B.class,
                                columns = {
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "UITGEVER", type = String.class),
                                        @ColumnResult(name = "AANTAL_KEER_VERHUURD", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_7C",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_7C.class,
                                columns = {
                                        @ColumnResult(name = "EINDDATUM", type = String.class),
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "HUURSTATUS", type = String.class),
                                        @ColumnResult(name = "STARTDATUM", type = String.class),
                                        @ColumnResult(name = "BEDRAG", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_7D",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_7D.class,
                                columns = {
                                        @ColumnResult(name = "TOTALE_SCHADE_2016", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_7E",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_7E.class,
                                columns = {
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "MERK", type = String.class),
                                        @ColumnResult(name = "TYPE", type = String.class),
                                        @ColumnResult(name = "PRIJS", type = String.class),
                                        @ColumnResult(name = "PRIJS_PER_D", type = String.class),
                                        @ColumnResult(name = "SCHADEBEDRAG", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_8A",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_8A.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "MERK_EIGEN_CONSOLE", type = String.class),
                                        @ColumnResult(name = "TYPE_EIGEN_CONSOLE", type = String.class),
                                        @ColumnResult(name = "VOORNAMEN", type = String.class),
                                        @ColumnResult(name = "ACHTERNAAM", type = String.class),
                                        @ColumnResult(name = "STRAATNAAM", type = String.class),
                                        @ColumnResult(name = "HUISNUMMER", type = String.class),
                                        @ColumnResult(name = "POSTCODE", type = String.class),
                                        @ColumnResult(name = "WOONPLAATS", type = String.class),
                                        @ColumnResult(name = "GEBOORTEDATUM", type = String.class),
                                        @ColumnResult(name = "GESLACHT", type = String.class),
                                        @ColumnResult(name = "WACHTWOORD", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_8B",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_8B.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "STARTDATUM", type = String.class),
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "BEDRAG", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_8C",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_8C.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "DATUM", type = String.class),
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "BEDRAG", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_8D",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_8D.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "OMZET_2014", type = String.class),
                                        @ColumnResult(name = "OMZET_2015", type = String.class),
                                        @ColumnResult(name = "OMZET_2016", type = String.class),
                                        @ColumnResult(name = "OMZET_2017", type = String.class),
                                        @ColumnResult(name = "TOTALE_OMZET", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_8E",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_8E.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "STATUS", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9A",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9A.class,
                                columns = {
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "MERK", type = String.class),
                                        @ColumnResult(name = "TYPE", type = String.class),
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "PRIJS", type = String.class),
                                        @ColumnResult(name = "PRIJS_PER_D", type = String.class),
                                        @ColumnResult(name = "SPEL_OF_CONSOLE", type = String.class),
                                        @ColumnResult(name = "JAAR_UITGAVE", type = String.class),
                                        @ColumnResult(name = "UITGEVER", type = String.class),
                                        @ColumnResult(name = "HUURSTATUS", type = String.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9B",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9B.class,
                                columns = {
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "UITGEVER", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9C",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9C.class,
                                columns = {
                                        @ColumnResult(name = "JAAR", type = String.class),
                                        @ColumnResult(name = "MAAND", type = String.class),
                                        @ColumnResult(name = "OMZET", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9D",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9D.class,
                                columns = {
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "AANTAL_KEER_VERKOCHT_VERHUURD", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9E",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9E.class,
                                columns = {
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "MERK", type = String.class),
                                        @ColumnResult(name = "TYPE", type = String.class),
                                        @ColumnResult(name = "STARTDATUM", type = String.class),
                                        @ColumnResult(name = "DATUM_GEREED", type = String.class),
                                        @ColumnResult(name = "REPARATIESTATUS", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9F",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9F.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "STATUS", type = String.class),
                                        @ColumnResult(name = "OMZET", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9G",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9G.class,
                                columns = {
                                        @ColumnResult(name = "JAAR", type = String.class),
                                        @ColumnResult(name = "AANTAL_ARTIKELEN", type = String.class),
                                        @ColumnResult(name = "TOTAALBEDRAG", type = String.class)
                                }
                        )
                }
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Klant.get7a",
                query = "SELECT * FROM OPDRACHT_7A",
                resultSetMapping = "OPDRACHT_7A"
        ),
        @NamedNativeQuery(
                name = "Klant.get7b",
                query = "SELECT * FROM OPDRACHT_7B",
                resultSetMapping = "OPDRACHT_7B"
        ),
        @NamedNativeQuery(
                name = "Klant.get7c",
                query = "SELECT * FROM OPDRACHT_7C",
                resultSetMapping = "OPDRACHT_7C"
        ),
        @NamedNativeQuery(
                name = "Klant.get7d",
                query = "SELECT * FROM OPDRACHT_7D",
                resultSetMapping = "OPDRACHT_7D"
        ),
        @NamedNativeQuery(
                name = "Klant.get7e",
                query = "select * FROM OPDRACHT_7E",
                resultSetMapping = "OPDRACHT_7E"
        ),
        @NamedNativeQuery(
                name = "Klant.get8a",
                query = "SELECT * FROM OPDRACHT_8A",
                resultSetMapping = "OPDRACHT_8A"
        ),
        @NamedNativeQuery(
                name = "Klant.get8b",
                query = "SELECT * FROM OPDRACHT_8B WHERE EMAILADRES = :emailadres",
                resultSetMapping = "OPDRACHT_8B"
        ),
        @NamedNativeQuery(
                name = "Klant.get8c",
                query = "SELECT * FROM OPDRACHT_8C WHERE EMAILADRES = :emailadres",
                resultSetMapping = "OPDRACHT_8C"
        ),
        @NamedNativeQuery(
                name = "Klant.get8d",
                query = "SELECT * FROM OPDRACHT_8D WHERE EMAILADRES = :emailadres",
                resultSetMapping = "OPDRACHT_8D"
        ),
        @NamedNativeQuery(
                name = "Klant.get8e",
                query = "select * FROM OPDRACHT_8E WHERE EMAILADRES = :emailadres",
                resultSetMapping = "OPDRACHT_8E"
        ),
        @NamedNativeQuery(
                name = "Klant.get9a",
                query = "SELECT * FROM OPDRACHT_9A",
                resultSetMapping = "OPDRACHT_9A"
        ),
        @NamedNativeQuery(
                name = "Klant.get9b",
                query = "SELECT * FROM OPDRACHT_9B",
                resultSetMapping = "OPDRACHT_9B"
        ),
        @NamedNativeQuery(
                name = "Klant.get9c",
                query = "SELECT * FROM OPDRACHT_9C",
                resultSetMapping = "OPDRACHT_9C"
        ),
        @NamedNativeQuery(
                name = "Klant.get9d",
                query = "SELECT * FROM OPDRACHT_9D",
                resultSetMapping = "OPDRACHT_9D"
        ),
        @NamedNativeQuery(
                name = "Klant.get9e",
                query = "select * FROM OPDRACHT_9E",
                resultSetMapping = "OPDRACHT_9E"
        ),
        @NamedNativeQuery(
                name = "Klant.get9f",
                query = "select * FROM OPDRACHT_9F",
                resultSetMapping = "OPDRACHT_9F"
        )
        ,
        @NamedNativeQuery(
                name = "Klant.get9g",
                query = "select * FROM OPDRACHT_9G",
                resultSetMapping = "OPDRACHT_9G"
        )
})

@Data
@AllArgsConstructor
@Entity
public class Klant {


    @Id
    private String emailadres;

    private String voornamen;

    private String achternaam;

    private String straatnaam;

    @Column(columnDefinition = "char")
    private String huisnummer;

    @Column(columnDefinition = "char")
    private String postcode;

    private String woonplaats;

    private java.sql.Timestamp geboortedatum;

    @Column(columnDefinition = "char")
    private String geslacht;

    @Column(columnDefinition = "char")
    private String wachtwoord;

    private String merkEigenConsole;

    private String typeEigenConsole;

    public String getWachtwoord() {
        return wachtwoord.trim();
    }

    public String getMerkEigenConsole() {
        return merkEigenConsole.trim();
    }

    public String getTypeEigenConsole() {
        return typeEigenConsole.trim();
    }

}

