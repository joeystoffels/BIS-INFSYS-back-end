package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KlantOmzetPerJaarPerMaand {

    private String emailadres;
    private Long jaar;
    private String omzet;
    private String omzet_laatste_12_maanden;
    private String status;
}