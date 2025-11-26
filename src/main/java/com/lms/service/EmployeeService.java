package com.lms.service;

import com.lms.entity.*;
import com.lms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeePrimaryInfoRepository primaryRepo;

    @Autowired
    private EmployeeSecondaryInfoRepository secondaryRepo;

    @Autowired
    private EmployeeEducationInfoRepository educationRepo;

    @Autowired
    private EmployeeAddressInfoRepository addressRepo;

    @Autowired
    private EmployeeBankDetailsRepository bankRepo;

    @Autowired
    private EmployeeExperienceInfoRepository experienceRepo;

    @Autowired
    private EmployeeTechnicalSkillsInfoRepository skillsRepo;

    @Autowired
    private EmployeeContactInfoRepository contactRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Primary Info
    public EmployeePrimaryInfo createPrimaryInfo(EmployeePrimaryInfo info) {
        info.setPassword(passwordEncoder.encode(info.getPassword()));
        return primaryRepo.save(info);
    }

    public List<EmployeePrimaryInfo> getAllPrimaryInfo() {
        return primaryRepo.findAll();
    }

    public Optional<EmployeePrimaryInfo> getPrimaryInfo(Long employeeId) {
        return primaryRepo.findById(employeeId);
    }

    public EmployeePrimaryInfo updatePrimaryInfo(EmployeePrimaryInfo info) {
        return primaryRepo.save(info);
    }

    // Secondary Info
    public EmployeeSecondaryInfo createSecondaryInfo(EmployeeSecondaryInfo info) {
        return secondaryRepo.save(info);
    }

    public Optional<EmployeeSecondaryInfo> getSecondaryInfo(Long employeeId) {
        return secondaryRepo.findByEmployeeId(employeeId);
    }

    public EmployeeSecondaryInfo updateSecondaryInfo(EmployeeSecondaryInfo info) {
        return secondaryRepo.save(info);
    }

    // Education
    public List<EmployeeEducationInfo> getEducation(Long employeeId) {
        return educationRepo.findByEmployeeId(employeeId);
    }

    public EmployeeEducationInfo addEducation(Long employeeId, EmployeeEducationInfo info) {
        info.setEmployeeId(employeeId);
        return educationRepo.save(info);
    }

    public EmployeeEducationInfo updateEducation(EmployeeEducationInfo info) {
        return educationRepo.save(info);
    }

    public void deleteEducation(Long employeeId, Long id) {
        Optional<EmployeeEducationInfo> opt = educationRepo.findById(id);
        if (opt.isPresent()) {
            EmployeeEducationInfo education = opt.get();
            if (education.getEmployeeId().equals(employeeId)) {
                educationRepo.delete(education);
            } else {
                throw new RuntimeException("Education record does not belong to the specified employee");
            }
        } else {
            throw new RuntimeException("Education record not found");
        }
    }

    public List<EmployeeEducationInfo> getAllEducation() {
        return educationRepo.findAll();
    }

    // Address
    public List<EmployeeAddressInfo> getAddresses(Long employeeId) {
        return addressRepo.findByEmployeeId(employeeId);
    }

    public EmployeeAddressInfo addAddress(Long employeeId, EmployeeAddressInfo info) {
        info.setEmployeeId(employeeId);
        return addressRepo.save(info);
    }

    public EmployeeAddressInfo updateAddress(EmployeeAddressInfo info) {
        return addressRepo.save(info);
    }

    public void deleteAddress(Long employeeId, Long id) {
        Optional<EmployeeAddressInfo> opt = addressRepo.findById(id);
        if (opt.isPresent()) {
            EmployeeAddressInfo address = opt.get();
            if (address.getEmployeeId().equals(employeeId)) {
                addressRepo.delete(address);
            } else {
                throw new RuntimeException("Address record does not belong to the specified employee");
            }
        } else {
            throw new RuntimeException("Address record not found");
        }
    }

    // Bank
    public Optional<EmployeeBankDetails> getBankDetails(Long employeeId) {
        return bankRepo.findByEmployeeId(employeeId);
    }

    public EmployeeBankDetails addBankDetails(Long employeeId, EmployeeBankDetails info) {
        info.setEmployeeId(employeeId);
        return bankRepo.save(info);
    }

    public EmployeeBankDetails updateBankDetails(EmployeeBankDetails info) {
        return bankRepo.save(info);
    }

    // Experience
    public List<EmployeeExperienceInfo> getExperience(Long employeeId) {
        return experienceRepo.findByEmployeeId(employeeId);
    }

    public EmployeeExperienceInfo addExperience(Long employeeId, EmployeeExperienceInfo info) {
        info.setEmployeeId(employeeId);
        return experienceRepo.save(info);
    }

    public EmployeeExperienceInfo updateExperience(EmployeeExperienceInfo info) {
        return experienceRepo.save(info);
    }

    public void deleteExperience(Long employeeId, Long id) {
        Optional<EmployeeExperienceInfo> opt = experienceRepo.findById(id);
        if (opt.isPresent()) {
            EmployeeExperienceInfo experience = opt.get();
            if (experience.getEmployeeId().equals(employeeId)) {
                experienceRepo.delete(experience);
            } else {
                throw new RuntimeException("Experience record does not belong to the specified employee");
            }
        } else {
            throw new RuntimeException("Experience record not found");
        }
    }

    // Skills
    public List<EmployeeTechnicalSkillsInfo> getSkills(Long employeeId) {
        return skillsRepo.findByEmployeeId(employeeId);
    }

    public EmployeeTechnicalSkillsInfo addSkill(Long employeeId, EmployeeTechnicalSkillsInfo info) {
        info.setEmployeeId(employeeId);
        return skillsRepo.save(info);
    }

    public EmployeeTechnicalSkillsInfo updateSkill(EmployeeTechnicalSkillsInfo info) {
        return skillsRepo.save(info);
    }

    public void deleteSkill(Long employeeId, Long id) {
        Optional<EmployeeTechnicalSkillsInfo> opt = skillsRepo.findById(id);
        if (opt.isPresent()) {
            EmployeeTechnicalSkillsInfo skill = opt.get();
            if (skill.getEmployeeId().equals(employeeId)) {
                skillsRepo.delete(skill);
            } else {
                throw new RuntimeException("Skill record does not belong to the specified employee");
            }
        } else {
            throw new RuntimeException("Skill record not found");
        }
    }

    // Contact
    public List<EmployeeContactInfo> getContacts(Long employeeId) {
        return contactRepo.findByEmployeeId(employeeId);
    }

    public EmployeeContactInfo addContact(Long employeeId, EmployeeContactInfo info) {
        info.setEmployeeId(employeeId);
        return contactRepo.save(info);
    }

    public EmployeeContactInfo updateContact(EmployeeContactInfo info) {
        return contactRepo.save(info);
    }

    public void deleteContact(Long employeeId, Long id) {
        Optional<EmployeeContactInfo> opt = contactRepo.findById(id);
        if (opt.isPresent()) {
            EmployeeContactInfo contact = opt.get();
            if (contact.getEmployeeId().equals(employeeId)) {
                contactRepo.delete(contact);
            } else {
                throw new RuntimeException("Contact record does not belong to the specified employee");
            }
        } else {
            throw new RuntimeException("Contact record not found");
        }
    }

    // Authentication
    public Optional<EmployeePrimaryInfo> findByUsername(String username) {
        return primaryRepo.findByUsername(username);
    }

    public boolean resetPassword(Long id, String oldPassword, String newPassword) {
        Optional<EmployeePrimaryInfo> opt = primaryRepo.findById(id);
        if (opt.isPresent()) {
            EmployeePrimaryInfo info = opt.get();
            if (passwordEncoder.matches(oldPassword, info.getPassword())) {
                info.setPassword(passwordEncoder.encode(newPassword));
                primaryRepo.save(info);
                return true;
            }
        }
        return false;
    }
}