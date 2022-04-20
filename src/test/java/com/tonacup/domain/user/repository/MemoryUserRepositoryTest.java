package com.tonacup.domain.user.repository;

import com.tonacup.domain.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryUserRepositoryTest {

    MemoryUserRepository repository = new MemoryUserRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        User user = new User();

        user.setId(1L);
        user.setUsername("userA");
        user.setEmail("abc@abc.com");

        repository.save(user);
        //when
        User findUser = repository.findById(user.getId()).get();

        //then
        assertThat(findUser).isEqualTo(user);
    }

    @Test
    public void findById() {
        //given
        User user = new User();
        User user2 = new User();

        user.setId(1L);
        user.setUsername("userA");
        user.setEmail("abc@abc.com");

        user2.setId(2L);
        user2.setUsername("userB");
        user2.setEmail("bbb@bbb.com");

        repository.save(user);
        repository.save(user2);
        //when
        User findUser = repository.findById(user.getId()).get();
        User findUser2 = repository.findById(user2.getId()).get();

        //then
        assertThat(findUser.getId()).isEqualTo(user.getId());
        assertThat(findUser.getUsername()).isEqualTo(user.getUsername());
        assertThat(findUser.getEmail()).isEqualTo(user.getEmail());

        assertThat(findUser2.getId()).isEqualTo(user2.getId());
        assertThat(findUser2.getUsername()).isEqualTo(user2.getUsername());
        assertThat(findUser2.getEmail()).isEqualTo(user2.getEmail());
    }

    @Test
    public void findByAll() {
        //given
        User user = new User();
        User user2 = new User();

        user.setId(1L);
        user.setUsername("userA");
        user.setEmail("abc@abc.com");

        user2.setId(2L);
        user2.setUsername("userB");
        user2.setEmail("bbb@bbb.com");

        //when
        repository.save(user);
        repository.save(user2);

        List<User> result = repository.findByAll();

        //then
        assertThat(result.size()).isEqualTo(2);
    }
}