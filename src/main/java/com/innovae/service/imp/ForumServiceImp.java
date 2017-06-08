package com.innovae.service.imp;

import com.google.gson.Gson;
import com.innovae.model.Topic;
import com.innovae.repository.ForumRepository;
import com.innovae.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Polotin on 2017/6/8.
 */
@Service
public class ForumServiceImp implements ForumService{
    @Autowired
    private ForumRepository forumRepository;

    @Override
    public String getTopicListJson(int type, int curNum, int perPage, int isSortByHot){
        List<Topic> topics;
        if(isSortByHot == 0){
            topics = forumRepository.getTopicList(type, curNum, perPage);
        }else {
            topics = forumRepository.getTopicListByHot(type, curNum, perPage);
        }

        String result="";
        if(topics.size() != 0) {
            result = new Gson().toJson(topics);
        }
        return result;
    }
    @Override
    public boolean addTopic(Topic topic)
    {
        try {
            forumRepository.save(topic);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return (forumRepository.findById(topic.getId())!=null);
    }


}
