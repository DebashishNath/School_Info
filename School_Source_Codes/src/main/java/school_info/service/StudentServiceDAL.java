package school_info.service;

import school_info.models.Student;
import school_info.repository.StudentRepository;
import utils.MessageResponse;

import utils.CodeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
class StudentServiceDAL extends StudentServiceImpl {

    @Autowired
    private StudentRepository studentRep;

    public StudentServiceDAL() {}

    @Override
    public Student updateStudent(Student student)
    {
        MessageResponse msgResp =new MessageResponse();
        try{
            Student studentToUpdate = studentRep.save(student);
            msgResp = new MessageResponse(CodeConstants.SUCCESS.getID(),
                    "Student details updated successfully!");
            studentToUpdate.setReturnMessage(msgResp);
            return studentToUpdate;
        }catch(Exception ex)
        {
            System.out.println("Error Is: " + ex.getMessage());
            msgResp = new MessageResponse(CodeConstants.FAILURE.getID(),
                    "Failed to update student details");
            student.setReturnMessage(msgResp);
            return student;
        }
    }

    @Override
    public MessageResponse deleteStudent(Long studentId){
        MessageResponse msgResp = new MessageResponse();
        try
        {
            studentRep.deleteById(studentId);
            msgResp = new MessageResponse(CodeConstants.SUCCESS.getID(), "Student details deleted successfully!");
            return msgResp;
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            msgResp = new MessageResponse(CodeConstants.FAILURE.getID(),"Failed to delete student");
            return msgResp;
        }
    }

    @Override
    public Optional<Student> findByStudentId(Long studentId) {
        return studentRep.findById(studentId);
    }

    @Override
    public List<Student> findAllStudents(){
        return studentRep.findAll();
    }

    @Override
    public List<Student> findByFirstName(String firstName){
        return studentRep.findByFirstNameContainingIgnoreCase(firstName);
    }

    @Override
    public List<Student> findByLastName(String lastName){
        return studentRep.findByLastNameContainingIgnoreCase(lastName);
    }

    @Override
    public List<Student> findByGender(String gender){
        return studentRep.findByGender(gender);
    }
}