package de.adesso.swarm;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

    List<User> findByName(@Param("name") String name);

    List<User> findByDomain(@Param("domain") String domain);
}
