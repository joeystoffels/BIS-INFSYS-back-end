package nl.han.duo.gameparadise.dto;

import lombok.Data;

import javax.persistence.*;

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
@SqlResultSetMapping(
        name = "Huurhistorie",
        classes = {
                @ConstructorResult(
                        targetClass = HuurHistorie.class,
                        columns = {
                                @ColumnResult(name = "EMAILADRES", type = String.class),
                        }
                )
        }
)
@NamedNativeQuery(
        name = "Klant.getHuurhistorie",
        query = "select EMAILADRES from KLANT",
        resultSetMapping = "Huurhistorie"
)
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