package com.hsf302.student.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.Nationalized;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;

//  - Lớp     : @Entity, @Table(name = "Students")
//  - id      : @Id + @GeneratedValue(strategy = GenerationType.IDENTITY)
//  - Mỗi field: @Column(name = "...", nullable = false, length = ...) theo bảng ở B0
//      + studentCode: length = 8, unique = true
//      + fullName   : length = 50 và thêm @Nationalized (NVARCHAR – lưu tiếng Việt)
//      + email      : length = 100
//      + major      : length = 2
//      + dateOfBirth, gpa, active: nullable = false
public class Student {

    private Long id;

    //  - studentCode: bắt buộc; regex ^(SE|SS|SA|HE)\d{6}$
    //                 message: "Mã SV phải có dạng SE/SS/SA/HE + 6 chữ số (VD: SE180001)"
    //  - fullName   : bắt buộc; độ dài 2 - 50
    //  - email      : bắt buộc; đúng định dạng email
    private String studentCode;
    private String fullName;
    private String email;

    //  - dateOfBirth: bắt buộc; phải là ngày trong quá khứ;
    //                 thêm @DateTimeFormat(pattern = "yyyy-MM-dd") để bind với <input type="date">
    //  - gpa        : bắt buộc; 0.0 <= gpa <= 10.0
    //  - major      : bắt buộc (chọn ngành)
    private LocalDate dateOfBirth;
    private Double gpa;
    private String major;

    private boolean active = true;

    public Student() {
    }

    public Student(Long id, String studentCode, String fullName, String email,
                   LocalDate dateOfBirth, Double gpa, String major, boolean active) {
        this.id = id;
        this.studentCode = studentCode;
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gpa = gpa;
        this.major = major;
        this.active = active;
    }

    //  - getAge(): trả về số tuổi (dùng Period.between); dateOfBirth null → 0
    //  - getRank(): >=9 "Xuất sắc", >=8 "Giỏi", >=6.5 "Khá", >=5 "Trung bình", còn lại "Yếu";
    //               gpa null → "Chưa xếp loại"
    public int getAge() {
        return 0;
    }

    public String getRank() {
        return null;
    }

    public Object getGpa() {
        return null;
    }

    // TODO 0: Generate Getters & Setters cho tất cả field (IntelliJ: Alt + Insert)
    //  Lưu ý: field boolean "active" → getter là isActive()
}
