package nl.han.duo.gameparadise.repository;

import nl.han.duo.gameparadise.dao.Klant;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9A;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9B;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9C;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9D;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9E;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9F;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9G;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Opdracht9Repository extends CrudRepository<Klant, Long> {

    List<Opdracht_9A> get9a();

    List<Opdracht_9B> get9b();

    List<Opdracht_9C> get9c();

    List<Opdracht_9D> get9d();

    List<Opdracht_9E> get9e();

    List<Opdracht_9F> get9f();

    List<Opdracht_9G> get9g();

}
