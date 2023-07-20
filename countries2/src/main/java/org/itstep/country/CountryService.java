package org.itstep.country;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final JdbcTemplate jdbcTemplate;

    public CountryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Country> findAll(){
        var sql = "select * from countries";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Country.class));
    }

    public List<Country> search(String name) {
        var sql = "SELECT * FROM countries where name like "+"'"+name+"%'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Country.class));
    }
}