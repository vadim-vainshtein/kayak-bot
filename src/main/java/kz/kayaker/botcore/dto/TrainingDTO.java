package kz.kayaker.botcore.dto;


import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class TrainingDTO {

    private DayOfWeek trainingDay;
    private LocalTime trainingTime;
}
