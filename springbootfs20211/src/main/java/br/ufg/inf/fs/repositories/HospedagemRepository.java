package br.ufg.inf.fs.repositories;

import br.ufg.inf.fs.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fs.entities.Hospedagem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Integer>{

    @Query("SELECT h FROM Hospedagem h WHERE str(h.quarto.categoriaQuarto) = str(:qtd)")
    public List<Hospedagem> findByCategoryHospedagem(@Param("qtd") Integer qtd);
}
