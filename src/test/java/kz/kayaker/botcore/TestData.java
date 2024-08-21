package kz.kayaker.botcore;

import kz.kayaker.botcore.entity.Training;
import kz.kayaker.botcore.entity.Training.TrainingBuilder;
import kz.kayaker.botcore.entity.security.Role;
import kz.kayaker.botcore.entity.security.User;
import kz.kayaker.botcore.entity.security.User.UserBuilder;

import java.time.DayOfWeek;
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
}
