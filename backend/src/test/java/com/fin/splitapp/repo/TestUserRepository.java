package com.fin.splitapp.repo;

import com.fin.splitapp.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TestUserRepository {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUserName("Ravi");
        user.setPassword("Ramu");
        user.setMobile("9123456789");

        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getUserId()).isGreaterThan(0);
    }

    @Test
    public void testFindByUserName() {
        User user = new User();
        user.setUserName("Ravi");
        user.setPassword("Ramu");
        user.setMobile("9123456789");

        userRepository.save(user);

        User foundUser = userRepository.findByUserName("Ravi");

        Assertions.assertThat(foundUser).isNotNull();
        Assertions.assertThat(foundUser.getUserId()).isGreaterThan(0);
    }
}
