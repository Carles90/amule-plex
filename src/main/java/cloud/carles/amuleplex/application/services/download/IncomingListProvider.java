package cloud.carles.amuleplex.application.services.download;

import cloud.carles.amuleplex.application.ApplicationProperties;
import cloud.carles.amuleplex.application.dto.download.IncomingListItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class IncomingListProvider {
    @Autowired
    private ApplicationProperties properties;
    @Autowired
    private IncomingListMapper mapper;

    public List<IncomingListItemDTO> provide() {
        File folder = new File(properties.getAmuleIncomingDirectory());
        List<File> files = Arrays.stream(Objects.requireNonNull(folder.listFiles()))
                .filter(File::isFile)
                .collect(Collectors.toList());

        return mapper.map(files);
    }
}
