package kr.ac.knu.knures.controller;

import kr.ac.knu.knures.api.response.UploadImageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class UploadController {
    @Value("${uploadImage.path}")
    String uploadImgPath;

    @PostMapping("/uploadImage")
    public ResponseEntity<UploadImageResponse> uploadImages(MultipartFile[] uploadFiles) {
        // 이미지는 3개까지만 받는다
        if (uploadFiles.length > 3) {
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<String> fileNames = new ArrayList<>();
        for (MultipartFile file : uploadFiles) {
            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") +1);
            String uuid = UUID.randomUUID().toString(); // 난수 이름 생성

            String fileName = uuid + "." + extension;
            String savePath = uploadImgPath + File.separator + fileName;
            Path path = Paths.get(savePath);
            try {
                file.transferTo(path);
                fileNames.add(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int fileNameSize = fileNames.size();
        UploadImageResponse res = UploadImageResponse.builder()
                .imgURL1(fileNameSize >= 1 ? fileNames.get(0) : null)
                .imgURL2(fileNameSize >= 2 ? fileNames.get(1) : null)
                .imgURL3(fileNameSize >= 3 ? fileNames.get(2) : null)
                .msg("OK")
                .build();

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
