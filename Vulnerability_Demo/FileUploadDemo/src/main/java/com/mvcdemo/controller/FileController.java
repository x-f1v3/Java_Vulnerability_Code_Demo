package com.mvcdemo.controller;

import com.sun.javafx.runtime.SystemProperties;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




@Controller
@RequestMapping("/file")
public class FileController {
    //单文件上传处理类
    @RequestMapping("/uploadFile")
    public ModelAndView upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //获取上传文件的原名
        String fileName = file.getOriginalFilename();
        //获取项目存放上传文件的路径
        String filePath = request.getServletContext().getRealPath("/");

        System.out.println("filePath+fileName:"+filePath+fileName);
        InputStream inputStream = file.getInputStream();
        //将文件存放到项目的指定路径
        FileUtils.copyInputStreamToFile(inputStream,new File(filePath+fileName));
        ModelAndView modelAndView = new ModelAndView("success");
        List<String> list = new ArrayList<String>();
        list.add(fileName);
        modelAndView.addObject("fileList",list);
        return modelAndView;
    }



    //跳转到单文件上传页面
    @RequestMapping("/file")
    public String file(){
        return "file";
    }
}
