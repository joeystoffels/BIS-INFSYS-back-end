package nl.han.duo.gameparadise.repository;


import nl.han.duo.gameparadise.dao.Artikel;
import nl.han.duo.gameparadise.dao.Klant;
import nl.han.duo.gameparadise.dao.NieuweKlant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KlantRepository extends CrudRepository<Klant, Long> {

    List<Artikel> getPiet();


    List<NieuweKlant> getKlantenTelefoonnummers();
}