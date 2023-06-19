package org.itstep.many_to_many_uni;

import org.itstep.one_to_many_uni.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
