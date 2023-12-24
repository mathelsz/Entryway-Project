package com.sistema.entryway.controller;

import com.sistema.entryway.dto.SubjectDTO;
import com.sistema.entryway.model.Subject;
import com.sistema.entryway.service.SubjectService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/subject/")
public class SubjectController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("{subjectId}")
    public Subject findSubjectById(@PathVariable UUID subjectId) {
        log.info("Recovering subject");

        try {
            return subjectService.findById(subjectId);
        } catch (Exception e) {
            throw new RuntimeException("Error in recovering subject! " + e);
        }
    }

    @PostMapping(value = "/create")
    public Subject createSubject(@RequestBody @Valid SubjectDTO subjectDTO) {
        log.info("Registering subject");

        try {
            return subjectService.create(
                    subjectDTO,
                    new BCryptPasswordEncoder().encode(subjectDTO.password())
            );
        } catch (Exception e) {
            throw new RuntimeException("Error registering subject! " + e);
        }
    }

    @PostMapping(value = "/update")
    public Subject updateSubject(@RequestBody @Valid Subject subject) {
        log.info("Updating subject");

        try {
            return subjectService.update(subject);
        } catch (Exception e) {
            throw new RuntimeException("Error updating subject! " + e);
        }
    }

    @PutMapping(value = "/activate/{subjectId}")
    public Subject activateSubject(@PathVariable UUID subjectId) {
        log.info("Activating subject");

        try {
            return subjectService.updateStatus(subjectId, true);
        } catch (Exception e) {
            throw new RuntimeException("Error activating subject! " + e);
        }
    }

    @PutMapping(value = "/inactivate/{subjectId}")
    public Subject inactivateSubject(@PathVariable UUID subjectId) {
        log.info("Inactivating subject");

        try {
            return subjectService.updateStatus(subjectId, false);
        } catch (Exception e) {
            throw new RuntimeException("Error in inactivating subject! " + e);
        }
    }
}
