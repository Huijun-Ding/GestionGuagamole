package Model;

public class Model {
	
		public AdminMateriel connexion(String id, String mdp, int i ) {
			AdminMateriel a = null;
				if(id.equals("admin") && mdp.equals("123456")) {
					a = new AdminMateriel("admin","123456","Duan","Chengyu");
				}
				return a;
		}
}

