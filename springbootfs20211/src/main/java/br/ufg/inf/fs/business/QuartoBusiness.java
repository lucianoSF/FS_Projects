package br.ufg.inf.fs.business;

import java.util.List;
import java.util.Optional;

import br.ufg.inf.fs.enums.CategoriaQuarto;
import br.ufg.inf.fs.exceptions.HotelException;
import br.ufg.inf.fs.exceptions.QuartoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.repositories.QuartoRepository;

@Service
public class QuartoBusiness {
	
	@Autowired
	private QuartoRepository repository;
	
	public List<Quarto> findAll(){
		return repository.findAll();		
	}

	public List<Quarto> findByCategoryQuarto(Integer category) {
		return repository.findByCategoryQuarto(category);
	}

	public Quarto findById(Integer id) {
		Optional<Quarto> retorno = repository.findById(id);
		if(retorno.isPresent()){
			return retorno.get();
		}else{
			return null;
		}

	}
	
	public Quarto insert(Quarto quarto) throws QuartoException {
		this.validaQuarto(quarto);
		return repository.save(quarto);
	}
	
	public Quarto update(Quarto quarto) throws QuartoException {
		this.validaQuarto(quarto);
		return repository.save(quarto);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private void validaQuarto(Quarto quarto) throws QuartoException {
		if(quarto.getCategoriaQuarto() == null) {
			throw new QuartoException("0208");
		}
	}
	
}
