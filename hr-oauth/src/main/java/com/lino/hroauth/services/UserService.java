package com.lino.hroauth.services;

import com.lino.hroauth.entities.User;
import com.lino.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {

        User user = userFeignClient.findByEmail(email).getBody();

        if (user == null) {
            logger.error("EMAIL NOT FOUND: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("EMAIL FOUND: " + email);
        return user;

    }

}
