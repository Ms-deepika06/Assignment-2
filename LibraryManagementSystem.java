import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

public class LibraryManagementSystem {
    private List<Book> books = new ArrayList<>();
    private JFrame frame;
    private JTextField titleField;
    private JTextField authorField;
    private JTextArea displayArea;

    public LibraryManagementSystem() {
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);

        JLabel authorLabel = new JLabel("Author:");
        authorField = new JTextField(20);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                if (!title.isEmpty() && !author.isEmpty()) {
                    Book book = new Book(title, author);
                    books.add(book);
                    displayBooks();
                    titleField.setText("");
                    authorField.setText("");
                }
            }
        });

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(authorLabel);
        panel.add(authorField);
        panel.add(addButton);
        panel.add(displayArea);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void displayBooks() {
        displayArea.setText("");
        for (Book book : books) {
            displayArea.append(book.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryManagementSystem();
            }
        });
    }
}
