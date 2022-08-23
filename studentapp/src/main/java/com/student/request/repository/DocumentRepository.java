package com.student.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.request.models.DocumentDetails;


@Repository
public interface DocumentRepository extends JpaRepository<DocumentDetails, Integer> {

}
