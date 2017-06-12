package com.innovae.service.imp;

import com.innovae.repository.ProjectRepository;
import com.innovae.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by manson on 2017/6/12.
 */
@Service
public class ProjectServiceImp implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public String uploadFile(int projectId,MultipartFile file)
    {
       if (file.isEmpty())
           return "文件为空";
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        String filePath = "F:/File/";
        File dest = new File(filePath+fileName);
        if (!dest.getParentFile().exists())
        {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        }
        catch (IllegalStateException|IOException e)
        {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @Override
    public  String sendMails(String senderId,List<String> emails)
    {
        String result = "";
        return result;
    }
}
