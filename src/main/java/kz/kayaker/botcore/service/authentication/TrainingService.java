package kz.kayaker.botcore.service.authentication;


import kz.kayaker.botcore.dto.TrainingDTO;
import kz.kayaker.botcore.entity.Training;
import kz.kayaker.botcore.repository.TrainingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public Training create(TrainingDTO dto) {
        Training training = Training.builder()
                                    .trainingTime(dto.getTrainingTime())
                                    .trainingDay(dto.getTrainingDay())
                                    .build();
        return trainingRepository.save(training);
    }

    public List<Training> readAll(){
        return trainingRepository.findAll();
    }

    public Training update(Training training){
        return trainingRepository.save(training);
    }
    public void delete(Long id){
        trainingRepository.deleteById(id);
    }

}
