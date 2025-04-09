import java.util.*;

public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    public boolean addTask(Task task) {
        if (tasks.containsKey(task.getName())) {
            return false;
        }
        tasks.put(task.getName(), task);
        return true;
    }

    public List<String> getAllTaskNames() {
        return new ArrayList<>(tasks.keySet());
    }

    public Task getTask(String name) {
        return tasks.get(name);
    }

    public boolean removeTask(String name) {
        return tasks.remove(name) != null;
    }
}
