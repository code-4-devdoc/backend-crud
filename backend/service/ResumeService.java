package com.devdoc.backend.service;

import com.devdoc.backend.dto.*;
import com.devdoc.backend.model.*;
import com.devdoc.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResumeService {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private AwardRepository awardRepository;
    @Autowired
    private CertificationRepository certificationRepository;
    @Autowired
    private EducationCompletionRepository educationCompletionRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private PersonalInfoRepository personalInfoRepository;
    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    private UserRepository userRepository;

    // Activity 항목 데이터 저장 또는 업데이트
    @Transactional
    public ActivityDTO saveOrUpdateActivity(int resumeId, ActivityDTO activityDTO) {
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        if (optionalResume.isPresent()) {
            Resume resume = optionalResume.get();
            Activity activity = activityRepository.findByIdAndResumeId(activityDTO.getId(), resumeId)
                    .orElse(new Activity());

            boolean isNew = (activity.getId() == null); // 새로운 항목인지 확인

            activity.setActivityName(activityDTO.getActivityName());
            activity.setOrganizationName(activityDTO.getOrganizationName());
            activity.setStartDate(activityDTO.getStartDate());
            activity.setEndDate(activityDTO.getEndDate());
            activity.setResume(resume);

            Activity savedActivity = activityRepository.save(activity);

            return new ActivityDTO(savedActivity.getId(), savedActivity.getActivityName(), savedActivity.getOrganizationName(), savedActivity.getStartDate(), savedActivity.getEndDate());
        }
        throw new RuntimeException("Resume not found");
    }

    // Activity 항목 데이터 삭제
    @Transactional
    public void deleteActivity(int resumeId, int activityId) {
        Optional<Activity> activity = activityRepository.findByIdAndResumeId(activityId, resumeId);
        activity.ifPresent(activityRepository::delete);
    }

    // Award 항목 데이터 저장 또는 업데이트
    @Transactional
    public AwardDTO saveOrUpdateAward(int resumeId, AwardDTO awardDTO) {
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        if (optionalResume.isPresent()) {
            Resume resume = optionalResume.get();
            Award award = awardRepository.findByIdAndResumeId(awardDTO.getId(), resumeId)
                    .orElse(new Award());

            boolean isNew = (award.getId() == null);

            award.setAwardName(awardDTO.getAwardName());
            award.setAwardingInstitution(awardDTO.getAwardingInstitution());
            award.setDate(awardDTO.getDate());
            award.setDescription(awardDTO.getDescription());
            award.setResume(resume);

            Award savedAward = awardRepository.save(award);

            return new AwardDTO(savedAward.getId(), savedAward.getAwardName(), savedAward.getAwardingInstitution(), savedAward.getDate(), savedAward.getDescription());
        }
        throw new RuntimeException("Resume not found");
    }

    // Award 항목 데이터 삭제
    @Transactional
    public void deleteAward(int resumeId, int awardId) {
        Optional<Award> award = awardRepository.findByIdAndResumeId(awardId, resumeId);
        award.ifPresent(awardRepository::delete);
    }

    // Certification 항목 데이터 저장 또는 업데이트
    @Transactional
    public CertificationDTO saveOrUpdateCertification(int resumeId, CertificationDTO certificationDTO) {
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        if (optionalResume.isPresent()) {
            Resume resume = optionalResume.get();
            Certification certification = certificationRepository.findByIdAndResumeId(certificationDTO.getId(), resumeId)
                    .orElse(new Certification());

            boolean isNew = (certification.getId() == null); // 새로운 항목인지 확인

            certification.setCertificationName(certificationDTO.getCertificationName());
            certification.setIssuer(certificationDTO.getIssuer());
            certification.setIssueDate(certificationDTO.getIssueDate());
            certification.setResume(resume);

            Certification savedCertification = certificationRepository.save(certification);

            return new CertificationDTO(savedCertification.getId(), savedCertification.getCertificationName(), savedCertification.getIssuer(), savedCertification.getIssueDate());
        }
        throw new RuntimeException("Resume not found");
    }

    // Certification 항목 데이터 삭제
    @Transactional
    public void deleteCertification(int resumeId, int certificationId) {
        Optional<Certification> certification = certificationRepository.findByIdAndResumeId(certificationId, resumeId);
        certification.ifPresent(certificationRepository::delete);
    }

    // Education 항목 데이터 저장 또는 업데이트
    @Transactional
    public EducationDTO saveOrUpdateEducation(int resumeId, EducationDTO educationDTO) {
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        if (optionalResume.isPresent()) {
            Resume resume = optionalResume.get();
            Education education = educationRepository.findByIdAndResumeId(educationDTO.getId(), resumeId)
                    .orElse(new Education());

            boolean isNew = (education.getId() == null); // 새로운 항목인지 확인

            education.setSchoolName(educationDTO.getSchoolName());
            education.setMajor(educationDTO.getMajor());
            education.setEnrollmentPeriod(educationDTO.getEnrollmentPeriod());
            education.setStatus(educationDTO.getStatus());
            education.setResume(resume);

            Education savedEducation = educationRepository.save(education);

            return new EducationDTO(savedEducation.getId(), savedEducation.getSchoolName(), savedEducation.getMajor(), savedEducation.getEnrollmentPeriod(), savedEducation.getStatus());
        }
        throw new RuntimeException("Resume not found");
    }

    // Education 항목 데이터 삭제
    @Transactional
    public void deleteEducation(int resumeId, int educationId) {
        Optional<Education> education = educationRepository.findByIdAndResumeId(educationId, resumeId);
        education.ifPresent(educationRepository::delete);
    }

    // EducationCompletion 항목 데이터 저장 또는 업데이트
    @Transactional
    public EducationCompletionDTO saveOrUpdateEducationCompletion(int resumeId, EducationCompletionDTO educationCompletionDTO) {
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        if (optionalResume.isPresent()) {
            Resume resume = optionalResume.get();
            EducationCompletion educationCompletion = educationCompletionRepository.findByIdAndResumeId(educationCompletionDTO.getId(), resumeId)
                    .orElse(new EducationCompletion());

            boolean isNew = (educationCompletion.getId() == null); // 새로운 항목인지 확인

            educationCompletion.setCourseName(educationCompletionDTO.getCourseName());
            educationCompletion.setInstitution(educationCompletionDTO.getInstitution());
            educationCompletion.setStartDate(educationCompletionDTO.getStartDate());
            educationCompletion.setEndDate(educationCompletionDTO.getEndDate());
            educationCompletion.setResume(resume);

            EducationCompletion savedEducationCompletion = educationCompletionRepository.save(educationCompletion);

            return new EducationCompletionDTO(savedEducationCompletion.getId(), savedEducationCompletion.getCourseName(), savedEducationCompletion.getInstitution(), savedEducationCompletion.getStartDate(), savedEducationCompletion.getEndDate());
        }
        throw new RuntimeException("Resume not found");
    }

    // EducationCompletion 항목 데이터 삭제
    @Transactional
    public void deleteEducationCompletion(int resumeId, int educationCompletionId) {
        Optional<EducationCompletion> educationCompletion = educationCompletionRepository.findByIdAndResumeId(educationCompletionId, resumeId);
        educationCompletion.ifPresent(educationCompletionRepository::delete);
    }

    // Language 항목 데이터 저장 또는 업데이트
    @Transactional
    public LanguageDTO saveOrUpdateLanguage(int resumeId, LanguageDTO languageDTO) {
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        if (optionalResume.isPresent()) {
            Resume resume = optionalResume.get();
            Language language = languageRepository.findByIdAndResumeId(languageDTO.getId(), resumeId)
                    .orElse(new Language());

            boolean isNew = (language.getId() == null); // 새로운 항목인지 확인

            language.setLanguage(languageDTO.getLanguage());
            language.setTestName(languageDTO.getTestName());
            language.setScore(languageDTO.getScore());
            language.setDate(languageDTO.getDate());
            language.setResume(resume);

            Language savedLanguage = languageRepository.save(language);

            return new LanguageDTO(savedLanguage.getId(), savedLanguage.getLanguage(), savedLanguage.getTestName(), savedLanguage.getScore(), savedLanguage.getDate());
        }
        throw new RuntimeException("Resume not found");
    }

    // Language 항목 데이터 삭제
    @Transactional
    public void deleteLanguage(int resumeId, int languageId) {
        Optional<Language> language = languageRepository.findByIdAndResumeId(languageId, resumeId);
        language.ifPresent(languageRepository::delete);
    }

    // PersonalInfo 항목 데이터 저장 또는 업데이트
    @Transactional
    public PersonalInfoDTO saveOrUpdatePersonalInfo(int resumeId, PersonalInfoDTO personalInfoDTO) {
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        if (optionalResume.isPresent()) {
            Resume resume = optionalResume.get();
            PersonalInfo personalInfo = personalInfoRepository.findByIdAndResumeId(personalInfoDTO.getId(), resumeId)
                    .orElse(new PersonalInfo());

            boolean isNew = (personalInfo.getId() == null); // 새로운 항목인지 확인

            personalInfo.setPhoto(personalInfoDTO.getPhoto());
            personalInfo.setName(personalInfoDTO.getName());
            personalInfo.setJobTitle(personalInfoDTO.getJobTitle());
            personalInfo.setEmail(personalInfoDTO.getEmail());
            personalInfo.setPhoneNumber(personalInfoDTO.getPhoneNumber());
            personalInfo.setBlog(personalInfoDTO.getBlog());
            personalInfo.setIntroduction(personalInfoDTO.getIntroduction());
            personalInfo.setResume(resume);

            PersonalInfo savedPersonalInfo = personalInfoRepository.save(personalInfo);

            return new PersonalInfoDTO(savedPersonalInfo.getId(), savedPersonalInfo.getPhoto(), savedPersonalInfo.getName(), savedPersonalInfo.getJobTitle(), savedPersonalInfo.getEmail(), savedPersonalInfo.getPhoneNumber(), savedPersonalInfo.getBlog(), savedPersonalInfo.getIntroduction());
        }
        throw new RuntimeException("Resume not found");
    }

    // PersonalInfo 항목 데이터 삭제
    @Transactional
    public void deletePersonalInfo(int resumeId, int personalInfoId) {
        Optional<PersonalInfo> personalInfo = personalInfoRepository.findByIdAndResumeId(personalInfoId, resumeId);
        personalInfo.ifPresent(personalInfoRepository::delete);
    }

    // 이력서 저장
    @Transactional
    public void saveResume(int resumeId, ResumeDTO resumeDTO) {
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        if (optionalResume.isPresent()) {
            Resume resume = optionalResume.get();
            resume.setTitle(resumeDTO.getTitle());

            List<Activity> activities = resumeDTO.getActivities().stream()
                    .map(activityDTO -> new Activity(activityDTO.getId(), activityDTO.getActivityName(), activityDTO.getOrganizationName(), activityDTO.getStartDate(), activityDTO.getEndDate(), resume))
                    .collect(Collectors.toList());
            resume.setActivities(activities);

            List<Award> awards = resumeDTO.getAwards().stream()
                    .map(awardDTO -> new Award(awardDTO.getId(), awardDTO.getAwardName(), awardDTO.getAwardingInstitution(), awardDTO.getDate(), awardDTO.getDescription(), resume))
                    .collect(Collectors.toList());
            resume.setAwards(awards);

            List<Certification> certifications = resumeDTO.getCertifications().stream()
                    .map(certificationDTO -> new Certification(certificationDTO.getId(), certificationDTO.getCertificationName(), certificationDTO.getIssuer(), certificationDTO.getIssueDate(), resume))
                    .collect(Collectors.toList());
            resume.setCertifications(certifications);

            List<Education> educations = resumeDTO.getEducations().stream()
                    .map(educationDTO -> new Education(educationDTO.getId(), educationDTO.getSchoolName(), educationDTO.getMajor(), educationDTO.getEnrollmentPeriod(), educationDTO.getStatus(), resume))
                    .collect(Collectors.toList());
            resume.setEducations(educations);

            List<EducationCompletion> educationCompletions = resumeDTO.getEducationCompletions().stream()
                    .map(educationCompletionDTO -> new EducationCompletion(educationCompletionDTO.getId(), educationCompletionDTO.getCourseName(), educationCompletionDTO.getInstitution(), educationCompletionDTO.getStartDate(), educationCompletionDTO.getEndDate(), resume))
                    .collect(Collectors.toList());
            resume.setEducationCompletions(educationCompletions);

            List<Language> languages = resumeDTO.getLanguages().stream()
                    .map(languageDTO -> new Language(languageDTO.getId(), languageDTO.getLanguage(), languageDTO.getTestName(), languageDTO.getScore(), languageDTO.getDate(), resume))
                    .collect(Collectors.toList());
            resume.setLanguages(languages);

            List<PersonalInfo> personalInfos = resumeDTO.getPersonalInfos().stream()
                    .map(personalInfoDTO -> new PersonalInfo(personalInfoDTO.getId(), personalInfoDTO.getPhoto(), personalInfoDTO.getName(), personalInfoDTO.getJobTitle(), personalInfoDTO.getEmail(), personalInfoDTO.getPhoneNumber(), personalInfoDTO.getBlog(), personalInfoDTO.getIntroduction(), resume))
                    .collect(Collectors.toList());
            resume.setPersonalInfos(personalInfos);

            resumeRepository.save(resume);
        }
    }

    // 특정 이력서 조회
    public ResumeDTO getResumeByResumeId(int resumeId) {
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        if (optionalResume.isPresent()) {
            Resume resume = optionalResume.get();

            List<ActivityDTO> activityDTOS = resume.getActivities().stream()
                    .map(activity -> new ActivityDTO(activity.getId(), activity.getActivityName(), activity.getOrganizationName(), activity.getStartDate(), activity.getEndDate()))
                    .collect(Collectors.toList());

            List<AwardDTO> awardDTOs = resume.getAwards().stream()
                    .map(award -> new AwardDTO(award.getId(), award.getAwardName(), award.getAwardingInstitution(), award.getDate(), award.getDescription()))
                    .collect(Collectors.toList());

            List<CertificationDTO> certificationDTOS = resume.getCertifications().stream()
                    .map(certification -> new CertificationDTO(certification.getId(), certification.getCertificationName(), certification.getIssuer(), certification.getIssueDate()))
                    .collect(Collectors.toList());

            List<EducationDTO> educationDTOS = resume.getEducations().stream()
                    .map(education -> new EducationDTO(education.getId(), education.getSchoolName(), education.getMajor(), education.getEnrollmentPeriod(), education.getStatus()))
                    .collect(Collectors.toList());

            List<EducationCompletionDTO> educationCompletionDTOS = resume.getEducationCompletions().stream()
                    .map(educationCompletion -> new EducationCompletionDTO(educationCompletion.getId(), educationCompletion.getCourseName(), educationCompletion.getInstitution(), educationCompletion.getStartDate(), educationCompletion.getEndDate()))
                    .collect(Collectors.toList());

            List<LanguageDTO> languageDTOs = resume.getLanguages().stream()
                    .map(language -> new LanguageDTO(language.getId(), language.getLanguage(), language.getTestName(), language.getScore(), language.getDate()))
                    .collect(Collectors.toList());

            List<PersonalInfoDTO> personalInfoDTOS = resume.getPersonalInfos().stream()
                    .map(personalInfo -> new PersonalInfoDTO(personalInfo.getId(), personalInfo.getPhoto(), personalInfo.getName(), personalInfo.getJobTitle(), personalInfo.getEmail(), personalInfo.getPhoneNumber(), personalInfo.getBlog(), personalInfo.getIntroduction()))
                    .collect(Collectors.toList());


            return new ResumeDTO(resume.getId(), resume.getTitle(), resume.getCreatedAt(), activityDTOS, awardDTOs, certificationDTOS, educationDTOS, educationCompletionDTOS, languageDTOs, personalInfoDTOS );
        }
        return null;
    }

    // 모든 이력서 조회
    public List<ResumeDTO> getAllResumes() {
        List<Resume> resumes = resumeRepository.findAll();
        return resumes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // 이력서를 DTO로 변환
    private ResumeDTO convertToDTO(Resume resume) {

        List<ActivityDTO> activities = activityRepository.findByResumeId(resume.getId())
                .stream()
                .map(activity -> new ActivityDTO(activity.getId(), activity.getActivityName(), activity.getOrganizationName(), activity.getStartDate(), activity.getEndDate()))
                .collect(Collectors.toList());

        List<AwardDTO> awards = awardRepository.findByResumeId(resume.getId())
                .stream()
                .map(award -> new AwardDTO(award.getId(), award.getAwardName(), award.getAwardingInstitution(), award.getDate(), award.getDescription()))
                .collect(Collectors.toList());

        List<CertificationDTO> certifications = certificationRepository.findByResumeId(resume.getId())
                .stream()
                .map(certification -> new CertificationDTO(certification.getId(), certification.getCertificationName(), certification.getIssuer(), certification.getIssueDate()))
                .collect(Collectors.toList());

        List<EducationDTO> educations = educationRepository.findByResumeId(resume.getId())
                .stream()
                .map(education -> new EducationDTO(education.getId(), education.getSchoolName(), education.getMajor(), education.getEnrollmentPeriod(), education.getStatus()))
                .collect(Collectors.toList());

        List<EducationCompletionDTO> educationCompletions = educationCompletionRepository.findByResumeId(resume.getId())
                .stream()
                .map(educationCompletion -> new EducationCompletionDTO(educationCompletion.getId(), educationCompletion.getCourseName(), educationCompletion.getInstitution(), educationCompletion.getStartDate(), educationCompletion.getEndDate()))
                .collect(Collectors.toList());

        List<LanguageDTO> languages = languageRepository.findByResumeId(resume.getId())
                .stream()
                .map(language -> new LanguageDTO(language.getId(), language.getLanguage(), language.getTestName(), language.getScore(), language.getDate()))
                .collect(Collectors.toList());

        List<PersonalInfoDTO> personalInfos = personalInfoRepository.findByResumeId(resume.getId())
                .stream()
                .map(personalInfo -> new PersonalInfoDTO(personalInfo.getId(), personalInfo.getPhoto(), personalInfo.getName(), personalInfo.getJobTitle(), personalInfo.getEmail(), personalInfo.getPhoneNumber(), personalInfo.getBlog(), personalInfo.getIntroduction()))
                .collect(Collectors.toList());


        return new ResumeDTO(resume.getId(), resume.getTitle(), resume.getCreatedAt(), activities, awards, certifications, educations, educationCompletions, languages, personalInfos );
    }

    // 특정 사용자의 모든 이력서 조회
    public List<ResumeDTO> getAllResumesByUser(String userId) {
        List<Resume> resumes = resumeRepository.findByUserId(userId);
        return resumes.stream().map(resume -> new ResumeDTO(resume.getId(), resume.getTitle(), resume.getCreatedAt(), null, null, null, null, null, null, null)).collect(Collectors.toList());
    }

    // 새로운 이력서 생성
    @Transactional
    public Resume createResume(String title, String userId) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            Resume resume = new Resume();
            resume.setTitle(title);
            resume.setUser(user);
            resume = resumeRepository.save(resume);
            return resume;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    // 이력서 삭제
    @Transactional
    public void deleteResumeByResumeId(int resumeId) {
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        optionalResume.ifPresent(resumeRepository::delete);
    }

    // 이력서 제목 저장
    @Transactional
    public ResumeDTO saveResumeTitleByResumeId(int resumeId, String newTitle) {
        Optional<Resume> optionalResume = resumeRepository.findById(resumeId);
        if (optionalResume.isPresent()) {
            Resume resume = optionalResume.get();
            resume.setTitle(newTitle);
            resumeRepository.save(resume);
            return new ResumeDTO(resume.getId(), resume.getTitle(), resume.getCreatedAt(), null, null, null, null, null, null, null);
        }
        return null;
    }
}

