package immo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

import immo.entity.Amortissement;
import immo.entity.Categorie;
import immo.entity.Immo;
import immo.entity.ImmoAnnee;
import immo.entity.ImmoVue;
import immo.entity.OpenPdfExporter;
import immo.service.CategorieService;
import immo.service.ImmoService;
import immo.service.ImmoVueService;
import jakarta.servlet.http.HttpServletResponse;


@Controller
//@RequestMapping("/immo")
public class MainController {
	
	  @Autowired
	    private CategorieService categorieService;
	  
	  @Autowired
	    private ImmoService immoService;
	  
	
	  
	  @Autowired
	    private ImmoVueService immoVueService;
	  
	  @Autowired
	    private Immo immo;
	  
	  
	  @RequestMapping(value="/",method=RequestMethod.GET)
	    public ModelAndView homepage() throws Exception{
	      
		  ModelAndView v = new ModelAndView();
		  List<Categorie> l = categorieService.getCategorieList();
	        v.addObject("listeCat",l);
	        v.setViewName("homepage");
	        return v;
	    }
	  
	  @RequestMapping(value="insertImmo",method=RequestMethod.POST)
	    public ModelAndView insertImmo(@RequestParam("article") String article,@RequestParam("idcategorie") int idcategorie,
	            @RequestParam("dateAchat") String dateAchat,@RequestParam("prixAchat") double prixAchat,@RequestParam("dateMiseEnService") String dateMiseEnService
	    ,@RequestParam("typeAmortissement") String typeAmortissement,@RequestParam("dureeAmortissement") int dureeAmortissement,
	    @RequestParam("detenteur") String detenteur) throws Exception{
		  
	        Immo a = immo.getInstanceImmo();
	        a.setArticle(article);
	        Categorie c = new Categorie();
	        c.setId(idcategorie);
	      //  c.setNom("");
	        a.setCategorie(c);
	        
	       // a.setIdcategorie(idcategorie);
	        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	        String da = sdf2.format(sdf1.parse(dateAchat));
	        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
	        
	      //  Date d  = (Date) sourceFormat.parse(da);
	        Date d  = new java.sql.Date(sourceFormat.parse(da).getTime());
	        a.setDateAchat(d);
	        String dms = sdf2.format(sdf1.parse(dateMiseEnService));
	        
	       // Date de  = (Date) sourceFormat.parse(dms);
	        Date de  = new java.sql.Date(sourceFormat.parse(dms).getTime());
	        a.setDateMiseEnService(de);
	        a.setTypeAmortissement(typeAmortissement);
	        a.setDureeAmortissement(dureeAmortissement);
	        a.setPrixAchat(prixAchat);
	        a.setDetenteur(detenteur);
	        immoService.addImmo(a);
	        
	        ModelAndView v = new ModelAndView();
	       List<Categorie> l = categorieService.getCategorieList();
	        v.addObject("listeCat",l);
	        v.setViewName("homepage");
	        return v;
	        
	    }
	  @RequestMapping(value="formajout",method=RequestMethod.GET)
	    public ModelAndView formajout() throws Exception{
	      
	       
	        
	        ModelAndView v = new ModelAndView();
	        List<Categorie> l = categorieService.getCategorieList();
	        v.addObject("listeCat",l);
	        v.setViewName("homepage");
	        return v;
	    }
	        @RequestMapping(value="formrecherche",method=RequestMethod.GET)
	    public ModelAndView formrecherche() throws Exception{
	      
	        List<Categorie> l = categorieService.getCategorieList();
	      
	        ModelAndView v = new ModelAndView();
	        v.addObject("listeCat",l);
	        v.setViewName("recherche");
	        return v;
	    }
	        
