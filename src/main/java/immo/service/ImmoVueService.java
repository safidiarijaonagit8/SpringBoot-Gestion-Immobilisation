package immo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import immo.entity.Immo;
import immo.entity.ImmoVue;


@Service
public interface ImmoVueService {
	 Page<ImmoVue> findAllImmo(int initPage); 
	 List<ImmoVue> rechercheMulti(String categorie,double prixAchatMin,double prixAchatMax,
	            Date dateMiseEnServiceMin,Date dateMiseEnServiceMax
	            ,int dureeAmortissementMin,int dureeAmortissementMax);
}
