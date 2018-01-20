package nl.han.duo.gameparadise.dto.opdracht_7;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Opdracht_7C {

    private String einddatum;
    private String emailadres;
    private String huurstatus;
    private String startdatum;
    private String bedrag;

    public String getHuurstatus() {
        return huurstatus.trim();
    }

}
