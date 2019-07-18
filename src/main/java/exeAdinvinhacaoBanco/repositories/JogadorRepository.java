package exeAdinvinhacaoBanco.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import exeAdinvinhacaoBanco.models.Jogador;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Integer>{

	
}
