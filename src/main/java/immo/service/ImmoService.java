package immo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import immo.entity.Amortissement;
import immo.entity.Immo;

@Service
public interface ImmoService {

	void addImmo(Immo i);
	List findAllImmo();
	
	 List<Immo> rechercheMulti(int idcategorie,double prixAchatMin,double prixAchatMax,
	            Date dateMiseEnServiceMin,Date dateMiseEnServiceMax
	            ,int dureeAmortissementMin,int dureeAmortissementMax);
	 
	 List<Amortissement> ammortissement(Immo b);
}
