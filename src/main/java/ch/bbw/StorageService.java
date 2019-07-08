package ch.bbw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
  private final Path rootLocation = Paths.get("upload-dir");

  public String store(MultipartFile file) {
    String path;
    try {
      if (!file.getOriginalFilename().endsWith(".jpg") && !file.getOriginalFilename().endsWith(".png") && !file.getOriginalFilename().endsWith(".jpeg")) {
        throw new RuntimeException("Uploaded File is not a picture!");
      }
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
      if (!Files.exists(Paths.get("upload-dir/"))) {
        Files.createDirectory(Paths.get("upload-dir/"));
      }

      Path rootPath = Paths.get((path = "upload-dir/" + sdf.format(new Date()) + "/"));
      path = path.concat(file.getOriginalFilename());
      Files.createDirectory(rootPath);
      Files.copy(file.getInputStream(), rootPath.resolve(file.getOriginalFilename()));
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("FAIL!");
    }
    return path;
  }

  public void init() {
    if (!Files.exists(rootLocation)) {
      try {
        Files.createDirectory(rootLocation);
      } catch (IOException e) {
        throw new RuntimeException("Could not initialize storage!");
      }
    }

  }
}
