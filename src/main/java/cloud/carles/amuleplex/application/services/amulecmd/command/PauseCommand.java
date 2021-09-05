package cloud.carles.amuleplex.application.services.amulecmd.command;

public class PauseCommand implements AmuleCommand {
    String fileId;

    public PauseCommand(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String serialize() {
        return String.format("Pause %s", fileId);
    }
}
