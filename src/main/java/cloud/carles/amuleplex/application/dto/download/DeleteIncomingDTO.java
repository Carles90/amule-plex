package cloud.carles.amuleplex.application.dto.download;

public class DeleteIncomingDTO {
    private final String fileName;

    public DeleteIncomingDTO(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
