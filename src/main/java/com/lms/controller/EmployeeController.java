package com.lms.controller;

import com.lms.entity.*;
import com.lms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Primary Info
    @PostMapping
    public ResponseEntity<EmployeePrimaryInfo> createEmployee(@RequestBody EmployeePrimaryInfo info) {
        return ResponseEntity.ok(service.createPrimaryInfo(info));
    }

    @GetMapping
    public ResponseEntity<List<EmployeePrimaryInfo>> getAllEmployees() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getAllPrimaryInfo());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeePrimaryInfo> getEmployee(@PathVariable String employeeId) {
        Optional<EmployeePrimaryInfo> opt = service.getPrimaryInfo(employeeId);
        return opt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeePrimaryInfo> updateEmployee(@PathVariable String employeeId, @RequestBody EmployeePrimaryInfo info) {
        info.setEmployeeId(employeeId);
        return ResponseEntity.ok(service.updatePrimaryInfo(info));
    }

    // Secondary Info
    @PostMapping("/{employeeId}/secondary")
    public ResponseEntity<EmployeeSecondaryInfo> createSecondary(@PathVariable String employeeId, @RequestBody EmployeeSecondaryInfo info) {
        info.setEmployeeId(employeeId);
        return ResponseEntity.ok(service.createSecondaryInfo(info));
    }

    @GetMapping("/{employeeId}/secondary")
    public ResponseEntity<EmployeeSecondaryInfo> getSecondary(@PathVariable String employeeId) {
        Optional<EmployeeSecondaryInfo> opt = service.getSecondaryInfo(employeeId);
        return opt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{employeeId}/secondary")
    public ResponseEntity<EmployeeSecondaryInfo> updateSecondary(@PathVariable String employeeId, @RequestBody EmployeeSecondaryInfo info) {
        info.setEmployeeId(employeeId);
        return ResponseEntity.ok(service.updateSecondaryInfo(info));
    }

    // Education
    @GetMapping("/{employeeId}/education")
    public ResponseEntity<List<EmployeeEducationInfo>> getEducation(@PathVariable String employeeId) {
        return ResponseEntity.ok(service.getEducation(employeeId));
    }

    @GetMapping("/education")
    public ResponseEntity<List<EmployeeEducationInfo>> getAllEducation() {
        return ResponseEntity.ok(service.getAllEducation());
    }

    @PostMapping("/{employeeId}/education")
    public ResponseEntity<EmployeeEducationInfo> addEducation(@PathVariable String employeeId, @RequestBody EmployeeEducationInfo info) {
        return ResponseEntity.ok(service.addEducation(employeeId, info));
    }

    @PutMapping("/{employeeId}/education/{id}")
    public ResponseEntity<EmployeeEducationInfo> updateEducation(@PathVariable String employeeId, @PathVariable Long id, @RequestBody EmployeeEducationInfo info) {
        info.setId(id);
        info.setEmployeeId(employeeId);
        return ResponseEntity.ok(service.updateEducation(info));
    }

    @DeleteMapping("/{employeeId}/education/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable String employeeId, @PathVariable Long id) {
        service.deleteEducation(employeeId, id);
        return ResponseEntity.noContent().build();
    }

    // Address
    @GetMapping("/{employeeId}/address")
    public ResponseEntity<List<EmployeeAddressInfo>> getAddresses(@PathVariable String employeeId) {
        return ResponseEntity.ok(service.getAddresses(employeeId));
    }

    @PostMapping("/{employeeId}/address")
    public ResponseEntity<EmployeeAddressInfo> addAddress(@PathVariable String employeeId, @RequestBody EmployeeAddressInfo info) {
        return ResponseEntity.ok(service.addAddress(employeeId, info));
    }

    @PutMapping("/{employeeId}/address/{id}")
    public ResponseEntity<EmployeeAddressInfo> updateAddress(@PathVariable String employeeId, @PathVariable Long id, @RequestBody EmployeeAddressInfo info) {
        info.setId(id);
        info.setEmployeeId(employeeId);
        return ResponseEntity.ok(service.updateAddress(info));
    }

    @DeleteMapping("/{employeeId}/address/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable String employeeId, @PathVariable Long id) {
        service.deleteAddress(employeeId, id);
        return ResponseEntity.noContent().build();
    }

    // Bank
    @GetMapping("/{employeeId}/bank")
    public ResponseEntity<EmployeeBankDetails> getBank(@PathVariable String employeeId) {
        Optional<EmployeeBankDetails> opt = service.getBankDetails(employeeId);
        return opt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{employeeId}/bank")
    public ResponseEntity<EmployeeBankDetails> addBank(@PathVariable String employeeId, @RequestBody EmployeeBankDetails info) {
        return ResponseEntity.ok(service.addBankDetails(employeeId, info));
    }

    @PutMapping("/{employeeId}/bank")
    public ResponseEntity<EmployeeBankDetails> updateBank(@PathVariable String employeeId, @RequestBody EmployeeBankDetails info) {
        info.setEmployeeId(employeeId);
        return ResponseEntity.ok(service.updateBankDetails(info));
    }

    // Experience
    @GetMapping("/{employeeId}/experience")
    public ResponseEntity<List<EmployeeExperienceInfo>> getExperience(@PathVariable String employeeId) {
        return ResponseEntity.ok(service.getExperience(employeeId));
    }

    @PostMapping("/{employeeId}/experience")
    public ResponseEntity<EmployeeExperienceInfo> addExperience(@PathVariable String employeeId, @RequestBody EmployeeExperienceInfo info) {
        return ResponseEntity.ok(service.addExperience(employeeId, info));
    }

    @PutMapping("/{employeeId}/experience/{id}")
    public ResponseEntity<EmployeeExperienceInfo> updateExperience(@PathVariable String employeeId, @PathVariable Long id, @RequestBody EmployeeExperienceInfo info) {
        info.setId(id);
        info.setEmployeeId(employeeId);
        return ResponseEntity.ok(service.updateExperience(info));
    }

    @DeleteMapping("/{employeeId}/experience/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable String employeeId, @PathVariable Long id) {
        service.deleteExperience(employeeId, id);
        return ResponseEntity.noContent().build();
    }

    // Skills
    @GetMapping("/{employeeId}/skills")
    public ResponseEntity<List<EmployeeTechnicalSkillsInfo>> getSkills(@PathVariable String employeeId) {
        return ResponseEntity.ok(service.getSkills(employeeId));
    }

    @PostMapping("/{employeeId}/skills")
    public ResponseEntity<EmployeeTechnicalSkillsInfo> addSkill(@PathVariable String employeeId, @RequestBody EmployeeTechnicalSkillsInfo info) {
        return ResponseEntity.ok(service.addSkill(employeeId, info));
    }

    @PutMapping("/{employeeId}/skills/{id}")
    public ResponseEntity<EmployeeTechnicalSkillsInfo> updateSkill(@PathVariable String employeeId, @PathVariable Long id, @RequestBody EmployeeTechnicalSkillsInfo info) {
        info.setId(id);
        info.setEmployeeId(employeeId);
        return ResponseEntity.ok(service.updateSkill(info));
    }

    @DeleteMapping("/{employeeId}/skills/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable String employeeId, @PathVariable Long id) {
        service.deleteSkill(employeeId, id);
        return ResponseEntity.noContent().build();
    }

    // Contact
    @GetMapping("/{employeeId}/contact")
    public ResponseEntity<List<EmployeeContactInfo>> getContacts(@PathVariable String employeeId) {
        return ResponseEntity.ok(service.getContacts(employeeId));
    }

    @PostMapping("/{employeeId}/contact")
    public ResponseEntity<EmployeeContactInfo> addContact(@PathVariable String employeeId, @RequestBody EmployeeContactInfo info) {
        return ResponseEntity.ok(service.addContact(employeeId, info));
    }

    @PutMapping("/{employeeId}/contact/{id}")
    public ResponseEntity<EmployeeContactInfo> updateContact(@PathVariable String employeeId, @PathVariable Long id, @RequestBody EmployeeContactInfo info) {
        info.setId(id);
        info.setEmployeeId(employeeId);
        return ResponseEntity.ok(service.updateContact(info));
    }

    @DeleteMapping("/{employeeId}/contact/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable String employeeId, @PathVariable Long id) {
        service.deleteContact(employeeId, id);
        return ResponseEntity.noContent().build();
    }
}