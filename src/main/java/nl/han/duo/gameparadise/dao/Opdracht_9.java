/*
package nl.han.duo.gameparadise.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.han.duo.gameparadise.dto.opdracht_9.*;

import javax.persistence.*;

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "OPDRACHT_9A",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9A.class,
                                columns = {
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "MERK", type = String.class),
                                        @ColumnResult(name = "TYPE", type = String.class),
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "PRIJS", type = String.class),
                                        @ColumnResult(name = "PRIJS_PER_D", type = String.class),
                                        @ColumnResult(name = "SPEL_OF_CONSOLE", type = String.class),
                                        @ColumnResult(name = "JAAR_UITGAVE", type = String.class),
                                        @ColumnResult(name = "UITGEVER", type = String.class),
                                        @ColumnResult(name = "HUURSTATUS", type = String.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9B",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9B.class,
                                columns = {
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "UITGEVER", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9C",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9C.class,
                                columns = {
                                        @ColumnResult(name = "JAAR", type = String.class),
                                        @ColumnResult(name = "MAAND", type = String.class),
                                        @ColumnResult(name = "OMZET", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9D",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9D.class,
                                columns = {
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "AANTAL_KEER_VERKOCHT_VERHUURD", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9E",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9E.class,
                                columns = {
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "MERK", type = String.class),
                                        @ColumnResult(name = "TYPE", type = String.class),
                                        @ColumnResult(name = "STARTDATUM", type = String.class),
                                        @ColumnResult(name = "DATUM_GEREED", type = String.class),
                                        @ColumnResult(name = "REPARATIESTATUS", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9F",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9F.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "STATUS", type = String.class),
                                        @ColumnResult(name = "OMZET", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_9G",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_9G.class,
                                columns = {
                                        @ColumnResult(name = "JAAR", type = String.class),
                                        @ColumnResult(name = "AANTAL_ARTIKELEN", type = String.class),
                                        @ColumnResult(name = "TOTAALBEDRAG", type = String.class)
                                }
                        )
                }
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Opdracht_9.get9a",
                query = "SELECT * FROM OPDRACHT_9A",
                resultSetMapping = "OPDRACHT_9A"
        ),
        @NamedNativeQuery(
                name = "Opdracht_9.get9b",
                query = "SELECT * FROM OPDRACHT_9B",
                resultSetMapping = "OPDRACHT_9B"
        ),
        @NamedNativeQuery(
                name = "Opdracht_9.get9c",
                query = "SELECT * FROM OPDRACHT_9C",
                resultSetMapping = "OPDRACHT_9C"
        ),
        @NamedNativeQuery(
                name = "Opdracht_9.get9d",
                query = "SELECT * FROM OPDRACHT_9D",
                resultSetMapping = "OPDRACHT_9D"
        ),
        @NamedNativeQuery(
                name = "Opdracht_9.get9e",
                query = "select * FROM OPDRACHT_9E",
                resultSetMapping = "OPDRACHT_9E"
        ),
        @NamedNativeQuery(
                name = "Opdracht_9.get9f",
                query = "select * FROM OPDRACHT_9F",
                resultSetMapping = "OPDRACHT_9F"
        )
        ,
        @NamedNativeQuery(
                name = "Opdracht_9.get9g",
                query = "select * FROM OPDRACHT_9G",
                resultSetMapping = "OPDRACHT_9G"
        )
})

@Data
@AllArgsConstructor
@Entity
public class Opdracht_9 {

    @Id
    private String placeholder;

}

*/
