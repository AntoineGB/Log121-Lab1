
/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CommBase.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/

import java.beans.PropertyChangeListener;
import java.io.*;
import java.net.*;
import javax.swing.SwingWorker;

/**
 * Base d'une communication via un fil d'exécution parallèle.
 */
public class CommBase {

	private final int DELAI = 1000;
	private SwingWorker threadComm = null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	private String host = "localhost";
	private int port = 10000;

	/**
	 * Constructeur
	 */
	public CommBase() {
	}

	/**
	 * D�finir le r�cepteur de l'information re�ue dans la communication avec le
	 * serveur
	 * 
	 * @param listener
	 *            sera alerté lors de l'appel de "firePropertyChanger" par le
	 *            SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener) {
		this.listener = listener;
	}

	/**
	 * Démarre la communication
	 */
	public void start() {
		creerCommunication();
	}

	/**
	 * Arrête la communication
	 */
	public void stop() {
		if (threadComm != null)
			threadComm.cancel(true);
		isActif = false;
	}

	/**
	 * Créer le nécessaire pour la communication avec le serveur
	 */
	protected void creerCommunication() {

		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");
				Socket socket = null;
				String ligne = null;
				Boolean bool = true;
				try {
					socket = new Socket(host, port);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter out = new BufferedWriter(new PrintWriter(socket.getOutputStream()));

				while (true) {
					Thread.sleep(DELAI);

					// C'EST DANS CETTE BOUCLE QU'ON COMMUNIQUE AVEC LE
					// SERVEUR

					out.write("GET\n");
					out.flush();
					ligne = in.readLine();

					// C'EST ICI QUE L'ON V�RIFIE SI LA LIGNE EST BONNE
					if (ligne.charAt(0) == 'c') {
						bool = false;
					} else {
						bool = true;
					}

					// La méthode suivante alerte l'observateur
					if (listener != null && bool)
						firePropertyChange("ENVOIE-TEST", null, ligne);
				}
				// return null;
			}
		};
		if (listener != null)
			threadComm.addPropertyChangeListener(listener); // La méthode
															// "propertyChange"
															// de
															// ApplicationFormes
															// sera donc
															// appelée lorsque
															// le SwinkWorker
															// invoquera la
															// méthode
															// "firePropertyChanger"
		threadComm.execute(); // Lance le fil d'exécution parallèle.
		isActif = true;
	}

	/**
	 * @return si le fil d'exécution parallèle est actif
	 */
	public boolean isActif() {
		return isActif;
	}
}
