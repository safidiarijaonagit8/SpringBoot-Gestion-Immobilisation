package immo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import immo.entity.Immo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;

@Repository
public interface ImmoRepo extends JpaRepository <Immo, Long>{
	
	
	/*@Query(value = "SELECT * FROM immo i WHERE i.categorie_id = :idc and (i.prixachat between :pamin and :pamax) and"
			+ " (i.datemiseenservice between :dmin and :dmax) and"
			+ " (i.dureeamortissement between :dammin and :dammax)")
	List<Immo> rechercheMulti(@Param("idc") Integer idcategorie,@Param("pamin") double prixachatmin,@Param("pamax") double prixachatmax,@Param("dmin") Date dmin,@Param("dmax") Date dmax,@Param("dammin") int dureeAmortissementMin,@Param("dammax") int dureeAmortissementMax);
	*/
	 
	
	
}

