package nl.han.duo.gameparadise.repository;

import nl.han.duo.gameparadise.dto.Artikel;
import nl.han.duo.gameparadise.dto.HuurHistorie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtikelRepository extends CrudRepository<Artikel, String> {

    List<HuurHistorie> getHuurhistorie();
}