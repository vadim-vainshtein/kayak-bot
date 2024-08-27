package kz.kayaker.botcore.controller;


import kz.kayaker.botcore.dto.UserPaymentDTO;
import kz.kayaker.botcore.entity.UserPayment;
import kz.kayaker.botcore.service.UserPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user_payment")
public class UserPaymentController {
    private final UserPaymentService userPaymentService;

    @PostMapping
    public ResponseEntity<UserPayment> create(
            @RequestBody UserPaymentDTO dto) {

        return new ResponseEntity<>(userPaymentService.create(dto), HttpStatus.OK);


    }

    @GetMapping
    public ResponseEntity<List<UserPayment>> readAll() {
        return new ResponseEntity<>(userPaymentService.readAll(), HttpStatus.OK);
    }
}
