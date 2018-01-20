package nl.han.duo.gameparadise.repository;

import nl.han.duo.gameparadise.dao.Opdracht_8;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8A;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8B;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8C;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8D;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8E;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Opdracht8Repository extends CrudRepository<Opdracht_8, Long> {

    List<Opdracht_8A> get8a();

    List<Opdracht_8B> get8b();

    List<Opdracht_8C> get8c();

    List<Opdracht_8D> get8d();

    List<Opdracht_8E> get8e();

}
