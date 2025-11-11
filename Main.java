import java.io.File;
import java.util.List;

/**
 * Main : exécute toutes les étapes du TP dans l'ordre.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== TP Java I/O - Librairie AlKendi ===");

        // 1) Créer arborescence et fichiers de départ
        GestionFichiers.creerArborescence();

        // 2) Importer le stock depuis workspace/data/stock_initial.csv
        List<Produit> produits = ImportStock.importerProduits("workspace/data/stock_initial.csv");

        // 3) Écrire ventes (deux méthodes)
        VenteManager.writeVenteBuffered("workspace/data/ventes.txt");
        VenteManager.writeVentePrintWriter("workspace/data/ventes.txt");
        VenteManager.appendVenteUtf8("workspace/data/ventes.txt", "2025-11-10T10:00;BK001;3;660.00");

        // 4) Copier un fichier binaire dummy.bin -> workspace/data/photos/BK001.jpg
        FichierBinaire.copier("dummy.bin", "workspace/data/photos/BK001.jpg");

        // 5) Créer index.dat (RandomAccessFile) et rechercher BK003
        IndexProduit.ecrireIndex(produits, "workspace/data/index.dat");
        IndexProduit.seekByRef("workspace/data/index.dat", "BK003");

        // 6) Sérialiser / Désérialiser produits
        SerialisationProduits.sauvegarder(produits, "workspace/data/produits.ser");
        List<Produit> loaded = SerialisationProduits.charger("workspace/data/produits.ser");
        if (loaded != null && !loaded.isEmpty()) {
            System.out.println("Produits chargés : " + loaded.size());
            System.out.println("Premier : " + loaded.get(0));
            System.out.println("Dernier : " + loaded.get(loaded.size() - 1));
        }

        // 7) Afficher arborescence finale
        System.out.println("\n--- Contenu du workspace ---");
        GestionFichiers.listerContenu(new File("workspace"));
        System.out.println("\n=== Fin ===");
    }
}
