package it.epicode.d5w6_test.cloudinary;

import com.cloudinary.Cloudinary;
import it.epicode.d5w6_test.exceptions.UploadException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryService {
    private final Cloudinary cloudinary;

    public Map uploader(MultipartFile file, String folder) {

        try {
            Map result =
                    cloudinary
                            .uploader()
                            .upload(file.getBytes(),
                                    Cloudinary.asMap("folder", folder, "public_id", file.getOriginalFilename()));
            return result;
        } catch (IOException e) {
            throw new UploadException("Upload error " + file.getOriginalFilename());
        }


    }
}
