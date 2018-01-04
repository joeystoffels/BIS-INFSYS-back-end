package nl.han.duo.gameparadise.dao;

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

    @Column(name = "PRIJS_PER_D", columnDefinition="smallmoney")
    private BigDecimal prijsPerDag;

    @Column(columnDefinition = "char")
    private String spelOfConsole;

    private Integer jaarUitgave;

    private String uitgever;
}