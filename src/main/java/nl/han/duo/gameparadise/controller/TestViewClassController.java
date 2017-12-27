package nl.han.duo.gameparadise.controller;


import nl.han.duo.gameparadise.dto.TestViewClass;
import nl.han.duo.gameparadise.repository.TestViewClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test-view")
public class TestViewClassController {

    @Autowired
    private TestViewClassRepository testViewClassRepository;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    Iterable<TestViewClass> sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return this.testViewClassRepository.findAll();
    }
}