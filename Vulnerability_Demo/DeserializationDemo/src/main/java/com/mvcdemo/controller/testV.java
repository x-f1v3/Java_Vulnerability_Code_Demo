package com.mvcdemo.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;
import java.util.Base64;


public class testV implements Serializable {

    private static final long serialVersionUID = 1L;

    public String Classname = null;
    public String Methodname1 = null;
    public String Methodname2 = null;
    public String Input = null;
//    public String Classname = "java.lang.Runtime";
//    public String Methodname1 = "getRuntime";
//    public String Methodname2 = "exec";
//    public String Input = "open /Applications/Calculator.app";
    public int IsClass = 0;

//    public testV(String Classname,String Methodname1,String Methodname2, String Input,int IsClass) {
//        try {
//            if (IsClass == 1){
//                Class cname = Class.forName(Classname);
//                Object o = cname.getMethod(Methodname2, String.class).invoke(cname.getMethod(Methodname1).invoke(null), Input);
//
//            }
//
//
//        } catch (Exception var48) {
//            var48.printStackTrace();
//
//        }
//    }

    //重写readObject()方法
    private void readObject(java.io.ObjectInputStream in) {
        //执行默认的readObject()方法
        try {
            in.defaultReadObject();
            Class cname = Class.forName(Classname);
            Object o = cname.getMethod(Methodname2, String.class).invoke(cname.getMethod(Methodname1).invoke(null), Input);
        } catch (Exception var48) {
            var48.printStackTrace();

        }
    }
    protected void finalize() throws java.lang.Throwable {
        if (IsClass == 0){
            Class cname = Class.forName(Classname);
            Object o = cname.getMethod(Methodname2, String.class).invoke(cname.getMethod(Methodname1).invoke(null), Input);

        }

    }


//    public static void main(String[] args) {
//        testV t = new testV();
//    }

}



