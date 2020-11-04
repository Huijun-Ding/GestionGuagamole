package Model;

import java.util.ArrayList;

public class Groupe {
    private String numGroupe;
    private Formation formation;
    private ArrayList<Etudiant> etudiants;
    private ArrayList<TP>listeTP;
    
    public Groupe(String num, Formation f) {
        this.numGroupe = num;
        this.formation = f;
        this.etudiants = new ArrayList<>();
        this.listeTP = new ArrayList<>();
    }
    
    public ArrayList<TP> getListeTP() {
		return listeTP;
	}
   
    public void ajouterTP(TP tp) {
		listeTP.add(tp);
    	
    }

	public String getNumGroupe() {
    	return numGroupe;
    }
	
    public void ajouterEtudiantGroupe(Etudiant etu) {
    	etudiants.add(etu);
        
    }
    
    public void supprimerEtudiantGroupe() {
        
    }
}
