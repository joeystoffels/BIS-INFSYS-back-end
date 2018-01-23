package nl.han.duo.gameparadise.repository;

import nl.han.duo.gameparadise.dao.Klant;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8A;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8B;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8C;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8D;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8E;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Opdracht8Repository extends CrudRepository<Klant, Long> {

    List<Opdracht_8A> get8a();

    List<Opdracht_8B> get8b(@Param("emailadres") String emailadres);

    List<Opdracht_8C> get8c(@Param("emailadres") String emailadres);

    List<Opdracht_8D> get8d(@Param("emailadres") String emailadres);

    List<Opdracht_8E> get8e(@Param("emailadres") String emailadres);

}
