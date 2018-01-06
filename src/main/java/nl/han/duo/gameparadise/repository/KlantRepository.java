package nl.han.duo.gameparadise.repository;

import nl.han.duo.gameparadise.dao.Artikel;
import nl.han.duo.gameparadise.dto.*;
import nl.han.duo.gameparadise.dao.Klant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KlantRepository extends CrudRepository<Klant, String> {


    List<KlantOmzet> getKlantOmzetByEmail(@Param("emailadres") String emailadres);

    List<HuurHistorie> getKlantHuurHistorieByEmail(@Param("emailadres") String emailadres);

    List<KlantOverzicht> getKlantOverzicht();

    List<Artikel> get9A_OverichtMomenteelVerhuurd();

    List<Spel> get9B_NietVerhuurdIn2016();

    List<KlantOmzetPerMaand> get9C_OmzettenVanIedereMaand();

    List<Top10> get9D_Top10PopulairsteSpellen();

    List<Reparatie> get9E_ConsolesDieInReparatieStaan();

    List<KlantOmzetPerJaarPerMaand> get9F_OmzettenPerKlantInEenJaar();

    List<Inkoophoeveelheid> get9GInkoophoeveelheid();
}

