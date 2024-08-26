package kz.kayaker.botcore.repository;

import kz.kayaker.botcore.entity.Training;
import kz.kayaker.botcore.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainingRepository extends JpaRepository<Training, Long> {

}
