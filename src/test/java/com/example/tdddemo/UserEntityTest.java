package com.example.tdddemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTest {

    @Test
    public void userEntityTest() {
        User user = new User(1L, "shaahin2010", "shaahin2010@gmail.com");
        Assert.assertNotNull(user);
        Assert.assertTrue(1L == user.getId());
    }
}
