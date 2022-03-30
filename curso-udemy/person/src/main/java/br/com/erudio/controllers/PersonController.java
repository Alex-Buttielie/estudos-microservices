package br.com.erudio.controllers;
import br.com.erudio.models.Person;
import br.com.erudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(value = "/consultarPessoa/{id}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById (@PathVariable(value = "id") Long id) {
        return this.service.findById(id);
    }

    @RequestMapping(value = "/listarPessoas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll () {
        return this.service.findAll();
    }

    @RequestMapping(value = "/alterarPessoa", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person alterarPessoa (@RequestBody Person pessoa) {
        return this.service.alterarPessoa(pessoa);
    }

    @RequestMapping(value = "/deletarPessoa/{id}", method = RequestMethod.DELETE)
    public void deletarPessoa (@PathVariable(value = "id") Long id) {
        this.service.excluirPessoa(id);
    }

    @RequestMapping(value = "/salvarPessoa", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person salvarPessoa (@RequestBody Person novaPessoa) {
        return this.service.salvarPessoa(novaPessoa);
    }


}
