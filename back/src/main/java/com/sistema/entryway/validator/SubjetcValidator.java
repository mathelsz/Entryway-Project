package com.sistema.entryway.validator;

import com.sistema.entryway.dto.SubjectDTO;
import com.sistema.entryway.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjetcValidator {
    private final SubjectRepository subjectRepository;

    public SubjetcValidator(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void verifySubject(SubjectDTO subject) {
        this.verifyUsename(subject.username());
    }

    private void verifyUsename(String username) {
        if (this.subjectRepository.existsSubjectByUsername(username)) {
            throw new RuntimeException("Subject already registered!");
        }
    }
}
