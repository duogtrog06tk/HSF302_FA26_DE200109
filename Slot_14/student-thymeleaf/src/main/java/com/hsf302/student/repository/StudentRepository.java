package com.hsf302.student.repository;

import com.hsf302.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Tìm kiếm không phân biệt hoa thường theo mã SV hoặc họ tên, sắp xếp id tăng dần
    List<Student> findByStudentCodeContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrderByIdAsc(String code, String name);

    // Kiểm tra trùng mã SV khi tạo mới
    boolean existsByStudentCodeIgnoreCase(String studentCode);

    // Kiểm tra trùng mã SV khi sửa (loại trừ ID của chính sinh viên đang sửa)
    boolean existsByStudentCodeIgnoreCaseAndIdNot(String studentCode, Long id);
}
