package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Top10 {
    private String titel;
    private String uitgever;
    private Long jaar_uitgave;
    private Long aantal_verhuurd;
}
