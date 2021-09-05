package cloud.carles.amuleplex.application.services.download;

import cloud.carles.amuleplex.application.ApplicationProperties;
import cloud.carles.amuleplex.application.dto.download.DeleteIncomingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class IncomingFileRemover {
    @Autowired
    private ApplicationProperties properties;

    public void remove(DeleteIncomingDTO request) throws IOException {
        Files.delete(Paths.get(properties.getAmuleIncomingDirectory() + "/" + request.getFileName()));
    }
}
