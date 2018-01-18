package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
public class HuurHistorie {

    private String barcode;
    private String merk;
    private String type;
    private String titel;
    private String uitgever;
    private Long jaarUitgave;
    private Date datum;
    private String prijs;
    private String emailadres;
    private String soort;

    public String getDatum() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(datum);
    }
}