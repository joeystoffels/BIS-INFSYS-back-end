package nl.han.duo.gameparadise.controller;


import nl.han.duo.gameparadise.dto.Artikel;
import nl.han.duo.gameparadise.dto.HuurHistorie;
import nl.han.duo.gameparadise.repository.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/artikel")
public class ArtikelController {

    @Autowired
    private ArtikelRepository artikelRepository;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody  Iterable<Artikel> findAll() {
        return artikelRepository.findAll();
    }

    @RequestMapping(value = "/historie", method=RequestMethod.GET)
    public Iterable<HuurHistorie> getHuurhistorie() {
        return this.artikelRepository.getHuurhistorie();
    }
}