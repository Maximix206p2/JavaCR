package org.itstep.one_to_one_uni;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    //Custom methods
    List<Address> findByCity(String city);
    List<Address> findByCityAndStreet(String city, String street);
    List<Address> findTop5ByCity(String city);
    List<Address> findByCityStartingWith(String prefix);
    List<Address> findByCityEndingWith(String suffix);
    List<Address> findByCityContaining(String infix);
    List<Address> findByCityLike(String pattern);
    List<Address> findByCityOrStreet(String city, String street);
    List<Address> findByCityOrderByStreetDesc(String city);
}
