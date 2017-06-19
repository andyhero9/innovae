package com.innovae.controller;

import com.innovae.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by manson on 2017/6/12.
 */
@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("projectId") int projectId) throws Exception
    {

       return projectService.uploadFile(projectId,file);
    }

    @ResponseBody
    @RequestMapping(value = "/sendMails",method = RequestMethod.POST)
    public String sendMails(@RequestParam("projectType") int project_type,@RequestParam("subject") String subject,@RequestParam("content") String content,HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        String senderId = request.getSession().getAttribute("id").toString();
        return projectService.sendMails(senderId,project_type,subject,content);
    }
}
