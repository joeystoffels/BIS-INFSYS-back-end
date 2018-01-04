package nl.han.duo.gameparadise.dao;

import lombok.Data;
import nl.han.duo.gameparadise.dao.Klant;

import javax.persistence.*;
import java.io.Serializable;

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