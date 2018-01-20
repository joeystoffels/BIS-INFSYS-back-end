package nl.han.duo.gameparadise.repository;

import nl.han.duo.gameparadise.dao.Opdracht_7;
import nl.han.duo.gameparadise.dto.opdracht_7.Opdracht_7A;
import nl.han.duo.gameparadise.dto.opdracht_7.Opdracht_7B;
import nl.han.duo.gameparadise.dto.opdracht_7.Opdracht_7C;
import nl.han.duo.gameparadise.dto.opdracht_7.Opdracht_7D;
import nl.han.duo.gameparadise.dto.opdracht_7.Opdracht_7E;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Opdracht7Repository extends CrudRepository<Opdracht_7, Long> {

    List<Opdracht_7A> get7a();

    List<Opdracht_7B> get7b();

    List<Opdracht_7C> get7c();

    List<Opdracht_7D> get7d();

    List<Opdracht_7E> get7e();
}