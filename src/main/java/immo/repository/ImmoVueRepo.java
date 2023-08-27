package immo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import immo.entity.Immo;
import immo.entity.ImmoVue;


@Repository
public interface ImmoVueRepo{
	
	

	 List<ImmoVue> rechercheMulti(String categorie,double prixAchatMin,double prixAchatMax,
	            Date dateMiseEnServiceMin,Date dateMiseEnServiceMax
	            ,int dureeAmortissementMin,int dureeAmortissementMax);
	
	
	
}
