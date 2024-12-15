import javax.swing.*; // Импортируем классы из библиотеки Swing для создания графического интерфейса
import java.awt.image.BufferedImage; // Импортируем класс BufferedImage для работы с изображениями
import java.util.List; // Импортируем интерфейс List для работы с коллекциями
import java.util.concurrent.ExecutorService; // Импортируем интерфейс ExecutorService для управления потоками
import java.util.concurrent.Executors; // Импортируем класс Executors для создания пула потоков
import java.util.ArrayList; // Импортируем класс ArrayList для работы с динамическими массивами

public class ImageInversionApp { // Объявляем основной класс приложения

    public static void main(String[] args) { // Главный метод, с которого начинается выполнение программы
        // Используем SwingUtilities для обеспечения потокобезопасного доступа к GUI
        SwingUtilities.invokeLater(() -> {
            ImageDisplay display = new ImageDisplay(); // Создаем экземпляр класса ImageDisplay для отображения изображений
            display.setVisible(true); // Делаем окно видимым
            processImages(display); // Вызываем метод для обработки изображений, передавая объект display
        });
    }

    private static void processImages(ImageDisplay display) { // Метод для обработки изображений
        ImageLoader loader = new ImageLoader(); // Создаем экземпляр класса ImageLoader для загрузки изображений
        // Создаем пул потоков с количеством потоков, равным количеству доступных процессоров
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            // Загружаем изображения из указанной директории "фотки" и сохраняем их в список
            List<BufferedImage> images = loader.loadImages("фотки");
            // Отображаем загруженные изображения в интерфейсе
            display.displayImages(images);

            // Перебираем каждое изображение в списке
            for (BufferedImage img : images) {
                // Отправляем задачу на выполнение в пул потоков
                executor.submit(() -> {
                    ImageProcessor processor = new ImageProcessor(); // Создаем экземпляр класса ImageProcessor для обработки изображений
                    // Инвертируем цвета изображения
                    BufferedImage inverted = processor.invertColors(img);
                    // Обновляем интерфейс, добавляя инвертированное изображение
                    display.newImages(inverted, images);
                });
            }

            executor.shutdown(); // Завершаем работу пула потоков, не принимая новые задачи

        } catch (Exception e) { // Обрабатываем возможные исключения
            e.printStackTrace(); // Выводим стек вызовов исключения в консоль для отладки
        }
    }
}
