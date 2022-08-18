package br.com.erudio.services;

import br.com.erudio.models.Person;
import br.com.erudio.repositorys.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person alterarPessoa(Person pessoaAtualizada) {
        return repository.save(pessoaAtualizada);
    }

    public Person salvarPessoa(Person novaPessoa) {
        return repository.save(novaPessoa);
    }

    public void excluirPessoa(Long id) {
        repository.deleteById(id);
    }
}
