package lk.kavi.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDto {

    private Long empId;
    private String firstName;
    private String lastName;
    private String depName;
}
