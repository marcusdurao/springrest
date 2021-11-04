package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/numberOne/numberTwo", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        return 10.0;
    }
//    Utilizado para enviar os parametros via queryParam
//    @RequestMapping("/greeting")
//    public Greeting greeting(@RequestParam(value="name", defaultValue = "Word") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template,name));
//    }
}
