package nl.han.duo.gameparadise.dto;

import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class HuurHistorie {

    //    private java.sql.Timestamp startdatum;
//
    private String emailadres;
//
//    private java.sql.Timestamp einddatum;
//
//    private String huurstatus;
//
//    private String schade;
//
//    private String reparabel;
//
//    private String barcode;
//
//    private String merk;
//
//    private String type;
//
//    private String titel;
//
//    private BigDecimal prijs;
//
//    private String prijsPerD;
//
//    private String spelOfConsole;
//
//    private Integer jaarUitgave;
//
//    private String uitgever;


    public HuurHistorie(String emailadres) {
        this.emailadres = emailadres;
    }
}