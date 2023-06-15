package org.itstep.one_to_one_uni;

import org.itstep.one_to_one_bi.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
