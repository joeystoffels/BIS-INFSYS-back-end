package nl.han.duo.gameparadise.controller;


import nl.han.duo.gameparadise.dao.Artikel;
import nl.han.duo.gameparadise.repository.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artikel")
public class ArtikelController {

    @Autowired
    private ArtikelRepository artikelRepository;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody  Iterable<Artikel> findAll() {
        return this.artikelRepository.findAll();
    }
}