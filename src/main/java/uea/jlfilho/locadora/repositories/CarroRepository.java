package uea.jlfilho.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.jlfilho.locadora.entities.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{

}
