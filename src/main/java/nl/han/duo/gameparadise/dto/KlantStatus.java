package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KlantStatus {

    private String emailadres;
    private String omzet;
    private String status;
}