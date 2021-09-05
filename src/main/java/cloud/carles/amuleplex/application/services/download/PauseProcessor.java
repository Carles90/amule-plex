package cloud.carles.amuleplex.application.services.download;

import cloud.carles.amuleplex.application.services.amulecmd.AmuleCommandApi;
import cloud.carles.amuleplex.application.services.amulecmd.command.PauseCommand;
import cloud.carles.amuleplex.application.services.amulecmd.command.SearchCommand;
import cloud.carles.amuleplex.application.services.amulecmd.exception.AmuleCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PauseProcessor {
    @Autowired
    private AmuleCommandApi api;

    public void process(String fileId) throws AmuleCommandException {
        this.api.send(new PauseCommand(fileId));
    }
}
