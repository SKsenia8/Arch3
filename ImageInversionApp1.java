import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;

public class ImageInversionApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageDisplay display = new ImageDisplay();
            display.setVisible(true);
            processImages(display);
        });
    }

    private static void processImages(ImageDisplay display) {
        ImageLoader loader = new ImageLoader();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            List<BufferedImage> images = loader.loadImages("фотки");
            display.displayImages(images);

            for (BufferedImage img : images) {
                executor.submit(() -> {
                    ImageProcessor processor = new ImageProcessor();
                    BufferedImage inverted = processor.invertColors(img);
                    display.newImages(inverted, images);
                });
            }

            executor.shutdown();




        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}