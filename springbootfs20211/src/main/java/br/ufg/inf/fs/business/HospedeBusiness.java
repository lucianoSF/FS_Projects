package br.ufg.inf.fs.business;

import java.util.List;
import java.util.Optional;

import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.exceptions.HospedeException;
import br.ufg.inf.fs.exceptions.HotelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.repositories.HospedeRepository;

@Service
public class HospedeBusiness {

    @Autowired
    private HospedeRepository repository;

    public List<Hospede> findAll(){
        return repository.findAll();
    }

    public Page<Hospede> paginator(Pageable pageable){
        return repository.findAll(pageable);
    }

    public List<Hospede> findName(String str){
        return repository.findByNmHospede(str);
    }

    public Hospede findById(Integer id) {
        Optional<Hospede> retorno = repository.findById(id);
        if(retorno.isPresent()){
            return retorno.get();
        }else{
            return null;
        }

    }

    public Hospede insert(Hospede hospede) throws HospedeException {
        this.validaHospede(hospede);
        return repository.save(hospede);
    }

    public Hospede update(Hospede hospede) throws  HospedeException{
        this.validaHospede(hospede);
        return repository.save(hospede);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private void validaHospede(Hospede hospede) throws HospedeException {
        if(hospede.getNmHospede() == null || hospede.getNmHospede().length() == 0) {
            throw new HospedeException("0308");
        }
        if(hospede.getCpf() == null) {
            throw new HospedeException("0309");
        }
    }
}
