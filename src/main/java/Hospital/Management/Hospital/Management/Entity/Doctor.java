package Hospital.Management.Hospital.Management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id;
        private String name;
        String phone;

        @Column(name = "created_at", insertable = false, updatable = false)
        LocalDateTime createdAt;
}
