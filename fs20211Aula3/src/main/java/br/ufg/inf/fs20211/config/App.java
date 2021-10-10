package br.ufg.inf.fs20211.config;

import javax.persistence.EntityManager;

import br.ufg.inf.fs.enums.CategoriaQuarto;
import br.ufg.inf.fs20211.ctrl.HospedagemCtrl;
import br.ufg.inf.fs20211.ctrl.HospedeCtrl;
import br.ufg.inf.fs20211.ctrl.HotelCtrl;
import br.ufg.inf.fs20211.ctrl.QuartoCtrl;
import br.ufg.inf.fs20211.entities.Hospedagem;
import br.ufg.inf.fs20211.entities.Hospede;
import br.ufg.inf.fs20211.entities.Hotel;
import br.ufg.inf.fs20211.entities.Quarto;

public class App {

	public static void main(String[] args) {
		System.out.println("Come�ando");

		testeJpaHospedagem();


	}
	
	public static void testeJpaQuarto() {
		QuartoCtrl ctrl = new QuartoCtrl ();
		HotelCtrl hotelCtrl = new HotelCtrl();
		System.out.println("Busca Todos");
		for(Quarto h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Buscar por ID");
		System.out.println(ctrl.findById(3));
		
		System.out.println("Inserir no banco");
		Quarto q1 = new Quarto(null, hotelCtrl.findById(1), CategoriaQuarto.APARTAMENTO, 3, 1010, 150.0);
		Quarto q2 = new Quarto(null, hotelCtrl.findById(2), CategoriaQuarto.DORMITORIO, 8, 310, 50.0);
		Quarto q3 = new Quarto(null, hotelCtrl.findById(3), CategoriaQuarto.LUXO, 5, 1210, 550.0);
		Quarto q4 = new Quarto(null, hotelCtrl.findById(4), CategoriaQuarto.SIMPLES, 2, 110, 100.0);
		q1 = ctrl.insert(q1);
		System.out.println(q1);
		
		q2 = ctrl.insert(q2);
		System.out.println(q2);
		
		q3 = ctrl.insert(q3);
		System.out.println(q3);
		
		q4 = ctrl.insert(q4);
		System.out.println(q4);
		
		for(Quarto q : ctrl.findAll()) {
			System.out.println(q);
		}
		
		System.out.println("Alterar no banco");
		q1.setPrDiaria(175.0);
		q1 = ctrl.update(q1);

		for(Quarto q : ctrl.findAll()) {
			System.out.println(q);
		}

		
		
		System.out.println("Excluir");
		ctrl.delete(q3.getIdQuarto());
		System.out.println("Terminou");
	}
	
	public static void testeJpaHotel() {
		HotelCtrl ctrl = new HotelCtrl();
		System.out.println("Busca Todos");
		for(Hotel h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Buscar por ID");
		System.out.println(ctrl.findById(3));
		
		System.out.println("Inserir no banco");
		Hotel hotel = new Hotel(null, "Teste", "Qualquer Lugar", 10);
		hotel = ctrl.insert(hotel);
		System.out.println(hotel);
		
		System.out.println("Alterar no banco");
		hotel.setNmHotel("Teste Alterado");
		hotel = ctrl.update(hotel);
		System.out.println(hotel);
		
		
		System.out.println("Excluir");
		ctrl.delete(hotel.getIdHotel());
		System.out.println("Terminou");
	}

	public static void testeJpa() {
		EntityManager em = DaoFactory.getEntityManager();
		
		// CREATE
		/*//Hotel hotel = new Hotel(null, "Castro`s Park Hotel", "Goi�nia", 5);
		em.getTransaction().begin();
		//em.persist(hotel);
		Hotel h1 = new Hotel(null, "Ibis", "Goi�nia", 3);
		Hotel h2 = new Hotel(null, "Copacabana Palace", "Rio de Janeiro", 5);
		Hotel h3 = new Hotel(null, "Denali Hotel", "An�polis", 4);
		
		em.persist(h1);
		em.persist(h2);
		em.persist(h3);
		
		
		em.getTransaction().commit();
		*/
		
		// READ ALL
		/*
		System.out.println("Buscar Todos");
		TypedQuery<Hotel> result = em.createQuery("from Hotel", Hotel.class);
		List<Hotel> hoteis = result.getResultList();
		for(Hotel h : hoteis) {
			System.out.println(h);
		}
		
		
		// READ BY ID
		Hotel h4 = em.find(Hotel.class, 3);
		
		System.out.println("Buscar Por ID");
		System.out.println(h4);
		
		System.out.println("Buscar por Ocorr�ncia");
		String sql = "from Hotel h where h.nmHotel like :str";
		TypedQuery<Hotel> result2 = em.createQuery(sql, Hotel.class);
		result2.setParameter("str", "%i%");
		hoteis = result2.getResultList();
		for(Hotel h : hoteis) {
			System.out.println(h);
		}*/
		
		System.out.println("Update do Objeto");
		Hotel hotelUpdate = em.find(Hotel.class, 2);
		
		hotelUpdate.setNmHotel("Ibis Hotel");
		
		em.getTransaction().begin();
		em.persist(hotelUpdate);
		em.getTransaction().commit();
		
		
		
		System.out.println("Delete do Objeto");
		/*new Hotel(null, "Hotel Santo Ant�nio", "Neropolis", 3);
		System.out.println(hotelDeleta);
		System.out.println("persistindo");
		em.getTransaction().begin();
		em.persist(hotelDeleta);
		em.getTransaction().commit();
		System.out.println("novo objeto");
		System.out.println(hotelDeleta);*/
		/*Hotel hotelDeleta = em.find(Hotel.class, 5);
		
		em.getTransaction().begin();
		em.remove(hotelDeleta);
		em.getTransaction().commit();
		*/
		
		DaoFactory.closeConnection();
	}

	public static void testeJpaHospede(){
		HospedeCtrl ctrl = new HospedeCtrl();

		System.out.println("Busca Todos");
		for(Hospede h : ctrl.findAll()) {
			System.out.println(h);
		}

		System.out.println("\nBuscar por ID #3");
		System.out.println(ctrl.findById(3));

		System.out.println("\nInserir no banco");
		Hospede hospede = new Hospede(null, "Miriam", "1994-01-01", 4444);
		hospede = ctrl.insert(hospede);
		System.out.println(hospede);

		System.out.println("\nAlterar no banco");
		hospede.setNmHospede("Nome Alterado");
		hospede = ctrl.update(hospede);
		System.out.println(hospede);
		
		
		System.out.println("\nExcluir");
		ctrl.delete(hospede.getIdHospede());
		for(Hospede h : ctrl.findAll()) {
			System.out.println(h);
		}
		System.out.println("Terminou");
	}


	public static void testeJpaHospedagem(){
		HospedagemCtrl ctrl = new HospedagemCtrl();
		QuartoCtrl quartoctrl = new QuartoCtrl();
		HospedeCtrl hospedectrl = new HospedeCtrl();

		System.out.println("Busca Todos");
		for(Hospedagem h : ctrl.findAll()) {
			System.out.println(h);
		}

		System.out.println("\nBuscar por ID #3");
		System.out.println(ctrl.findById(3));

		System.out.println("\nInserir no banco");
		Hospedagem hospedagem = new Hospedagem(null, quartoctrl.findById(1), hospedectrl.findById(1), "2021-10-07", "2021-10-08");
		hospedagem = ctrl.insert(hospedagem);
		System.out.println(hospedagem);

		System.out.println("\nAlterar no banco");
		hospedagem.setDtCheckin("2011-11-11");
		hospedagem = ctrl.update(hospedagem);
		System.out.println(hospedagem);
		
		System.out.println("\nExcluir");
		ctrl.delete(hospedagem.getIdHospedagem());
		for(Hospedagem h : ctrl.findAll()) {
			System.out.println(h);
		}
		System.out.println("Terminou");
	}

}
