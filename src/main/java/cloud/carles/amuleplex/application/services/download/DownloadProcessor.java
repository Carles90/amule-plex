package cloud.carles.amuleplex.application.services.download;

import cloud.carles.amuleplex.application.dto.download.DownloadRequestDTO;
import cloud.carles.amuleplex.application.services.amulecmd.AmuleCommandApi;
import cloud.carles.amuleplex.application.services.amulecmd.command.AmuleCommand;
import cloud.carles.amuleplex.application.services.amulecmd.command.DownloadCommand;
import cloud.carles.amuleplex.application.services.amulecmd.command.HelpCommand;
import cloud.carles.amuleplex.application.services.amulecmd.command.ResultsCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DownloadProcessor {
    @Autowired
    private AmuleCommandApi api;

    public void process(DownloadRequestDTO download) {
        List<AmuleCommand> commands = new ArrayList<>();
        commands.add(new HelpCommand());
        commands.add(new ResultsCommand());
        commands.add(new DownloadCommand(download.getIndex()));
        api.sendMulti(commands);
    }
}
