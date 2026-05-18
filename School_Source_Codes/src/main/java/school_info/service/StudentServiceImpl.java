package school_info.service;

import school_info.models.Student;

import java.util.List;
import java.util.Optional;

public abstract class StudentServiceImpl implements StudentService {

    @Override
    public abstract Student saveStudent(Student student);

    @Override
    public abstract Student updateStudent(Student student);

    @Override
    public abstract void deleteStudent(Long studentId);

    @Override
    public abstract Optional<Student> findById(Long studentId);

    @Override
    public abstract List<Student> findAllStudents();

    @Override
    public abstract List<Student> findByFirstName(String firstName);

    @Override
    public abstract List<Student> findByLastName(String lastName);

    @Override
    public abstract List<Student> findByGender(String gender);
}
