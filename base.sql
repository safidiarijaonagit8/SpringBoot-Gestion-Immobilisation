CREATE SCHEMA immodb;

CREATE TABLE immodb.categorie ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	nom                  varchar(255)      
 );

CREATE TABLE immodb.immo ( 
	id                   int  NOT NULL  AUTO_INCREMENT  PRIMARY KEY,
	article              varchar(255)      ,
	dateachat            date      ,
	datemiseenservice    date      ,
	detenteur            varchar(255)      ,
	dureeamortissement   int      ,
	prixachat            double      ,
	typeamortissement    varchar(255)      ,
	categorie_id         int  NOT NULL    ,
	CONSTRAINT fkgca8pjbfhhov86qvy8qsmjj58_0 FOREIGN KEY ( categorie_id ) REFERENCES immodb.categorie( id ) ON DELETE RESTRICT ON UPDATE RESTRICT
 );

CREATE INDEX `FKgca8pjbfhhov86qvy8qsmjj58` ON immodb.immo ( categorie_id );

CREATE VIEW v_immo AS select
i.id,
i.article,i.dateachat,i.prixachat,i.datemiseenservice,i.typeamortissement,i.dureeamortissement,i.detenteur,c.nom
from immo i join categorie c on i.categorie_id=c.id;

INSERT INTO immodb.categorie( id, nom ) VALUES ( 1, 'meuble');
INSERT INTO immodb.categorie( id, nom ) VALUES ( 2, 'technologie');
INSERT INTO immodb.categorie( id, nom ) VALUES ( 3, 'transport');
INSERT INTO immodb.immo( id, article, dateachat, datemiseenservice, detenteur, dureeamortissement, prixachat, typeamortissement, categorie_id ) VALUES ( 1, 'Ordinateur', '2023-11-14', '2023-11-15', 'Mr DG', 5, 2300000.0, 'lineaire', 2);
INSERT INTO immodb.immo( id, article, dateachat, datemiseenservice, detenteur, dureeamortissement, prixachat, typeamortissement, categorie_id ) VALUES ( 2, 'camion', '2023-01-01', '2023-02-01', 'Mr DG', 20, 4.5E7, 'lineaire', 3);
