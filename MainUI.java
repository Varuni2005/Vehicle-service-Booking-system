import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class MainUI extends JFrame {
    JComboBox<String> tableSelector, collectionSelector;
    JTextArea outputArea;
    JButton fetchBtn;

    public MainUI() {
        setTitle("Vehicle Service Booking System");
        setLayout(new FlowLayout());

        tableSelector = new JComboBox<>(new String[]{"vehicles", "bookings"});
        collectionSelector = new JComboBox<>(new String[]{"ArrayList", "LinkedList"});

        fetchBtn = new JButton("Fetch and Display");
        outputArea = new JTextArea(15, 50);

        add(new JLabel("Select Table:"));
        add(tableSelector);
        add(new JLabel("Select Collection:"));
        add(collectionSelector);
        add(fetchBtn);
        add(new JScrollPane(outputArea));

        fetchBtn.addActionListener(e -> fetchData());

        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void fetchData() {
        String table = (String) tableSelector.getSelectedItem();
        String collection = (String) collectionSelector.getSelectedItem();
        outputArea.setText("");

        try (Connection con = DBConnection.getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);

            if (table.equals("vehicles")) {
                Collection<Vehicle> vehicles = collection.equals("ArrayList") ? new ArrayList<>() : new LinkedList<>();

                while (rs.next()) {
                    vehicles.add(new Vehicle(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getFloat(4),
                            rs.getString(5).charAt(0)
                    ));
                }

                // Use Iterator
                outputArea.append("Using Iterator:\n");
                Iterator<Vehicle> it = vehicles.iterator();
                while (it.hasNext()) {
                    outputArea.append(it.next().toString() + "\n");
                }

                // Sort using Comparator
                List<Vehicle> sortedList = new ArrayList<>(vehicles);
                sortedList.sort(Comparator.comparing(v -> v.ownerName));
                outputArea.append("\nSorted by Owner Name:\n");
                for (Vehicle v : sortedList) outputArea.append(v.toString() + "\n");

            } else if (table.equals("bookings")) {
                Collection<Booking> bookings = collection.equals("ArrayList") ? new ArrayList<>() : new LinkedList<>();

                while (rs.next()) {
                    bookings.add(new Booking(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getFloat(5)
                    ));
                }

                // Use For-each
                outputArea.append("Using For-each:\n");
                for (Booking b : bookings) outputArea.append(b.toString() + "\n");

                // Sort using Comparator
                List<Booking> sortedList = new ArrayList<>(bookings);
                sortedList.sort(Comparator.comparingDouble(b -> b.estimatedCost));
                outputArea.append("\nSorted by Estimated Cost:\n");
                for (Booking b : sortedList) outputArea.append(b.toString() + "\n");
            }

        } catch (SQLException ex) {
            outputArea.setText("Database Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new MainUI();
    }
}