	        @RequestMapping(value="recherchemulti",method=RequestMethod.POST)
	        public ModelAndView recherchemulti(@RequestParam("nomcategorie") String nomcategorie,
	                @RequestParam("prixAchatMin") double prixAchatMin,@RequestParam("prixAchatMax") double prixAchatMax,@RequestParam("dateMiseEnServiceMin") String dateMiseEnServiceMin,
	                @RequestParam("dateMiseEnServiceMax") String dateMiseEnServiceMax
	        ,@RequestParam("dureeAmortissementMin") int dureeAmortissementMin,@RequestParam("dureeAmortissementMax") int dureeAmortissementMax
	        ) throws Exception{
	        	
	        	 Immo a = immo.getInstanceImmo();
	        	//  Categorie c = new Categorie();
	  	        //c.setId(idcategorie);
	  	      
	  	       // a.setCategorie(c);
	  	        
	       
	          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	          SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	          DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
	          String dmsmin = sdf2.format(sdf1.parse(dateMiseEnServiceMin));
	          
	          Date dmin  = new java.sql.Date(sourceFormat.parse(dmsmin).getTime());
	          
	         // Date dmin = sourceFormat.parse(dmsmin);
	          String dmsmax = sdf2.format(sdf1.parse(dateMiseEnServiceMax));
	          
	          Date dmax  = new java.sql.Date(sourceFormat.parse(dmsmax).getTime());
	         // Date dmax = sourceFormat.parse(dmsmax);
	          
	         List<ImmoVue> lista = immoVueService.rechercheMulti(nomcategorie, prixAchatMin, prixAchatMax, dmin, dmax, dureeAmortissementMin, dureeAmortissementMax);
	       
	          ModelAndView v = new ModelAndView();
	     

	          v.addObject("resultats", lista);

	          v.setViewName("resultat");
	          return v;

	        }
	        @RequestMapping(value="formrechercheannee",method=RequestMethod.GET)
	        public ModelAndView formrechercheannee() throws Exception{
	          
	            List<Integer> annees = new ArrayList();
	            
	            for(int i = 2000;i<=2030;i++)
	            {
	                annees.add(i);
	                
	            }
	           
	             ModelAndView v = new ModelAndView();
	             v.addObject("annees", annees);
	            v.setViewName("rechercheAnnee");
	            return v;
	        }
	  
	        @RequestMapping(value= "rechercheannee", method= RequestMethod.GET) 
	        public ModelAndView rechercheannee(@RequestParam("an") int an) throws Exception  {       
	      
	                List<Immo> l = immoService.findAllImmo();
	                
	                List<List<Amortissement>> t = new ArrayList();
	                double totalExercice = 0.0;
	                
	                for(int i = 0;i<l.size();i++)
	                {
	                        List<Amortissement> ammos = immoService.ammortissement(l.get(i));
	                        t.add(ammos);
	                }
	                List<ImmoAnnee> la = new ArrayList();
	                
	                for(int j=0;j<t.size();j++)
	                {
	                    for(int k=0;k<t.get(j).size();k++)
	                    {
	                        Calendar cal1 = Calendar.getInstance();
	                        cal1.setTime(t.get(j).get(k).getDateDebut());
	                        int year1 = cal1.get(Calendar.YEAR);
	                        if(year1==an)
	                        {
	                            ImmoAnnee a = new ImmoAnnee();
	                            a.setDateDebut(t.get(j).get(k).getDateDebut());
	                            a.setDateFin(t.get(j).get(k).getDateFin());
	                            a.setAnterieure(t.get(j).get(k).getAnterieure());
	                            a.setExercice(t.get(j).get(k).getExercice());
	                            a.setCumul(t.get(j).get(k).getCumul());
	                            a.setVnc(t.get(j).get(k).getVnc());
	                            a.setArticle(t.get(j).get(k).getArticle());
	                            totalExercice = totalExercice + t.get(j).get(k).getExercice();
	                            la.add(a);
	                            
	                        }
	                    }
	                    
	                }
	                      ModelAndView v = new ModelAndView();
	          v.addObject("annee", an);

	           v.addObject("totalExercice", totalExercice);
	          v.addObject("listeImmoAnnee", la);

	          v.setViewName("listeImmoAnnee");
	          return v;
	                
	              
	        }
	        @RequestMapping(value="/pdfannee",method=RequestMethod.POST)
	        public void exportToPdfAnnee(@RequestParam("annee") String annee, HttpServletResponse response) throws DocumentException, IOException, Exception {
	        	 List<Immo> l = immoService.findAllImmo();
	                List<List<Amortissement>> t = new ArrayList();
	                double totalExercice = 0.0;
	                
	                for(int i = 0;i<l.size();i++)
	                {
	                	 List<Amortissement> ammos = immoService.ammortissement(l.get(i));
	                        t.add(ammos);
	                }
	                List<ImmoAnnee> la = new ArrayList();
	                int taona = Integer.valueOf(annee);
	                
	                for(int j=0;j<t.size();j++)
	                {
	                    for(int k=0;k<t.get(j).size();k++)
	                    {
	                        Calendar cal1 = Calendar.getInstance();
	                        cal1.setTime(t.get(j).get(k).getDateDebut());
	                        int year1 = cal1.get(Calendar.YEAR);
	                        if(year1==taona)
	                        {
	                            ImmoAnnee a = new ImmoAnnee();
	                            a.setDateDebut(t.get(j).get(k).getDateDebut());
	                            a.setDateFin(t.get(j).get(k).getDateFin());
	                            a.setAnterieure(t.get(j).get(k).getAnterieure());
	                            a.setExercice(t.get(j).get(k).getExercice());
	                            a.setCumul(t.get(j).get(k).getCumul());
	                            a.setVnc(t.get(j).get(k).getVnc());
	                            a.setArticle(t.get(j).get(k).getArticle());
	                            totalExercice = totalExercice + t.get(j).get(k).getExercice();
	                            la.add(a);
	                            
	                        }
	                    }
	                    
	                }
	            ///get list code here
	          
	            response.setContentType("application/pdf");
	            
	            long millis=System.currentTimeMillis();  
	            java.sql.Date date=new java.sql.Date(millis);  

	            String headerKey = "Content-Disposition";
	            String headerValue = "inline; filename=immobilisations_"+annee+" " + date + ".pdf";  //nom fichier asiana anle annee
	            response.setHeader(headerKey, headerValue);
	             ;
	            OpenPdfExporter exporter = new OpenPdfExporter(null,la);
	            exporter.export1(response);
	        }
	        
