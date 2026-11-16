import java.util.Scanner;

interface AccessControl {
    String getRole();
    int getAccessLevel();
    boolean canAccess(int requiredLevel);
}

class Developer implements AccessControl {
    public String getRole() {
        return "Developer";
    }

    public int getAccessLevel() {
        return 1;
    }

    public boolean canAccess(int requiredLevel) {
        return getAccessLevel() >= requiredLevel;
    }
}

class Manager implements AccessControl {
    public String getRole() {
        return "Manager";
    }

    public int getAccessLevel() {
        return 2;
    }

    public boolean canAccess(int requiredLevel) {
        return getAccessLevel() >= requiredLevel;
    }
}

class Administrator implements AccessControl {
    public String getRole() {
        return "Administrator";
    }

    public int getAccessLevel() {
        return 3;
    }

    public boolean canAccess(int requiredLevel) {
        return getAccessLevel() >= requiredLevel;
    }
}

public class EmployeeAccessPermission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int roleType = sc.nextInt();
        int requiredLevel = sc.nextInt();

        AccessControl accessControl;
        switch (roleType) {
            case 1:
                accessControl = new Developer();
                break;
            case 2:
                accessControl = new Manager();
                break;
            default:
                accessControl = new Administrator();
        }

        System.out.println("Role: " + accessControl.getRole());
        System.out.println("Access Level: " + accessControl.getAccessLevel());
        System.out.println("Can Access: " + accessControl.canAccess(requiredLevel));

        sc.close();
    }
}
