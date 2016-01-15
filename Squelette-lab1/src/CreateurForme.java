import java.util.regex.*;




public class CreateurForme {

	
	/**
	 *  Sépare la ligne reçus du serveur pour construire une forme avec les données qu'elle contient
	 * @param s
	 * 			String contenat la ligne reçus du serveur
	 * @return
	 * 			Retourne un nouvelle forme
	 */
	public Formes decryptage(String s){
		String[] tabString;
		String sTemporaire;
		Formes f=null;
		
		tabString=s.split(" ");
	
		sTemporaire=tabString[1];
		if(sTemporaire.equalsIgnoreCase("<CERCLE>")){
			int[] tabIntDonne={Integer.parseInt(tabString[2]), Integer.parseInt(tabString[3]),Integer.parseInt(tabString[4])};
		}else{
			int[] tabIntDonne={Integer.parseInt(tabString[2]), Integer.parseInt(tabString[3]),Integer.parseInt(tabString[4]),Integer.parseInt(tabString[5])};
		}
		switch(sTemporaire){
		case "<CARRE>":
			break;
		case "<RECTANGLE>":
			break;
		case "<OVALE>":
			break;
		case "<LIGNE>":
			break;
		case "<CERCLE>":
			break;
		}
		
		return f;
		
	}
}
