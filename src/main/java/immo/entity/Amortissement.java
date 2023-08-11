package immo.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Amortissement {
	 Date dateDebut;
	    Date dateFin;
	    Double anterieure;
	    Double exercice;
	    Double cumul;
	    Double vnc;
	    String article;

	    public Amortissement() {
	    }

	    public Amortissement(Date dateDebut, Date dateFin, Double anterieure, Double exercice, Double cumul, Double vnc,String article) {
	        this.dateDebut = dateDebut;
	        this.dateFin = dateFin;
	        this.anterieure = anterieure;
	        this.exercice = exercice;
	        this.cumul = cumul;
	        this.vnc = vnc;
	        this.article = article;
	    }

	    public String getArticle() {
	        return article;
	    }

	    public void setArticle(String article) {
	        this.article = article;
	    }
	    public int nbrMois(Date date1,Date date2)
	    {
	        if(date2==null || date1==null){
	        return -1;//Error
	    }
	    Calendar m_calendar=Calendar.getInstance();
	    m_calendar.setTime(date1);
	    int nMonth1=12*m_calendar.get(Calendar.YEAR)+m_calendar.get(Calendar.MONTH);
	    m_calendar.setTime(date2);
	    int nMonth2=12*m_calendar.get(Calendar.YEAR)+m_calendar.get(Calendar.MONTH);
	    return java.lang.Math.abs(nMonth2-nMonth1);
	    }
	    
	    public int diffdate(Date date1, Date date2) {
	        Calendar c1 = Calendar.getInstance();
	        c1.setTime(date1);

	        Calendar c2 = Calendar.getInstance();
	        c2.setTime(date2);

	        int days = 0;

	        if (c1.getTimeInMillis() == c2.getTimeInMillis()) {
	            return 0;
	        }

	        if (c1.getTimeInMillis() > c2.getTimeInMillis()) {
	            c1.setTime(date2);
	            c2.setTime(date1);
	        }

	        do {
	            c1.add(Calendar.DAY_OF_MONTH, 1);
	            ++days;
	        } while (c1.getTimeInMillis() < c2.getTimeInMillis());
	        return days;
	    }


	     public List<Amortissement> getTableauAmortissement(Immo immo) {
	        
	        Date dateMiseEnService = immo.getDateMiseEnService();
	        Double exoAnnuelle = immo.exerciceAnnuelle();
	        List<Amortissement> liste = new ArrayList<>();
	        Double anteZero = Double.valueOf(0); 

	        for (int i = 0; i < immo.getDureeAmortissement(); i++) {

	            Calendar calendar1 = Calendar.getInstance();
	            calendar1.setTime(dateMiseEnService);
	            int yearMiseEnService = calendar1.get(Calendar.YEAR);
	            java.sql.Date premierJanvier = java.sql.Date.valueOf(yearMiseEnService + "-01-01");  
	            
	            Amortissement a = new Amortissement();
	            a.setDateDebut(dateMiseEnService);
	            String date = yearMiseEnService + "-12-31";
	            java.sql.Date finAnnee = java.sql.Date.valueOf(date);
	            a.setDateFin(finAnnee);
	            a.setAnterieure(anteZero);
	            //int diff = diffdate(premierJanvier, dateMiseEnService); //diff = jours entre 1er janvier et dateMiseEnService
	            int diff = nbrMois(premierJanvier, dateMiseEnService);
	            int d = 12-diff;
	            if (diff > 0) {
	                //Double prorata = (exoAnnuelle) * (360 - diff) / 360;  
	                Double prorata = (exoAnnuelle) * d / 12;  
	                a.setExercice(prorata);
	            } else { 
	                a.setExercice(exoAnnuelle);
	            }
	            a.setCumul(a.getAnterieure() + a.getExercice());
	           
	            a.setVnc(immo.getPrixAchat() - a.getCumul());
	            a.setArticle(immo.getArticle());
	            liste.add(a);
	            anteZero = a.getCumul();
	            yearMiseEnService = yearMiseEnService + 1;
	            String ddebut = yearMiseEnService + "-01-01";
	            dateMiseEnService = java.sql.Date.valueOf(ddebut);
	        }
	        
	        //faran ny tableau
	        Calendar cal1 = Calendar.getInstance();
	        cal1.setTime(immo.getDateMiseEnService());
	        int year1 = cal1.get(Calendar.YEAR);
	        int month1 = cal1.get(Calendar.MONTH);
	        int day1 = cal1.get(Calendar.DAY_OF_MONTH);
	        java.sql.Date dat1 = java.sql.Date.valueOf(year1 + "-01-01");
	        //int diff = diffdate(dat1, immo.getDateMiseEnService());
	  int diff = nbrMois(dat1, immo.getDateMiseEnService());
	        if (diff > 0) {
	            Amortissement a = new Amortissement();
	            a.setDateDebut(dateMiseEnService);

	            cal1.add(Calendar.YEAR, immo.getDureeAmortissement()); //
	            cal1.add(Calendar.DAY_OF_MONTH, -1);
	            java.sql.Date dateFaranyTableau = new java.sql.Date(cal1.getTime().getTime());

	            a.setDateFin(dateFaranyTableau);
	            a.setAnterieure(anteZero);
	            
	            Double dd = (exoAnnuelle) * (diff) / 12;  //diff nbr jour entre premier janvier et dateMiseEnService am farany tableau
	            a.setExercice(dd);

	            a.setCumul(a.getAnterieure() + a.getExercice());
	            a.setVnc(immo.getPrixAchat() - a.getCumul());
	              a.setArticle(immo.getArticle());
	            liste.add(a);
	        }
	        return liste;
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
	    

}
