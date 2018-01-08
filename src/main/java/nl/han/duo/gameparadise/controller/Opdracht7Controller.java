package nl.han.duo.gameparadise.controller;


import nl.han.duo.gameparadise.dao.Schade;
import nl.han.duo.gameparadise.repository.Opdracht7Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Opdracht7Controller {

    @Autowired
    private Opdracht7Repository opdracht7Repository;

/*    @RequestMapping(value = "/7a", method=RequestMethod.GET)
    public @ResponseBody Iterable<Omzet> get7a() {
        return this.opdracht7Repository.get7a();
    }

    @RequestMapping(value = "/7b", method=RequestMethod.GET)
    public @ResponseBody Iterable<Artikel> get7b() {
        return this.opdracht7Repository.get7b();
    }

    @RequestMapping(value = "/7c", method=RequestMethod.GET)
    public @ResponseBody Iterable<HuurOvereenkomst> get7c() {
        return this.opdracht7Repository.get7c();
    }*/

    @RequestMapping(value = "/7d", method=RequestMethod.GET)
    public @ResponseBody Iterable<Schade> get7d() {
        return this.opdracht7Repository.get7d();
    }

/*    @RequestMapping(value = "/7e", method=RequestMethod.GET)
    public @ResponseBody Iterable<Artikel> get7e() {
        return this.opdracht7Repository.get7e();
    }*/
}