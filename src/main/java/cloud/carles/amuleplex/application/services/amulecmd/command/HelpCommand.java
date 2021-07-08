package cloud.carles.amuleplex.application.services.amulecmd.command;

public class HelpCommand implements AmuleCommand {
    @Override
    public String serialize() {
        return "Help";
    }
}
