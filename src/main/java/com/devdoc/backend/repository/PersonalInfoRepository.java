package com.devdoc.backend.repository;

import com.devdoc.backend.model.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Integer> {

    List<PersonalInfo> findByResumeId(Integer resumeId);
    Optional<PersonalInfo> findByIdAndResumeId(Integer id, Integer resumeId);
}
