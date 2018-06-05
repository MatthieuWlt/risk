import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class mission {

	public boolean winner = false;
	public int numero_mission;

	public mission(boolean w, int numero_mission) {
		this.winner = w;
		this.numero_mission = numero_mission;
	}
	
	public static void Chat_Box_Mission(Joueur j) {
		int choixmissionj = 0;
		Random rand = new Random();
		while (choixmissionj == 0) {
			if (StdDraw.isMousePressed()) {
				double x4 = StdDraw.mouseX();// on recupere la coordonnée de x cliqué
				double y4 = StdDraw.mouseY();// on recupere la coordonnée de y cliqué
				if (x4 < 116 && x4 > 104 && y4 < 104 && y4 > 96) {// si elles sont sur le bouton
					int missionj = rand.nextInt(8 - 1) + 1;// on choisit une mission aléatoire
					j.attribution_mission(missionj, 2, j);// on attribut une mission au joueur 1
					j.setMission(missionj);// on attribut la mission 1 au joueur 1
					StdDraw.pause(500);
					choixmissionj = 1;// on termine la boucle while					
				} else {
					choixmissionj = 0;// on redemande au joueur de choisir sa mission
					StdDraw.text(60, 105, " Joueur "+ j.getNumero()+", découvrez votre mission");// affichage
				}
			} else {
				choixmissionj = 0;// on demande au joueur de choisir sa mission
				StdDraw.text(60, 105, "Joueur "+ j.getNumero()+", découvrez votre mission");// affichage
			}
		}
	}
	
}
