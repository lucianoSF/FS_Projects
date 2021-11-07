package br.ufg.inf.fs.business;

import java.util.List;
import java.util.Optional;

import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.exceptions.HospedagemException;
import br.ufg.inf.fs.exceptions.HospedeException;
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

    public List<Hospedagem> findByCategoryHospedagem(Integer category) {
        return repository.findByCategoryHospedagem(category);
    }

    public Hospedagem findById(Integer id) {
        Optional<Hospedagem> retorno = repository.findById(id);
        if(retorno.isPresent()){
            return retorno.get();
        }else{
            return null;
        }

    }

    public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {
        this.validaHospedagem(hospedagem);
        return repository.save(hospedagem);
    }

    public Hospedagem update(Hospedagem hospedagem) throws HospedagemException {
        this.validaHospedagem(hospedagem);
        return repository.save(hospedagem);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private void validaHospedagem(Hospedagem hospedagem) throws HospedagemException {
        if(hospedagem.getDtCheckin() == null || hospedagem.getDtCheckin().length() == 0) {
            throw new HospedagemException("0408");
        }
    }

}
