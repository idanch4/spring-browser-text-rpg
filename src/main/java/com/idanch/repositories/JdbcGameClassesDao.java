package com.idanch.repositories;

import com.idanch.repositories.interfaces.GameClassesDao;
import com.idanch.representations.HeroClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository("hero_dao")
public class JdbcGameClassesDao implements GameClassesDao {
    public static Logger log = LoggerFactory.getLogger(JdbcGameClassesDao.class);

    private JdbcTemplate jdbcTemplate;
    private RowMapper<HeroClass> heroClassRowMapper = (resultSet, rowCount) -> {
        //TODO:: Get column names from a constants class
        String name = resultSet.getString("Name");
        String description = resultSet.getString("Description");
        return new HeroClass(name, description);
    };


    @Autowired
    public void setDataSource(DataSource dataSource) {
        log.debug("Setting mysql datasource to create JdbcTemplate");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public HeroClass getHeroClass(String name) {
        log.debug("Executing SELECT statement. Retrieving hero class " + name);
        return jdbcTemplate.queryForObject(
                        "SELECT Name,Description FROM classes WHERE Name=?;",
                        heroClassRowMapper,
                        name);
    }

    @Override
    public List<HeroClass> getAllHeroClasses() {
        //TODO:: return a dictionary
        log.debug("Executing SELECT statement. Retrieving all hero classes");
        return Collections.unmodifiableList(jdbcTemplate.query(
                "SELECT Name,Description FROM classes;",
                heroClassRowMapper));
    }
}