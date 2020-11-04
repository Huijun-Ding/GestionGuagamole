package Model;

import java.util.ArrayList;

public class Formation {
    private String nomFormation;
    private AdminRespoF adminRespoF;
    private ArrayList<Groupe> groupes;
    
    public Formation(String nom, AdminRespoF resp) {
        this.nomFormation = nom;
        this.adminRespoF = resp;
        this.groupes = new ArrayList<>();
    }
    
    public String getNomFormation() {
    	return nomFormation;
    }
    
    public void ajouterGroupe() {
        
    }
    
    public void modifierGroupe() {
        
    }    
    
    public void supprimerGroupe() {
        
    }    
}
