package com.example.tdddemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @MockBean
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        Mockito.when(userRepository.count()).thenReturn(2L);
        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(new User(1L, "a", "a")));
    }

    @Test
    public void persist() {
        User user = new User(null, "shaahin2010", "shaahin2010@gmail.com");
        userRepository.save(user);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void countAll() {
        long count = userRepository.count();
        Assert.assertEquals(2, count);
    }

    @Test
    public void findAll() {
        List<User> users = userRepository.findAll();
        assertThat(users, hasSize(1));
        assertThat(users, hasItem(new User(1L, "a", "a")));
    }
}

