import java.io.*;
import java.util.List;

public class IndexProduit {

    public static void ecrireIndex(List<Produit> produits, String chemin) {
        try (RandomAccessFile raf = new RandomAccessFile(chemin, "rw")) {
            for (Produit p : produits) {
                raf.writeUTF(p.getRef());
                raf.writeLong(raf.getFilePointer()); // position fictive
            }
        } catch (IOException e) {
            LoggerApp.logErreur("IndexProduit", e.getMessage());
        }
    }

    public static long seekByRef(String chemin, String ref) {
        try (RandomAccessFile raf = new RandomAccessFile(chemin, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                String r = raf.readUTF();
                long pos = raf.readLong();
                if (r.equals(ref)) {
                    System.out.println("Position trouvée pour " + ref + " : " + pos);
                    return pos;
                }
            }
        } catch (IOException e) {
            LoggerApp.logErreur("seekByRef", e.getMessage());
        }
        return -1;
    }
}
