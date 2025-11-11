import java.io.*;

public class FichierBinaire {

    public static void copier(String source, String destination) {
        long start = System.currentTimeMillis();
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(destination)) {

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            LoggerApp.logErreur("FichierBinaire", e.getMessage());
        }
        long end = System.currentTimeMillis();
        System.out.println("Copie terminée en " + (end - start) + " ms");
    }
}
