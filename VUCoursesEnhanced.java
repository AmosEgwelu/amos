import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class VUCoursesEnhanced {
    
    // Using HashMap for more efficient storage
    private Map<String, Course> courseMap;
    private Scanner scanner;
    
    // Inner class to represent a course
    class Course {
        String moduleName;
        int tuition;
        
        Course(String moduleName, int tuition) {
            this.moduleName = moduleName;
            this.tuition = tuition;
        }
    }
    
    // Constructor
    public VUCoursesEnhanced() {
        courseMap = new HashMap<>();
        scanner = new Scanner(System.in);
        
        // Initialize courses
        initializeCourses();
    }
    
    // Initialize course data
    private void initializeCourses() {
        courseMap.put("BSF", new Course("BSc. Software Engineering", 900000));
        courseMap.put("BIT", new Course("BSc. Information Technology", 750000));
        courseMap.put("BCS", new Course("BSc. Computer Science", 800000));
        courseMap.put("BCE", new Course("BSc. Computer Engineering", 950000));
    }
    
    // Method to search and display course
    public void searchAndDisplayCourse() {
        System.out.print("\nEnter Module Code: ");
        String moduleCode = scanner.nextLine().toUpperCase().trim();
        
        System.out.println("\n==================================");
        System.out.println("     VICTORIA UNIVERSITY KAMPALA    ");
        System.out.println("         COURSE DETAILS           ");
        System.out.println("==================================");
        
        if (courseMap.containsKey(moduleCode)) {
            Course course = courseMap.get(moduleCode);
            System.out.println("Module Code   : " + moduleCode);
            System.out.println("Module Name   : " + course.moduleName);
            System.out.printf("Tuition Fee   : UGX %,d%n", course.tuition);
            System.out.println("Status        : Active Course");
        } else {
            System.out.println("ERROR: Wrong Module Code details!");
            System.out.println("\nValid Module Codes are:");
            for (String code : courseMap.keySet()) {
                System.out.println("  - " + code + " (" + courseMap.get(code).moduleName + ")");
            }
        }
        System.out.println("==================================\n");
    }
    
    // Method to display all courses
    public void displayAllCourses() {
        System.out.println("\n==================================");
        System.out.println("   AVAILABLE COURSES AT VICKS    ");
        System.out.println("==================================");
        System.out.printf("%-10s %-30s %-15s%n", "Code", "Module Name", "Tuition (UGX)");
        System.out.println("------------------------------------------------");
        
        for (Map.Entry<String, Course> entry : courseMap.entrySet()) {
            System.out.printf("%-10s %-30s %,12d%n", 
                entry.getKey(), entry.getValue().moduleName, entry.getValue().tuition);
        }
        System.out.println("==================================\n");
    }
    
    // Main menu
    public void run() {
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║         VUPay Application          ║");
        System.out.println("║    Victoria University Kampala     ║");
        System.out.println("╚════════════════════════════════════╝");
        
        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View All Courses");
            System.out.println("2. Search Course by Code");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
                
                switch(choice) {
                    case 1:
                        displayAllCourses();
                        break;
                    case 2:
                        searchAndDisplayCourse();
                        break;
                    case 3:
                        System.out.println("Thank you for using VUPay. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = 0;
            }
            
        } while (choice != 3);
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        VUCoursesEnhanced app = new VUCoursesEnhanced();
        app.run();
    }
}