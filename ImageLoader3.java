import javax.imageio.ImageIO; // Импортируем класс ImageIO для работы с изображениями (чтение и запись)
import java.awt.image.BufferedImage; // Импортируем класс BufferedImage для работы с изображениями
import java.io.File; // Импортируем класс File для работы с файлами и директориями
import java.util.ArrayList; // Импортируем класс ArrayList для работы с динамическими массивами
import java.util.List; // Импортируем интерфейс List для работы с коллекциями

public class ImageLoader { // Объявляем класс ImageLoader, который будет загружать изображения

    // Метод для загрузки изображений из указанной директории
    public List<BufferedImage> loadImages(String directoryPath) throws Exception {
        List<BufferedImage> images = new ArrayList<>(); // Создаем список для хранения загруженных изображений
        File dir = new File(directoryPath); // Создаем объект File, представляющий директорию по указанному пути
        // Получаем список файлов в директории, фильтруя только файлы с расширениями .jpg и .png
        File[] files = dir.listFiles((d, name) -> name.endsWith(".jpg") || name.endsWith(".png"));
        
        // Проверяем, что массив файлов не равен null (т.е. директория существует и доступна)
        if (files != null) {
            // Перебираем все файлы в массиве
            for (File file : files) {
                // Читаем изображение из файла и сохраняем его в объект BufferedImage
                BufferedImage image = ImageIO.read(file);
                // Добавляем загруженное изображение в список
                images.add(image);
            }
        }
        // Возвращаем список загруженных изображений
        return images;
    }
}
