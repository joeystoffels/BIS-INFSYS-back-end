package nl.han.duo.gameparadise.dto;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@NamedQueries({
        @NamedQuery(
                name = "Klant.findAllByQuery",
                query = "SELECT k FROM Klant k"
        ),
        @NamedQuery(
                name = "Klant.findByTest",
                query = "SELECT k FROM Klant k WHERE k.typeEigenConsole = 'PS3'"
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "Huurhistorie",
                classes = {
                        @ConstructorResult(
                                targetClass = HuurHistorie.class,
                                columns = {
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "MERK", type = String.class),
                                        @ColumnResult(name = "TYPE", type = String.class),
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "UITGEVER", type = String.class),
                                        @ColumnResult(name = "JAAR_UITGAVE", type = Long.class),
                                        @ColumnResult(name = "STARTDATUM", type = Date.class),
                                        @ColumnResult(name = "EINDDATUM", type = Date.class),
                                        @ColumnResult(name = "KOSTEN", type = String.class),
                                        @ColumnResult(name = "EMAILADRES", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "Klantoverzicht",
                classes = {
                        @ConstructorResult(
                                targetClass = KlantOverzicht.class,
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
                                        @ColumnResult(name = "GEBOORTEDATUM", type = Date.class),
                                        @ColumnResult(name = "GESLACHT", type = String.class),
                                        @ColumnResult(name = "OMZET", type = String.class),
                                        @ColumnResult(name = "STATUS", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "Klantomzet",
                classes = {
                        @ConstructorResult(
                                targetClass = KlantOmzet.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "JAAR", type = Long.class),
                                        @ColumnResult(name = "OMZET", type = String.class)
                                }
                        )
                }
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Klant.getHuurhistorieByEmail",
                query = "select BARCODE, MERK, TYPE, TITEL, UITGEVER, JAAR_UITGAVE, STARTDATUM, EINDDATUM, KOSTEN, EMAILADRES from Opdr8_HuurHistorie WHERE EMAILADRES = :emailadres",
                resultSetMapping = "Huurhistorie"
        ),
        @NamedNativeQuery(
                name = "Klant.getAllHuurhistorie",
                query = "select BARCODE, MERK, TYPE, TITEL, UITGEVER, JAAR_UITGAVE, STARTDATUM, EINDDATUM, KOSTEN, EMAILADRES from Opdr8_HuurHistorie",
                resultSetMapping = "Huurhistorie"
        ),
        @NamedNativeQuery(
                name = "Klant.getOverzicht",
                query = "select EMAILADRES, MERK_EIGEN_CONSOLE, TYPE_EIGEN_CONSOLE, VOORNAMEN, ACHTERNAAM, STRAATNAAM, HUISNUMMER, POSTCODE, WOONPLAATS, GEBOORTEDATUM, GESLACHT, WACHTWOORD, OMZET , STATUS from Opdr8_Overzicht",
                resultSetMapping = "Klantoverzicht"
        ),
        @NamedNativeQuery(
                name = "Klant.getOmzet",
                query = "select EMAILADRES, JAAR, OMZET from Opdr8_OmzetKlantPerJaar WHERE EMAILADRES = :emailadres",
                resultSetMapping = "Klantomzet"
        )
})
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