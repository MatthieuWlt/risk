import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Joueur {
	public int numero;
	Color couleur;
	String nomcoul;
	public ArrayList<territoire> list_ter;
	
	public Joueur(int numero, Color couleur, String nomcoul) {
		this.numero=numero;
		this.couleur=couleur;
		this.nomcoul=nomcoul;
		this.list_ter= new ArrayList<territoire>();
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<territoire> getList_ter() {
		return list_ter;
	}

	public void setList_ter(ArrayList<territoire> list_ter) {
		this.list_ter = list_ter;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String getNomcoul() {
		return nomcoul;
	}

	public void setNomcoul(String nomcoul) {
		this.nomcoul = nomcoul;
	}
	public void recupere_mission() {
		
	}
	
	public ArrayList<Integer> affiche_list() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0;i<list_ter.size();i++) {
			territoire t = list_ter.get(i);
			int e=t.getNumero();
			list.add(e);
		}
		return list;
	}
	
	public void affiche(){
		System.out.println("Joueur"+numero+" : "+affiche_list() +"\n"+"Couleur : "+ nomcoul);
	}
	public void territoire_joueur() {
		int a;
		int b=0;
		Random rand = new Random(); 
		for (int i=0;i<list_ter.size();i++) {
			territoire y=(territoire) list_ter.get(i);
			b=b++;
			y.position(y,couleur);
		}
	}
	
	public void armee_joueur(int x) {
		Random rand = new Random();
		int w = 1;
		while (w!=x+1-list_ter.size()) {
			territoire g = (territoire) list_ter.get(rand.nextInt(list_ter.size() - 0)+ 0);
			add_armee(g,1);
			g.position(g,couleur);
			w++;
		}
	}
	
	public void add_armee(territoire t, int p) {
		int r=t.getA();
		r=r+p;
		t.setA(r);
	}
	
	public void sup_armee(territoire t, int p) {
		int r=t.getA();
		r=r-p;
		t.setA(r);
	}
	
	public void attribution_mission(int numero_mission, int choix, Joueur j){
		switch(numero_mission) {
		case 1 :
			Random rand = new Random();
			System.out.println("La mission du joueur"+j.getNumero()+" est de d�truire le joueur"+rand.nextInt(choix - 1)+ 1);
			break;
		case 2 :
			System.out.println("La mission du joueur"+j.getNumero()+" est de conqu�rir tous les territoires");
			break;
		case 3 :
			System.out.println("La mission du joueur"+j.getNumero()+" est de contr�ler 3 r�gions et au moins 18 territoires");
			break;
		case 4 :
			System.out.println("La mission du joueur"+j.getNumero()+" est de contr�ler 18 territoires avec au moins 2 arm�es");
			break;
		case 5 :
			System.out.println("La mission du joueur"+j.getNumero()+" est de contr�ler 30 territoires");
			break;
		case 6 :
			System.out.println("La mission du joueur"+j.getNumero()+" est de contr�ler 24 territoires");
			break;
		case 7 :
			System.out.println("La mission du joueur"+j.getNumero()+" est de contr�ler 21 territoires");
			break;
		case 8 :
			System.out.println("La mission du joueur"+j.getNumero()+" est de contr�ler la plus grosse r�gion et une autre r�gion()");
			break;
		}
	}
	public territoire recherche_ter(int num, Joueur j) {
		for(int i=0; i<j.list_ter.size();i++) {
			territoire h = j.list_ter.get(i);
			int n = h.getNumero();
			if(n==num) {
				return h;
			}
		}
		return null;
	}
	
	public territoire choix_pays(int choix4, Joueur j) {
		//ArrayList<territoire> list_ter=j.list_ter;
		//while (choix4==1) {
			//if (StdDraw.mousePressed()) {
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
				//Am�rique
				if (86.7 < y && y < 90.7 && 5.2<x && x<9.2) {
					territoire t = recherche_ter(1,j);
					return t;
				} else if (78 < y && y < 82 && 10.1<x && x<14.1) {
					territoire t = recherche_ter(2,j);
					return t;
				} 
				else if (56.9 < y && y < 60.9 && 9.8<x && x<13.8) {
					territoire t = recherche_ter(3,j);
					return t;
				} else if (15.9 < x && x < 19.9 && 67.6<y && y<71.6) {
					territoire t = recherche_ter(4,j);
					return t;
				} 
				else if (33.8 < x && x < 37.8 && 91<y && y<95) {
					territoire t = recherche_ter(5,j);
					return t;
				} else if (13.3 < x && x < 17.3 && 86.3<y && y<90.3) {
					territoire t = recherche_ter(6,j);
					return t;
				} 
				else if (17.3 < x && x < 21.3 && 78.9<y && y<82.9) {
					territoire t = recherche_ter(7,j);
					return t;
				} else if (24.1 < x && x < 28.1 && 77.9<y && y<81.9) {
					territoire t = recherche_ter(8,j);
					return t;
				} else if (9.4 < x && x < 13.4 && 70<y && y<74) {
					territoire t = recherche_ter(9,j);
					return t;
				} 
				//Am�rique du sud
				else if (22.3 < x && x < 26.3 && 17.7<y && y<21.7) {
					territoire t = recherche_ter(10,j);	
					return t;
				} else if (25.9 < x && x < 29.9 && 32.5<y && y<36.5) {
					territoire t = recherche_ter(11,j);
					return t;
				} 
				else if (21.2 < x && x < 25.2 && 28.9<y && y<32.9) {
					territoire t = recherche_ter(12,j);			
					return t;
				} else if (20.5 < x && x < 24.5 && 45.2<y && y<49.2) {
					territoire t = recherche_ter(13,j);		
					return t;
				} 
				//Afrique
				else if (50.1 < x && x < 54.1 && 40.2<y && y<44.2) {
					territoire t = recherche_ter(14,j);
					return t;
				} else if (56.6 < x && x < 60.6 && 46.6<y && y<50.6) {
					territoire t = recherche_ter(15,j);
					return t;
				} else if (50.5 < x && x < 54.5 && 60.7<y && y<64.7) {
					territoire t = recherche_ter(16,j);
					return t;
				} else if (58.7 < x && x < 62.7 && 26.2<y && y<30.2) {
					territoire t = recherche_ter(17,j);
					return t;
				} else if (42.6 < x && x < 46.6 && 53.6<y && y<57.6) {
					territoire t = recherche_ter(18,j);			
					return t;
				} else if (50.5 < x && x < 54.5 && 26.2<y && y<30.2) {
					territoire t = recherche_ter(19,j);				
					return t;
				} 
				//Europe
				else if (42.3 < x && x < 46.3 && 79<y && y<83) {
					territoire t = recherche_ter(20,j);			
					return t;
				} else if (38.7 < x && x < 42.7 && 84.6<y && y<88.6) {
					territoire t = recherche_ter(21,j);
					return t;
				} else if (47.6 < x && x < 51.6 && 77.6<y && y<81.6) {
					territoire t = recherche_ter(22,j);		
					return t;
				} else if (47.6 < x && x < 51.6 && 84.6<y && y<88.6) {
					territoire t = recherche_ter(23,j);		
					return t;
				} else if (50.1 < x && x < 54.1 && 71.9<y && y<75.9) {
					territoire t = recherche_ter(24,j);
					return t;
				} else if (53.7 < x && x < 57.7 && 79.7<y && y<83.7) {
					territoire t = recherche_ter(25,j);			
					return t;
				} else if (43.7 < x && x < 47.7 && 71.9<y && y<75.9) {
					territoire t = recherche_ter(26,j);			
					return t;
				}
				//Oc�anie
				else if (90.1 < x && x < 94.1 && 21.9<y && y<25.9) {
					territoire t = recherche_ter(27,j);		
					return t;
				} else if (81.9 < x && x < 85.9 && 41<y && y<45) {
					territoire t = recherche_ter(28,j);
					return t;
				} else if (90.9 < x && x < 94.9 && 36.7<y && y<40.7) {
					territoire t = recherche_ter(29,j);		
					return t;
				} else if (83 < x && x < 87 && 21.2<y && y<25.2) {
					territoire t = recherche_ter(30,j);				
					return t;
				} 
				//Asie
				else if (63 < x && x < 67 && 72.6<y && y<76.6) {
					territoire t = recherche_ter(31,j);		
					return t;
				} else if (75.1 < x && x < 79.1 && 64.2<y && y<68.2) {
					territoire t = recherche_ter(32,j);				
					return t;
				} else if (68.7 < x && x < 72.7 && 57.9<y && y<61.9) {
					territoire t = recherche_ter(33,j);		
					return t;
				} else if (75.5 < x && x < 79.5 && 79<y && y<83) {
					territoire t = recherche_ter(34,j);				
					return t;
				} else if (88.3 < x && x < 92.3 && 67<y && y<71) {
					territoire t = recherche_ter(35,j);			
					return t;
				} else if (85.1 < x && x < 89.1 && 86<y && y<90) {
					territoire t = recherche_ter(36,j);	
					return t;
				} else if (56.9 < x && x < 60.9 && 64.2<y && y<68.2) {
					territoire t = recherche_ter(37,j);
					return t;
				} else if (76.6 < x && x < 80.6 && 72.6<y && y<76.6) {
					territoire t = recherche_ter(38,j);
					return t;
				} else if (77.3 < x && x < 81.3 && 52.2<y && y<56.2) {
					territoire t = recherche_ter(39,j);
					return t;
				} else if (68.4 < x && x < 72.4 && 86<y && y<90) {
					territoire t = recherche_ter(40,j);
					return t;
				} else if (62.6 < x && x < 66.6 && 83.2<y && y<87.2) {
					territoire t = recherche_ter(41,j);
					return t;
				} else if (76.2 < x && x < 80.2 && 86<y && y<90) {
					territoire t = recherche_ter(42,j);
					return t;
				} 
				else {
				}
			//break;
			//} else {
			//}
		//}
			return null;
		
	}
	public void initialisation(int choix4, Joueur j) {
		int i =0;
		while (choix4!=0) {
			if (StdDraw.mousePressed()) {
			System.out.println("Il vous reste "+(19-i)+" arm�es � placer");
			territoire t=choix_pays(1,j);
			add_armee(t, 1);
			i++;
			t.position(t,couleur);
			StdDraw.pause(500);
			if(i==19) {
				break;
			}
			}
			else {
				
			}
		}
	}
	public int de(Joueur j) {
		Random rand = new Random();
		int r=rand.nextInt(6 - 1)+ 1;
		return r;
	}
	
	
	public void phase_attaque(int c, Joueur j1, Joueur j2 ) {
		while (c!=0) {
			if (StdDraw.mousePressed()) { //clique sur un des boutons � droite
				double x = StdDraw.mouseX();
				double y = StdDraw.mouseY();
					if (105 < x && x < 115 && 77<y && y<83) { //lorsqu'on clique sur "attaque"
						System.out.println("choisir un pays");
						StdDraw.pause(500);
						while(c!=0) {
							if (StdDraw.mousePressed()) { //clique sur un territoire
							territoire t1=choix_pays(1,j1); //selection du pays qui attaque
							t1.position(t1,StdDraw.YELLOW); //affichage du pays qui attaque
							StdDraw.pause(500);
							while(c!=0) {
								System.out.println("choisir un pays � attaquer");
								if (StdDraw.mousePressed()) {//clique sur le territoire � attaquer
								territoire t2=choix_pays(1,j2); //selection du pays � attaquer
								int att= de(j1); //r�sultat du d� joueur attaquant
								int def= de(j2); //r�sultat du d� joueur defenseur
								if (att>def) {
									System.out.println("le Joueur"+j1.getNumero()+" gagne");
									add_armee(t2,(t1.getA()-2)); //d�placement arm�e joueur attaquant
									sup_armee(t1,(t1.getA()-1)); 
									j1.list_ter.add(t2); //ajout du territoire au joueur attaquant
									j2.list_ter.remove(t2); //suppression du territoire au joueur defenseur
									t2.position(t2, j1.getCouleur()); //affichage territoire conquis
									t1.position(t1, j1.getCouleur()); //affichage territoire attaquant
									StdDraw.pause(500);
								}
								else if (att<=def) {
									System.out.println("le Joueur"+j1.getNumero()+" perd");
									sup_armee(t1,1); //le joueur attaquant perd un soldat
									t1.position(t1, j1.getCouleur()); //affichage du territoire
									StdDraw.pause(500);
								}
								StdDraw.pause(500);
								break;
								}
							}
							break;
							}
							
						}
					}else if (105 < x && x < 115 && 87<y && y<93) { //lorsqu'on clique sur "finir"
						StdDraw.pause(500);
						break;
					}
					
			}else {
				
			}
		}
	}
}
