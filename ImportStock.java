import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ImportStock {

    public static List<Produit> importerProduits(String chemin) {
        List<Produit> produits = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(chemin), StandardCharsets.UTF_8))) {

            String line;
            boolean header = true;
            while ((line = br.readLine()) != null) {
                if (header) { header = false; continue; }
                String[] t = line.split(";");
                Produit p = new Produit(t[0], t[1], Double.parseDouble(t[2]), Integer.parseInt(t[3]));
                produits.add(p);
            }
            double total = produits.stream().mapToDouble(p -> p.getPrix() * p.getQte()).sum();
            System.out.println("Produits importés : " + produits.size());
            System.out.println("Valeur totale du stock : " + total);

        } catch (IOException e) {
            LoggerApp.logErreur("ImportStock", e.getMessage());
        }
        return produits;
    }
}
