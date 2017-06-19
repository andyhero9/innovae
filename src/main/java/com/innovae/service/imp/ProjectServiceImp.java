package com.innovae.service.imp;

import com.innovae.model.Administrator;
import com.innovae.model.Group;
import com.innovae.model.Project;
import com.innovae.repository.AccountRepository;
import com.innovae.repository.AdministratorRepository;
import com.innovae.repository.GroupRepository;
import com.innovae.repository.ProjectRepository;
import com.innovae.service.ProjectService;
import com.sun.istack.internal.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
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
    private AdministratorRepository administratorRepository;

    @Override
    public String uploadFile(int projectId,MultipartFile file)
    {
        String a = "\"result\":";
        String result = "false";

       if (file.isEmpty())
           result="false";
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
        }
        catch (IllegalStateException|IOException e)
        {
            e.printStackTrace();
        }
        //save filePath to database
        filePath = filePath+fileName;
        Project temp = projectRepository.findOne(projectId);
        int type = temp.getType();
        switch (type)
        {
            case 1:
                temp.setPath1(filePath);
                break;
            case 2:
                temp.setPath2(filePath);
                break;
            case 3:
                temp.setPath3(filePath);
                break;
        }
        if (dest.exists())
            result ="true";
        return "{"+a+result+"}";
    }

    @Autowired
    JavaMailSender mailSender;
    private GroupRepository groupRepository;
    private AccountRepository accountRepository;
    @Override
    @Nullable
    public  String sendMails(String senderId,int project_type,String subject,String content)
    {
        Administrator temp = administratorRepository.findOne(senderId);
        List<String> emails = null;
        List<Project> projects = projectRepository.findByTpye(project_type);
        List<Integer> projectIds = null;
        List<Group> groups = null;
        String result = "false";
        try {

            for (Project p:projects)
            {
                projectIds.add(p.getId());
            }

            for (Integer i:projectIds)
            {
                groups.add(groupRepository.findOne(i));
            }

            for (Group g:groups)
            {
                emails.add(accountRepository.findOne(g.getLeader()).getEmail());
            }
        }
       catch (NullPointerException e)
       {
           e.printStackTrace();
       }
       try {
           final MimeMessage mimeMessage = mailSender.createMimeMessage();
           final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
           message.setFrom(temp.getEmail());
           message.setTo((String[])emails.toArray());
           message.setSubject(subject);
           message.setText(content);
           mailSender.send(mimeMessage);
           result = "true";
       }
       catch (Exception e)
       {
            e.printStackTrace();
       }
        String a = "\"result\":";

        return "{"+a+result+"}";
    }
}
