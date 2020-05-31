package com.idanch;

import com.idanch.repositories.JdbcGameClassesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.idanch");

        JdbcGameClassesDao dao = (JdbcGameClassesDao) context.getBean("dao");
        dao.listAllClasses();
    }
}