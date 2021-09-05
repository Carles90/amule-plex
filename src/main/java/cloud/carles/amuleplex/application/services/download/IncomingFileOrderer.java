package cloud.carles.amuleplex.application.services.download;

import cloud.carles.amuleplex.application.ApplicationProperties;
import cloud.carles.amuleplex.application.dto.download.OrderIncomingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class IncomingFileOrderer {
    @Autowired
    private ApplicationProperties properties;

    public void order(OrderIncomingDTO request) throws IOException {
        Files.move(
                Paths.get(properties.getAmuleIncomingDirectory() + "/" + request.getFileName()),
                this.getDestinationPath(request),
                StandardCopyOption.REPLACE_EXISTING
        );
    }

    public Path getDestinationPath(OrderIncomingDTO request) {
        if (request.getType().equals(OrderIncomingDTO.TYPE_MOVIE)) {
            return Paths.get(properties.getPlexDirectory() + "/" + properties.getMoviesDirectory());
        }

        return Paths.get(properties.getPlexDirectory() + "/" + properties.getMoviesDirectory() + "/" + request.getShow());
    }
}
