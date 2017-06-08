package com.innovae.service;

import com.innovae.model.Topic;

/**
 * Created by Polotin on 2017/6/8.
 */
public interface ForumService {
    String getTopicListJson(int type, int curNum, int perPage, int isSortByHot);
    //by manson
    boolean addTopic(Topic topic) throws Exception;
}
