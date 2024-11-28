import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageViewer extends JFrame {
    private JLabel imageLabel;
    private JFileChooser fileChooser;
    private JPanel mainPanel;

    public ImageViewer() {
        setTitle("Image Viewer");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        fileChooser = new JFileChooser(new File("src"));
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".jpg") || 
                       f.getName().toLowerCase().endsWith(".png") ||
                       f.isDirectory();
            }
            public String getDescription() {
                return "Image Files (*.jpg, *.png)";
            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open Image");
        
        openItem.addActionListener(e -> openImage());
        fileMenu.add(openItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        add(mainPanel);
    }

    private void openImage() {
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedImage originalImage = ImageIO.read(selectedFile);
                ImageIcon resizedIcon = resizeImage(originalImage);
                imageLabel.setIcon(resizedIcon);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, 
                    "Error loading image: " + ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private ImageIcon resizeImage(BufferedImage originalImage) {
        // Dapatkan ukuran panel
        int panelWidth = mainPanel.getWidth();
        int panelHeight = mainPanel.getHeight();

        // Jika panel belum memiliki ukuran, gunakan ukuran frame
        if (panelWidth <= 0) panelWidth = getWidth();
        if (panelHeight <= 0) panelHeight = getHeight();

        // Resize gambar sesuai ukuran panel
        Image scaledImage = originalImage.getScaledInstance(
            panelWidth, panelHeight, 
            Image.SCALE_SMOOTH
        );

        return new ImageIcon(scaledImage);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageViewer viewer = new ImageViewer();
            viewer.setVisible(true);
        });
    }
}