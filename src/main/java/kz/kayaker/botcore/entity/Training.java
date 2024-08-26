package kz.kayaker.botcore.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "training")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Training {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private DayOfWeek trainingDay;

    @Column(nullable = false)
    private LocalTime trainingTime;

    public Training(int dayOfWeek, int hour, int minute) {
        trainingDay = DayOfWeek.of(dayOfWeek);
        trainingTime = LocalTime.of(hour, minute);
    }



}
