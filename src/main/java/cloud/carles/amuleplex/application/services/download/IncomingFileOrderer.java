package cloud.carles.amuleplex.application.services.download;

import cloud.carles.amuleplex.application.ApplicationProperties;
import cloud.carles.amuleplex.application.dto.download.OrderIncomingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class IncomingFileOrderer {
    @Autowired
    private ApplicationProperties properties;

    public void order(OrderIncomingDTO request) throws IOException {
        String destinationPath = getDestinationPath(request);

        Files.createDirectories(Paths.get(destinationPath));

        Files.move(
                Paths.get(properties.getAmuleIncomingDirectory() + "/" + request.getFileName()),
                Paths.get(destinationPath + "/" + request.getFileName()),
                StandardCopyOption.REPLACE_EXISTING
        );
    }

    public String getDestinationPath(OrderIncomingDTO request) {
        if (request.getType().equals(OrderIncomingDTO.TYPE_MOVIE)) {
            return properties.getPlexDirectory() + "/" + properties.getMoviesDirectory();
        }

        return properties.getPlexDirectory() + "/" + properties.getShowsDirectory() + "/" + request.getShow();
    }
}
