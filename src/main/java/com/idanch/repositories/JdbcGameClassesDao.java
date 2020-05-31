package com.idanch.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository("dao")
public class JdbcGameClassesDao implements GameClassesDao {
    public static Logger log = LoggerFactory.getLogger(JdbcGameClassesDao.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        log.debug("Setting mysql datasource to create JdbcTemplate");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Integer listAllClasses() {
        log.debug("Executing SELECT statement with mysql db");
        Integer rowsCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM classes;", Integer.class);
        log.debug("classes table contains: " + rowsCount + " rows");
        return rowsCount;
    }
}