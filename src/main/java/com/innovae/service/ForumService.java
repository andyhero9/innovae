package com.innovae.service;

/**
 * Created by Polotin on 2017/6/8.
 */
public interface ForumService {
    String getTopicListJson(int type, int curNum, int perPage, int isSortByHot);
}
