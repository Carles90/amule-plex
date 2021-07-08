package cloud.carles.amuleplex.application.services.download;

import cloud.carles.amuleplex.application.dto.download.DownloadListItemDTO;
import cloud.carles.amuleplex.application.services.amulecmd.AmuleCommandApi;
import cloud.carles.amuleplex.application.services.amulecmd.command.DownloadStatusCommand;
import cloud.carles.amuleplex.application.services.amulecmd.exception.AmuleCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownloadListProvider {
    @Autowired
    private AmuleCommandApi api;

    @Autowired
    private DownloadListMapper mapper;

    public List<DownloadListItemDTO> provide() throws AmuleCommandException {
        String[] lines = api.send(new DownloadStatusCommand());
        return mapper.map(lines);
    }
}
