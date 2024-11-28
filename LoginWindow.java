import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {
    public static void main(String[] args) {
        // Membuat JFrame (window utama)
        JFrame frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        // Membuat label untuk username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 25);
        frame.add(userLabel);

        // Membuat input field untuk username
        JTextField userField = new JTextField();
        userField.setBounds(150, 50, 180, 25);
        frame.add(userField);

        // Membuat label untuk password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 100, 25);
        frame.add(passLabel);

        // Membuat input field untuk password
        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 100, 180, 25);
        frame.add(passField);

        // Membuat tombol login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 80, 25);
        frame.add(loginButton);

        // Membuat label untuk pesan (status)
        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(50, 200, 300, 25);
        statusLabel.setForeground(Color.RED);
        frame.add(statusLabel);

        // Menambahkan aksi untuk tombol login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                // Validasi sederhana username dan password
                if ("admin".equals(username) && "password123".equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                } else {
                    statusLabel.setText("Invalid username or password.");
                }
            }
        });

        // Menampilkan window
        frame.setLocationRelativeTo(null); // Pusatkan window
        frame.setVisible(true);
    }
}
