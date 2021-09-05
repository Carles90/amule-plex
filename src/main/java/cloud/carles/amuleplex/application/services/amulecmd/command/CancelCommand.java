package cloud.carles.amuleplex.application.services.amulecmd.command;

public class CancelCommand implements AmuleCommand {
    String fileId;

    public CancelCommand(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String serialize() {
        return String.format("Cancel %s", fileId);
    }
}
