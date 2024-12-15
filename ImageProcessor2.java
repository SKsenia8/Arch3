import java.awt.image.BufferedImage;

public class ImageProcessor {
    public BufferedImage invertColors(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage invertedImage = new BufferedImage(width, height, image.getType());

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgba = image.getRGB(x, y);
                int alpha = (rgba >> 24) & 0xff;
                int red = 255 - ((rgba >> 16) & 0xff);
                int green = 255 - ((rgba >> 8) & 0xff);
                int blue = 255 - (rgba & 0xff);
                invertedImage.setRGB(x, y, (alpha << 24) | (red << 16) | (green << 8) | blue);
            }
        }
        return invertedImage;
    }
}