package ignite.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ignite.api.service.S3Service;

@RestController
@RequestMapping("/api/s3")
public class S3RestController {

    @Autowired
    S3Service s3Service;

    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadImages(@RequestParam("images") List<MultipartFile> images) {
        List<String> imageUrls = images.stream().map(s3Service::uploadFile).collect(Collectors.toList());
        return ResponseEntity.ok(imageUrls);
    }

}
