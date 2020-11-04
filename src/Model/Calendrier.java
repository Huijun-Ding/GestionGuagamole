package Model;

import java.util.Date;

public class Calendrier {
    private Creneau heure;
    private Date date;
    
    public Calendrier(Creneau t, Date j) {
        this.date = j;
        this.heure = t;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public Creneau getHeure() {
        return this.heure;
    }
    
    public void setHeure(Creneau heure) {
		this.heure = heure;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean equals(Object o) {
            if (o instanceof Calendrier) { //tester si o est une object/type ActionSimple
                    Calendrier as = (Calendrier)o;
                    if (this.getDate().equals(as.getDate()) && this.getHeure().equals(as.getHeure())) {
                            return true;
                    } else {
                            return false;
                    }
            } else {
                    return false;
            }
    }
    
    public String toString(){//overriding the toString() method  
        return this.date+" "+this.heure;  
    }  

    public int hashCode() {
        String hashString = this.toString();  // donner un code hash
        return hashString.hashCode();
    }
}
