package br.ufg.inf.fs.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.repositories.HospedagemRepository;

@Service
public class HospedagemBusiness {

    @Autowired
    private HospedagemRepository repository;

    public List<Hospedagem> findAll(){
        return repository.findAll();
    }

    public Hospedagem findById(Integer id) {
        Optional<Hospedagem> retorno = repository.findById(id);
        return retorno.get();
    }

    public Hospedagem insert(Hospedagem hospedagem) {
        return repository.save(hospedagem);
    }

    public Hospedagem update(Hospedagem hospedagem) {
        return repository.save(hospedagem);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
