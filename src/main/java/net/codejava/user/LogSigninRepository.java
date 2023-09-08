package net.codejava.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogSigninRepository extends CrudRepository<LogSignIn, Long> {
}
