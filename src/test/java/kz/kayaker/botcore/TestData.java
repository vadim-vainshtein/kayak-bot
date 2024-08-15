package kz.kayaker.botcore;

import kz.kayaker.botcore.entity.security.Role;
import kz.kayaker.botcore.entity.security.User;
import kz.kayaker.botcore.entity.security.User.UserBuilder;

public class TestData {

    public static UserBuilder user() {
        return User.builder()
                   .username("user")
                   .password("password")
                   .role(Role.USER);
    }
}
