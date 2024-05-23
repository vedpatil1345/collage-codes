import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int enrolled;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolled = 0;
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getCapacity() { return capacity; }
    public int getEnrolled() { return enrolled; }
    public String getSchedule() { return schedule; }

    public boolean enrollStudent() {
        if (enrolled < capacity) {
            enrolled++;
            return true;
        }
        return false;
    }

    public boolean dropStudent() {
        if (enrolled > 0) {
            enrolled--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return code + ": " + title + " (" + enrolled + "/" + capacity + ") - " + schedule;
    }
}

class Student {
    private String id;
    private String name;
    private List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Course> getRegisteredCourses() { return registeredCourses; }

    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        if (course.enrollStudent()) {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.dropStudent();
            return true;
        }
        return false;
    }
}

class CourseManagementSystem {
    private List<Course> courses;
    private List<Student> students;

    public CourseManagementSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public Course getCourseByCode(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    public boolean registerStudentToCourse(String studentId, String courseCode) {
        Student student = getStudentById(studentId);
        Course course = getCourseByCode(courseCode);
        if (student != null && course != null) {
            return student.registerCourse(course);
        }
        return false;
    }

    public boolean removeStudentFromCourse(String studentId, String courseCode) {
        Student student = getStudentById(studentId);
        Course course = getCourseByCode(courseCode);
        if (student != null && course != null) {
            return student.dropCourse(course);
        }
        return false;
    }
}
class CourseManagementGUI extends JFrame {
    private CourseManagementSystem cms;

    private JTextArea courseListTextArea;
    private JTextField studentIdField;
    private JTextField courseCodeField;

    public CourseManagementGUI(CourseManagementSystem cms) {
        this.cms = cms;
        setTitle("Course Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Course list panel
        courseListTextArea = new JTextArea(10, 50);
        courseListTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(courseListTextArea);
        updateCourseList();

        // Registration panel
        JPanel registrationPanel = new JPanel();
        registrationPanel.setLayout(new GridLayout(3, 2));

        registrationPanel.add(new JLabel("Student ID:"));
        studentIdField = new JTextField();
        registrationPanel.add(studentIdField);

        registrationPanel.add(new JLabel("Course Code:"));
        courseCodeField = new JTextField();
        registrationPanel.add(courseCodeField);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerStudent();
            }
        });
        registrationPanel.add(registerButton);

        JButton dropButton = new JButton("Drop");
        dropButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dropStudent();
            }
        });
        registrationPanel.add(dropButton);

        // Course input panel
        JPanel courseInputPanel = new JPanel();
        courseInputPanel.setLayout(new GridLayout(6, 2));

        JTextField courseCodeInput = new JTextField();
        JTextField courseTitleInput = new JTextField();
        JTextField courseDescriptionInput = new JTextField();
        JTextField courseCapacityInput = new JTextField();
        JTextField courseScheduleInput = new JTextField();

        courseInputPanel.add(new JLabel("Course Code:"));
        courseInputPanel.add(courseCodeInput);
        courseInputPanel.add(new JLabel("Course Title:"));
        courseInputPanel.add(courseTitleInput);
        courseInputPanel.add(new JLabel("Course Description:"));
        courseInputPanel.add(courseDescriptionInput);
        courseInputPanel.add(new JLabel("Course Capacity:"));
        courseInputPanel.add(courseCapacityInput);
        courseInputPanel.add(new JLabel("Course Schedule:"));
        courseInputPanel.add(courseScheduleInput);

        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = courseCodeInput.getText().trim();
                String title = courseTitleInput.getText().trim();
                String description = courseDescriptionInput.getText().trim();
                int capacity = Integer.parseInt(courseCapacityInput.getText().trim());
                String schedule = courseScheduleInput.getText().trim();
                cms.addCourse(new Course(code, title, description, capacity, schedule));
                updateCourseList();
                JOptionPane.showMessageDialog(CourseManagementGUI.this, "Course added successfully!");
            }
        });
        courseInputPanel.add(addCourseButton);

        // Student input panel
        JPanel studentInputPanel = new JPanel();
        studentInputPanel.setLayout(new GridLayout(3, 2));

        JTextField studentIdInput = new JTextField();
        JTextField studentNameInput = new JTextField();

        studentInputPanel.add(new JLabel("Student ID:"));
        studentInputPanel.add(studentIdInput);
        studentInputPanel.add(new JLabel("Student Name:"));
        studentInputPanel.add(studentNameInput);

        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = studentIdInput.getText().trim();
                String name = studentNameInput.getText().trim();
                cms.addStudent(new Student(id, name));
                JOptionPane.showMessageDialog(CourseManagementGUI.this, "Student added successfully!");
            }
        });
        studentInputPanel.add(addStudentButton);

        // Add panels to the frame
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(registrationPanel, BorderLayout.SOUTH);
        add(courseInputPanel, BorderLayout.NORTH);
        add(studentInputPanel, BorderLayout.EAST);

        setVisible(true);
    }

    private void updateCourseList() {
        StringBuilder courseList = new StringBuilder();
        for (Course course : cms.getCourses()) {
            courseList.append(course.toString()).append("\n");
        }
        courseListTextArea.setText(courseList.toString());
    }

    private void registerStudent() {
        String studentId = studentIdField.getText().trim();
        String courseCode = courseCodeField.getText().trim();
        if (cms.registerStudentToCourse(studentId, courseCode)) {
            JOptionPane.showMessageDialog(this, "Registration successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Registration failed.");
        }
        updateCourseList();
    }

    private void dropStudent() {
        String studentId = studentIdField.getText().trim();
        String courseCode = courseCodeField.getText().trim();
        if (cms.removeStudentFromCourse(studentId, courseCode)) {
            JOptionPane.showMessageDialog(this, "Course dropped successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to drop course.");
        }
        updateCourseList();
    }
}
class T5{
    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();

        // Launch the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CourseManagementGUI(cms);
            }
        });
    }
}
