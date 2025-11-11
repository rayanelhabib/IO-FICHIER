
---

## 📘 Description des classes

###  `Produit.java`
Représente un produit du stock avec :
- Référence (`ref`)
- Désignation (`designation`)
- Prix (`prix`)
- Quantité (`qte`)

La classe est **Serializable** pour pouvoir être enregistrée en binaire.

---

###  `GestionFichiers.java`
Crée toute l’**arborescence de travail** (`workspace/`) et les fichiers de base :
- `stock_initial.csv` (stock initial)
- `dummy.bin` (fichier binaire test)
- Méthode pour **lister récursivement** les dossiers et fichiers.

---

###  `ImportStock.java`
Lit le fichier CSV `stock_initial.csv` en **UTF-8**  
et construit une liste d’objets `Produit`.

=> Permet de :
- Charger les produits en mémoire  
- Calculer la **valeur totale du stock**

---

###  `VenteManager.java`
Gère les **écritures de ventes** dans `ventes.txt` :
- `BufferedWriter` pour écrire manuellement
- `PrintWriter` pour formatage et auto-flush
- `appendVenteUtf8()` pour garantir un encodage UTF-8 correct

---

###  `FichierBinaire.java`
Effectue la **copie d’un fichier binaire** (`dummy.bin` → `photos/BK001.jpg`).

Permet d’apprendre :
- L’utilisation de `FileInputStream` / `FileOutputStream`
- La lecture/écriture par **buffers d’octets**
- La **mesure du temps d’exécution** de la copie

---

###  `IndexProduit.java`
Utilise `RandomAccessFile` pour créer un **fichier d’index produit** (`index.dat`).

Fonctionnalités :
- Écrire les références et positions binaires
- Rechercher une référence (`seekByRef`)

Apprentissage :
- Manipulation de fichiers à **accès direct**
- Utilisation de `seek()`, `writeUTF()`, `writeLong()`

---

###  `SerialisationProduits.java`
Permet la **sérialisation et désérialisation** de la liste de produits :
- Sauvegarde → `produits.ser`
- Lecture → reconstitution de la liste

Apprentissage :
- `ObjectOutputStream` / `ObjectInputStream`
- Importance de `Serializable`

---

###  `LoggerApp.java`
Système de **journalisation simple** :
- Écrit dans `logs/app.log`
- Format : `[date] opération - message`
- Utilisé pour toutes les erreurs d’E/S

---

###  `Main.java`
C’est le **point d’entrée** du projet.
Il exécute toutes les étapes du TP dans l’ordre :
1. Crée l’arborescence  
2. Importe le stock  
3. Écrit des ventes  
4. Copie un fichier binaire  
5. Crée un index binaire  
6. Sérialise et désérialise les produits  
7. Affiche le contenu complet du workspace

---

## 💡 Ce qu’on a appris

###  1. Lecture et écriture de fichiers texte
- `FileReader` / `FileWriter` pour les fichiers simples  
- `BufferedReader` / `BufferedWriter` pour plus d’efficacité  
- `PrintWriter` pour un formatage automatique et pratique  

###  2. Encodage UTF-8
- Utiliser `InputStreamReader` et `OutputStreamWriter`
- Gérer les accents et caractères spéciaux dans les fichiers texte

###  3. Flux binaires
- Copier des fichiers avec `FileInputStream` / `FileOutputStream`
- Travailler avec des **buffers d’octets** pour de meilleures performances

###  4. Fichiers à accès direct
- `RandomAccessFile` pour écrire/lire à des positions précises  
- Comprendre la différence entre **lecture séquentielle** et **aléatoire**

###  5. Sérialisation Java
- Sauvegarder des objets complets avec `ObjectOutputStream`
- Lire et recharger les objets avec `ObjectInputStream`

###  6. Journalisation
- Gestion des erreurs avec un **log fichier**
- Comprendre l’intérêt de `try-with-resources` et du **flush()**

---

##  Technologies utilisées
- **Java SE 17+**
- API **`java.io`** et **`java.nio.charset`**
- Encodage **UTF-8**
- IDE : Visual Studio Code / IntelliJ IDEA

---

## => Exécution

### 1️ Compiler tous les fichiers
```bash
javac src/*.java

!! WA7ed l7aja sghria ila bghito run code diro weste dossier qui s appel src apres compilih with javac
