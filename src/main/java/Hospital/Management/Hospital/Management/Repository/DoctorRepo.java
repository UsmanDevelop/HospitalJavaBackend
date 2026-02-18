package Hospital.Management.Hospital.Management.Repository;

import Hospital.Management.Hospital.Management.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
    Optional<Doctor> findDoctorById(int id);
}
