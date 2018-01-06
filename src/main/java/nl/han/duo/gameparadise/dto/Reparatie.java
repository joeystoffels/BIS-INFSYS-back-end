package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
public class Reparatie {
    private Long schadenummer;
    private String barcode;
    private Date startdatum;
    private String inlognaam;
    private Date datum_gereed;
    private String kosten;
    private String reparatiestatus;
    private String emailadres;


    public String getStartdatum() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(startdatum);
    }

    public String getDatum_gereed() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(datum_gereed);
    }

    public String getInlognaam() {
        return inlognaam.trim();
    }

    public String getReparatiestatus() {
        return reparatiestatus.trim();
    }
}
