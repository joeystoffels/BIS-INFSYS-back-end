package nl.han.duo.gameparadise.controller;


import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8A;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8B;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8C;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8D;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8E;
import nl.han.duo.gameparadise.repository.Opdracht8Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Opdracht8Controller {

    @Autowired
    private Opdracht8Repository opdracht8Repository;

    @RequestMapping(value = "/8a", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Opdracht_8A> get8a() {
        return this.opdracht8Repository.get8a();
    }

    @RequestMapping(value = "/8b", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Opdracht_8B> get8b() {
        return this.opdracht8Repository.get8b();
    }

    @RequestMapping(value = "/8c", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Opdracht_8C> get8c() {
        return this.opdracht8Repository.get8c();
    }

    @RequestMapping(value = "/8d", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Opdracht_8D> get8d() {
        return this.opdracht8Repository.get8d();
    }

    @RequestMapping(value = "/8e", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Opdracht_8E> get8e() {
        return this.opdracht8Repository.get8e();
    }
}