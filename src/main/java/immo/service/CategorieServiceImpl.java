package immo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import immo.entity.Categorie;
import immo.repository.CategorieRepo;


@Service
public class CategorieServiceImpl implements CategorieService{

	@Autowired
	CategorieRepo categorieRepo;
	
	@Override
	public List<Categorie> getCategorieList() {
	return categorieRepo.findAll();
	}
	
	
}
