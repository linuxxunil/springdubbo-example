package vip.bestsvip.user;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vip.bestsvip.api.service.UserService;


@SpringBootTest()
public class UserApplicationTest {
    
    @Autowired
    private UserService userService;
    
    @Test
    void testUserService() {
        System.out.println(userService.helloDubbo());
    }

}
