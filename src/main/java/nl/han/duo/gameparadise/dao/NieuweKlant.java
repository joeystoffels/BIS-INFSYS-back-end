package nl.han.duo.gameparadise.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@Data
@AllArgsConstructor
public class NieuweKlant {


    private String emailadres;
    private String achternaam;
    private String telnummer;


//
//    private String merk_eigen_console;
//
//
//    private String type_eigen_console;
//
//    private String voornamen;
//
//
//    private String achternaam;
//
//
//    private String adres;
//
//    private String huisnummer;
//
//    private String postcode;
//
//
//    private String woonplaats;
//
//
//    private Timestamp geboortedatum;
//
//
//    private String geslacht;
//
//    private String telnummer;
//
//    private String mobiel_of_vast;

}
