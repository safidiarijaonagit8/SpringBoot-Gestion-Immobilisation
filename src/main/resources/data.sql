create view v_immo
as select i.article,i.dateachat,i.prixachat,i.datemiseenservice,
i.typeamortissement,i.dureeamortissement,i.detenteur,c.nom
from immo i join categorie c 
on i.categorie_id=c.id;