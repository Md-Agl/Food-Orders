package com.md.food.foodorder.helper;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Slf4j
public class FileHelper {

    private final String uploadPath = "uploads";
    private final Path rootLocation = Paths.get(uploadPath);

    //upload file
    public String uploadFile(MultipartFile file) {
        //create folder if it doesn't exist
        createUploadFolderIfNotExist();

        String originalFilename = file.getOriginalFilename();
        // Generate a unique file name to avoid conflicts
        String uniqueFilename = UUID.randomUUID().toString() + "_" + originalFilename;

        try {
            // Save the file to the local system
            Path destinationFile = this.rootLocation.resolve(uniqueFilename);
            Files.copy(file.getInputStream(), destinationFile);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file: " + file.getOriginalFilename());
        }

        return uniqueFilename;
    }

    //create folder if it doesn't exist
    private void createUploadFolderIfNotExist() {
        log.info("Trying to upload create folder if doesn't exist");
        try {
            //if uploadPath doesn't exist
            if (Files.notExists(rootLocation)) {
                Files.createDirectories(rootLocation);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while trying to upload file");
        }
    }

    public boolean deleteUploadFile(String fileUrl) {
        try {
            Path filePath = rootLocation.resolve(fileUrl);  //make path url
            Files.delete(filePath);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}