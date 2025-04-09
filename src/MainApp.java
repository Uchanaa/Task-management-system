import java.time.LocalDateTime;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        System.out.print("შეიყვანე შენი სახელი: ");
        String username = scanner.nextLine();

        while (true) {
            System.out.println("\nაირჩიე მოქმედება:");
            System.out.println("1. Task-ის დამატება");
            System.out.println("2. ყველა Task-ის ნახვა");
            System.out.println("3. Task-ის განახლება");
            System.out.println("4. Task-ის წაშლა");
            System.out.println("5. Task-ის ნახვა დეტალურად");
            System.out.println("0. გასვლა");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("შეიყვანე Task-ის ტიპი (basic / limited / repeat): ");
                    String type = scanner.nextLine();
                    System.out.print("შეიყვანე Task-ის სახელი: ");
                    String name = scanner.nextLine();
                    System.out.print("შეიყვანე Task-ის აღწერა: ");
                    String desc = scanner.nextLine();

                    Task task = null;
                    if (type.equalsIgnoreCase("basic")) {
                        task = new BasicTask(name, desc, username);
                    } else if (type.equalsIgnoreCase("limited")) {
                        System.out.print("შეიყვანე deadline (YYYY-MM-DDTHH:MM): ");
                        LocalDateTime deadline = LocalDateTime.parse(scanner.nextLine());
                        task = new LimitedTimeTask(name, desc, username, deadline);
                    } else if (type.equalsIgnoreCase("repeat")) {
                        System.out.print("შეიყვანე რამდენჯერ უნდა შესრულდეს: ");
                        int count = Integer.parseInt(scanner.nextLine());
                        System.out.print("შეიყვანე როდის უნდა შესრულდეს (YYYY-MM-DDTHH:MM): ");
                        LocalDateTime repeatDate = LocalDateTime.parse(scanner.nextLine());
                        task = new RepeatableTask(name, desc, username, count, repeatDate);
                    }

                    if (task != null && taskManager.addTask(task)) {
                        System.out.println("Task წარმატებით დაემატა!");
                    } else {
                        System.out.println("Task ვერ დაემატა ან უკვე არსებობს.");
                    }
                    break;
                case 2:
                    System.out.println("ყველა ტასკი:");
                    for (String tName : taskManager.getAllTaskNames()) {
                        System.out.println(tName);
                    }
                    break;
                case 3:
                    System.out.print("შეიყვანე განსახლებელი Task-ის სახელი: ");
                    String updateName = scanner.nextLine();
                    Task updateTask = taskManager.getTask(updateName);
                    if (updateTask == null) {
                        System.out.println("Task არ არსებობს.");
                        break;
                    }
                    System.out.print("შეიყვანე ახალი აღწერა: ");
                    updateTask.setDescription(scanner.nextLine());

                    if (updateTask instanceof LimitedTimeTask) {
                        System.out.print("ახალი deadline (YYYY-MM-DDTHH:MM): ");
                        ((LimitedTimeTask) updateTask).setDeadline(LocalDateTime.parse(scanner.nextLine()));
                    } else if (updateTask instanceof RepeatableTask) {
                        System.out.print("ახალი განმეორებების რაოდენობა: ");
                        ((RepeatableTask) updateTask).setRepeatCount(Integer.parseInt(scanner.nextLine()));
                        System.out.print("ახალი განმეორების თარიღი (YYYY-MM-DDTHH:MM): ");
                        ((RepeatableTask) updateTask).setRepeatDate(LocalDateTime.parse(scanner.nextLine()));
                    }

                    System.out.println("Task განახლდა.");
                    break;
                case 4:
                    System.out.print("შეიყვანე წასაშლელი Task-ის სახელი: ");
                    String deleteName = scanner.nextLine();
                    if (taskManager.removeTask(deleteName)) {
                        System.out.println("Task წაიშალა.");
                    } else {
                        System.out.println("Task არ არსებობს.");
                    }
                    break;
                case 5:
                    System.out.print("შეიყვანე Task-ის სახელი დეტალურად სანახავად: ");
                    String detailName = scanner.nextLine();
                    Task detailTask = taskManager.getTask(detailName);
                    if (detailTask != null) {
                        System.out.println(detailTask.getDetails());
                    } else {
                        System.out.println("Task არ არსებობს.");
                    }
                    break;
                case 0:
                    System.out.println("ნახვამდის!");
                    return;
                default:
                    System.out.println("არასწორი ბრძანება.");
            }
        }
    }
}
