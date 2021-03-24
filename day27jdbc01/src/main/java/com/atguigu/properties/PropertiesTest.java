package com.atguigu.properties;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
    @Test
    public void test01() throws IOException {
        // get system properties
//        Properties properties = System.getProperties();
//        properties.list(System.out);
//        properties.getProperty("file.encoding");

        Properties properties = new Properties();
        properties.setProperty("mysqluser","root");
        properties.setProperty("mysqlpassword","root");
        System.out.println(properties);
        properties.store(new FileOutputStream(new File("/Users/a123/IdeaProjects/javaweb/day27jdbc01/src/main/java/com/atguigu/test.properties")), "test");
    }

    @Test
    public void test02() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("/Users/a123/IdeaProjects/javaweb/day27jdbc01/src/main/java/com/atguigu/test.properties")));
        System.out.println(properties);
    }
}
