package Model;

import java.util.ArrayList;

public class Groupe {
    private String numGroupe;
    private Formation formation;
    private ArrayList<Etudiant> etudiants;
    private ArrayList<TP>listeTPs;

    
    public Groupe(String num, Formation f) {
        this.numGroupe = num;
        this.formation = f;
        this.etudiants = new ArrayList<>();
        this.listeTPs = new ArrayList<>();
    }
    
    public ArrayList<TP> getListeTPs() {
		return listeTPs;
	}
   
    public void ajouterTP(TP tp) {
		listeTPs.add(tp);
    	
    }

	public String getNumGroupe() {
    	return numGroupe;
    }
	
    public void ajouterEtudiantGroupe(Etudiant etu) {
    	etudiants.add(etu);
        
    }
    
    public void supprimerEtudiantGroupe() {
        
    }
    
    public void addListTPs() {
        
    }
    
    public void removeListTPs() {
        
    }
    
}
