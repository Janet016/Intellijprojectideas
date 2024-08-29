//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.HashMap;
import java.util.Map;

class Student {
    private String name;
    private String id;
    private Map<Course, Integer> enrolledCourses; // Map to store Course objects and corresponding grades

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new HashMap<>();
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Method to enroll in a course
    public void enrollCourse(Course course) {
        if (enrolledCourses.containsKey(course)) {
            System.out.println("Already enrolled in this course.");
        } else if (course.getEnrolledStudents() >= course.getMaxCapacity()) {
            System.out.println("Course is full.");
        } else {
            enrolledCourses.put(course, null); // Initially, no grade is assigned
            course.incrementEnrollment();
        }
    }

    // Method to assign a grade
    public void assignGrade(Course course, int grade) {
        if (enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, grade);
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }

    // Method to get enrolled courses
    public Map<Course, Integer> getEnrolledCourses() {
        return enrolledCourses;
    }
}


 class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int enrolledStudents;

    private static int totalEnrolledStudents = 0; // Static variable to track total enrollment

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = 0;
    }

    // Getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    // Method to increment enrolled students
    public void incrementEnrollment() {
        if (enrolledStudents < maxCapacity) {
            enrolledStudents++;
            totalEnrolledStudents++;
        }
    }

    // Static method to get total enrolled students
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}


