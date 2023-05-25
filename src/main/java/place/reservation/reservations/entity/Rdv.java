package place.reservation.reservations.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import place.reservation.reservations.entity.utils.RdvStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rdvs")
public class Rdv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_first_name", nullable = false)
    private String clientFirstName;

    @Column(name = "client_last_name", nullable = false)
    private String clientLastName;

    @Column(name = "client_email", nullable = false)
    private String clientEmail;

    @Column(name = "client_phone_number", nullable = false)
    private String clientPhoneNumber;

    @Column(name = "date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private LocalTime time;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "procedures_id", nullable = false)
    private Procedure procedure;

    @Column(name = "rdv_status", nullable = false)
    private RdvStatus rdvStatus;

    @Column(name = "discount")
    private double discount;
}
