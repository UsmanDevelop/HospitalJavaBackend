package Hospital.Management.Hospital.Management.Service;

import Hospital.Management.Hospital.Management.Entity.Doctor;
import Hospital.Management.Hospital.Management.Repository.DoctorRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepo doctorRepo;

    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public ResponseEntity<List<Doctor>> getAllDoctors(){
        return ResponseEntity.ok(doctorRepo.findAll());
    }

    public ResponseEntity<Doctor> getDoctorById(int id){
        Optional<Doctor> doctor = doctorRepo.findDoctorById(id);

        if(doctor.isPresent()){
            return ResponseEntity.ok(doctor.get());
        }
        return (ResponseEntity<Doctor>) ResponseEntity.notFound();
    }

}
