package nl.han.duo.gameparadise.service;


import nl.han.duo.gameparadise.dto.Klant;
import nl.han.duo.gameparadise.repository.KlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlantService {

    @Autowired
    private KlantRepository klantRepository;

    public Iterable<Klant> findAllByQuery(){
        return this.klantRepository.findByTest();
    }
}
