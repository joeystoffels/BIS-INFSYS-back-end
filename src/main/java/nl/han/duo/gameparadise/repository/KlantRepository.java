package nl.han.duo.gameparadise.repository;

import nl.han.duo.gameparadise.dto.HuurHistorie;
import nl.han.duo.gameparadise.dao.Klant;
import nl.han.duo.gameparadise.dto.KlantOmzet;
import nl.han.duo.gameparadise.dto.KlantOverzicht;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KlantRepository extends CrudRepository<Klant,String> {


    List<KlantOverzicht> getOverzicht();

    List<HuurHistorie> getAllHuurhistorie();

    List<KlantOmzet> getOmzet(@Param("emailadres") String emailadres);

    List<HuurHistorie> getHuurhistorieByEmail(@Param("emailadres") String emailadres);

    Iterable<Klant> findAllByQuery();

    Iterable<Klant> findByTest();

}

