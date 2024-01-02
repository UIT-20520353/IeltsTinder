package uit.se122.ieltstinder.service;

import org.springframework.web.multipart.MultipartFile;

public interface ResourceService {

    void uploadAudio(MultipartFile audio);
    void uploadImage(MultipartFile image);

}
