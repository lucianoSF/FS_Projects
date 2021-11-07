package br.ufg.inf.fs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fs.entities.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

    @Query("SELECT h FROM Hotel h WHERE h.nmHotel LIKE %:str%")
    public List<Hotel> findByNmHotel(@Param("str") String str);


    @Query("SELECT h FROM Hotel h WHERE h.qtdEstrelas = :qtd")
    public List<Hotel> findByQtdEstelas(@Param("qtd") Integer qtd);
}
