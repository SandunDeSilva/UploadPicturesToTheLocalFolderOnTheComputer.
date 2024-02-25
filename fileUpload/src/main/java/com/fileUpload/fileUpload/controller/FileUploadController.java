package com.fileUpload.fileUpload.controller;

import com.fileUpload.fileUpload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadService fIleUploadService;

    @PostMapping("api/v1/aiupload")
    public String uploadFile(
            @RequestParam("CustomerID") String pCustomerID,
            @RequestParam("file") MultipartFile pFile,
            @RequestParam("IdentifiedObject") String pIdentifiedObject) throws Exception {

        return fIleUploadService.uplaod(pCustomerID, pFile, pIdentifiedObject);
    }
}
