package lk.kavi.backend.repository;

import lk.kavi.backend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(value = "select * from department a where a.depName= :depName", nativeQuery = true)
    Long getDepartmentIdByName(String depName);
}
