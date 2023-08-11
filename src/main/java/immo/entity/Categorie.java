package immo.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

//import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//@Component
@Entity
@Table(name="categorie")
public class Categorie extends BaseModel {
	
	  @Column(name="nom")
	    private String nom;
	  
	 @OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	    private Set<Immo> immos;
	 
	    public Categorie() {
	    }

	    public Categorie(String nom) {
	        this.nom = nom;
	    }
	    public Categorie getInstanceCategorie()
	    {
	        Categorie a = new Categorie();
	        return a;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }
	    
	  
	
	

}
