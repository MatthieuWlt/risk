import edu.princeton.cs.introcs.StdDraw;

public class View {

	// Fonction permettant d'afficher une image en fond
	public static void afficherFond(double x, double y, String fichier) {
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.picture(x, y, fichier);
		StdDraw.pause(500);
	}

	// Fonction permettant d'afficher une image
	public static void afficherImage(double x, double y, String fichier) {
		StdDraw.picture(x, y, fichier);
	}

	//Fonction permettant d'afficher le plateau de jeu
	public static void afficher_map() {
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.picture(50.0,50.0,"IMAGE/parchemin_2.png");
		StdDraw.picture(50.0,50.0,"IMAGE/map.png");
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledRectangle(110, 100, 8, 4);// bouton mission
		StdDraw.filledRectangle(110, 90, 8, 4);// bouton finir son tour
		StdDraw.filledRectangle(110, 80, 8, 4);// bouton attaquer
		StdDraw.filledRectangle(110, 70, 8, 4);// bouton se déplacer
		StdDraw.setPenColor(StdDraw.ORANGE);
		StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
		StdDraw.setPenColor(StdDraw.BLACK);// couleur de l'écriture
		StdDraw.text(110, 100, "mission");// texte
		StdDraw.text(110, 90, "finir");// texte
		StdDraw.text(110, 80, "attaque");// texte
		StdDraw.text(110, 70, "mouvement");// texte
		StdDraw.text(25, 105, "Chat-Box : ");//texte	
	}
	
	// Fonction qui affiche les images des personnages au moment du choix
	public static void affichage_personnage(int i, String perso1, String perso2, String perso3) {
		if(i==1) {
			StdDraw.clear(StdDraw.WHITE);
			StdDraw.picture(50.0,50.0,"IMAGE/parchemin_2.png");
			View.afficherImage(60.0, 45.0, perso1);
			StdDraw.pause(500);
		}
		
		else if (i==2) {
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.picture(50.0,50.0,"IMAGE/parchemin_2.png");
		View.afficherImage(35.0, 45.0, perso1);
		View.afficherImage(85.0, 45.0, perso2);
		StdDraw.pause(500);
		}
		
		else if (i==3) {
			StdDraw.clear(StdDraw.WHITE);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.picture(50.0,50.0,"IMAGE/parchemin_2.png");
			View.afficherImage(20.0, 45.0, perso1);
			View.afficherImage(60.0, 45.0, perso2);
			View.afficherImage(100.0, 45.0, perso3);
			StdDraw.pause(500);
		}
	}
}
