import java.io.File;

public class GestionFichiers {

    public static void creerArborescence() {
        String[] paths = {
            "workspace/data/photos",
            "workspace/logs",
            "workspace/tmp"
        };

        for (String path : paths) {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
                System.out.println("Créé : " + dir.getAbsolutePath());
            } else {
                System.out.println("Existe déjà : " + dir.getAbsolutePath());
            }
        }
    }

    public static void listerContenu(File dossier) {
        File[] files = dossier.listFiles();
        if (files == null) return;
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println("[Dossier] " + f.getName());
                listerContenu(f);
            } else {
                System.out.println("  [Fichier] " + f.getName() + " (" + f.length() + " octets)");
            }
        }
    }
}
