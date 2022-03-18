package br.com.erudio.services;

import br.com.erudio.models.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private AtomicLong counter = new AtomicLong();

    public Person findById(String id) {
        return Person
                .builder()
                .id(counter.incrementAndGet())
                .firstName("Alex")
                .lastName("Buttielie")
                .address("Trindade - Goías - Brasil")
                .gender("Brasil")
                .build();

    }


}
