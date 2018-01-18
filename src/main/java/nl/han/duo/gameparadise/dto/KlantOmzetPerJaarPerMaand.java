package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Data
@AllArgsConstructor
public class KlantOmzetPerJaarPerMaand {

    private String emailadres;
    private Long jaar;
    private BigDecimal omzet;
    private BigDecimal omzet_laatste_12_maanden;
    private String status;


    public BigDecimal getOmzet() {
        return this.omzet;
    }

    public BigDecimal getOmzet_laatste_12_maanden() {
        return omzet_laatste_12_maanden;
    }


}