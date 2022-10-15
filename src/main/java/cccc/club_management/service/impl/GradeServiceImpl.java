package cccc.club_management.service.impl;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Grade;
import cccc.club_management.repositories.ClubRepository;
import cccc.club_management.repositories.GradeRepository;
import cccc.club_management.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> getGrades() {
        return this.gradeRepository.findAll();
    }

    @Override
    public Grade getGradeById(Long id) throws NotFoundException {
        if(this.gradeRepository.findById(id).isPresent()) {
            return this.gradeRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveGrade(Grade grade) {
        this.gradeRepository.save(grade);
    }

    @Override
    public void deleteGrade(Long id) throws NotFoundException {
        if(this.gradeRepository.existsById(id)) {
            this.gradeRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }
}
