package cloud.carles.amuleplex.application.dto.download;

public class IncomingListItemDTO {
    private final String name;
    private final long size;

    public IncomingListItemDTO(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }
}
