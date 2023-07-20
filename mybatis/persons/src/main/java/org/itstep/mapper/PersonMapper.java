package org.itstep.mapper;

import org.apache.ibatis.annotations.*;
import org.itstep.model.Person;

import java.util.Map;

public interface PersonMapper {

    @Select("select personId, name from person where personId=#{personId}")
    Person getPerson(Integer personId);

    @Insert("Insert into person(name) values (#{name})")
    public Integer save(Person person);

    @Update("Update Person set name= #{name} where personId=#{personId}")
    public void updatePerson(Person person);

    @Delete("Delete from Person where personId=#{personId}")
    public void deletePersonById(Integer personId);

    @Select("select * from Person ")
    @MapKey("personId")
    Map<Integer, Person> getAllPerson();
}
