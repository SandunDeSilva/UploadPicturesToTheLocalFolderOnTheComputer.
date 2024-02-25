package com.fileUpload.fileUpload.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    String uplaod(String pCustomerID, MultipartFile file, String pIdentifiedObject) throws Exception;

}
