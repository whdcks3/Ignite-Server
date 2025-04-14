package ignite.api.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service {

    private final AmazonS3 s3Client;
    private final String bucketName;

    public S3Service(
            @Value("${aws.s3.bucket}") String bucketName,
            @Value("${aws.s3.region}") String region,
            @Value("${aws.s3.access-key}") String accessKey,
            @Value("${aws.s3.secret-key}") String secretKey) {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        this.s3Client = new AmazonS3Client(credentials);
        this.bucketName = bucketName;
    }

    private File convertMultiPart2File(MultipartFile file) throws IOException {
        File convertedFile = File.createTempFile("temp" + new Date().getTime(), null);
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(file.getBytes());
        fos.close();
        return convertedFile;
    }

    public String getFileUrl(String fileName) {
        return "https://" + bucketName + ".s3.amazonaws.com/" + fileName;
    }

    public String uploadFile(MultipartFile file) {
        try {
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            File tempFile = convertMultiPart2File(file);

            s3Client.putObject(new PutObjectRequest(bucketName, filename, tempFile)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
            tempFile.delete();

            return filename;
        } catch (IOException e) {
            throw new RuntimeException("파일 업로드 실패");
        }
    }

    public void deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
    }
}
