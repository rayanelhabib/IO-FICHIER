import java.io.*;
import java.util.List;

public class SerialisationProduits {

    public static void sauvegarder(List<Produit> produits, String chemin) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(chemin))) {
            oos.writeObject(produits);
        } catch (IOException e) {
            LoggerApp.logErreur("Serialisation", e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Produit> charger(String chemin) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(chemin))) {
            return (List<Produit>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            LoggerApp.logErreur("Deserialisation", e.getMessage());
        }
        return null;
    }
}
