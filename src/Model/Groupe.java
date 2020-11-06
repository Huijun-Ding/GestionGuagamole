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
    
    public void ajouterEtudiantGroupe() {
        
    }
    
    public void supprimerEtudiantGroupe() {
        
    }
    
    public void addListTPs() {
        
    }
    
    public void removeListTPs() {
        
    }
    
    public ArrayList<TP> getListTPs() {
        return this.listTPs;
    }
    
    public String getNumG() {
    	return this.numGroupe;
    }
}
