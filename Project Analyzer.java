import java.util.ArrayList;
import java.util.List;

class Project {
    private String studentName;
    private int daysToComplete;
    private boolean completedOnTime;

    public Project(String studentName, int daysToComplete, boolean completedOnTime) {
        this.studentName = studentName;
        this.daysToComplete = daysToComplete;
        this.completedOnTime = completedOnTime;
    }

    public int getDaysToComplete() {
        return daysToComplete;
    }

    public boolean isCompletedOnTime() {
        return completedOnTime;
    }
}

class ProjectAnalyzer {
    private List<Project> projects;

    public ProjectAnalyzer() {
        this.projects = new ArrayList<>();
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void analyzeProjects() {
        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;
        double totalTime = 0;

        for (Project project : projects) {
            if (project.isCompletedOnTime()) {
                onTimeCount++;
            } else if (project.getDaysToComplete() > 0) {
                lateCount++;
            } else {
                earlyCount++;
            }
            totalTime += project.getDaysToComplete();
        }

        int totalProjects = projects.size();
        double averageTime = totalTime / totalProjects;

        System.out.println("Projects completed on time: " + onTimeCount);
        System.out.println("Projects completed late: " + lateCount);
        System.out.println("Projects completed early: " + earlyCount);
        System.out.println("Average time to complete projects: " + averageTime);
    }
}

public class Main {
    public static void main(String[] args) {
        ProjectAnalyzer analyzer = new ProjectAnalyzer();

        // Example projects
        analyzer.addProject(new Project("Alice", 2, true));
        analyzer.addProject(new Project("Bob", -1, false));
        analyzer.addProject(new Project("Charlie", 5, false));
        analyzer.addProject(new Project("David", 0, true));

        analyzer.analyzeProjects();
    }
}
