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
	
	//Cette classe repartie tous les territoires dans une liste de 42 territoires
	public static ArrayList<territoire> randomAvecExclusion(int min, int max){
		//création d'une liste de territoires
		ArrayList resultat = new ArrayList<territoire>(); 
		Random rand = new Random();
		//tant que tous les territoires ne sont pas attribues
		while (resultat.size()!=42){ 
			//on initialise le numero du territoire
			int s=0;
			//on choisit aleatoirement un numero de territoire
			territoire res2 = new territoire (rand.nextInt(max - min)+ min,1,null);
			//on parcourt la liste de territoires
			for (int i=0;i<resultat.size();i++) {
				//si le territoire tiré au sort ne correspond pas au territoire de la liste territoire[i] on passe au suivant
				if (res2.getNumero()==((territoire)resultat.get(i)).getNumero()) {
					s++;
				}
			}
			//si le territoire tirer au sort n'est pas detecte 
			if (s==0) {
				//on ajoute a la liste le territoire tire au sort
				resultat.add(res2);
			}
		} 
		return resultat; 
	}
	
	//Cette fonction attribue une liste a un joueur
	public ArrayList ajouter_teritoire(Joueur j, List<territoire> l1) {
		//ajoute tous les territoires a la liste du joueur
		for (int i=0;i<l1.size();i++) {
			//recupere le territoire à la i eme position dans la liste l1
			territoire y=(territoire) l1.get(i);
			//ajoute le territoire y a la liste du joueur
			j.getList_ter().add(y);
		}
		return j.list_ter;
	}
	
	public static void placementArmeeRestantes(Joueur j1, int choix4) {
		j1.initialisation(choix4, j1, 5); // placement des armées du joueur 1
	}
	
}
