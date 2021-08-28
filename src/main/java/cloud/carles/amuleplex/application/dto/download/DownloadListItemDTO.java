package cloud.carles.amuleplex.application.dto.download;

public class DownloadListItemDTO {
    private final String id;
    private final String name;
    private final float percent;
    private final int usersSending;
    private final int usersAvailable;
    private final int usersTotal;
    private final String status;
    private final String internalFileName;
    private final String priority;
    private final String speed;

    public DownloadListItemDTO(
            String id,
            String name,
            float percent,
            int usersSending,
            int usersAvailable,
            int usersTotal,
            String status,
            String internalFileName,
            String priority,
            String speed
    ) {
        this.id = id;
        this.name = name;
        this.percent = percent;
        this.usersSending = usersSending;
        this.usersAvailable = usersAvailable;
        this.usersTotal = usersTotal;
        this.status = status;
        this.internalFileName = internalFileName;
        this.priority = priority;
        this.speed = speed;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPercent() {
        return percent;
    }

    public int getUsersSending() {
        return usersSending;
    }

    public int getUsersAvailable() {
        return usersAvailable;
    }

    public int getUsersTotal() {
        return usersTotal;
    }

    public String getStatus() {
        return status;
    }

    public String getInternalFileName() {
        return internalFileName;
    }

    public String getPriority() {
        return priority;
    }

    public String getSpeed() {
        return speed;
    }
}
