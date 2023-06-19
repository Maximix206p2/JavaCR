package org.itstep.one_to_many_uni;

import org.itstep.one_to_one_uni.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
