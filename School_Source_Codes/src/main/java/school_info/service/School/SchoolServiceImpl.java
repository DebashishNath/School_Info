package school_info.service.School;

import school_info.models.School;
import school_info.models.Student;
import utils.MessageResponse;

import java.util.Optional;

abstract class SchoolServiceImpl implements SchoolService{
    @Override
    public School updateSchool(School school){
        return new SchoolServiceDAL().updateSchool(school);
    }

    @Override
    public MessageResponse deleteSchool(Long schoolId){
        return new SchoolServiceDAL().deleteSchool(schoolId);
    }

    @Override
    public Optional<School> findBySchoolName(String schoolName){
        return new SchoolServiceDAL().findBySchoolName(schoolName);
    }

    @Override
    public boolean existsBySchoolName(String schoolName){
        return new SchoolServiceDAL().existsBySchoolName(schoolName);
    }
}