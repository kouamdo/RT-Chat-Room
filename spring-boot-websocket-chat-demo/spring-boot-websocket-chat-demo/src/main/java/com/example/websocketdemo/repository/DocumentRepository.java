package com.example.websocketdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.websocketdemo.model.Document;


@Repository
public interface DocumentRepository extends JpaRepository<Document , Long> {

}
