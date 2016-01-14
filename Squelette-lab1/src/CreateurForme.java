import java.util.regex.*;




public class CreateurForme {

	
	public Formes decryptage(String s){
		String[] tabString;
		String sTemporaire;
		Formes f=null;
		
		tabString=s.split(" ");
	
		sTemporaire=tabString[1];
		if(sTemporaire.equalsIgnoreCase("<CARRE>")){
			String[] tabStringTempo={tabString[2], tabString[3],tabString[4],tabString[5]};
			f=CreationCarre(tabStringTempo);
		}
		if(sTemporaire.equalsIgnoreCase("<RECTANGLE>")){
			String[] tabStringTempo={tabString[2], tabString[3],tabString[4],tabString[5]};
			f=CreationRectangle(tabStringTempo);
		}
		if(sTemporaire.equalsIgnoreCase("<CERCLE>")){
			String[] tabStringTempo={tabString[2], tabString[3],tabString[4]};
			f=CreationCercle(tabStringTempo);
		}
		if(sTemporaire.equalsIgnoreCase("<OVALE>")){
			String[] tabStringTempo={tabString[2], tabString[3],tabString[4],tabString[5]};
			f=CreationOvale(tabStringTempo);
		}
		if(sTemporaire.equalsIgnoreCase("<LIGNE>")){
			String[] tabStringTempo={tabString[2], tabString[3],tabString[4],tabString[5]};
			f=CreationLigne(tabStringTempo);
		}
		
		return f;
		
	}
	private Formes CreationLigne(String[] tabStringTempo) {
		// TODO Auto-generated method stub
		return null;
	}

	private Formes CreationOvale(String[] tabStringTempo) {
		// TODO Auto-generated method stub
		return null;
	}

	private Formes CreationCercle(String[] tabStringTempo) {
		// TODO Auto-generated method stub
		return null;
	}

	private Formes CreationRectangle(String[] tabStringTempo) {
		// TODO Auto-generated method stub
		return null;
	}

	private Formes CreationCarre(String[] tabStringTempo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
