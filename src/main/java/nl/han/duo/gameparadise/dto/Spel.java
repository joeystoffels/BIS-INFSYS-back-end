package nl.han.duo.gameparadise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
public class Spel {
    private String titel;
    private String uitgever;
    private Long jaar_uitgave;

}
