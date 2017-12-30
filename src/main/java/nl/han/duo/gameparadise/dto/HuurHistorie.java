package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
    private Date startdatum;
    private Date einddatum;
    private String kosten;
    private String emailadres;
}