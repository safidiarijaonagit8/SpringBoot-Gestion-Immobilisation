package immo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import immo.entity.Immo;
import immo.entity.ImmoVue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository("impl")
public class ImmoVueRepoImpl implements ImmoVueRepo{
	@PersistenceContext
	EntityManager em;
	
	 public List<ImmoVue> rechercheMulti(String categorie,double prixAchatMin,double prixAchatMax,
	            Date dateMiseEnServiceMin,Date dateMiseEnServiceMax
	            ,int dureeAmortissementMin,int dureeAmortissementMax){
		 
		 CriteriaBuilder cb = em.getCriteriaBuilder();
	        CriteriaQuery<ImmoVue> cq = cb.createQuery(ImmoVue.class);

	        Root<ImmoVue> b = cq.from(ImmoVue.class);
	        Predicate p1 = cb.equal(b.get("nom"), categorie);
	        Predicate p2 =  cb.between(b.get("dateMiseEnService"), dateMiseEnServiceMin, dateMiseEnServiceMax);
	        Predicate p3 =  cb.between(b.get("prixAchat"), prixAchatMin, prixAchatMax);
	        Predicate p4 =  cb.between(b.get("dureeAmortissement"), dureeAmortissementMin, dureeAmortissementMax);
	       
	        
	        cq.where(p1,p2,p3,p4);

	        TypedQuery<ImmoVue> query = em.createQuery(cq);
	        return query.getResultList();
	 }
	 

}
