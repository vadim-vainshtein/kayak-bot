package kz.kayaker.botcore.repository;

import kz.kayaker.botcore.TestData;
import kz.kayaker.botcore.entity.security.UserToken;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class UserTokenRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private UserTokenRepository userTokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveAndLoad() {

        var user = TestData.user()
                           .build();
        var token = "sample token";
        var userToken = new UserToken(user, token);

        userRepository.save(user);
        userTokenRepository.save(userToken);

        var loadedToken = userTokenRepository.findUserTokenByToken(token);
        assertThat(loadedToken).isNotEmpty();

        var loadedUser = loadedToken.get()
                                    .getUser();
        assertThat(loadedUser.getUsername()).isEqualTo(user.getUsername());
    }

}