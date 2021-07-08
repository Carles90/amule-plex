package cloud.carles.amuleplex.application.services.amulecmd.command;

public class SearchCommand implements AmuleCommand {
    String query;

    public SearchCommand(String query) {
        this.query = query;
    }

    @Override
    public String serialize() {
        return String.format("Search local %s", query);
    }
}
