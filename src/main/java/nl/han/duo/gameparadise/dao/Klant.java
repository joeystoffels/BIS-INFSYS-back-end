package nl.han.duo.gameparadise.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "klantentelefoon",
                classes = {
                        @ConstructorResult(
                                targetClass = NieuweKlant.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "ACHTERNAAM", type = String.class),
                                        @ColumnResult(name = "TELNUMMER", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "piet",
                classes = {
                        @ConstructorResult(
                                targetClass = Artikel.class,
                                columns = {
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "MERK", type = String.class),
                                        @ColumnResult(name = "TYPE", type = String.class),
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "PRIJS", type = String.class),
                                        @ColumnResult(name = "PRIJS_PER_D", type = String.class),
                                        @ColumnResult(name = "SPEL_OF_CONSOLE", type = String.class)
                                }
                        )
                }
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Klant.getKlantenTelefoonnummers",
                query = "select * FROM Henk",
                resultSetMapping = "klantentelefoon"
        ),
        @NamedNativeQuery(
                name = "Klant.getPiet",
                query = "select * FROM Piet",
                resultSetMapping = "piet"
        )
})
@Data
@Entity
public class Klant {

    @Id
    private String emailadres;

    @Column(columnDefinition = "char")
    private String merk_eigen_console;

    @Column(columnDefinition = "char")
    private String type_eigen_console;

    @NotNull
    private String voornamen;

    @NotNull
    private String achternaam;

    @NotNull
    private String adres;

    @NotNull
    @Column(columnDefinition = "char")
    private String huisnummer;

    @NotNull
    @Column(columnDefinition = "char")
    private String postcode;

    @NotNull
    private String woonplaats;

    @NotNull
    private java.sql.Timestamp geboortedatum;

    @Column(columnDefinition = "char")
    private String geslacht;

    @NotNull
    @JsonIgnore
    @Column(columnDefinition = "char")
    private String wachtwoord;

    public String getGeboortedatum() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(this.geboortedatum);
    }
}
