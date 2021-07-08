package cloud.carles.amuleplex.application.services.amulecmd.command;

public class DownloadCommand implements AmuleCommand {
    int index;

    public DownloadCommand(int index) {
        this.index = index;
    }

    @Override
    public String serialize() {
        return String.format("Download %s", index);
    }
}
