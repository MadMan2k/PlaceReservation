package place.reservation.reservations.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 70, name = "first_name")
    private String firstName;

    @NotBlank
    @Column(nullable = false, length = 70, name = "last_name")
    private String lastName;

    @NotBlank
    @Column(nullable = false, unique = true, length = 70)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Column(length = 20, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, name = "user_role")
    @Enumerated(EnumType.ORDINAL)
    private UserRole userRole;
}
