package com.mvcdemo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.Base64;



@Controller
@RequestMapping("/")
public class DeserializationController {

    @RequestMapping("/Deserialization")
    public void Deserialization(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String command = request.getParameter("command");
        PrintWriter out = response.getWriter();
        StringBuffer buffer = new StringBuffer();


        if (command != null && !command.equals("")) {


            byte[] asBytes = Base64.getDecoder().decode(command);
            ByteArrayInputStream bis = new ByteArrayInputStream(asBytes);


            ObjectInputStream ois= null;
            try{
                ois=new ObjectInputStream(bis);
                testV tableOrder = (testV)ois.readObject();
                ois.close();

            }catch(Exception var48){
                System.out.println(var48);

            }

            out.println(buffer.toString());

        }



    }



}
