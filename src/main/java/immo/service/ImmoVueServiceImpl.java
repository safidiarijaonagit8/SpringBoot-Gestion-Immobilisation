package immo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import immo.entity.Immo;
import immo.entity.ImmoVue;
import immo.repository.ImmoVueRepo;
import immo.repository.ImmoVueRepoImpl;
import immo.repository.ImmoVueRepository;

@Service
public class ImmoVueServiceImpl implements ImmoVueService{

	  @Autowired
	  private ImmoVueRepository immoVueRepo;
	  
	public Page<ImmoVue> findAllImmo(int initPage) {
		 
		Pageable sort = 
				  PageRequest.of(initPage, 3, Sort.by("article").ascending());
			return immoVueRepo.findAll(sort);
		}
	
	@Autowired
	@Qualifier("impl")
	ImmoVueRepoImpl immoRepo;
	
	@Override
	public List<ImmoVue> rechercheMulti(String categorie,double prixAchatMin,double prixAchatMax,
            Date dateMiseEnServiceMin,Date dateMiseEnServiceMax
    ,int dureeAmortissementMin,int dureeAmortissementMax) {
	return immoRepo.rechercheMulti(categorie, prixAchatMin, prixAchatMax, dateMiseEnServiceMin, dateMiseEnServiceMax, dureeAmortissementMin, dureeAmortissementMax);
		
	}
}
