package com.practice.User.service;

import com.practice.exceptions.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Map;

@Service
public class CloudinaryService {

    // Constantes
    private static final String[] SUPPORTED_IMAGE_TYPES = {"image/jpeg", "image/png", "image/gif", "image/bmp", "image/webp"};
    private static final long MAX_FILE_SIZE = 5 * 1024 * 1024; // 5 MB

    private final Cloudinary cloudinary;

    public CloudinaryService() {
        // Intenta obtener la URL de Cloudinary primero de System.getenv()
        String cloudinaryUrl = System.getenv("CLOUDINARY_URL");

        // Si no está en las variables del sistema, intenta con Dotenv como fallback
        if (cloudinaryUrl == null || cloudinaryUrl.isEmpty()) {
            try {
                Dotenv dotenv = Dotenv.load();
                cloudinaryUrl = dotenv.get("CLOUDINARY_URL");
            } catch (Exception e) {
                throw new IllegalStateException("CLOUDINARY_URL is not set in the environment variables.");
            }
        }

        // Validación final
        if (cloudinaryUrl == null || cloudinaryUrl.isEmpty()) {
            throw new IllegalStateException("CLOUDINARY_URL is not set in the environment variables.");
        }

        this.cloudinary = new Cloudinary(cloudinaryUrl);
    }

    public String uploadImage(MultipartFile file) throws IOException {
        // Validar que el archivo no sea nulo o vacío
        if (file == null || file.isEmpty()) {
            throw new InvalidFileException("El archivo no puede ser nulo o vacío.");
        }

        // Validar que el archivo sea una imagen
        if (!isImage(file)) {
            throw new InvalidFileException("El archivo debe ser una imagen (jpg, png, gif, bmp, webp).");
        }

        // Validar el tamaño del archivo
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new InvalidFileException("El archivo debe tener un tamaño menor a 5 MB.");
        }

        try {
            // Subir imagen a Cloudinary
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap(
                            "use_filename", true,
                            "unique_filename", false,
                            "overwrite", true
                    ));
            String imageUrl = uploadResult.get("url").toString();
            return imageUrl;
        } catch (IOException e) {
            throw new CloudinaryUploadException("Error al subir imagen a Cloudinary", e);
        }
    }

    // Método para validar si el archivo es una imagen
    private boolean isImage(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType == null) {
            return false;
        }

        for (String supportedType : SUPPORTED_IMAGE_TYPES) {
            if (contentType.equals(supportedType)) {
                return true;
            }
        }

        return false;
    }
}
