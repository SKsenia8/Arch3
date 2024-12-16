import javax.swing.*; // Импортируем классы из библиотеки Swing для создания графического интерфейса
import java.awt.*; // Импортируем классы для работы с графикой и компоновкой
import java.awt.image.BufferedImage; // Импортируем класс BufferedImage для работы с изображениями
import java.util.List; // Импортируем интерфейс List для работы с коллекциями

public class ImageDisplay extends JFrame { // Объявляем класс ImageDisplay, который наследует JFrame для создания окна приложения
    private JPanel panel; // Объявляем панель для отображения изображений

    // Конструктор класса ImageDisplay
    public ImageDisplay() {
        setTitle("Инверсия изображения"); // Устанавливаем заголовок окна
        setSize(800, 600); // Устанавливаем размер окна (ширина 800, высота 600)
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Устанавливаем действие при закрытии окна (выход из приложения)
        panel = new JPanel(); // Создаем новый объект JPanel для размещения изображений
        add(panel); // Добавляем панель в окно
    }

    // Метод для отображения оригинальных изображений
    public void displayImages(List<BufferedImage> original) {
        panel.removeAll(); // Удаляем все компоненты из панели перед добавлением новых изображений
        panel.setLayout(new GridLayout(2, original.size())); // Устанавливаем компоновку панели в виде сетки (2 строки, количество столбцов равно количеству изображений)
        
        // Перебираем все оригинальные изображения
        for (BufferedImage img : original) {
            // Добавляем каждое изображение в панель в виде JLabel с иконкой
            panel.add(new JLabel(new ImageIcon(img)));
        }
        
        panel.revalidate(); // Пересчитываем компоненты панели
        panel.repaint(); // Перерисовываем панель для отображения новых изображений
    }

    // Метод для отображения инвертированного изображения
    public void newImages(BufferedImage inverted, List<BufferedImage> original) {
        panel.setLayout(new GridLayout(2, original.size())); // Устанавливаем компоновку панели в виде сетки (2 строки, количество столбцов равно количеству оригинальных изображений)
        // Добавляем инвертированное изображение в панель в виде JLabel с иконкой
        panel.add(new JLabel(new ImageIcon(inverted)));

        panel.revalidate(); // Пересчитываем компоненты панели
        panel.repaint(); // Перерисовываем панель для отображения нового изображения
    }
}
