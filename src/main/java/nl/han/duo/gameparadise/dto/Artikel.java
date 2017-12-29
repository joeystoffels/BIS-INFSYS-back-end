package nl.han.duo.gameparadise.dto;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Artikel {
    @Id
    @Column(columnDefinition = "char")
    private String barcode;

    private String merk;

    private String type;

    private String titel;

    @Column(name = "PRIJS", columnDefinition="smallmoney")
    private BigDecimal prijs;

    private String prijsPerD;

    @Column(columnDefinition = "char")
    private String spelOfConsole;

    private Integer jaarUitgave;

    private String uitgever;
}