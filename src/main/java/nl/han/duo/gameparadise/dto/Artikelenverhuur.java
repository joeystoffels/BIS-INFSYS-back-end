package nl.han.duo.gameparadise.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Artikelenverhuur implements Serializable {

    @Id
    @Column(columnDefinition = "char")
    private String barcode;

    @Id
    private java.sql.Timestamp startdatum;

    @Id
    @ManyToOne
    @JoinColumn(name = "emailadres")
    private Klant emailadres;
}