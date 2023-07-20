package org.itstep.city;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService{

    private final JdbcTemplate jdbcTemplate;

    public CityService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<City> findAll() {
        var sql = "SELECT * FROM cities limit 100";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(City.class));
    }

    //Получить все города одного штата
    public List<CityState> findCitiesOfState(Long stateId) {
        var sql = "select c.id, c.name, c.latitude, c.longitude, " +
        "s.name as stateName from cities c " +
        "left join states s on s.id=c.state_id where c.state_id=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CityState.class),stateId); //Здесь список аргументов для подстановки
    }

    public List<CityState> findCitiesOfState2(String stateName) {
        var sql = "select c.id, c.name, c.latitude, c.longitude, " +
                "s.name as stateName from cities c " +
                "left join states s on s.id=c.state_id where c.state_id=?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CityState.class), stateName); //Здесь список аргументов для подстановки
    }

    public List<City> search(String name) {
        var sql = "SELECT * FROM cities where name like "+"'"+name+"%'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(City.class));
    }
}
