package exeAdinvinhacaoBanco.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import exeAdinvinhacaoBanco.models.NumeroSortiado;

@Repository
public interface NumeroSortiadoRopository extends CrudRepository<NumeroSortiado, Integer> {

}
