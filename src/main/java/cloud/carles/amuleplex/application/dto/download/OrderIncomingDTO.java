package cloud.carles.amuleplex.application.dto.download;

public class OrderIncomingDTO {
    public static final String TYPE_MOVIE = "movie";
    public static final String TYPE_SHOW = "show";

    private String fileName;
    private String type;
    private String show;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }
}
