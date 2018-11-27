package de.adesso.swarm;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends PagingAndSortingRepository<User, Long> {

    List<User> findByName(@Param("lastName") String name);

    List<User> findByFirstName(@Param("firstName") String firstName);
}
