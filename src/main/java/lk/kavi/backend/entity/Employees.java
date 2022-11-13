package lk.kavi.backend.entity;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "employees")
public class Employees implements Serializable {

    @Id
    @GeneratedValue()
    @Column(name = "id", nullable = false, unique = true)
    private Long empId;

    private String firstName;

    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "depId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

}
