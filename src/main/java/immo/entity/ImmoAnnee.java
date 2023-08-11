package immo.entity;

import java.util.Date;

public class ImmoAnnee {
	 Date dateDebut;
	    Date dateFin;
	    Double anterieure;
	    Double exercice;
	    Double cumul;
	    Double vnc;
	    String article;

	    public ImmoAnnee() {
	    }

	    public ImmoAnnee(Date dateDebut, Date dateFin, Double anterieure, Double exercice, Double cumul, Double vnc, String article) {
	        this.dateDebut = dateDebut;
	        this.dateFin = dateFin;
	        this.anterieure = anterieure;
	        this.exercice = exercice;
	        this.cumul = cumul;
	        this.vnc = vnc;
	        this.article = article;
	    }

	    public Date getDateDebut() {
	        return dateDebut;
	    }

	    public void setDateDebut(Date dateDebut) {
	        this.dateDebut = dateDebut;
	    }

	    public Date getDateFin() {
	        return dateFin;
	    }

	    public void setDateFin(Date dateFin) {
	        this.dateFin = dateFin;
	    }

	    public Double getAnterieure() {
	        return anterieure;
	    }

	    public void setAnterieure(Double anterieure) {
	        this.anterieure = anterieure;
	    }

	    public Double getExercice() {
	        return exercice;
	    }

	    public void setExercice(Double exercice) {
	        this.exercice = exercice;
	    }

	    public Double getCumul() {
	        return cumul;
	    }

	    public void setCumul(Double cumul) {
	        this.cumul = cumul;
	    }

	    public Double getVnc() {
	        return vnc;
	    }

	    public void setVnc(Double vnc) {
	        this.vnc = vnc;
	    }

	    public String getArticle() {
	        return article;
	    }

	    public void setArticle(String article) {
	        this.article = article;
	    }
	    
}
