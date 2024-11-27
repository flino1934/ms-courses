package com.lino.hruser.repositories;

import com.lino.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface USerRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
