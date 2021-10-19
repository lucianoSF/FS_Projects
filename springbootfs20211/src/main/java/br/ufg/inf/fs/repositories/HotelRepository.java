package br.ufg.inf.fs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fs.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
