import java.io.IOException;
import java.util.Scanner;

public class Main {
    public Main() {

    }

    public static void main(String[] args) {
        (new LibraryManagementApplication(LibraryContext.getInstance())).run();

    }
}
