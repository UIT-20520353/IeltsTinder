package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uit.se122.ieltstinder.config.ApplicationProperties;
import uit.se122.ieltstinder.service.ResourceService;
import uit.se122.ieltstinder.service.S3Service;
import uit.se122.ieltstinder.util.FileUtils;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    private final S3Service s3Service;

    @Override
    public void uploadAudio(MultipartFile audio) {
        byte[] bytes = FileUtils.checkAudioFile(audio);
        String key = "audio" + "-" + UUID.randomUUID() + ".mp3";

        String url = s3Service.uploadFile(key,"ieltstinder", bytes, List.of("audio"), audio.getContentType());
        System.out.println(url);
    }

    @Override
    public void uploadImage(MultipartFile image) {
        byte[] bytes = FileUtils.checkFile(image);
        String key = "audio" + "-" + UUID.randomUUID() + ".png";

        String url = s3Service.uploadFile(key,"ieltstinder", bytes, List.of("image"), image.getContentType());
        System.out.println(url);
    }
}
