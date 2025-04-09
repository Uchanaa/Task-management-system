public abstract class Task {
    protected String name;
    protected String description;
    protected String creatorUsername;

    public Task(String name, String description, String creatorUsername) {
        this.name = name;
        this.description = description;
        this.creatorUsername = creatorUsername;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatorUsername() {
        return creatorUsername;
    }

    public abstract String getDetails();
}