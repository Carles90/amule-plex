package cloud.carles.amuleplex.application.services.download;

import cloud.carles.amuleplex.application.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ShowsFoldersProvider {
    @Autowired
    private ApplicationProperties properties;

    public List<String> provide() {
        File file = new File(properties.getPlexDirectory() + "/" + properties.getShowsDirectory());

        return Arrays.stream(Objects.requireNonNull(file.listFiles()))
                .filter(File::isDirectory)
                .map(File::getName)
                .collect(Collectors.toList());
    }
}
