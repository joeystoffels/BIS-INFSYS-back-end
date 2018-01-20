package nl.han.duo.gameparadise.dto.opdracht_7;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Opdracht_7A {

    private String omzet_januari_2015;

    public String getOmzet_januari_2015() {
        return omzet_januari_2015.trim();
    }

}
