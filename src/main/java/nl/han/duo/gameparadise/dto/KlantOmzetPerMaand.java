package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KlantOmzetPerMaand {

    private Long maand;
    private Long jaar;
    private String omzet;
}