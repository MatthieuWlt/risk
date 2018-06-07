import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Partie {
	public int nbre_joueur;
	public int nbre_territoire;
	

	public Partie(int ter, int jou) {
		this.nbre_territoire = ter;
		this.nbre_joueur = jou;
	}

	public int getNbre_joueur() {
		return nbre_joueur;
	}

	public void setNbre_joueur(int nbre_joueur) {
		this.nbre_joueur = nbre_joueur;
	}

	public int getNbre_territoire() {
		return nbre_territoire;
	}

	public void setNbre_territoire(int nbre_territoire) {
		this.nbre_territoire = nbre_territoire;
	}

	public void afficher_map() {
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
	
	public static ArrayList<territoire> randomAvecExclusion(int min, int max){ 
		ArrayList resultat = new ArrayList<territoire>(); 
		Random rand = new Random(); 
		while (resultat.size()!=42){ 
			int s=0;
			territoire res2 = new territoire (rand.nextInt(max - min)+ min,1,null);
			for (int i=0;i<resultat.size();i++) {
				if (res2.getNumero()==((territoire)resultat.get(i)).getNumero()) {
					s++;
				}
			}
			if (s==0) {
				resultat.add(res2);
			}
		} 
		return resultat; 
	}
	
	public ArrayList ajouter_teritoire(Joueur j, List<territoire> l1) {
		for (int i=0;i<l1.size();i++) {
			territoire y=(territoire) l1.get(i);
			j.getList_ter().add(y);
		}
		return j.list_ter;
	}
	
	public static void placementArmeeRestantes(Joueur j1, int choix4, int c) {
		j1.initialisation(choix4, j1, c); // placement des armées du joueur 1
	}
}
