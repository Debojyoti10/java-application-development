package com.lms.service;

import com.lms.entity.*;
import com.lms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDate;

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
        // Preserve the existing password - don't allow password updates through this endpoint
        Optional<EmployeePrimaryInfo> existing = primaryRepo.findById(info.getId());
        if (existing.isPresent()) {
            info.setPassword(existing.get().getPassword());
        }
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
        if (info.getId() == null || !educationRepo.existsById(info.getId())) {
            throw new RuntimeException("Education record not found");
        }
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

    public EmployeeEducationInfo updateEducationByEmployeeId(Long employeeId, EmployeeEducationInfo info) {
        List<EmployeeEducationInfo> educations = educationRepo.findByEmployeeId(employeeId);
        if (educations.isEmpty()) {
            throw new RuntimeException("No education found for employee");
        }
        EmployeeEducationInfo existing = educations.get(0);
        existing.setDegree(info.getDegree());
        existing.setUniversity(info.getUniversity());
        existing.setYearOfPassing(info.getYearOfPassing());
        existing.setGrade(info.getGrade());
        return educationRepo.save(existing);
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

    public EmployeeAddressInfo updateAddressByEmployeeId(Long employeeId, EmployeeAddressInfo info) {
        List<EmployeeAddressInfo> addresses = addressRepo.findByEmployeeId(employeeId);
        if (addresses.isEmpty()) {
            throw new RuntimeException("No address found for employee");
        }
        EmployeeAddressInfo existing = addresses.get(0);
        existing.setAddressType(info.getAddressType());
        existing.setStreet(info.getStreet());
        existing.setCity(info.getCity());
        existing.setState(info.getState());
        existing.setZipCode(info.getZipCode());
        return addressRepo.save(existing);
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

    public EmployeeExperienceInfo updateExperienceByEmployeeId(Long employeeId, EmployeeExperienceInfo info) {
        List<EmployeeExperienceInfo> experiences = experienceRepo.findByEmployeeId(employeeId);
        if (experiences.isEmpty()) {
            throw new RuntimeException("No experience found for employee");
        }
        EmployeeExperienceInfo existing = experiences.get(0);
        existing.setCompanyName(info.getCompanyName());
        existing.setRole(info.getRole());
        existing.setStartDate(info.getStartDate());
        existing.setEndDate(info.getEndDate());
        existing.setDescription(info.getDescription());
        return experienceRepo.save(existing);
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

    public EmployeeTechnicalSkillsInfo updateSkillByEmployeeId(Long employeeId, EmployeeTechnicalSkillsInfo info) {
        List<EmployeeTechnicalSkillsInfo> skills = skillsRepo.findByEmployeeId(employeeId);
        if (skills.isEmpty()) {
            throw new RuntimeException("No skills found for employee");
        }
        EmployeeTechnicalSkillsInfo existing = skills.get(0);
        existing.setSkillName(info.getSkillName());
        existing.setProficiency(info.getProficiency());
        return skillsRepo.save(existing);
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

    public EmployeeContactInfo updateContactByEmployeeId(Long employeeId, EmployeeContactInfo info) {
        List<EmployeeContactInfo> contacts = contactRepo.findByEmployeeId(employeeId);
        if (contacts.isEmpty()) {
            throw new RuntimeException("No contact found for employee");
        }
        EmployeeContactInfo existing = contacts.get(0);
        existing.setContactType(info.getContactType());
        existing.setPhone(info.getPhone());
        existing.setEmail(info.getEmail());
        return contactRepo.save(existing);
    }

    // Authentication
    public Optional<EmployeePrimaryInfo> findByUsername(String username) {
        return primaryRepo.findByUsername(username);
    }

    public boolean passwordExists(String plainPassword) {
        List<EmployeePrimaryInfo> allUsers = primaryRepo.findAll();
        for (EmployeePrimaryInfo user : allUsers) {
            if (passwordEncoder.matches(plainPassword, user.getPassword())) {
                return true;
            }
        }
        return false;
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

    // Create Full Employee
    public Long createFullEmployee(Map<String, Object> fullEmployeeData) {
        // Parse primary info
        Map<String, Object> primaryData = (Map<String, Object>) fullEmployeeData.get("primary");
        EmployeePrimaryInfo primary = new EmployeePrimaryInfo();
        primary.setFirstName((String) primaryData.get("firstName"));
        primary.setLastName((String) primaryData.get("lastName"));
        primary.setEmail((String) primaryData.get("email"));
        primary.setPhone((String) primaryData.get("phone"));
        primary.setDateOfBirth(LocalDate.parse((String) primaryData.get("dateOfBirth")));
        primary.setGender((String) primaryData.get("gender"));
        primary.setDepartment((String) primaryData.get("department"));
        primary.setDesignation((String) primaryData.get("designation"));
        primary.setUsername((String) primaryData.get("username"));
        primary.setPassword(passwordEncoder.encode((String) primaryData.get("password")));

        // Check for duplicate username
        if (primaryRepo.findByUsername(primary.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        EmployeePrimaryInfo savedPrimary = primaryRepo.save(primary);
        Long employeeId = savedPrimary.getId();

        // Parse and save secondary info
        if (fullEmployeeData.containsKey("secondary")) {
            Map<String, Object> secondaryData = (Map<String, Object>) fullEmployeeData.get("secondary");
            EmployeeSecondaryInfo secondary = new EmployeeSecondaryInfo();
            secondary.setEmployeeId(employeeId);
            secondary.setJoiningDate(LocalDate.parse((String) secondaryData.get("joiningDate")));
            secondary.setManagerId((String) secondaryData.get("managerId"));
            secondary.setEmploymentType((String) secondaryData.get("employmentType"));
            secondary.setSalary(((Number) secondaryData.get("salary")).doubleValue());
            secondaryRepo.save(secondary);
        }

        // Parse and save education
        if (fullEmployeeData.containsKey("education")) {
            List<Map<String, Object>> educationList = (List<Map<String, Object>>) fullEmployeeData.get("education");
            for (Map<String, Object> eduData : educationList) {
                EmployeeEducationInfo education = new EmployeeEducationInfo();
                education.setEmployeeId(employeeId);
                education.setDegree((String) eduData.get("degree"));
                education.setUniversity((String) eduData.get("university"));
                education.setYearOfPassing(((Number) eduData.get("yearOfPassing")).intValue());
                education.setGrade((String) eduData.get("grade"));
                educationRepo.save(education);
            }
        }

        // Parse and save address
        if (fullEmployeeData.containsKey("address")) {
            List<Map<String, Object>> addressList = (List<Map<String, Object>>) fullEmployeeData.get("address");
            for (Map<String, Object> addrData : addressList) {
                EmployeeAddressInfo address = new EmployeeAddressInfo();
                address.setEmployeeId(employeeId);
                address.setAddressType((String) addrData.get("addressType"));
                address.setStreet((String) addrData.get("street"));
                address.setCity((String) addrData.get("city"));
                address.setState((String) addrData.get("state"));
                address.setZipCode((String) addrData.get("zipCode"));
                addressRepo.save(address);
            }
        }

        // Parse and save bank
        if (fullEmployeeData.containsKey("bank")) {
            Map<String, Object> bankData = (Map<String, Object>) fullEmployeeData.get("bank");
            EmployeeBankDetails bank = new EmployeeBankDetails();
            bank.setEmployeeId(employeeId);
            bank.setAccountNumber((String) bankData.get("accountNumber"));
            bank.setAccountType((String) bankData.get("accountType"));
            bank.setBankName((String) bankData.get("bankName"));
            bank.setIfscCode((String) bankData.get("ifscCode"));
            bankRepo.save(bank);
        }

        // Parse and save experience
        if (fullEmployeeData.containsKey("experience")) {
            List<Map<String, Object>> experienceList = (List<Map<String, Object>>) fullEmployeeData.get("experience");
            for (Map<String, Object> expData : experienceList) {
                EmployeeExperienceInfo experience = new EmployeeExperienceInfo();
                experience.setEmployeeId(employeeId);
                experience.setCompanyName((String) expData.get("companyName"));
                experience.setRole((String) expData.get("role"));
                experience.setStartDate(LocalDate.parse((String) expData.get("startDate")));
                experience.setEndDate(expData.get("endDate") != null ? LocalDate.parse((String) expData.get("endDate")) : null);
                experience.setDescription((String) expData.get("description"));
                experienceRepo.save(experience);
            }
        }

        // Parse and save skills
        if (fullEmployeeData.containsKey("skills")) {
            List<Map<String, Object>> skillsList = (List<Map<String, Object>>) fullEmployeeData.get("skills");
            for (Map<String, Object> skillData : skillsList) {
                EmployeeTechnicalSkillsInfo skill = new EmployeeTechnicalSkillsInfo();
                skill.setEmployeeId(employeeId);
                skill.setSkillName((String) skillData.get("skillName"));
                skill.setProficiency((String) skillData.get("proficiency"));
                skillsRepo.save(skill);
            }
        }

        // Parse and save contact
        if (fullEmployeeData.containsKey("contact")) {
            List<Map<String, Object>> contactList = (List<Map<String, Object>>) fullEmployeeData.get("contact");
            for (Map<String, Object> contData : contactList) {
                EmployeeContactInfo contact = new EmployeeContactInfo();
                contact.setEmployeeId(employeeId);
                contact.setContactType((String) contData.get("contactType"));
                contact.setPhone((String) contData.get("phone"));
                contact.setEmail((String) contData.get("email"));
                contactRepo.save(contact);
            }
        }

        return employeeId;
    }
}