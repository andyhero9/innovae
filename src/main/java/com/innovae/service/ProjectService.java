package com.innovae.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by manson on 2017/6/12.
 */
@Service
public interface ProjectService {

    String uploadFile(int projectId,MultipartFile file) throws Exception;
    String sendMails(String senderId,int project_type,String subject,String content) throws Exception;
}
