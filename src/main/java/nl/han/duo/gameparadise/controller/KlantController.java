package nl.han.duo.gameparadise.controller;

import nl.han.duo.gameparadise.dto.Klant;
import nl.han.duo.gameparadise.repository.KlantRepository;
import nl.han.duo.gameparadise.service.KlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/klant")
public class KlantController {

    @Autowired
    private KlantRepository klantRepository;

    @Autowired
    private KlantService klantService;

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public Iterable<Klant> findKlanten() {
        return this.klantService.findAllByQuery();
    }

    @RequestMapping(value = "/1", method=RequestMethod.GET)
    public Iterable<Klant> findKlanten1() {
        return this.klantRepository.findAll();
    }
}