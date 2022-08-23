package com.student.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.request.models.Application_details;

public interface ApplicationDetailsRepository extends JpaRepository<Application_details,Integer> {

}
