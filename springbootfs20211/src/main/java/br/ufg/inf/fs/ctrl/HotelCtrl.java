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

import br.ufg.inf.fs.business.HotelBusiness;
import br.ufg.inf.fs.entities.Hotel;

@RestController
@RequestMapping(value="hoteis")
public class HotelCtrl {

	@Autowired
	private HotelBusiness business;
	
	@GetMapping("/all")
	public ResponseEntity<List<Hotel>> findAll(){
		List<Hotel> list = business.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}/details")
	public ResponseEntity<Hotel> findById(@PathVariable Integer id){
		Hotel retorno = business.findById(id);
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Hotel> insert(@RequestBody Hotel hotel){
		hotel = business.insert(hotel);
		return ResponseEntity.ok(hotel);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Hotel> update(@RequestBody Hotel hotel){
		hotel = business.update(hotel);
		return ResponseEntity.ok(hotel);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		business.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
