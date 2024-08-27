package kz.kayaker.botcore.dto;

import jakarta.persistence.Column;
import kz.kayaker.botcore.entity.security.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserPaymentDTO {
    private User user;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer amount;
    private Integer price;
    private Boolean paid;
}
