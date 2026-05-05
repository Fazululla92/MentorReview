package Collections;
import java.util.ArrayList;
import java.util.TreeMap;

class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name, ArrayList<Double> grades) {
        if (name == null || grades == null) throw new NullPointerException();
        this.name = name;
        this.grades = grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        if (grades == null) throw new NullPointerException();
        this.grades = grades;
    }

    public double getAverage() {
        double sum = 0;
        for (Double g : grades) sum += g;
        return grades.isEmpty() ? 0 : sum / grades.size();
    }
}
public class GradeManagementSystem {

    private TreeMap<Integer, Student> students = new TreeMap<>();
    public void addStudent(int id, String name, ArrayList<Double> grades) {
        if (name == null || grades == null) throw new NullPointerException();
        students.put(id, new Student(name, grades));
    }

    public void updateGrades(int id, ArrayList<Double> grades) {
        if (grades == null) throw new NullPointerException();
        Student s = students.get(id);
        if (s != null) s.setGrades(grades);
    }

    public double getAverage(int id) {
        Student s = students.get(id);
        return (s == null) ? 0 : s.getAverage();
    }

    public static void main(String[] args) {

        GradeManagementSystem system = new GradeManagementSystem();

        ArrayList<Double> alice = new ArrayList<>();
        alice.add(85.0);
        alice.add(90.0);
        alice.add(78.0);

        ArrayList<Double> bob = new ArrayList<>();
        bob.add(88.0);
        bob.add(92.0);
        bob.add(80.0);

        system.addStudent(1, "Alice", alice);
        system.addStudent(2, "Bob", bob);

        ArrayList<Double> updatedAlice = new ArrayList<>();
        updatedAlice.add(87.0);
        updatedAlice.add(91.0);
        updatedAlice.add(82.0);

        system.updateGrades(1, updatedAlice);

        System.out.println("Alice avg: " + system.getAverage(1));
        System.out.println("Bob avg: " + system.getAverage(2));
    }
}
