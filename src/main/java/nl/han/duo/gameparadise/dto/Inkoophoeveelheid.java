package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Inkoophoeveelheid {
    private Long jaar;
    private Long aantal;
    private String totaalbedrag;
}
