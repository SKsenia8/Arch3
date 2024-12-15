import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class ImageDisplay extends JFrame {
    private JPanel panel;
    public ImageDisplay() {
        setTitle("Инверсия изображения");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        add(panel);
    }

    public void displayImages(List<BufferedImage> original) {
        panel.removeAll();
        panel.setLayout(new GridLayout(2, original.size()));
        for (BufferedImage img : original) {
            panel.add(new JLabel(new ImageIcon(img)));
        }
        panel.revalidate();
        panel.repaint();
    }

    public void newImages(BufferedImage inverted, List<BufferedImage> original) {
        panel.setLayout(new GridLayout(2, original.size()));
        panel.add(new JLabel(new ImageIcon(inverted)));

        panel.revalidate();
        panel.repaint();
    }
}