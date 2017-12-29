package nl.han.duo.gameparadise.controller;

import nl.han.duo.gameparadise.dto.HuurHistorie;
import nl.han.duo.gameparadise.dto.Klant;
import nl.han.duo.gameparadise.repository.KlantRepository;
import nl.han.duo.gameparadise.service.KlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rapport")
public class RapportController {

    @Autowired
    private KlantRepository klantRepository;

    @RequestMapping(value = "/1", method=RequestMethod.GET)
    public Iterable<HuurHistorie> findKlanten1() {
        return this.klantRepository.getHuurhistorie();
    }
}