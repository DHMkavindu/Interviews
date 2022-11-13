package lk.kavi.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class Department implements Serializable {

    @Id
    @GeneratedValue
    private Long depId;

    private String depName;

    @OneToMany(mappedBy = "empId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Employees> employees;
}
