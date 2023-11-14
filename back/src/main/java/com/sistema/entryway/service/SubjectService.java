package com.sistema.entryway.service;

import com.sistema.entryway.dto.SubjectDTO;
import com.sistema.entryway.model.Subject;
import com.sistema.entryway.repository.SubjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Transactional(readOnly = true)
    public Page<Subject> findAll(Pageable pageable) {
        return subjectRepository.findAll(pageable); //TODO: fazer listagem dos sujeitos
    }

    @Transactional(readOnly = true)
    public Subject findById(UUID subjectId) {
        return subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("subject not fund!")); //TODO: fazer uma Exception
    }

    private Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Subject create(SubjectDTO subjectDTO) {
        return this.save(new Subject(subjectDTO));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Subject update(Subject subject) {
        var subjectRetrieved = this.findById(subject.getId());

        subjectRetrieved.mergeForUpdate(subject);

        return this.save(subjectRetrieved);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Subject updateStatus(UUID subjectId, boolean status) {
        var subjectRetrieved = this.findById(subjectId);

        subjectRetrieved.setActive(status);

        return this.save(subjectRetrieved);
    }
}
