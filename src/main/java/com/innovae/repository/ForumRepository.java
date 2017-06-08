package com.innovae.repository;

import com.innovae.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Polotin on 2017/6/8.
 */
@Repository
public interface ForumRepository extends JpaRepository<Topic,Integer> {
    @Query(value = "select * from Topic where type=?1 order by time desc limit ?2,?3", nativeQuery=true)
    List<Topic> getTopicList(int type, int curNum, int perPage);

    @Query(value = "select * from Topic where type=?1 order by coments_count desc limit ?2,?3", nativeQuery=true)
    List<Topic> getTopicListByHot(int type, int curNum, int perPage);

}
