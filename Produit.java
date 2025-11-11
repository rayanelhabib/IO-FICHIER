import java.io.Serializable;

public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ref;
    private String designation;
    private double prix;
    private int qte;

    public Produit(String ref, String designation, double prix, int qte) {
        this.ref = ref;
        this.designation = designation;
        this.prix = prix;
        this.qte = qte;
    }

    public String getRef() { return ref; }
    public String getDesignation() { return designation; }
    public double getPrix() { return prix; }
    public int getQte() { return qte; }

    @Override
    public String toString() {
        return ref + ";" + designation + ";" + prix + ";" + qte;
    }
}
