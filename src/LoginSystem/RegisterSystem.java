package LoginSystem;

import java.io.*;
import java.util.HashMap;

public class RegisterSystem {
    private HashMap<String, String> users;

    public RegisterSystem() {
        users = new HashMap<>();
    }

    public void register(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
        } else {
            users.put(username, password);
            saveUsersToFile("./src/users.txt");
            System.out.println("Registration successful!");
        }
    }

    private void saveUsersToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String username : users.keySet()) {
                writer.append(username + ":" + users.get(username) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + filename);
            e.printStackTrace();
        }
    }
}
