package immo.entity;
import java.sql.Date;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import jakarta.persistence.Column;

//import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/*@Entity
@Table(name="immocategorie")*/

@Entity
@Immutable
@Subselect("select * from v_immo")
public class ImmoVue extends BaseModel{
	@Column(name="article")
    String article;
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
    @Column(name="nom")
    String nom;
    
    public ImmoVue() {
    }

    public ImmoVue(String article, String nom, Date dateAchat, double prixAchat, Date dateMiseEnService, String typeAmortissement, int dureeAmortissement, String detenteur) 
    {
        this.article = article;
        this.nom = nom;
        this.dateAchat = dateAchat;
        this.prixAchat = prixAchat;
        this.dateMiseEnService = dateMiseEnService;
        this.typeAmortissement = typeAmortissement;
        this.dureeAmortissement = dureeAmortissement;
        this.detenteur = detenteur;
    }
      public ImmoVue getInstanceImmo() {
          ImmoVue iv = new ImmoVue();
          return iv; 
    }


    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

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



}
