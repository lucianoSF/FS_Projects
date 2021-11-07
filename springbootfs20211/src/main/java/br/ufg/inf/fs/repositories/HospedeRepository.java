package br.ufg.inf.fs.repositories;

import br.ufg.inf.fs.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fs.entities.Hospede;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospedeRepository extends JpaRepository<Hospede, Integer>{

    @Query("SELECT h FROM Hospede h WHERE h.nmHospede LIKE %:str%")
    public List<Hospede> findByNmHospede(@Param("str") String str);
}
