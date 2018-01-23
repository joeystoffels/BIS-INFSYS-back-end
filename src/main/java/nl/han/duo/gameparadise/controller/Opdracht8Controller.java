package nl.han.duo.gameparadise.controller;


import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8A;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8B;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8C;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8D;
import nl.han.duo.gameparadise.dto.opdracht_8.Opdracht_8E;
import nl.han.duo.gameparadise.repository.Opdracht8Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/8b/{emailadres}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Opdracht_8B> get8b(
            @PathVariable(name = "emailadres", required = true) String emailadres
    ) {
        System.out.println(emailadres);
        return this.opdracht8Repository.get8b(emailadres);
    }

    @RequestMapping(value = "/8c/{emailadres}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Opdracht_8C> get8c(
            @PathVariable(name = "emailadres", required = true) String emailadres
    ) {
        return this.opdracht8Repository.get8c(emailadres);
    }

    @RequestMapping(value = "/8d/{emailadres}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Opdracht_8D> get8d(
            @PathVariable(name = "emailadres", required = true) String emailadres
    ) {
        return this.opdracht8Repository.get8d(emailadres);
    }

    @RequestMapping(value = "/8e/{emailadres}", method = RequestMethod.GET)
    public @ResponseBody Iterable<Opdracht_8E> get8e(
            @PathVariable(name = "emailadres", required = true) String emailadres
    ) {
        return this.opdracht8Repository.get8e(emailadres);
    }
}