package org.example.developer.controller;

import org.example.developer.domain.Announcement;
import org.example.developer.domain.Content;
import org.example.developer.domain.Department;
import org.example.developer.domain.University;
import org.example.developer.repository.AnnouncementRepository;
import org.example.developer.repository.ContentRepository;
import org.example.developer.repository.DepartmentRepository;
import org.example.developer.repository.UniversityRepository;
import org.example.developer.service.AnnouncementService;
import org.example.developer.service.ContentService;
import org.example.developer.service.DepartmentService;
import org.example.developer.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cnu")
public class UniversityApiController {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private UniversityService universityService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private ContentService contentService;

    @GetMapping("/universities")
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @GetMapping("/departments/{universityId}")
    public List<Department> getDepartmentsByUniversity(@PathVariable Long universityId) {
        return departmentRepository.findByUniversityId(universityId);
    }

    @GetMapping("/announcements/{departmentId}")
    public List<Announcement> getAnnouncementsByDepartment(@PathVariable Long departmentId) {
        return announcementRepository.findByDepartmentId(departmentId);
    }

    @GetMapping("/contents/{announcementId}")
    public List<Content> getContentsByAnnouncement(@PathVariable Long announcementId) {
        return contentRepository.findByAnnouncementId(announcementId);
    }
}
