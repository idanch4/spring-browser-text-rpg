package com.idanch.repositories;

import com.idanch.repositories.interfaces.InitialAttributesDao;
import com.idanch.representations.InitialAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository("attr_dao")
public class JdbcInitialAttributesDao implements InitialAttributesDao {
    public static Logger log = LoggerFactory.getLogger(JdbcInitialAttributesDao.class);

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<InitialAttributes> initialAttributesRowMapper =
            (resultSet, rowCount) -> {
        //TODO:: Get column names from a constants class
                String heroClassName = resultSet.getString("className");
                int charisma = resultSet.getInt("charisma");
                int integrity = resultSet.getInt("integrity");
                int confidence = resultSet.getInt("confidence");
                int luck = resultSet.getInt("luck");

                return new InitialAttributes(
                        heroClassName,
                        charisma,
                        integrity,
                        confidence,
                        luck);
            };

    @Autowired
    public JdbcInitialAttributesDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public InitialAttributes getInitialAttributes(String heroClassName) {
        return jdbcTemplate.queryForObject("SELECT charisma,integrity,confidence,luck" +
                " FROM initial_attributes WHERE className=?;", initialAttributesRowMapper, heroClassName);
    }

    @Override
    public List<InitialAttributes> getAllInitialAttributes() {
        //TODO: return a dictionary
        return Collections.unmodifiableList(jdbcTemplate.query("SELECT className,charisma,integrity,confidence,luck" +
                " FROM initial_attributes;", initialAttributesRowMapper));
    }
}
