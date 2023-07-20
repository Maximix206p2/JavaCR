package org.itstep.mapper;

import org.apache.ibatis.annotations.*;
import org.itstep.model.Address;
import org.itstep.model.Person;

public interface AddressMapper {

    @Insert("Insert into address (streetAddress,personId) values(#{streetAddress},#{personId})")
    @Options(useGeneratedKeys = true)
    public Integer saveAddress(Address address);

    @Select("SELECT addressId, streetAddress FROM Address WHERE addressId = #{addressId}")
    @Results(value = { @Result(property = "addressId", column = "addressId"),
            @Result(property = "streetAddress", column = "streetAddress"),
            @Result(property = "person", column = "personId", javaType = Person.class, one = @One(select = "getPerson")) })
    Address getAddresses(Integer addressId);

    @Select("SELECT personId FROM address WHERE addressId = #{addressId})")
    Person getPerson(Integer addressId);
}

