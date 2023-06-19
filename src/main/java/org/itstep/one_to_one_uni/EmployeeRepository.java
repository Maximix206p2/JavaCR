package org.itstep.one_to_one_uni;

import org.itstep.one_to_one_bi.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Custom methods
    List<Employee> findByAgeLessThan(Integer age);
    List<Employee> findByAgeLessThanEqual(Integer age);
    List<Employee> findByAgeBetween(Integer ageMin, Integer ageMax);
    List<Employee> findByAgeIn(Collection<Integer> ages);

    //Named queries
    List<Employee> findByCity(String city);
    List<Employee> findGreaterThanAgeInCity(String city, Integer age);

    //Custom queries
    //JPQL - язык запросов с селектами и т.д.
    @Query("select e from Employee e inner join Address a on e.address.id=a.id where a.city=:city")
    List<Employee> findByCity2(@Param("city") String city);

    @Query(value = "select * from employee e inner join address a on e.address_id=a.id where a.city=:city", nativeQuery = true)
    List<Employee> findByCity3(@Param("city") String city);
}
