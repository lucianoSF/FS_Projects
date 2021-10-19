package br.ufg.inf.fs;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.repositories.HospedagemRepository;
import br.ufg.inf.fs.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.enums.CategoriaQuarto;
import br.ufg.inf.fs.repositories.HotelRepository;
import br.ufg.inf.fs.repositories.QuartoRepository;

@Configuration
@Profile("dev")
public class Config  implements CommandLineRunner{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private QuartoRepository quartoRepository;

	@Autowired
	private HospedeRepository hospedeRepository;

	@Autowired
	private HospedagemRepository hospedagemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		/*
		 * INSERIR NO MEU BANCO DE DADOS INFORMAÇÕES INICIAIS...
		 * */

		
		Hotel h1 = hotelRepository.save(new Hotel(null, "Calderão Furado", "Beco Diagonal", 3));
		Hotel h2 = hotelRepository.save(new Hotel(null, "Bates Hotel", "White Pine Bay", 2));
		Hotel h3 = hotelRepository.save(new Hotel(null, "Hotel Overlook", "Colorado", 4));
		Hotel h4 = hotelRepository.save(new Hotel(null, "Continental Hotel", "Ney York City", 5));
		
		Quarto q1 = quartoRepository.save(new Quarto(null, h1, CategoriaQuarto.APARTAMENTO, 4, 1010, 200.0));
		Quarto q2 = quartoRepository.save(new Quarto(null, h2, CategoriaQuarto.SIMPLES, 1, 7, 100.0));
		Quarto q3 = quartoRepository.save(new Quarto(null, h3, CategoriaQuarto.PADRAO, 2, 306, 150.0));
		Quarto q4 = quartoRepository.save(new Quarto(null, h4, CategoriaQuarto.LUXO, 3, 1313, 500.0));


		Hospede hp1 = hospedeRepository.save(new Hospede(null, "joaquim", "2012-01-01", 1111));
		Hospede hp2 = hospedeRepository.save(new Hospede(null, "jose", "2012-01-01", 2222));
		Hospede hp3 = hospedeRepository.save(new Hospede(null, "cabral", "2012-01-01", 3333));

		Hospedagem hpd1 = hospedagemRepository.save(new Hospedagem(null, q1, hp1, "2012-01-01", null));
		Hospedagem hpd2 = hospedagemRepository.save(new Hospedagem(null, q2, hp2, "2013-01-01", null));
		Hospedagem hpd3 = hospedagemRepository.save(new Hospedagem(null, q2, hp3, "2014-01-01", null));
	}

}
