/*
package nl.han.duo.gameparadise.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "OPDRACHT_7D",
                classes = {
                        @ConstructorResult(
                                targetClass = Schade.class,
                                columns = {
                                        @ColumnResult(name = "TOTALE_SCHADE_2016", type = String.class)
                                }
                        )
                }
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Schade.get7d",
                query = "select * FROM OPDRACHT_7D",
                resultSetMapping = "OPDRACHT_7D"
        )
})

@Data
@AllArgsConstructor
@Entity
public class Schade {

    @Id
    @NotNull
    private String totale_schade_2016;

}
*/
