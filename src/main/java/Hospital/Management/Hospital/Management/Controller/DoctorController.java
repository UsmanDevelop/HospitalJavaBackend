package Hospital.Management.Hospital.Management.Controller;

import Hospital.Management.Hospital.Management.Entity.Doctor;
import Hospital.Management.Hospital.Management.Service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll(){
        return doctorService.getAllDoctors();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int id){
        return doctorService.getDoctorById(id);
    }
}
