package kz.kayaker.botcore.repository;

import kz.kayaker.botcore.TestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class UserPaymentRepositoryTest extends AbstractRepositoryTest {
    @Autowired
    UserPaymentRepository userPaymentRepository;

    @Test
    void saveAndLoad() {
        var userPayment = TestData.userPayment()
                                  .build();
        userPaymentRepository.save(userPayment);
        var userPaymentList = userPaymentRepository.findAll();

        assertThat(userPaymentList).isNotEmpty();

        var loaded = userPaymentList.get(0);
        assertThat(loaded.getId()).isNotZero();
        assertThat(loaded.getStartDate()).isEqualTo(userPayment.getStartDate());
        assertThat(loaded.getEndDate()).isEqualTo(userPayment.getEndDate());
        assertThat(loaded.getAmount()).isEqualTo(userPayment.getAmount());
        assertThat(loaded.getPrice()).isEqualTo(userPayment.getPrice());
        assertThat(loaded.getPaid()).isEqualTo(userPayment.getPaid());
    }
}
