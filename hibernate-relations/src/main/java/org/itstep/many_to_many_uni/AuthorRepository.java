package org.itstep.many_to_many_uni;

import org.itstep.one_to_many_uni.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
