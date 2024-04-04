import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class PlantSerializer implements Runnable {

    private Plant plant;
    private String path;

    public PlantSerializer(Plant plant, String path) {
        this.plant = plant;
        this.path = path;
    }

    @Override
    public void run() {
        if (plant != null && path != null) {
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(this.path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(plant);
                oos.close();
                System.out.println("Сериализация объекта Plant - Успешно!");
            } catch (IOException ex) {
                System.out.println("Сериализация объекта Plant - Ошибка!");
            }
        }
    }

}