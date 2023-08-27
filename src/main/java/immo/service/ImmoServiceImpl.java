package immo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import immo.entity.Amortissement;
import immo.entity.Immo;
import immo.repository.ImmoRepository;

@Service
public class ImmoServiceImpl implements ImmoService{
	
	
	@Autowired
	ImmoRepository immoRepository;
	
	@Override
	public void addImmo(Immo i) {
	immoRepository.save(i);
	}
	@Override
	public List findAllImmo() {
	 return immoRepository.findAll();
	}
	
	
	
	@Override
    public List<Amortissement> ammortissement(Immo b) {
        
            List<Amortissement> valiny = new ArrayList<>();
            valiny = new Amortissement().getTableauAmortissement(b);
            return valiny;
       }
	@Override
	public Optional<Immo> findById(Long id)
	{
		return immoRepository.findById(id);
	}

}
