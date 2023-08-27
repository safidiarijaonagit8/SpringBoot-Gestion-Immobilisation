package immo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import immo.entity.ImmoVue;

@Repository
public interface ImmoVueRepository extends JpaRepository<ImmoVue, Long>{
	
	Page<ImmoVue> findAll(Pageable pageable);

}
