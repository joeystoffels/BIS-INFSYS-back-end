package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
public class KlantOverzicht {

    private String emailadres;
    private String merkEigenConsole;
    private String typeEigenConsole;
    private String voornamen;
    private String achternaam;
    private String straatnaam;
    private String huisnummer;
    private String postcode;
    private String woonplaats;
    private Date geboortedatum;
    private String geslacht;
    private String omzet;
    private String status;

    public String getHuisnummer() {
        return huisnummer.trim();
    }

    public String getMerkEigenConsole() {
        return merkEigenConsole.trim();
    }

    public String getTypeEigenConsole() {
        return typeEigenConsole.trim();
    }

    public String getGeboortedatum() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(geboortedatum);
    }
}