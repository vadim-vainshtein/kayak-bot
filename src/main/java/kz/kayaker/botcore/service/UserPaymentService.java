package kz.kayaker.botcore.service;

import kz.kayaker.botcore.dto.UserPaymentDTO;
import kz.kayaker.botcore.entity.UserPayment;
import kz.kayaker.botcore.repository.UserPaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserPaymentService {
    private final UserPaymentRepository userPaymentRepository;

    public UserPayment create(UserPaymentDTO dto) {
        UserPayment userPayment = UserPayment.builder()
                                             .userId(dto.getUserId())
                                             .startDate(dto.getStartDate())
                                             .endDate(dto.getEndDate())
                                             .amount(dto.getAmount())
                                             .price(dto.getPrice())
                                             .paid(dto.getPaid())
                                             .build();
        return userPaymentRepository.save(userPayment);
    }

    public List<UserPayment> readAll() {
        return userPaymentRepository.findAll();
    }
}
