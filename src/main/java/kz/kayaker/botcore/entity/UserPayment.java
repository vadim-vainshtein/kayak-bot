package kz.kayaker.botcore.entity;

import jakarta.persistence.*;
import kz.kayaker.botcore.entity.security.User;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "user_payment")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPayment {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Boolean paid;

}
