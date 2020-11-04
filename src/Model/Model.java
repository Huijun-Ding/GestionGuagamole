<<<<<<< HEAD
package Model;

public class Model {
	
		public AdminMateriel connexion(String id, String mdp, int i ) {
				if(id.equals("admin") && mdp.equals("123456")) {
					AdminMateriel a = new AdminMateriel("admin","123456","Duan","Chengyu");
					return a;
				}
				return null;
		}
}
=======
package Model;

public class Model {
		public boolean connexion(String id, String mdp, int i ) {
			return true;
		}
}
>>>>>>> af169c0d8c2fce09538d60003d18d2d11a892b9f
