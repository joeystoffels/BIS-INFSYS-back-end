package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class KlantOmzet {

    private String emailadres;
    private Long jaar;
    private String omzet;
}