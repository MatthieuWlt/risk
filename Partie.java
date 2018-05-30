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
			y.setJ(j);
			j.getList_ter().add(y);
		}
		return j.list_ter;
	}
}
