import java.util.Scanner;

public class VUCourses {
    // Declaring variables for course details
    private String moduleCode;
    private String moduleName;
    private double tuition;
    
    // Constructor
    public VUCourses(String moduleCode, String moduleName, double tuition) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.tuition = tuition;
    }
    
    // Getters and setters
    public String getModuleCode() {
        return moduleCode;
    }
    
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
    
    public String getModuleName() {
        return moduleName;
    }
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    public double getTuition() {
        return tuition;
    }
    
    public void setTuition(double tuition) {
        this.tuition = tuition;
    }
    
    @Override
    public String toString() {
        return "Module: " + moduleName + 
               "\nModule Code: " + moduleCode + 
               "\nTuition Fee: UGX " + String.format("%,.0f", tuition);
    }
}