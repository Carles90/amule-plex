package cloud.carles.amuleplex.application.dto.download;

public class OrderIncomingDTO {
    public static final String TYPE_MOVIE = "movie";
    public static final String TYPE_SHOW = "show";

    private final String fileName;
    private final String type;
    private final String show;

    public OrderIncomingDTO(String fileName, String type, String show) {
        this.fileName = fileName;
        this.type = type;
        this.show = show;
    }

    public String getFileName() {
        return fileName;
    }

    public String getType() {
        return type;
    }

    public String getShow() {
        return show;
    }
}
