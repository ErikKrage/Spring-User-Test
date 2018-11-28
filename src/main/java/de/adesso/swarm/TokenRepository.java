package de.adesso.swarm;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TokenRepository extends PagingAndSortingRepository<Token, Long> {
}
