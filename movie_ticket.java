import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Movie class for storing movie details
class Movie {
private String title;
private String[] timings;

public Movie(String title, String[] timings) {
this.title = title;
this.timings = timings;
}

public String getTitle() {
return title;
}

public String[] getTimings() {
return timings;
}
}

// Main application class
public class MovieTicketBookingSystem {
private JFrame frame;
private JComboBox<String> movieDropdown;
private JComboBox<String> timeDropdown;
private JTextField ticketsField;
private JLabel outputLabel;

// Sample movie data
private Movie[] movies = {
new Movie("Movie A", new String[]{"10:00 AM", "1:00 PM", "4:00 PM", "7:00 PM"}), new Movie("Movie B", new String[]{"11:00 AM", "2:00 PM", "5:00 PM", "8:00 PM"}), new Movie("Movie C", new String[]{"9:00 AM", "12:00 PM", "3:00 PM", "6:00 PM"})
};

public MovieTicketBookingSystem() {
// Initialize the main frame
frame = new JFrame("Movie Ticket Booking System");
frame.setSize(400, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new GridLayout(6, 2, 10, 10));

// Add components to the frame
frame.add(new JLabel("Select Movie:"));
movieDropdown = new JComboBox<>();
for (Movie movie : movies) {
movieDropdown.addItem(movie.getTitle());
}
frame.add(movieDropdown);

frame.add(new JLabel("Select Time:"));
timeDropdown = new JComboBox<>();
updateTimings(); // Populate timings based on selected movie
frame.add(timeDropdown);

movieDropdown.addActionListener(e -> updateTimings());

frame.add(new JLabel("Number of Tickets:"));
ticketsField = new JTextField();
frame.add(ticketsField);

JButton bookButton = new JButton("Book Tickets");
frame.add(bookButton);

outputLabel = new JLabel("");
frame.add(outputLabel);

// Add action listener for booking
bookButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
bookTickets();
}
});
frame.setVisible(true);
}

private void updateTimings() {
timeDropdown.removeAllItems();
int selectedIndex = movieDropdown.getSelectedIndex();
for (String time : movies[selectedIndex].getTimings()) {
timeDropdown.addItem(time);
}
}

private void bookTickets() {
String selectedMovie = (String) movieDropdown.getSelectedItem();
String selectedTime = (String) timeDropdown.getSelectedItem();
String tickets = ticketsField.getText();

if (tickets.isEmpty() || Integer.parseInt(tickets) <= 0) {
outputLabel.setText("Please enter a valid ticket count.");
} else {
outputLabel.setText("Booked " + tickets + " tickets for " +
selectedMovie + " at " + selectedTime + ".");
}
}

public static void main(String[] args) {
SwingUtilities.invokeLater(MovieTicketBookingSystem::new);
}
}
