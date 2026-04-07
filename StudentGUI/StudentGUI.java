import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

// Student class
class StudentData implements Serializable {
    int rollNo;
    String name;
    float marks;

    StudentData(int r, String n, float m) {
        rollNo = r;
        name = n;
        marks = m;
    }
}

// Main GUI class
public class StudentGUI extends JFrame {

    JTextField rollField, nameField, marksField;
    JTextArea area;
    ArrayList<StudentData> list;

    StudentGUI() {

        // Load previous data
        list = loadData();

        // Frame settings
        setTitle("Student System");
        setSize(400, 400);
        setLayout(new FlowLayout());

        // Input fields
        rollField = new JTextField(10);
        nameField = new JTextField(10);
        marksField = new JTextField(10);

        // Buttons
        JButton add = new JButton("Add");
        JButton show = new JButton("Show");
        JButton search = new JButton("Search");
        JButton delete = new JButton("Delete");

        // Output area
        area = new JTextArea(10, 30);
        area.setEditable(false);

        // Add components
        add(new JLabel("Roll"));
        add(rollField);

        add(new JLabel("Name"));
        add(nameField);

        add(new JLabel("Marks"));
        add(marksField);

        add(add);
        add(show);
        add(search);
        add(delete);

        add(new JScrollPane(area));

        // Button actions
        add.addActionListener(e -> addStudent());
        show.addActionListener(e -> showStudents());
        search.addActionListener(e -> searchStudent());
        delete.addActionListener(e -> deleteStudent());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Add student
    void addStudent() {
        try {
            int r = Integer.parseInt(rollField.getText());
            String n = nameField.getText();
            float m = Float.parseFloat(marksField.getText());

            list.add(new StudentData(r, n, m));
            saveData();

            area.setText("Student Added");

        } catch (Exception e) {
            area.setText("Invalid Input");
        }
    }

    // Show all
    void showStudents() {
        if (list.isEmpty()) {
            area.setText("No Data");
            return;
        }

        String text = "";

        for (StudentData s : list) {
            text += "Roll: " + s.rollNo +
                    " Name: " + s.name +
                    " Marks: " + s.marks + "\n";
        }

        area.setText(text);
    }

    // Search
    void searchStudent() {
        try {
            int r = Integer.parseInt(rollField.getText());

            for (StudentData s : list) {
                if (s.rollNo == r) {
                    area.setText("Found\nName: " + s.name +
                            "\nMarks: " + s.marks);
                    return;
                }
            }

            area.setText("Not Found");

        } catch (Exception e) {
            area.setText("Invalid Input");
        }
    }

    // Delete
    void deleteStudent() {
        try {
            int r = Integer.parseInt(rollField.getText());

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).rollNo == r) {
                    list.remove(i);
                    saveData();
                    area.setText("Deleted");
                    return;
                }
            }

            area.setText("Not Found");

        } catch (Exception e) {
            area.setText("Invalid Input");
        }
    }

    // Save file
    void saveData() {
        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream("data.dat"));
            out.writeObject(list);
            out.close();
        } catch (Exception e) {
            area.setText("Save Error");
        }
    }

    // Load file
    ArrayList<StudentData> loadData() {
        try {
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream("data.dat"));
            return (ArrayList<StudentData>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        new StudentGUI();
    }
}