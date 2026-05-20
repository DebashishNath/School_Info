package school_info.service.School;

import school_info.models.School;
import school_info.models.Student;
import utils.MessageResponse;
import java.util.Optional;

public interface SchoolService {

    School updateSchool(School school);

    MessageResponse deleteSchool(Long schoolId);

    Optional<School> findBySchoolName(String schoolName);

    boolean existsBySchoolName(String schoolName);
}