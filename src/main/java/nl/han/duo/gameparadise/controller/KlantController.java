package nl.han.duo.gameparadise.controller;


import nl.han.duo.gameparadise.dao.Artikel;
import nl.han.duo.gameparadise.dao.Klant;
import nl.han.duo.gameparadise.dao.NieuweKlant;
import nl.han.duo.gameparadise.repository.KlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/klant")
public class KlantController {

    @Autowired
    private KlantRepository klantRepository;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public @ResponseBody Iterable<Klant> getKlanten() {
        return this.klantRepository.findAll();
    }

    @RequestMapping(value = "/meer", method=RequestMethod.GET)
    public @ResponseBody Iterable<NieuweKlant> getMeerKlanten() {
        return this.klantRepository.getKlantenTelefoonnummers();
    }

    @RequestMapping(value = "/piet", method=RequestMethod.GET)
    public @ResponseBody Iterable<Artikel> getPiet() {
        return this.klantRepository.getPiet();
    }
}