package cloud.carles.amuleplex.application.services.amulecmd.command;

public class ResumeCommand implements AmuleCommand {
    String fileId;

    public ResumeCommand(String fileId) {
        this.fileId = fileId;
    }

    @Override
    public String serialize() {
        return String.format("Resume %s", fileId);
    }
}
