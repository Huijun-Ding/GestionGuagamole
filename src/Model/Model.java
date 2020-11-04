package Model;

public class Model {
	
		public AdminMateriel connexion(int id, String mdp, int i ) {
			AdminMateriel a = null;
				if(id==1234 && mdp.equals("123456")) {
					a = new AdminMateriel(1234,"123456","Duan","Chengyu");
				}
				return a;
		}
}

