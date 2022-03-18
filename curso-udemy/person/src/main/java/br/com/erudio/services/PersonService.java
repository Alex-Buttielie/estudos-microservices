package br.com.erudio.services;

import br.com.erudio.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private AtomicLong counter = new AtomicLong();

    public Person findById(String id) {
        return this.criarObjetoPessoa("Alex");

    }

    public List<Person> findAll() {
        return preencherListaDePessoas();
    }

    private List<Person> preencherListaDePessoas() {
        List <Person> listPersons = new ArrayList<>();
        listPersons.add(this.criarObjetoPessoa("Alex"));
        listPersons.add(this.criarObjetoPessoa("Laura"));
        listPersons.add( this.criarObjetoPessoa("Maria Clara"));
        return listPersons;
    }

    private Person criarObjetoPessoa(String nome) {
        return Person
                .builder()
                .id(counter.incrementAndGet())
                .firstName(nome)
                .lastName("Alves")
                .address("Trindade - Goías - Brasil")
                .gender("Brasil")
                .build();
    }
}
