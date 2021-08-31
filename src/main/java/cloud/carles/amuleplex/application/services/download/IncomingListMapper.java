package cloud.carles.amuleplex.application.services.download;

import cloud.carles.amuleplex.application.dto.download.IncomingListItemDTO;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomingListMapper {
    public List<IncomingListItemDTO> map(List<File> files) {
        return files.stream()
                .map(f -> new IncomingListItemDTO(f.getName(), f.length()))
                .collect(Collectors.toList());
    }
}
