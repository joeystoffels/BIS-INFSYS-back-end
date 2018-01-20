package nl.han.duo.gameparadise.dto.opdracht_9;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Opdracht_9E {

    private String barcode;
    private String merk;
    private String type;
    private String startdatum;
    private String datum_gereed;
    private String reparatiestatus;

    public String getMerk() {
        return merk.trim();
    }

    public String getType() {
        return type.trim();
    }

    public String getReparatiestatus() {
        return reparatiestatus.trim();
    }

}
