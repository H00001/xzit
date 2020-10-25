package com.example.sql.conf;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Conf {
    private String driver;
    private String protocol;
    private String dbtype;
    private String addr;
    private String port;
    private String dbname;
    private String username;
    private String password;

    private Conf() {
    }

    public String getDriver() {
        return driver;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getDbtype() {
        return dbtype;
    }

    public String getAddr() {
        return addr;
    }

    public String getPort() {
        return port;
    }

    public String getDbname() {
        return dbname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static Conf init() throws NoSuchFieldException, IOException, IllegalAccessException {
        File f=
new File("d:\\aaa\\untitled\\conf\\" +
              "application.properties");
        // 1.读取文件
        List<String> ls= Files.readAllLines(f.toPath());
        Conf conf = new Conf();
        for (String v: ls){
            //v:protocol=jdbc
            String[] sp = v.split("=");
            // 通过字符串获取字段
            Field fi = Conf.class.getDeclaredField(sp[0]);
            fi.setAccessible(true);
            // 设置conf这个对象字段的值是sp[1]
            fi.set(conf,sp[1]);
        }
        // 2.将文件中的参数转换成
        // Conf 对象
        return conf;
    }

    @Override
    public String toString() {
        // jdbc字符串
        return protocol+":"+dbtype+"://"+addr+":"+port+"/"+dbname;
    }
}
