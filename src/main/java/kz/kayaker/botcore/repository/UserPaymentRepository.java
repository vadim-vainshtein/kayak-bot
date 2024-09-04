package kz.kayaker.botcore.repository;

import kz.kayaker.botcore.entity.UserPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {
}
