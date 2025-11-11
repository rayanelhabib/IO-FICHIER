import java.io.*;
import java.time.LocalDateTime;

public class LoggerApp {
    private static final String LOG_PATH = "workspace/logs/app.log";

    public static void logErreur(String operation, String message) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(LOG_PATH, true))) {
            pw.printf("[%s] %s - %s%n", LocalDateTime.now(), operation, message);
        } catch (IOException e) {
            System.err.println("Erreur d'écriture du log : " + e.getMessage());
        }
    }
}
