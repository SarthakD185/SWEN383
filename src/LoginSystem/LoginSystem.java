<<<<<<< HEAD:src/Register/LoginSystem.java
package Register;
=======
package LoginSystem;
>>>>>>> 1629693de86adb692be8135e0b147934a254a24d:src/LoginSystem/LoginSystem.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoginSystem {
    private HashMap<String, String> users;

    public LoginSystem() {
        users = new HashMap<>();
        loadUsersFromFile("C:/Users/aisha/OneDrive/Desktop/2022-2023/spring/nutriHealth/SWEN383/src");
    }

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Incorrect username or password. Please try again.");
            return false;
        }
    }

    private void loadUsersFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(":");
                String username = tokens[0];
                String password = tokens[1];
                addUser(username, password);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
            e.printStackTrace();
        }
    }
}

