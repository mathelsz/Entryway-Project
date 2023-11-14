package com.sistema.entryway.controller;

import com.sistema.entryway.dto.SubjectDTO;
import com.sistema.entryway.model.Subject;
import com.sistema.entryway.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/public/subject/")
public class SubjectController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("{subjectId}")
    public Subject findSubjectById(@PathVariable UUID subjectId) {
        log.info("Recuperando sujeito");

        try {
            var subject = subjectService.findById(subjectId);

            log.info("sujeito recuperado: " + subject);
            return subject;
        } catch (Exception e) {
            throw new RuntimeException("Erro em recuperar sujeito! " + e);
        }
    }

    @PostMapping(value = "/create")
    public Subject createSubject(@RequestBody SubjectDTO subjectDTO) {
        log.info("Registrando sujeito");

        try {
            var subject = subjectService.create(subjectDTO);

            log.info("sujeito criado: " + subject);
            return subject;
        } catch (Exception e) {
            throw new RuntimeException("Erro em cadastrar sujeito! " + e);
        }
    }

    @PostMapping(value = "/update")
    public Subject updateSubject(@RequestBody Subject subject) {
        log.info("Atualizando sujeito");

        try {
            var updatedSubject = subjectService.update(subject);

            log.info("sujeito atualizado: " + updatedSubject);
            return updatedSubject;
        } catch (Exception e) {
            throw new RuntimeException("Erro em atualizar sujeito! " + e);
        }
    }

    @PutMapping(value = "/activate/{subjectId}")
    public Subject activateSubject(@PathVariable UUID subjectId) {
        log.info("Ativando sujeito");

        try {
            var updatedSubject = subjectService.updateStatus(subjectId, true);

            log.info("sujeito ativado: " + updatedSubject);
            return updatedSubject;
        } catch (Exception e) {
            throw new RuntimeException("Erro em ativar sujeito! " + e);
        }
    }

    @PutMapping(value = "/inactivate/{subjectId}")
    public Subject inactivateSubject(@PathVariable UUID subjectId) {
        log.info("Inativando sujeito");

        try {
            var updatedSubject = subjectService.updateStatus(subjectId, false);

            log.info("sujeito inativado: " + updatedSubject);
            return updatedSubject;
        } catch (Exception e) {
            throw new RuntimeException("Erro em inativar sujeito! " + e);
        }
    }
}
