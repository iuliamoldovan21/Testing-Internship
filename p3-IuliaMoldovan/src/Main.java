import Controller.Controller;
import Repository.CSVRepository;
import View.UI;

public class Main {
    public static void main(String[] args) {
        CSVRepository repo = new CSVRepository("file.txt");
        Controller ctrl = new Controller(repo);
        UI ui = new UI(ctrl);
        ui.start();
    }
}
