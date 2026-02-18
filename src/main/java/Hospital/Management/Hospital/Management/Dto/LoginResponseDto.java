package Hospital.Management.Hospital.Management.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class LoginResponseDto {
    private String jwt;
    private int id;
}
