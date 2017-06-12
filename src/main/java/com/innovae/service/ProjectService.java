package com.innovae.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by manson on 2017/6/12.
 */
@Service
public interface ProjectService {

    String uploadFile(int projectId,MultipartFile file) throws Exception;
    String sendMails(String senderId,List<String> emails);
}
