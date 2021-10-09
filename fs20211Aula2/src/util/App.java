package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.ufg.inf.fs.ctrl.HospedagemCtrl;
import br.ufg.inf.fs.ctrl.HospedeCtrl;
import br.ufg.inf.fs.ctrl.HotelCtrl;
import br.ufg.inf.fs.ctrl.QuartoCtrl;
import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.enums.CategoriaQuarto;

public class App {
	
	public static void testeSystem() {
		
		System.out.println("Hello World");
		System.err.println("Hello World com erro");

	}
	
	public static void main(String[] args) {
		
		testeCrudHospedagem();
	}
	
	public static void testeConexcao() {
		try{
			Connection con = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/db_hotel", "developer","1234");
			System.out.println("Conex�o funcionou");
			}catch(SQLException e){
				System.err.println("Conex�o n�o funcionou");
				System.out.println(e.getMessage());
			}	
	}
	
	
	public static void testeCrudHotel() {
		
		HotelCtrl ctrl = new HotelCtrl();
		
		System.out.println("Lista de Hoteis Cadastrados");
		for(Hotel h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		System.out.println("Buscar pelo #ID 1");
		Hotel hotel = ctrl.findById(1);
		System.out.println(hotel);
		
		System.out.println("Cadastrar novo Hotel");
		
		Hotel h1 = new Hotel(null, "Hotel Goi�nia", "Goi�nia", 3);
		h1 = ctrl.insert(h1);
		System.out.println(h1);
		
		Hotel h2 = ctrl.findById(3);
		System.out.println("UPDATE");
		System.out.println("#ID original: "+h2);
		h2.setNmHotel(h2.getNmHotel()+" ALTERADO");
		h2 = ctrl.update(h2);
		System.out.println("#ID alterado: "+h2);
		
		
		System.out.println("Lista de Hoteis Cadastrados");
		for(Hotel h : ctrl.findAll()) {
			System.out.println(h);
		}
		System.out.println("Deletar #ID 4");
		ctrl.delete(4);
		
		System.out.println("Lista de Hoteis Atualizado");
		for(Hotel h : ctrl.findAll()) {
			System.out.println(h);
		}
		
		
	}
	
	public static void testeCrudQuarto() {
		
		QuartoCtrl ctrl = new QuartoCtrl();
		
		HotelCtrl hotelCtrl = new HotelCtrl();
		
		System.out.println("Lista de Quartos Cadastrados");
		for(Quarto q : ctrl.findAll()) {
			System.out.println(q);
		}
		
		System.out.println("Buscar pelo #ID 1");
		Quarto quarto = ctrl.findById(1);
		System.out.println(quarto);
		
		System.out.println("Cadastrar novo Quarto");
		
		Quarto q1 = new Quarto(null, 
					hotelCtrl.findById(1), 
					CategoriaQuarto.APARTAMENTO, 
					3,
					120,
					240.0);
		q1 = ctrl.insert(q1);
		System.out.println(q1);
		
		Quarto q2 = ctrl.findById(1);
		System.out.println("UPDATE");
		System.out.println("#ID original: "+q2);
		q2.setPrDiaria(q2.getPrDiaria()+20);
		q2 = ctrl.update(q2);
		System.out.println("#ID alterado: "+q2);
		
		
		System.out.println("Lista de Quartos Cadastrados");
		for(Quarto h : ctrl.findAll()) {
			System.out.println(h);
		}
		System.out.println("Deletar #ID 3");
		ctrl.delete(12);
		
		System.out.println("Lista de Quartos Atualizado");
		for(Quarto q : ctrl.findAll()) {
			System.out.println(q);
		}

	}
	public static void testeCrudHospede(){

		HospedeCtrl ctrl = new HospedeCtrl();
		System.out.println("Listar todos");
		for (Hospede h : ctrl.findAll()){
			System.out.println(h);
		}

		System.out.println("\nListar pela id #1");
		Hospede hospede = ctrl.findById(1);
		System.out.println(hospede);

		System.out.println("\nInserindo um hospede");
		hospede = new Hospede(null, "Miriam", "1994-01-01", 4444);
		hospede = ctrl.insert(hospede);
		System.out.println(hospede);

		System.out.println("\nAtualizando um hospede #4");
		hospede = ctrl.findById(4);
		hospede.setDtNascimento("2004-01-01");
		hospede = ctrl.update(hospede);
		System.out.println(hospede);

		System.out.println("\nDeletando um hospede #4");
		System.out.println("ANTES:");
		for(Hospede h : ctrl.findAll()){
			System.out.println(h);
		}
		ctrl.delete(4);
		System.out.println("\nDEPOIS:");
		for(Hospede h : ctrl.findAll()){
			System.out.println(h);
		}

	}

	public static void testeCrudHospedagem(){

		HospedagemCtrl ctrl = new HospedagemCtrl();
		HospedeCtrl hospedectrl = new HospedeCtrl();
		QuartoCtrl quartoCtrl = new QuartoCtrl();
		System.out.println("Listar todos");
		for (Hospedagem h : ctrl.findAll()){
			System.out.println(h);
		}

		System.out.println("\nListar pela id #1");
		Hospedagem hospedagem = ctrl.findById(1);
		System.out.println(hospedagem);

		System.out.println("\nInserindo uma hospedagem");
		hospedagem = new Hospedagem(null, quartoCtrl.findById(1), hospedectrl.findById(1), "2021-10-07", "2021-10-08");
		hospedagem = ctrl.insert(hospedagem);
		System.out.println(hospedagem);

		System.out.println("\nAtualizando uma hospedagem #4");
		hospedagem = ctrl.findById(4);
		hospedagem.setDtCheckout("2021-11-08");
		hospedagem = ctrl.update(hospedagem);
		System.out.println(hospedagem);

		System.out.println("\nDeletando uma hospedagem #4");
		System.out.println("ANTES:");
		for(Hospedagem h : ctrl.findAll()){
			System.out.println(h);
		}
		ctrl.delete(4);
		System.out.println("\nDEPOIS:");
		for(Hospedagem h : ctrl.findAll()){
			System.out.println(h);
		}

	}

}
