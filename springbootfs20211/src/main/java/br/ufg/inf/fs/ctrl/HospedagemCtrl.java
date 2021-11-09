package br.ufg.inf.fs.ctrl;

import java.util.ArrayList;
import java.util.List;

import br.ufg.inf.fs.Messages;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.exceptions.HospedagemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.fs.business.HospedagemBusiness;
import br.ufg.inf.fs.entities.Hospedagem;

@RestController
@RequestMapping(value="hospedagem")
public class HospedagemCtrl {

    @Autowired
    private HospedagemBusiness business;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<Hospedagem>> findAll(){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        List<Hospedagem> list = new ArrayList<Hospedagem>();

        try{
            list = business.findAll();
            if(list.size() == 0){
                headers.add("message", Messages.get("0407"));
            }
        }catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hospedagem>>(list, headers, status);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/paginator")
    public ResponseEntity<Page<Hospedagem>> paginator(Pageable pageable){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        Page<Hospedagem> list = null;
        try {
            list = business.paginator(pageable);
            if(list.getSize() == 0) {
                headers.add("message", Messages.get("0407"));
            }
        }catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<Page<Hospedagem>>(list, headers, status);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{category}")
    public ResponseEntity<List<Hospedagem>> findByCategory(@PathVariable Integer category){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        List<Hospedagem> list = new ArrayList<Hospedagem>();
        try{
            list = business.findByCategoryHospedagem(category);
            if(list.size() == 0){
                headers.add("message", Messages.get("0407"));
            }
        }catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<List<Hospedagem>>(list, headers, status);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}/details")
    public ResponseEntity<Hospedagem> findById(@PathVariable Integer id){
        Hospedagem retorno = new Hospedagem();
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        try{
            retorno = business.findById(id);
            if(retorno == null){
                headers.add("message", Messages.get("0407"));
            }
        }catch (Exception e){
            status = HttpStatus.BAD_REQUEST;
            headers.add("message", Messages.get("0002"));
        }
        return new ResponseEntity<Hospedagem>(retorno, headers, status);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/insert")
    public ResponseEntity<Hospedagem> insert(@RequestBody Hospedagem hospedagem){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.CREATED;

        try{
            hospedagem = business.insert(hospedagem);
            headers.add("message", Messages.get("0401"));
        }catch (HospedagemException e){
            headers.add("message", Messages.get(e.getMessage()));
            status = HttpStatus.BAD_REQUEST;
        }catch (Exception e){
            headers.add("message", Messages.get("0402"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Hospedagem>(hospedagem, headers, status);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Hospedagem> update(@RequestBody Hospedagem hospedagem){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;

        try{
            hospedagem = business.update(hospedagem);
            headers.add("message", Messages.get("0403"));
        }catch (HospedagemException e){
            headers.add("message", Messages.get(e.getMessage()));
            status = HttpStatus.BAD_REQUEST;
        }catch (Exception e){
            headers.add("message", Messages.get("0404"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Hospedagem>(hospedagem, headers, status);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.NO_CONTENT;

        try{
            business.delete(id);
            headers.add("message", Messages.get("0405"));
        }catch (Exception e){
            headers.add("message", Messages.get("0406"));
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Void>(headers, status);
    }

}
