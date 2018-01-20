package nl.han.duo.gameparadise.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.han.duo.gameparadise.dto.opdracht_7.*;

import javax.persistence.*;

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "OPDRACHT_7A",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_7A.class,
                                columns = {
                                        @ColumnResult(name = "OMZET_JANUARI_2015", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_7B",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_7B.class,
                                columns = {
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "UITGEVER", type = String.class),
                                        @ColumnResult(name = "AANTAL_KEER_VERHUURD", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_7C",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_7C.class,
                                columns = {
                                        @ColumnResult(name = "EINDDATUM", type = String.class),
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "HUURSTATUS", type = String.class),
                                        @ColumnResult(name = "STARTDATUM", type = String.class),
                                        @ColumnResult(name = "BEDRAG", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_7D",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_7D.class,
                                columns = {
                                        @ColumnResult(name = "TOTALE_SCHADE_2016", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_7E",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_7E.class,
                                columns = {
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "MERK", type = String.class),
                                        @ColumnResult(name = "TYPE", type = String.class),
                                        @ColumnResult(name = "PRIJS", type = String.class),
                                        @ColumnResult(name = "PRIJS_PER_D", type = String.class),
                                        @ColumnResult(name = "SCHADEBEDRAG", type = String.class)
                                }
                        )
                }
        ),

})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Opdracht_7.get7a",
                query = "SELECT * FROM OPDRACHT_7A",
                resultSetMapping = "OPDRACHT_7A"
        ),
        @NamedNativeQuery(
                name = "Opdracht_7.get7b",
                query = "SELECT * FROM OPDRACHT_7B",
                resultSetMapping = "OPDRACHT_7B"
        ),
        @NamedNativeQuery(
                name = "Opdracht_7.get7c",
                query = "SELECT * FROM OPDRACHT_7C",
                resultSetMapping = "OPDRACHT_7C"
        ),
        @NamedNativeQuery(
                name = "Opdracht_7.get7d",
                query = "SELECT * FROM OPDRACHT_7D",
                resultSetMapping = "OPDRACHT_7D"
        ),
        @NamedNativeQuery(
                name = "Opdracht_7.get7e",
                query = "select * FROM OPDRACHT_7E",
                resultSetMapping = "OPDRACHT_7E"
        )
})

@Data
@AllArgsConstructor
@Entity
public class Opdracht_7 {

    @Id
    private String placeholder;

}

