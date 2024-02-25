package com.fileUpload.fileUpload.repository;

import com.fileUpload.fileUpload.entity.FileUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUploadEntity,Integer> {
}
