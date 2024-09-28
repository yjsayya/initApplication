package com.example.initmodule.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class fileUtils {

    /**
     * 저장할 파일과 업로드할 디렉토리 위치를 받으면 - 파일을 저장한다.
     * @param fileToUpload
     * @param uploadDir
     * @return 최종 업로드/dir/파일이름.파일확장자
     */
    public static String saveFileLogic(MultipartFile fileToUpload, String uploadDir) {
        // 1. file에서 필요한 정보 추출
        String[] fileInfo = getFileInfo(fileToUpload);
        String fileName = fileInfo[0];
        String extension = (fileInfo[1] == null || "".equals(fileInfo[1])) ? ".txt" : fileInfo[1];
        // 2. 필요한 정보 가공 단계
        String uploadFileName = makeFileName(fileName, uploadDir);

        // 3. 파일 업로드
        saveFile(fileToUpload, uploadDir, uploadFileName);

        return uploadFileName;
    }

    public static void updateFileLogic(MultipartFile fileToUpload, String uploadDir) {
        // 기존꺼 삭제

        // 다시 필요한 정보 가공

        // 다시 저장
    }

    private static void saveFile(MultipartFile fileToUpload, String uploadDir, String uploadFileName) {
        try {
            File file = new File(uploadDir + uploadFileName);
            fileToUpload.transferTo(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFile(String uploadDir, String fileName) {
        Path filePath = Paths.get(uploadDir, fileName);
        if (!Files.exists(filePath))
            throw new IllegalArgumentException("No File");
        try {
            Files.delete(filePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String[] getFileInfo(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName == null || file.isEmpty()) {
            return null;
        }
        String extenstion = getFileExtension(fileName);
//        long fileSize = file.getSize(); // byte 단위로 뽑아줌

        return new String[] {fileName, extenstion};
    }

    private static String getFileExtension(String fileName) {
        int lastIndexOfDot = fileName.lastIndexOf('.');
        if (lastIndexOfDot == -1) {
            return "";
        }
        return fileName.substring(lastIndexOfDot + 1).toLowerCase();
    }

    /**
     * 파일 이름 규칙을 정한 다음에 넣으면 된다.
     * ex) yyyymmddhh24miss_filename.jpg
     */
    private static String makeFileName(String fileName, String uploadDir) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return currentDateTime.format(formatter) + "_" + fileName;
    }

}