import java.time.LocalDateTime;

public class RepeatableTask extends Task {
    private int repeatCount;
    private LocalDateTime repeatDate;

    public RepeatableTask(String name, String description, String creatorUsername, int repeatCount, LocalDateTime repeatDate) {
        super(name, description, creatorUsername);
        this.repeatCount = repeatCount;
        this.repeatDate = repeatDate;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public void setRepeatDate(LocalDateTime repeatDate) {
        this.repeatDate = repeatDate;
    }

    @Override
    public String getDetails() {
        return "RepeatableTask | Name: " + name + ", Description: " + description + ", Repeat: " + repeatCount + " times on " + repeatDate + ", Creator: " + creatorUsername;
    }
}