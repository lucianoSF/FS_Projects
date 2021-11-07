package br.ufg.inf.fs.repositories;

import br.ufg.inf.fs.enums.CategoriaQuarto;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fs.entities.Quarto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuartoRepository extends JpaRepository<Quarto, Integer>{

    @Query("SELECT q FROM Quarto q WHERE str(q.categoriaQuarto) = str(:category)")
    public List<Quarto> findByCategoryQuarto(@Param("category") Integer category);

}
