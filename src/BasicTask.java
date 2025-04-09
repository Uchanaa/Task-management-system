public class BasicTask extends Task {
    public BasicTask(String name, String description, String creatorUsername) {
        super(name, description, creatorUsername);
    }

    @Override
    public String getDetails() {
        return "BasicTask | Name: " + name + ", Description: " + description + ", Creator: " + creatorUsername;
    }
}