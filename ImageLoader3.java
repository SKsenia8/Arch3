import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageLoader {
    public List<BufferedImage> loadImages(String directoryPath) throws Exception {
        List<BufferedImage> images = new ArrayList<>();
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".jpg") || name.endsWith(".png"));
        if (files != null) {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                images.add(image);
            }
        }
        return images;
    }
}