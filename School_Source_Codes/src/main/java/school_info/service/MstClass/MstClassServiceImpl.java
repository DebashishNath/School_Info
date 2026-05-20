package school_info.service.MstClass;

import school_info.models.MstClass;
import school_info.models.School;
import utils.MessageResponse;

import java.util.List;
import java.util.Optional;

abstract class MstClassServiceImpl implements MstClassService {
    @Override
    public MstClass updateMstClass(MstClass mstClass){
        return new MstClassServiceDAL().updateMstClass(mstClass);
    }

    @Override
    public MessageResponse deleteMstClass(Long classId){
        return new MstClassServiceDAL().deleteMstClass(classId);
    }

    @Override
    public List<MstClass> findBySchool(School school){
        return new MstClassServiceDAL().findBySchool(school);
    }

    @Override
    public Optional<MstClass> findBySchoolAndClassName(
            School school,
            String className
    ){
        return new MstClassServiceDAL().findBySchoolAndClassName(school,className);
    }

    @Override
    public List<MstClass> findByAvailableSeatsGreaterThan(Integer seats){
        return new MstClassServiceDAL().findByAvailableSeatsGreaterThan(seats);
    }
}