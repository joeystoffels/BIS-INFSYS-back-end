package nl.han.duo.gameparadise.controller;

import nl.han.duo.gameparadise.dao.Artikel;
import nl.han.duo.gameparadise.dto.*;
import nl.han.duo.gameparadise.repository.KlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rapport")
public class RapportController {

    @Autowired
    private KlantRepository klantRepository;

    @RequestMapping(value = "/overzicht-momenteel-verhuurd", method = RequestMethod.GET)
    public Iterable<Artikel> overzichtMomenteelVerhuurd() {
        return this.klantRepository.get9A_OverichtMomenteelVerhuurd();
    }

    @RequestMapping(value = "/niet-verhuurd-in-2016", method = RequestMethod.GET)
    public Iterable<Spel> nietVerhuurdIn2016() {
        return this.klantRepository.get9B_NietVerhuurdIn2016();
    }

    @RequestMapping(value = "/omzetten-van-iedere-maand", method = RequestMethod.GET)
    public Iterable<KlantOmzetPerMaand> omzettenVanIedereMaand() {
        return this.klantRepository.get9C_OmzettenVanIedereMaand();
    }

    @RequestMapping(value = "/top-10-verhuurd", method = RequestMethod.GET)
    public Iterable<Top10> top10Verhuurd() {
        return this.klantRepository.get9D_Top10PopulairsteSpellen();
    }

    @RequestMapping(value = "/consoles-in-reparatie", method = RequestMethod.GET)
    public Iterable<Reparatie> consolesInReparatie() {
        return this.klantRepository.get9E_ConsolesDieInReparatieStaan();
    }

    @RequestMapping(value = "/omzetten-per-klant-per-jaar", method = RequestMethod.GET)
    public Iterable<KlantOmzetPerJaarPerMaand> omzettenPerKlantPerJaar() {
        return this.klantRepository.get9F_OmzettenPerKlantInEenJaar();
    }

    @RequestMapping(value = "/inkoophoeveelheid", method = RequestMethod.GET)
    public Iterable<Inkoophoeveelheid> inkoophoeveelheid() {
        return this.klantRepository.get9GInkoophoeveelheid();
    }
}