package kz.kayaker.botcore.controller;


import kz.kayaker.botcore.dto.TrainingDTO;
import kz.kayaker.botcore.entity.Training;
import kz.kayaker.botcore.service.TrainingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/training")
public class TrainingController {
    private final TrainingService trainingService;

    @PostMapping
    public ResponseEntity<Training> create(
            @RequestBody TrainingDTO dto) {

        return new ResponseEntity<>(trainingService.create(dto), HttpStatus.OK);


    }

    @GetMapping
    public ResponseEntity<List<Training>> readAll() {
        return new ResponseEntity<>(trainingService.readAll(), HttpStatus.OK);
    }


}
