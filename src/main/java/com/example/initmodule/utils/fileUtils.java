package com.example.initmodule.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileUtils {

    /**
     * 저장할 파일과 업로드할 디렉토리 위치를 받으면 - 파일을 저장한다.
     * @param fileToUpload
     * @param uploadDir
     * @return 최종 업로드/dir/파일이름.파일확장자
     */

    public static void updateFileLogic(MultipartFile fileToUpload, String uploadDir) {
        // 기존꺼 삭제

        // 다시 필요한 정보 가공

        // 다시 저장
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

    public static void saveFile(MultipartFile fileToUpload, String uploadDir, String uploadFileName) {
        try {
            File file = new File(uploadDir + uploadFileName);
            fileToUpload.transferTo(file);
        } catch (IOException e) {
            throw new IllegalArgumentException("File Error");
        }
    }

    private static String[] getFileInfo(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if ("".equals(fileName) || file.isEmpty()) {
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

}