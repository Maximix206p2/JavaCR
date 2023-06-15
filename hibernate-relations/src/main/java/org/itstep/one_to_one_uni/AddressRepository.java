package org.itstep.one_to_one_uni;

import org.itstep.one_to_one_bi.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
