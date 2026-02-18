package Hospital.Management.Hospital.Management.Service;

import Hospital.Management.Hospital.Management.Entity.Patient;
import Hospital.Management.Hospital.Management.Repository.PatientRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public ResponseEntity<List<Patient>> getAll(){
        return ResponseEntity.ok(patientRepo.findAll());
    }
}
