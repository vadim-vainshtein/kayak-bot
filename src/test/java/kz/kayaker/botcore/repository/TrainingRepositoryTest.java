package kz.kayaker.botcore.repository;

import kz.kayaker.botcore.TestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class TrainingRepositoryTest extends AbstractRepositoryTest {
    @Autowired
    TrainingRepository trainingRepository;

    @Test
    void saveAndLoad() {
        var training = TestData.training()
                               .build();
        trainingRepository.save(training);
        var trainingList = trainingRepository.findAll();

        assertThat(trainingList).isNotEmpty();

        var loaded = trainingList.get(0);
        assertThat(loaded.getId()).isNotZero();
        assertThat(loaded.getTrainingTime()).isEqualTo(training.getTrainingTime());
        assertThat(loaded.getTrainingDay()).isEqualTo(training.getTrainingDay());
    }


}
