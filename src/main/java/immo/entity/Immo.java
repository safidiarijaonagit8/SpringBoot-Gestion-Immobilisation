package immo.entity;
import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;

//import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="immo")
public class Immo extends BaseModel{
	
	    @Column(name="article")
	    String article;
	    /*@Column(name="idcategorie")
	    int idcategorie;*/
	    @Column(name="dateachat")
	    Date dateAchat;
	    @Column(name="prixachat")
	    double prixAchat;
	    @Column(name="datemiseenservice")
	    Date dateMiseEnService;
	    @Column(name="typeamortissement")
	    String typeAmortissement;
	    @Column(name="dureeamortissement")
	    int dureeAmortissement;
	    @Column(name="detenteur")
	    String detenteur;
	    
	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "categorie_id", nullable = false)
	    private Categorie categorie;
	    
	    public Immo() {
	    }
	        public Immo(String article, int idcategorie, Date dateAchat, double prixAchat, Date dateMiseEnService, String typeAmortissement, int dureeAmortissement, String detenteur) 
	        {
	        this.article = article;
	        //this.idcategorie = idcategorie;
	        this.dateAchat = dateAchat;
	        this.prixAchat = prixAchat;
	        this.dateMiseEnService = dateMiseEnService;
	        this.typeAmortissement = typeAmortissement;
	        this.dureeAmortissement = dureeAmortissement;
	        this.detenteur = detenteur;
	    }
	        
	        public Immo(String article, int idcategorie, Date dateAchat, double prixAchat, Date dateMiseEnService,
					String typeAmortissement, int dureeAmortissement, String detenteur, Categorie categorie) {
				super();
				this.article = article;
				//this.idcategorie = idcategorie;
				this.dateAchat = dateAchat;
				this.prixAchat = prixAchat;
				this.dateMiseEnService = dateMiseEnService;
				this.typeAmortissement = typeAmortissement;
				this.dureeAmortissement = dureeAmortissement;
				this.detenteur = detenteur;
				this.categorie = categorie;
			}
			public Immo getInstanceImmo()
	        {
	        	return new Immo();
	        }
	    

	    public Categorie getCategorie() {
				return categorie;
			}
			public void setCategorie(Categorie categorie) {
				this.categorie = categorie;
			}
		public String getArticle() {
	        return article;
	    }

	    public void setArticle(String article) {
	        this.article = article;
	    }

	/*    public int getIdcategorie() {
	        return idcategorie;
	    }

	    public void setIdcategorie(int idcategorie) {
	        this.idcategorie = idcategorie;
	    }
*/
	    public Date getDateAchat() {
	        return dateAchat;
	    }

	    public void setDateAchat(Date dateAchat) {
	        this.dateAchat = dateAchat;
	    }

	    public double getPrixAchat() {
	        return prixAchat;
	    }

	    public void setPrixAchat(double prixAchat) {
	        this.prixAchat = prixAchat;
	    }

	    public Date getDateMiseEnService() {
	        return dateMiseEnService;
	    }

	    public void setDateMiseEnService(Date dateMiseEnService) {
	        this.dateMiseEnService = dateMiseEnService;
	    }

	    public String getTypeAmortissement() {
	        return typeAmortissement;
	    }

	    public void setTypeAmortissement(String typeAmortissement) {
	        this.typeAmortissement = typeAmortissement;
	    }

	    public int getDureeAmortissement() {
	        return dureeAmortissement;
	    }

	    public void setDureeAmortissement(int dureeAmortissement) {
	        this.dureeAmortissement = dureeAmortissement;
	    }

	    public String getDetenteur() {
	        return detenteur;
	    }

	    public void setDetenteur(String detenteur) {
	        this.detenteur = detenteur;
	    }

	  public Double exerciceAnnuelle() {
	        return this.getPrixAchat() / this.getDureeAmortissement();
	    }


}
