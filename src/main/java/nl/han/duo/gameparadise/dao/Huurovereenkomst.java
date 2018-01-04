package nl.han.duo.gameparadise.dao;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Huurovereenkomst implements Serializable {

    @Id
    private java.sql.Timestamp startdatum;

    @Id
    private String emailadres;

    private java.sql.Timestamp einddatum;

    @Column(columnDefinition = "char")
    private String huurstatus;

    private Boolean schade;

    private Boolean reparabel;
}