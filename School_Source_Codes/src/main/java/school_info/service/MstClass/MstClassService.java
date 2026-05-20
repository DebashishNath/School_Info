package school_info.service.MstClass;

import school_info.models.MstClass;
import school_info.models.School;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface MstClassService {
    MstClass updateMstClass(MstClass mstClass);

    MessageResponse deleteMstClass(Long classId);

    List<MstClass> findBySchool(School school);

    Optional<MstClass> findBySchoolAndClassName(
            School school,
            String className
    );

    List<MstClass> findByAvailableSeatsGreaterThan(Integer seats);
}