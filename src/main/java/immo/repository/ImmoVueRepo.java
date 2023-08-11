package immo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import immo.entity.ImmoVue;


@Repository
public interface ImmoVueRepo extends JpaRepository <ImmoVue, Long>{
     
	
}
