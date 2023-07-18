package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public AssignmentController(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @GetMapping
    public ResponseEntity<List<Assignment>> getAssignmentsByUser(@RequestHeader("Authorization") String token) {
        if (isValidToken(token)) {
            List<Assignment> assignments = assignmentRepository.findAll();
            return ResponseEntity.ok(assignments);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        if (isValidToken(token)) {
            Optional<Assignment> assignment = assignmentRepository.findById(id);
            if (assignment.isPresent()) {
                return ResponseEntity.ok(assignment.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignmentById(@PathVariable Long id, @RequestBody Assignment updatedAssignment, @RequestHeader("Authorization") String token) {
        if (isValidToken(token)) {
            Optional<Assignment> assignment = assignmentRepository.findById(id);
            if (assignment.isPresent()) {
                Assignment existingAssignment = assignment.get();
                Assignment savedAssignment = assignmentRepository.save(existingAssignment);
                return ResponseEntity.ok(savedAssignment);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment newAssignment, @RequestHeader("Authorization") String token) {
        if (isValidToken(token)) {
            Assignment savedAssignment = assignmentRepository.save(newAssignment);
            return ResponseEntity.ok(savedAssignment);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    private boolean isValidToken(String token) {
        // Validate the token
        return token != null && !token.isEmpty();
    }
}

