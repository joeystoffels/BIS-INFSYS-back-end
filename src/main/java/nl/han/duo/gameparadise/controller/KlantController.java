package nl.han.duo.gameparadise.controller;

import nl.han.duo.gameparadise.dto.HuurHistorie;
import nl.han.duo.gameparadise.dto.Klant;
import nl.han.duo.gameparadise.dto.KlantOmzet;
import nl.han.duo.gameparadise.dto.KlantOverzicht;
import nl.han.duo.gameparadise.repository.KlantRepository;
import nl.han.duo.gameparadise.service.KlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/klant")
public class KlantController {

    @Autowired
    private KlantRepository klantRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<KlantOverzicht> findKlanten() {
        return this.klantRepository.getOverzicht();
    }

    @RequestMapping(value = "/{emailadres}/history", method = RequestMethod.GET)
    public Iterable<HuurHistorie> findKlantHuurhistoryByEmail(
            @PathVariable(name = "emailadres", required = true) String emailadres
            ) {
        return this.klantRepository.getHuurhistorieByEmail(emailadres);
    }

    @RequestMapping(value = "/{emailadres}/omzet", method = RequestMethod.GET)
    public Iterable<KlantOmzet> findKlantOmzetPerJaarByEmail(
            @PathVariable(name = "emailadres", required = true) String emailadres
    ) {
        return this.klantRepository.getOmzet(emailadres);
    }
}