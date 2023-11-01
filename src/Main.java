import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fl = new File("./src/service/");
        File[] lf = fl.listFiles();

        for (File file : lf) {
            System.out.println(file.getName());
        }
    }
}
