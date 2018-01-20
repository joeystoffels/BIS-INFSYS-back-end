package nl.han.duo.gameparadise.dto.opdracht_7;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Opdracht_7E {

    private String barcode;
    private String merk;
    private String type;
    private String prijs;
    private String prijs_per_d;
    private String schadebedrag;

    public String getMerk() {
        return merk.trim();
    }

    public String getType() {
        return type.trim();
    }

}