	        @RequestMapping(value= "init", method= RequestMethod.GET) 
	        public ModelAndView paginate(@RequestParam("page_id") int page_id) {       
	           
	     
	            Page<ImmoVue> p = immoVueService.findAllImmo(page_id);
	            
	     
	            return new ModelAndView("listeImmo", "listeImmo", p.getContent());  
	        
	    }
	        @RequestMapping(value = "tableau",method=RequestMethod.GET)
	        public ModelAndView tableau(@RequestParam("id") String id) throws Exception {
	        
	       //    List<Immo> immo = adminService.findWithCriteriaById(immobilisation.getInstanceImmo(),"id",Integer.valueOf(id));
	           
	        	Optional<Immo> immo = immoService.findById( Long. parseLong(id));
	        	ArrayList<Immo> result = new ArrayList<>();
	        	immo.ifPresent(result::add);
	            ModelAndView mv = new ModelAndView();
	          
	            List<Amortissement> ammos = immoService.ammortissement(result.get(0));
	           
	             mv.addObject("detailImmo", result);
	        
	            mv.addObject("ammos", ammos);
	            mv.setViewName("tableau");
	            return mv;
	        }
	  
	        @RequestMapping(value="/pdf",method=RequestMethod.POST)
	        public void exportToPdf(@RequestParam("id") String id, HttpServletResponse response) throws DocumentException, IOException, Exception {
	        	Optional<Immo> immo = immoService.findById( Long. parseLong(id));
	        	ArrayList<Immo> result = new ArrayList<>();
	        	immo.ifPresent(result::add);
	        	 List<Amortissement> ammos = immoService.ammortissement(result.get(0));
	          
	            response.setContentType("application/pdf");
	            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	            String currentDateTime = dateFormatter.format(new Date(0));
	            
	            long millis=System.currentTimeMillis();  
	            java.sql.Date date=new java.sql.Date(millis);  
	            
	            String headerKey = "Content-Disposition";
	            String headerValue = "inline; filename=immobilisations_" + date + ".pdf";
	            response.setHeader(headerKey, headerValue);

	            OpenPdfExporter exporter = new OpenPdfExporter(ammos);
	            exporter.export(response);
	            
	            
	                
	        }

}
