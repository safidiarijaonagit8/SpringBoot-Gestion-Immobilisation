package immo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import immo.entity.Amortissement;
import immo.entity.Immo;

@Service
public interface ImmoService {

	void addImmo(Immo i);
	List findAllImmo();
	

	 
	 List<Amortissement> ammortissement(Immo b);
	 
	 Optional<Immo> findById(Long id);
}
