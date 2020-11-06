package Model;

import java.util.ArrayList;

public class Groupe {

    private String numGroupe;
    private Formation formation;
    private ArrayList<Etudiant> etudiants;
    private ArrayList<TP> listTPs;

    public Groupe(String num, Formation f) {
        this.numGroupe = num;
        this.formation = f;
    }

    public void ajouterTP(TP tp) {
        this.listTPs.add(tp);
    }

    public void ajouterEtudiantGroupe(Etudiant etu) {
        this.etudiants.add(etu);
    }

    public ArrayList<TP> getListTPs() {
        return this.listTPs;
    }

    public String getNumG() {
        return this.numGroupe;
    }

    public Formation getFormation() {
        return this.formation;
    }
}
