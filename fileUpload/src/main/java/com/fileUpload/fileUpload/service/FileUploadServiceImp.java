package com.fileUpload.fileUpload.service;

import com.fileUpload.fileUpload.entity.FileUploadEntity;
import com.fileUpload.fileUpload.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class FileUploadServiceImp implements FileUploadService {
    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Value("${upload.image.path}")
    private String uploadImagePath;

    @Override
    public String uplaod(
            String pCustomerID,
            MultipartFile file,
            String pIdentifiedObject) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence "
                        + fileName);
            }

            LocalDateTime currentDateTime = LocalDateTime.now();

            FileUploadEntity newObjectAIEntity = new FileUploadEntity(pCustomerID,
                    currentDateTime,
                    fileName,
                    (currentDateTime.toString() + "_" + fileName),
                    pIdentifiedObject);

            try {
                fileUploadRepository.save(newObjectAIEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }

            File newFile = new File(uploadImagePath
                    + "\\" + (new Date()).getTime() + "_" + fileName);

            // Transfer the content of MultipartFile to the file
            file.transferTo(newFile);

            return "Successfully Inserted!";
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }

}
