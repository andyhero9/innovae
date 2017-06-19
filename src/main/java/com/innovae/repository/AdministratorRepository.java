package com.innovae.repository;

import com.innovae.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by manson on 2017/6/18.
 */
@Repository
public interface AdministratorRepository extends JpaRepository<Administrator,String>{
}
