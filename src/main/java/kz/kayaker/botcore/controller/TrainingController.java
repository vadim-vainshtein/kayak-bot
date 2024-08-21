package kz.kayaker.botcore.controller;


import kz.kayaker.botcore.dto.TrainingDTO;
import kz.kayaker.botcore.entity.Training;
import kz.kayaker.botcore.entity.security.Role;
import kz.kayaker.botcore.entity.security.User;
import kz.kayaker.botcore.service.authentication.TrainingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@AllArgsConstructor
public class TrainingController {
    private final TrainingService trainingService;

    @PostMapping
    public ResponseEntity<Training> create(@RequestBody TrainingDTO dto, User user){
        if(user.getRole().equals(Role.ADMIN)) {
            return new ResponseEntity<>(trainingService.create(dto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping
    public ResponseEntity<List<Training>> readAll(){
        return new ResponseEntity<>(trainingService.readAll(), HttpStatus.OK);
    }

//    @PutMapping
//    public ResponseEntity<Training> update(@RequestBody Training training){
//        return new ResponseEntity<>(trainingService.update(training), HttpStatus.OK);
//    }

//    @DeleteMapping("/{id}")
//    public HttpStatus delete(@PathVariable Long id){
//        trainingService.delete(id);
//        return HttpStatus.OK;
//    }

}
