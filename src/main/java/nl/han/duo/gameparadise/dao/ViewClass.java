package nl.han.duo.gameparadise.dao;

import lombok.Data;
import nl.han.duo.gameparadise.dto.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Klant.getKlantOverzicht",
                query = "select EMAILADRES, MERK_EIGEN_CONSOLE, TYPE_EIGEN_CONSOLE, VOORNAMEN, ACHTERNAAM, STRAATNAAM, HUISNUMMER, POSTCODE, WOONPLAATS, GEBOORTEDATUM, GESLACHT, OMZET , STATUS from Opdr8_KlantOverzicht  ",
                resultSetMapping = "KlantOverzicht"
        ),
        @NamedNativeQuery(
                name = "Klant.getKlantHuurHistorieByEmail",
                query = "select BARCODE, MERK, [TYPE], TITEL, UITGEVER, JAAR_UITGAVE, DATUM, PRIJS, EMAILADRES, SOORT from HistorieHuur WHERE EMAILADRES = :emailadres",
                resultSetMapping = "HuurHistorie"
        ),
        @NamedNativeQuery(
                name = "Klant.getAllHuurhistorie",
                query = "select BARCODE, MERK, [TYPE], TITEL, UITGEVER, JAAR_UITGAVE, DATUM, PRIJS, EMAILADRES, SOORT from HistorieHuur",
                resultSetMapping = "HuurHistorie"
        ),

        @NamedNativeQuery(
                name = "Klant.getKlantOmzetByEmail",
                query = "select EMAILADRES, JAAR, OMZET from Opdr8_OmzetPerKlantPerJaar WHERE EMAILADRES = :emailadres",
                resultSetMapping = "KlantOmzet"
        ),
        @NamedNativeQuery(
                name = "Klant.get9A_OverichtMomenteelVerhuurd",
                query = "select BARCODE, MERK, TYPE, TITEL, PRIJS, PRIJS_PER_D, SPEL_OF_CONSOLE, JAAR_UITGAVE, UITGEVER  from Opdr9A_OverzichtMomenteelVerhuurd",
                resultSetMapping = "Artikel"
        ),
        @NamedNativeQuery(
                name = "Klant.get9B_NietVerhuurdIn2016",
                query = "select TITEL, UITGEVER, JAAR_UITGAVE from Opdr9B_NietVerhuurdIn2016",
                resultSetMapping = "Spel"
        ),
        @NamedNativeQuery(
                name = "Klant.get9C_OmzettenVanIedereMaand",
                query = "select MAAND, JAAR, OMZET from Opdr9C_OmzettenVanIedereMaand2012Tot2017",
                resultSetMapping = "KlantOmzetPerMaand"
        ),
        @NamedNativeQuery(
                name = "Klant.get9D_Top10PopulairsteSpellen",
                query = "select TITEL, UITGEVER, JAAR_UITGAVE, AANTAL_VERHUURD from Opdr9D_Top10PopulairsteSpellen",
                resultSetMapping = "Top10"
        ),
        @NamedNativeQuery(
                name = "Klant.get9E_ConsolesDieInReparatieStaan",
                query = "select SCHADENUMMER, BARCODE, STARTDATUM, INLOGNAAM, DATUM_GEREED, KOSTEN, REPARATIESTATUS, EMAILADRES from Opdr9E_ConsolesDieInReparatieStaan",
                resultSetMapping = "Reparatie"
        ),
        @NamedNativeQuery(
                name = "Klant.get9F_OmzettenPerKlantInEenJaar",
                query = "select EMAILADRES, JAAR, OMZET, OMZET_LAATSTE_12_MAANDEN, STATUS from Opdr9F_OmzettenPerKlantInEenJaar",
                resultSetMapping = "KlantOmzetPerJaarPerMaand"
        ),
        @NamedNativeQuery(
                name = "Klant.get9GInkoophoeveelheid",
                query = "select JAAR, AANTAL, TOTAALBEDRAG from Opdr9G_Inkoophoeveelheid",
                resultSetMapping = "Inkoophoeveelheid"
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "Reparatie",
                classes = {
                        @ConstructorResult(
                                targetClass = Reparatie.class,
                                columns = {
                                        @ColumnResult(name = "SCHADENUMMER", type = Long.class),
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "STARTDATUM", type = Date.class),
                                        @ColumnResult(name = "INLOGNAAM", type = String.class),
                                        @ColumnResult(name = "DATUM_GEREED", type = Date.class),
                                        @ColumnResult(name = "KOSTEN", type = String.class),
                                        @ColumnResult(name = "REPARATIESTATUS", type = String.class),
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "Top10",
                classes = {
                        @ConstructorResult(
                                targetClass = Top10.class,
                                columns = {
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "UITGEVER", type = String.class),
                                        @ColumnResult(name = "JAAR_UITGAVE", type = Long.class),
                                        @ColumnResult(name = "AANTAL_VERHUURD", type = Long.class),
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "HuurHistorie",
                classes = {
                        @ConstructorResult(
                                targetClass = HuurHistorie.class,
                                columns = {
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "MERK", type = String.class),
                                        @ColumnResult(name = "TYPE", type = String.class),
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "UITGEVER", type = String.class),
                                        @ColumnResult(name = "JAAR_UITGAVE", type = Long.class),
                                        @ColumnResult(name = "DATUM", type = Date.class),
                                        @ColumnResult(name = "PRIJS", type = String.class),
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "SOORT", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "KlantOverzicht",
                classes = {
                        @ConstructorResult(
                                targetClass = KlantOverzicht.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "MERK_EIGEN_CONSOLE", type = String.class),
                                        @ColumnResult(name = "TYPE_EIGEN_CONSOLE", type = String.class),
                                        @ColumnResult(name = "VOORNAMEN", type = String.class),
                                        @ColumnResult(name = "ACHTERNAAM", type = String.class),
                                        @ColumnResult(name = "STRAATNAAM", type = String.class),
                                        @ColumnResult(name = "HUISNUMMER", type = String.class),
                                        @ColumnResult(name = "POSTCODE", type = String.class),
                                        @ColumnResult(name = "WOONPLAATS", type = String.class),
                                        @ColumnResult(name = "GEBOORTEDATUM", type = Date.class),
                                        @ColumnResult(name = "GESLACHT", type = String.class),
                                        @ColumnResult(name = "OMZET", type = String.class),
                                        @ColumnResult(name = "STATUS", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "KlantOmzet",
                classes = {
                        @ConstructorResult(
                                targetClass = KlantOmzet.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "JAAR", type = Long.class),
                                        @ColumnResult(name = "OMZET", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "KlantOmzetPerMaand",
                classes = {
                        @ConstructorResult(
                                targetClass = KlantOmzetPerMaand.class,
                                columns = {
                                        @ColumnResult(name = "MAAND", type = Long.class),
                                        @ColumnResult(name = "JAAR", type = Long.class),
                                        @ColumnResult(name = "OMZET", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "KlantOmzetPerJaarPerMaand",
                classes = {
                        @ConstructorResult(
                                targetClass = KlantOmzetPerJaarPerMaand.class,
                                columns = {
                                        @ColumnResult(name = "EMAILADRES", type = String.class),
                                        @ColumnResult(name = "JAAR", type = Long.class),
                                        @ColumnResult(name = "OMZET", type = BigDecimal.class),
                                        @ColumnResult(name = "OMZET_LAATSTE_12_MAANDEN", type = BigDecimal.class),
                                        @ColumnResult(name = "STATUS", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "Inkoophoeveelheid",
                classes = {
                        @ConstructorResult(
                                targetClass = Inkoophoeveelheid.class,
                                columns = {
                                        @ColumnResult(name = "JAAR", type = Long.class),
                                        @ColumnResult(name = "AANTAL", type = Long.class),
                                        @ColumnResult(name = "TOTAALBEDRAG", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "Artikel",
                classes = {
                        @ConstructorResult(
                                targetClass = Artikel.class,
                                columns = {
                                        @ColumnResult(name = "BARCODE", type = String.class),
                                        @ColumnResult(name = "MERK", type = String.class),
                                        @ColumnResult(name = "TYPE", type = String.class),
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "PRIJS", type = BigDecimal.class),
                                        @ColumnResult(name = "PRIJS_PER_D", type = BigDecimal.class),
                                        @ColumnResult(name = "SPEL_OF_CONSOLE", type = String.class),
                                        @ColumnResult(name = "JAAR_UITGAVE", type = Integer.class),
                                        @ColumnResult(name = "UITGEVER", type = String.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "Spel",
                classes = {
                        @ConstructorResult(
                                targetClass = Spel.class,
                                columns = {
                                        @ColumnResult(name = "TITEL", type = String.class),
                                        @ColumnResult(name = "UITGEVER", type = String.class),
                                        @ColumnResult(name = "JAAR_UITGAVE", type = Long.class)
                                }
                        )
                }
        )
})
public class ViewClass {


}