package com.innovae.repository;

import com.innovae.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by manson on 2017/6/12.
 */
@Repository
public interface GroupRepository extends JpaRepository<Group,Integer>{

    @Query(value = "select p from Group p where p.projectId = ?1")
    List<Group> findByProjectId(int projectId );

}
