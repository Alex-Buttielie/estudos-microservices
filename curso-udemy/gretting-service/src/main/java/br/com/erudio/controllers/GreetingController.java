package br.com.erudio.controllers;

import br.com.erudio.configurations.GrettingConfiguration;
import br.com.erudio.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping()
public class GreetingController {
    private static final String template = "%s, %s!";
    private  final AtomicLong count = new AtomicLong();

    @Autowired
    private GrettingConfiguration configuration;

    @RequestMapping(value = "/greeting")
    public Greeting greeting (@RequestParam(value = "name", defaultValue = "") String name) {
        if(name.isEmpty()) name = configuration.getDefaultValue();

        return new Greeting(
                count.incrementAndGet(),
                String.format(template, configuration.getGreeting(), name));

    }

}
