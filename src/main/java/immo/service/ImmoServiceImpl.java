package immo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import immo.entity.Amortissement;
import immo.entity.Immo;
import immo.repository.ImmoRepo;

@Service
public class ImmoServiceImpl implements ImmoService{
	@Autowired
	ImmoRepo immoRepo;
	
	@Override
	public void addImmo(Immo i) {
	immoRepo.save(i);
	}
	@Override
	public List findAllImmo() {
	 return immoRepo.findAll();
	}
	
	@Override
	public List<Immo> rechercheMulti(int idcategorie,double prixAchatMin,double prixAchatMax,
            Date dateMiseEnServiceMin,Date dateMiseEnServiceMax
    ,int dureeAmortissementMin,int dureeAmortissementMax) {
	//return immoRepo.rechercheMulti(idcategorie, prixAchatMin, prixAchatMax, dateMiseEnServiceMin, dateMiseEnServiceMax, dureeAmortissementMin, dureeAmortissementMax);
		List l = new ArrayList<Immo>();
		return l;
	}
	
	@Override
    public List<Amortissement> ammortissement(Immo b) {
        
            List<Amortissement> valiny = new ArrayList<>();
            valiny = new Amortissement().getTableauAmortissement(b);
            return valiny;
       }

}
