package cloud.carles.amuleplex.application.dto.search;

public class SearchResultDTO {
    private int downloadIndex;
    private String name;
    private float size;
    private int sources;

    public SearchResultDTO(int downloadIndex, String name, float size, int sources) {
        this.downloadIndex = downloadIndex;
        this.name = name;
        this.size = size;
        this.sources = sources;
    }

    public int getDownloadIndex() {
        return downloadIndex;
    }

    public void setDownloadIndex(int downloadIndex) {
        this.downloadIndex = downloadIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getSources() {
        return sources;
    }

    public void setSources(int sources) {
        this.sources = sources;
    }
}
