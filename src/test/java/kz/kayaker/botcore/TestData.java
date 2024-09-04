package kz.kayaker.botcore;

import kz.kayaker.botcore.entity.Training;
import kz.kayaker.botcore.entity.Training.TrainingBuilder;
import kz.kayaker.botcore.entity.UserPayment;
import kz.kayaker.botcore.entity.UserPayment.UserPaymentBuilder;
import kz.kayaker.botcore.entity.security.Role;
import kz.kayaker.botcore.entity.security.User;
import kz.kayaker.botcore.entity.security.User.UserBuilder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestData {

    public static UserBuilder user() {
        return User.builder()
                   .username("user")
                   .password("password")
                   .role(Role.USER);
    }

    public static TrainingBuilder training() {
        return Training.builder()
                       .trainingTime(LocalTime.of(12, 13))
                       .trainingDay(DayOfWeek.FRIDAY);
    }

    public static UserPaymentBuilder userPayment() {
        return UserPayment.builder()
                          .userId(1L)
                          .startDate(LocalDate.of(2024, 10, 11))
                          .endDate(LocalDate.of(2024, 10, 12))
                          .amount(3)
                          .price(1000)
                          .paid(true);
    }
}
