package place.reservation.reservations.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import place.reservation.reservations.entity.utils.UserRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Comparable<User> {

    private static final int TEXT_FIELD_MAX_LENGTH = 70;
    private static final int PHONE_NUMBER_MAX_LENGTH = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(nullable = false, length = TEXT_FIELD_MAX_LENGTH, name = "first_name")
    private String firstName;

    @NotBlank
    @Column(nullable = false, length = TEXT_FIELD_MAX_LENGTH, name = "last_name")
    private String lastName;

    @NotBlank
    @Column(nullable = false, unique = true, length = TEXT_FIELD_MAX_LENGTH)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Column(length = PHONE_NUMBER_MAX_LENGTH, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, name = "user_role")
    @Enumerated(EnumType.ORDINAL)
    private UserRole userRole;

    @Column(name = "is_exist")
    private boolean isExist = true;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime modifiedAt;


    @Override
    public int compareTo(User user) {
        if (this.getModifiedAt().isAfter(user.modifiedAt)) {
            return -1;
        } else if (this.getModifiedAt().isBefore(user.modifiedAt)){
            return 1;
        } else {
            return 0;
        }
    }
}
