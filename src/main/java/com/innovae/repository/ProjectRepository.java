package com.innovae.repository;

import com.innovae.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by manson on 2017/6/12.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
    @Query(value = "select * from Project where type = ?1")
    List<Project> findByTpye(int type);


}
