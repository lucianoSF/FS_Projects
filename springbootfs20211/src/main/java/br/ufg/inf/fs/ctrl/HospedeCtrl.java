package br.ufg.inf.fs.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.fs.business.HospedeBusiness;
import br.ufg.inf.fs.entities.Hospede;

@RestController
@RequestMapping(value="hospedes")
public class HospedeCtrl {

    @Autowired
    private HospedeBusiness business;

    @GetMapping("/all")
    public ResponseEntity<List<Hospede>> findAll(){
        List<Hospede> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<Hospede> findById(@PathVariable Integer id){
        Hospede retorno = business.findById(id);
        return ResponseEntity.ok(retorno);
    }

    @PostMapping("/insert")
    public ResponseEntity<Hospede> insert(@RequestBody Hospede hospede){
        hospede = business.insert(hospede);
        return ResponseEntity.ok(hospede);
    }

    @PutMapping("/update")
    public ResponseEntity<Hospede> update(@RequestBody Hospede hospede){
        hospede = business.update(hospede);
        return ResponseEntity.ok(hospede);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        business.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
