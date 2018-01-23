/*
package nl.han.duo.gameparadise.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import nl.han.duo.gameparadise.dto.opdracht_8.*;

import javax.persistence.*;

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "OPDRACHT_8A",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_8A.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "MERK_EIGEN_CONSOLE", type = String.class),
                                        @ColumnResult(name = "TYPE_EIGEN_CONSOLE", type = String.class),
                                        @ColumnResult(name = "VOORNAMEN", type = String.class),
                                        @ColumnResult(name = "ACHTERNAAM", type = String.class),
                                        @ColumnResult(name = "STRAATNAAM", type = String.class),
                                        @ColumnResult(name = "HUISNUMMER", type = String.class),
                                        @ColumnResult(name = "POSTCODE", type = String.class),
                                        @ColumnResult(name = "WOONPLAATS", type = String.class),
                                        @ColumnResult(name = "GEBOORTEDATUM", type = String.class),
                                        @ColumnResult(name = "GESLACHT", type = String.class),
                                        @ColumnResult(name = "WACHTWOORD", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_8B",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_8B.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "STARTDATUM", type = String.class),
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "BEDRAG", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_8C",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_8C.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "DATUM", type = String.class),
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "BEDRAG", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_8D",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_8D.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "OMZET_2014", type = String.class),
                                        @ColumnResult(name = "OMZET_2015", type = String.class),
                                        @ColumnResult(name = "OMZET_2016", type = String.class),
                                        @ColumnResult(name = "OMZET_2017", type = String.class),
                                        @ColumnResult(name = "TOTALE_OMZET", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "OPDRACHT_8E",
                classes = {
                        @ConstructorResult(
                                targetClass = Opdracht_8E.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "STATUS", type = String.class)
                                }
                        )
                }
        ),

})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Opdracht_8.get8a",
                query = "SELECT * FROM OPDRACHT_8A",
                resultSetMapping = "OPDRACHT_8A"
        ),
        @NamedNativeQuery(
                name = "Opdracht_8.get8b",
                query = "SELECT * FROM OPDRACHT_8B WHERE EMAILADRES = :emailadres",
                resultSetMapping = "OPDRACHT_8B"
        ),
        @NamedNativeQuery(
                name = "Opdracht_8.get8c",
                query = "SELECT * FROM OPDRACHT_8C WHERE EMAILADRES = :emailadres",
                resultSetMapping = "OPDRACHT_8C"
        ),
        @NamedNativeQuery(
                name = "Opdracht_8.get8d",
                query = "SELECT * FROM OPDRACHT_8D WHERE EMAILADRES = :emailadres",
                resultSetMapping = "OPDRACHT_8D"
        ),
        @NamedNativeQuery(
                name = "Opdracht_8.get8e",
                query = "select * FROM OPDRACHT_8E WHERE EMAILADRES = :emailadres",
                resultSetMapping = "OPDRACHT_8E"
        )
})

@Data
@AllArgsConstructor
@Entity
public class Opdracht_8 {

    @Id
    private String placeholder;

}

*/
