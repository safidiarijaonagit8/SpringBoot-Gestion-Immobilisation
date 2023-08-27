package immo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import immo.entity.Immo;


@Repository
public interface ImmoRepository extends JpaRepository<Immo, Long>{
	

}
