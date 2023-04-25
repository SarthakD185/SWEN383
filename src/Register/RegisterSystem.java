import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class RegisterSystem {
    private HashMap<String, String> users;

    public RegisterSystem(HashMap<String, String> existingUsers) {
        users = new HashMap<>();
        for (String username : existingUsers.keySet()) {
            users.put(username, existingUsers.get(username));
        }
    }

    public void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
        } else {
            users.put(username, password);
            saveUsersToFile("users.txt");
            System.out.println("Registration successful!");
        }
    }

    private void saveUsersToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String username : users.keySet()) {
                writer.write(username + ":" + users.get(username) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + filename);
            e.printStackTrace();
        }
    }
}
