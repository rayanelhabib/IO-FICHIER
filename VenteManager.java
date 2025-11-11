import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class VenteManager {

    public static void writeVenteBuffered(String chemin) {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(chemin, true), StandardCharsets.UTF_8))) {
            bw.write(LocalDateTime.now() + ";BK002;2;361.00");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            LoggerApp.logErreur("writeVenteBuffered", e.getMessage());
        }
    }

    public static void writeVentePrintWriter(String chemin) {
        try (PrintWriter out = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(chemin, true), StandardCharsets.UTF_8), true)) {
            out.printf("%s;%s;%d;%.2f%n", LocalDateTime.now(), "BK003", 1, 199.90);
        } catch (IOException e) {
            LoggerApp.logErreur("writeVentePrintWriter", e.getMessage());
        }
    }

    public static void appendVenteUtf8(String chemin, String texte) {
        try (PrintWriter out = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(chemin, true), StandardCharsets.UTF_8))) {
            out.println(texte);
        } catch (IOException e) {
            LoggerApp.logErreur("appendVenteUtf8", e.getMessage());
        }
    }
}
