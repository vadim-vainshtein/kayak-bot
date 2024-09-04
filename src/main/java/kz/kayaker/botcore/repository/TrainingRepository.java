package kz.kayaker.botcore.repository;

import kz.kayaker.botcore.entity.Training;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainingRepository extends JpaRepository<Training, Long> {

}
