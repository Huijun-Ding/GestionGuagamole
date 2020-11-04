package Model;

import java.util.ArrayList;

public class Groupe {

    private int numGroupe;
    private Formation formation;
    private ArrayList<Etudiant> etudiants;
    private ArrayList<TP> listeTPs;

    public Groupe(int num, Formation f) {
        this.numGroupe = num;
        this.formation = f;
        this.etudiants = new ArrayList<>();
        this.listeTPs = new ArrayList<>();
    }

    public ArrayList<TP> getListeTPs() {
        return listeTPs;
    }

    public void ajouterTP(TP tp) {
        this.listeTPs.add(tp);
    }

    public void removeListTPs(TP tp) {
        this.listeTPs.remove(tp);
    }
    
    public int getNumGroupe() {
        return numGroupe;
    }

    public void ajouterEtudiantGroupe(Etudiant etu) {
        this.etudiants.add(etu);
    }

    public void supprimerEtudiantGroupe(Etudiant e) {
        this.etudiants.remove(e);
    }
    
    public ArrayList<Etudiant> getEtudiants() {
        return this.etudiants;
    }

    public int getNbEtudiant() {
        return this.etudiants.size();
    }
}
