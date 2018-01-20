package nl.han.duo.gameparadise.controller;


import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9A;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9B;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9C;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9D;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9E;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9F;
import nl.han.duo.gameparadise.dto.opdracht_9.Opdracht_9G;
import nl.han.duo.gameparadise.repository.Opdracht9Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Opdracht9Controller {

    @Autowired
    private Opdracht9Repository opdracht9Repository;

    @RequestMapping(value = "/9a", method=RequestMethod.GET)
    public @ResponseBody Iterable<Opdracht_9A> get9a() {
        return this.opdracht9Repository.get9a();
    }

    @RequestMapping(value = "/9b", method=RequestMethod.GET)
    public @ResponseBody Iterable<Opdracht_9B> get9b() {
        return this.opdracht9Repository.get9b();
    }

    @RequestMapping(value = "/9c", method=RequestMethod.GET)
    public @ResponseBody Iterable<Opdracht_9C> get9c() {
        return this.opdracht9Repository.get9c();
    }

    @RequestMapping(value = "/9d", method=RequestMethod.GET)
    public @ResponseBody Iterable<Opdracht_9D> get9d() {
        return this.opdracht9Repository.get9d();
    }

    @RequestMapping(value = "/9e", method=RequestMethod.GET)
    public @ResponseBody Iterable<Opdracht_9E> get9e() {
        return this.opdracht9Repository.get9e();
    }

    @RequestMapping(value = "/9f", method=RequestMethod.GET)
    public @ResponseBody Iterable<Opdracht_9F> get9f() {
        return this.opdracht9Repository.get9f();
    }

    @RequestMapping(value = "/9g", method=RequestMethod.GET)
    public @ResponseBody Iterable<Opdracht_9G> get9g() {
        return this.opdracht9Repository.get9g();
    }
}
