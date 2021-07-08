package cloud.carles.amuleplex.application.services.amulecmd.command;

public class DownloadStatusCommand implements AmuleCommand {
    @Override
    public String serialize() {
        return "Show DL";
    }
}
