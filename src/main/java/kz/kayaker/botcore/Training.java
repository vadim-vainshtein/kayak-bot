package kz.vainshtein.kayakbotcore;

import jakarta.persistence.Entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Training {
    private DayOfWeek trainingDay;
    private LocalTime trainingTime;

    public Training(int dayOfWeek, int hour, int minute){
    this.trainingDay = DayOfWeek.of(dayOfWeek);
    this.trainingTime = LocalTime.of(hour, minute);
}

    public DayOfWeek getTrainingDay(){
        return trainingDay;
    }
    public LocalTime getTrainingTime(){
        return trainingTime;
    }
    public void setTrainingDay(int dayOfWeek){
        trainingDay = DayOfWeek.of(dayOfWeek);
    }
    public void setTrainingTime(int hour, int minute){
        trainingTime = LocalTime.of(hour, minute);
    }

}
