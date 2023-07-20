package org.itstep.state;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private final JdbcTemplate jdbcTemplate;

    public StateService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<State> findAll() {
        var sql = "SELECT * FROM states";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(State.class));
    }

    //Получить штаты и название страны
    public List<StateCountry> findAllJoinCountries() {
        var sql = "select s.id, s.name, c.name as countryName from states s " +
                "left join countries c on c.id=s.country_id order by s.id";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StateCountry.class));
    }

    //Получить все штаты одной страны
    public List<StateCountry> findStatesOfCountry(String countryName) {
        var sql = "select s.id, s.name, c.name as countryName from states s " +
                "left join countries c on c.id=s.country_id where c.name=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StateCountry.class),countryName); //Здесь список аргументов для подстановки

    }

    public List<State> search(String name) {
        var sql = "SELECT * FROM states where name like "+"'"+name+"%'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(State.class));
    }
}