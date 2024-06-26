// ResumeController.java
package com.devdoc.backend.controller;

import com.devdoc.backend.dto.*;
import com.devdoc.backend.model.Resume;
import com.devdoc.backend.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    /* Activity 관련 메소드 시작 */
    @PostMapping("/{resumeId}/activities")
    public ResponseEntity<ActivityDTO> saveOrUpdateActivity(@PathVariable int resumeId, @RequestBody ActivityDTO activityDTO) {
        try {
            ActivityDTO updatedActivity = resumeService.saveOrUpdateActivity(resumeId, activityDTO);
            return ResponseEntity.ok(updatedActivity); // 업데이트된 activity 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 서버 에러 발생 시 500 반환
        }
    }

    // Activity 데이터 삭제
    @DeleteMapping("/{resumeId}/activities/{activityId}")
    public ResponseEntity<Void> deleteActivity(@PathVariable int resumeId, @PathVariable int activityId) {
        try {
            resumeService.deleteCertification(resumeId, activityId);
            return ResponseEntity.noContent().build(); // certification 데이터 삭제 후 no content 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Activity 데이터 수정
    @PutMapping("/{resumeId}/activities")
    public ResponseEntity<ActivityDTO> updateActivity(@PathVariable int resumeId, @RequestBody ActivityDTO activityDTO) {
        try {
            ActivityDTO updatedActivity = resumeService.saveOrUpdateActivity(resumeId, activityDTO);
            return ResponseEntity.ok(updatedActivity); // 수정된 certification 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* Activity 관련 메소드 끝 */
    /* Award 관련 메소드 시작 */

    // Award 데이터 저장 또는 수정
    @PostMapping("/{resumeId}/awards")
    public ResponseEntity<AwardDTO> saveOrUpdateAward(@PathVariable int resumeId, @RequestBody AwardDTO awardDTO) {
        try {
            AwardDTO updatedAward = resumeService.saveOrUpdateAward(resumeId, awardDTO);
            return ResponseEntity.ok(updatedAward); // 수정된 Award 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Award 데이터 삭제
    @DeleteMapping("/{resumeId}/awards/{awardId}")
    public ResponseEntity<Void> deleteAward(@PathVariable int resumeId, @PathVariable int awardId) {
        try {
            resumeService.deleteAward(resumeId, awardId);
            return ResponseEntity.noContent().build(); //Award 데이터 삭제 후 no content 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Award 데이터 수정
    @PutMapping("/{resumeId}/awards")
    public ResponseEntity<AwardDTO> updateAward(@PathVariable int resumeId, @RequestBody AwardDTO awardDTO) {
        try {
            AwardDTO updatedAward = resumeService.saveOrUpdateAward(resumeId, awardDTO);
            return ResponseEntity.ok(updatedAward); // 업데이트된 Award 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* Award 관련 메소드 끝 */
    /* Education 관련 메소드 시작 */

    // Education 데이터 저장 또는 수정
    @PostMapping("/{resumeId}/education")
    public ResponseEntity<EducationDTO> saveOrUpdateEducation(@PathVariable int resumeId, @RequestBody EducationDTO educationDTO) {
        try {
            EducationDTO updatedEducation = resumeService.saveOrUpdateEducation(resumeId, educationDTO);
            return ResponseEntity.ok(updatedEducation); // 업데이트된 education 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 서버 에러 발생 시 500 반환
        }
    }

    // Education 데이터 삭제
    @DeleteMapping("/{resumeId}/education/{educationId}")
    public ResponseEntity<Void> deleteEducation(@PathVariable int resumeId, @PathVariable int educationId) {
        try {
            resumeService.deleteEducation(resumeId, educationId);
            return ResponseEntity.noContent().build(); // education 데이터 삭제 후 no content 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Education 데이터 수정
    @PutMapping("/{resumeId}/education")
    public ResponseEntity<EducationDTO> updateEducation(@PathVariable int resumeId, @RequestBody EducationDTO educationDTO) {
        try {
            EducationDTO updatedEducation = resumeService.saveOrUpdateEducation(resumeId, educationDTO);
            return ResponseEntity.ok(updatedEducation); // 수정된 education 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* Education 관련 메소드 끝 */

    // Training 데이터 저장 또는 수정
    @PostMapping("/{resumeId}/training")
    public ResponseEntity<TrainingDTO> saveOrUpdateTraining(@PathVariable int resumeId, @RequestBody TrainingDTO trainingDTO) {
        try {
            TrainingDTO updatedTraining = resumeService.saveOrUpdateTraining(resumeId, trainingDTO);
            return ResponseEntity.ok(updatedTraining); // 업데이트된 Training 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 서버 에러 발생 시 500 반환
        }
    }

    // Training 데이터 삭제
    @DeleteMapping("/{resumeId}/training/{trainingId}")
    public ResponseEntity<Void> deleteTriaing(@PathVariable int resumeId, @PathVariable int trainingId) {
        try {
            resumeService.deleteTraining(resumeId, trainingId);
            return ResponseEntity.noContent().build(); // educationCompletion 데이터 삭제 후 no content 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Training 데이터 수정
    @PutMapping("/{resumeId}/training")
    public ResponseEntity<TrainingDTO> updateTraining(@PathVariable int resumeId, @RequestBody TrainingDTO trainingDTO) {
        try {
            TrainingDTO updatedTraining = resumeService.saveOrUpdateTraining(resumeId, trainingDTO);
            return ResponseEntity.ok(updatedTraining); // 수정된 educationCompletion 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* Training 관련 메소드 끝 */




    /* Certification 관련 메소드 시작 */
    @PostMapping("/{resumeId}/certification")
    public ResponseEntity<CertificationDTO> saveOrUpdateCertification(@PathVariable int resumeId, @RequestBody CertificationDTO certificationDTO) {
        try {
            CertificationDTO updatedCertification = resumeService.saveOrUpdateCertification(resumeId, certificationDTO);
            return ResponseEntity.ok(updatedCertification); // 업데이트된 certification 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 서버 에러 발생 시 500 반환
        }
    }

    // Certification 데이터 삭제
    @DeleteMapping("/{resumeId}/certification/{certificationId}")
    public ResponseEntity<Void> deleteCertification(@PathVariable int resumeId, @PathVariable int certificationId) {
        try {
            resumeService.deleteCertification(resumeId, certificationId);
            return ResponseEntity.noContent().build(); // certification 데이터 삭제 후 no content 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Certification 데이터 수정
    @PutMapping("/{resumeId}/certification")
    public ResponseEntity<CertificationDTO> updateCertification(@PathVariable int resumeId, @RequestBody CertificationDTO certificationDTO) {
        try {
            CertificationDTO updatedCertification = resumeService.saveOrUpdateCertification(resumeId, certificationDTO);
            return ResponseEntity.ok(updatedCertification); // 수정된 certification 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* Certification 관련 메소드 끝 */
    /* Language 관련 메소드 시작 */

    // language 데이터 저장 또는 수정
    @PostMapping("/{resumeId}/languages")
    public ResponseEntity<LanguageDTO> saveOrUpdateLanguage(@PathVariable int resumeId, @RequestBody LanguageDTO languageDTO) {
        try {
            LanguageDTO updatedLanguage = resumeService.saveOrUpdateLanguage(resumeId, languageDTO);
            return ResponseEntity.ok(updatedLanguage); // 업데이트된 language 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 서버 에러 발생 시 500 반환
        }
    }

    // language 데이터 삭제
    @DeleteMapping("/{resumeId}/languages/{languageId}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable int resumeId, @PathVariable int languageId) {
        try {
            resumeService.deleteLanguage(resumeId, languageId);
            return ResponseEntity.noContent().build(); // language 데이터 삭제 후 no content 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // language 데이터 수정
    @PutMapping("/{resumeId}/languages")
    public ResponseEntity<LanguageDTO> updateLanguage(@PathVariable int resumeId, @RequestBody LanguageDTO languageDTO) {
        try {
            LanguageDTO updatedLanguage = resumeService.saveOrUpdateLanguage(resumeId, languageDTO);
            return ResponseEntity.ok(updatedLanguage); // 수정된 language 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* Language 관련 메소드 끝 */

    // AboutMe 데이터 저장 또는 수정
    @PostMapping("/{resumeId}/aboutMe")
    public ResponseEntity<AboutMeDTO> saveOrUpdateAboutMe(@PathVariable int resumeId, @RequestBody AboutMeDTO aboutMeDTO) {
        try {
            AboutMeDTO updatedAboutMe = resumeService.saveOrUpdateAboutMe(resumeId, aboutMeDTO);
            return ResponseEntity.ok(updatedAboutMe); // 업데이트된 AboutMe 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 서버 에러 발생 시 500 반환
        }
    }

    // AboutMe 데이터 삭제
    @DeleteMapping("/{resumeId}/aboutMe/{aboutMeId}")
    public ResponseEntity<Void> deleteAboutMe(@PathVariable int resumeId, @PathVariable int aboutMeId) {
        try {
            resumeService.deleteAboutMe(resumeId, aboutMeId);
            return ResponseEntity.noContent().build(); // AboutMe 데이터 삭제 후 no content 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // AboutMe 데이터 수정
    @PutMapping("/{resumeId}/aboutMe")
    public ResponseEntity<AboutMeDTO> updateAboutMe(@PathVariable int resumeId, @RequestBody AboutMeDTO aboutMeDTO) {
        try {
            AboutMeDTO updatedAboutMe = resumeService.saveOrUpdateAboutMe(resumeId, aboutMeDTO);
            return ResponseEntity.ok(updatedAboutMe); // 수정된 AboutMe 데이터 반환
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* AboutMe 관련 메소드 끝 */


    // 이력서 저장
    @PostMapping("/{resumeId}/save")
    public ResponseEntity<?> saveResume(@PathVariable int resumeId, @RequestBody ResumeDTO resumeDTO) {
        try {
            resumeService.saveResume(resumeId, resumeDTO);
            return new ResponseEntity<>(HttpStatus.OK); // 이력서 저장 후 200 반환
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 서버 에러 발생 시 500 반환
        }
    }

    // 이력서 데이터 불러오기
    @GetMapping("/{resumeId}")
    public ResponseEntity<ResumeDTO> getResumeByResumeId(@PathVariable int resumeId) {
        try {
            ResumeDTO resumeDTO = resumeService.getResumeByResumeId(resumeId);
            if (resumeDTO != null) {
                return new ResponseEntity<>(resumeDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // User 의 Resume 목록 조회
    @GetMapping
    public ResponseEntity<List<ResumeDTO>> getAllResumesByUser(@AuthenticationPrincipal String userId) {
        try {
            List<ResumeDTO> resumes = resumeService.getAllResumesByUser(userId);
            return new ResponseEntity<>(resumes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ResumeId 생성 : SkillId x3 생성
    @PostMapping
    public ResponseEntity<Resume> createResume(@RequestBody String title, @AuthenticationPrincipal String userId) {
        try {
            Resume createdResume = resumeService.createResume(title, userId);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdResume);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // ResumeId 삭제
    @DeleteMapping("/{resumeId}")
    public ResponseEntity<Void> deleteResumeByResumeId(@PathVariable int resumeId) {
        try {
            resumeService.deleteResumeByResumeId(resumeId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // ResumeId 업데이트 : Title만
    @PutMapping("/{resumeId}/title")
    public ResponseEntity<ResumeDTO> saveResumeTitleByResumeId(
            @PathVariable int resumeId,
            @RequestBody String newTitle) {
        try {
            ResumeDTO updatedResume = resumeService.saveResumeTitleByResumeId(resumeId, newTitle);
            if (updatedResume != null) {
                return ResponseEntity.ok(updatedResume);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
