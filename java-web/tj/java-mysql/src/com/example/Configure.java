package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Configure {
    public static Conf read() throws URISyntaxException, IOException {
       List<String> s = Files.readAllLines(
               FileSystems.getDefault().getPath("D:\\aaa\\java-mysql\\res",
                       "mysql.conf"));
       Conf f = new Conf();
       for (String s1 : s) {
           //s1：port=3306
            String k = s1.split("=")[0];  //k:port
            String v = s1.split("=")[1];  //v:3306
            if (k.equals("host")){
                f.host = v; //f.host="localhost
            } else if (k.equals("port")){
                f.port = Integer.parseInt(v); // f.port = 3306
            } else if (k.equals("db_name")){
                f.db_name = v;
            } else if (k.equals("db_type")){
                f.db_type = v;
            } else if(k.equals("username")){
                f.username = v;
            }
        }
       return f;
    }

}
