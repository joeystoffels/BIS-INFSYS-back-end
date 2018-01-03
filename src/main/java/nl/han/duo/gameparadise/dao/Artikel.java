package nl.han.duo.gameparadise.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Artikel {

    private String barcode;
    private String merk;
    private String type;
    private String titel;
    private String prijs;
    private String prijs_per_d;
    private String spel_of_console;
}
