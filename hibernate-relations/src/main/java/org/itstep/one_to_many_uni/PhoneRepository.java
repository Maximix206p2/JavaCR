package org.itstep.one_to_many_uni;

import org.itstep.one_to_one_uni.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
