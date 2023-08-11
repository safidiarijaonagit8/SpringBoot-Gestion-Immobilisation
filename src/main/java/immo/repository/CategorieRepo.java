package immo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import immo.entity.Categorie;

@Repository
public interface CategorieRepo extends JpaRepository <Categorie, Long>{
	
	

}
