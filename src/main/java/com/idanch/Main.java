package com.idanch;

import com.idanch.repositories.JdbcGameClassesDao;
import com.idanch.repositories.JdbcInitialAttributesDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.idanch");

        JdbcGameClassesDao hero_dao = (JdbcGameClassesDao) context.getBean("hero_dao");
        log.info("Charmer: " + hero_dao.getHeroClass("Charmer"));
        log.info(hero_dao.getAllHeroClasses().toString());

        JdbcInitialAttributesDao attr_dao = (JdbcInitialAttributesDao) context.getBean("attr_dao");
        log.info("Charmer stats: " + attr_dao.getInitialAttributes("Charmer"));
        log.info(attr_dao.getAllInitialAttributes().toString());
    }
}