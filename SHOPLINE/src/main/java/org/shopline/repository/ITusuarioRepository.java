package org.shopline.repository;

import org.shopline.model.Tusuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITusuarioRepository extends JpaRepository<Tusuario, Integer>{

}
