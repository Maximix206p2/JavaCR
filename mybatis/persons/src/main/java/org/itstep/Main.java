package org.itstep;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.itstep.mapper.AddressMapper;
import org.itstep.mapper.PersonMapper;
import org.itstep.model.Address;
import org.itstep.model.Person;
import org.itstep.utils.MyBatisUtil;

import java.util.Map;

public class Main { //application.properties нельзя юзать
    public static void main(String[] args) { //File -> New -> Module
        //MyBatisUtil myBatisUtil = new MyBatisUtil();
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.buildSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.getConnection();

        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        Integer count = personMapper.save(new Person("name"));
        System.out.println(count);

        Person person = personMapper.getPerson(7);
        System.out.println(person);

        person.setName("new name");
        personMapper.updatePerson(person);

        person = personMapper.getPerson(7);
        System.out.println(person);

        Map<Integer, Person> persons = personMapper.getAllPerson();
        persons.forEach((id,pers)-> System.out.println(pers));

        addressMapper.saveAddress(new Address("street", 7));

        Address address = addressMapper.getAddresses(1);
        System.out.println(address);
        sqlSession.commit();
        sqlSession.close();
    }
}
