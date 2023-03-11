package uea.jlfilho.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.jlfilho.locadora.entities.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Integer>{

}
