package br.com.erudio.controllers;
import br.com.erudio.models.Person;
import br.com.erudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(value = "/consultarPessoa/{id}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById (@PathVariable(value = "id") String id) {
        return this.service.findById(id);
    }

    @RequestMapping(value = "/listarPessoas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll () {
        return this.service.findAll();
    }


}
