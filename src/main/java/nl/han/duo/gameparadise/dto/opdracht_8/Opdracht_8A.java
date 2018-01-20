package nl.han.duo.gameparadise.dto.opdracht_8;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Opdracht_8A {

    private String emailadres;
    private String merk_eigen_console;
    private String type_eigen_console;
    private String voornamen;
    private String achternaam;
    private String straatnaam;
    private String huisnummer;
    private String postcode;
    private String woonplaats;
    private String geboortedatum;
    private String geslacht;
    private String wachtwoord;

    public String getMerk_eigen_console() {
        return merk_eigen_console.trim();
    }

    public String getType_eigen_console() {
        return type_eigen_console.trim();
    }

    public String getWachtwoord() {
        return wachtwoord.trim();
    }

    public String getHuisnummer() {
        return huisnummer.trim();
    }
}