import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import edu.princeton.cs.introcs.StdDraw;

public class IA {
	public Joueur j;
	public Partie p;

	public IA(Joueur j, Partie p) {
		this.j=j;
		this.p=p;
	}
	
	public void IA_placementArmeeRestantes(Joueur j2, int c) {//c représente le  nombre d'armées restantes
		StdDraw.setPenColor(StdDraw.ORANGE);
		StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(25, 105, "Chat-Box : ");//texte
		StdDraw.text(60, 105, "J"+j.getNumero()+" place" );
		IA_verif_region(c);
	}
	
	public void IA_initialisation(Joueur j2, int c) {
		territoire t1 = choix_joueur(j2);
		int a = c/2;
		j2.add_armee(t1, a);
		territoire t2 = choix_joueur(j2);
		j2.add_armee(t2, c-a);
		System.out.println(t2.getA());
	}
	
	public void IA_verif_region(int c) {
		int w=0;
		if (c==19||c==17) {
			w = 6;
		}
		else if (c==21||c==20) {
			w=7;
		}
		else if(c==13) {
			w=4;
		}
		Region r1 = new Region(1);
		Region r2 = new Region(2);
		Region r3 = new Region(3);
		Region r4 = new Region(4);
		Region r5 = new Region(5);
		Region r6 = new Region(6);
		ArrayList<territoire> L = j.getList_ter();
		//Cas où l'IA contôle un territoire entier dès le début
		if(r1.region(j)==9) {
			territoire t1= j.recherche_ter(1, j);
			territoire t2=j.recherche_ter(5, j);
			territoire t3=j.recherche_ter(3, j);
			j.add_armee(t1,w);
			j.add_armee(t2,w);
			j.add_armee(t3,c-2*w);
			t1.position(t1, j.getCouleur());
			t2.position(t2, j.getCouleur());
			t3.position(t3, j.getCouleur());
			StdDraw.pause(500);
		}
		else if(r2.region(j)==4) {
			territoire t1= j.recherche_ter(11, j);
			territoire t2=j.recherche_ter(13, j);
			j.add_armee(t1,w+3);
			j.add_armee(t2,c-(w+3));
			t1.position(t1, j.getCouleur());
			t2.position(t2, j.getCouleur());
			StdDraw.pause(500);
		}
		else if(r3.region(j)==6) {
			territoire t1= j.recherche_ter(15, j);
			territoire t2=j.recherche_ter(16, j);
			territoire t3=j.recherche_ter(18, j);
			j.add_armee(t1,w);
			j.add_armee(t2,w);
			j.add_armee(t3,c-w*2);
			t1.position(t1, j.getCouleur());
			t2.position(t2, j.getCouleur());
			t3.position(t3, j.getCouleur());
			StdDraw.pause(500);
		}
		else if(r4.region(j)==7) {
			territoire t1= j.recherche_ter(21, j);
			territoire t2=j.recherche_ter(24, j);
			territoire t3=j.recherche_ter(25, j);
			territoire t4=j.recherche_ter(26, j);
			j.add_armee(t1,c-3*(w-1));
			j.add_armee(t2,w-1);
			j.add_armee(t3,w-1);
			j.add_armee(t4,w-1);
			t1.position(t1, j.getCouleur());
			t2.position(t2, j.getCouleur());
			t3.position(t3, j.getCouleur());
			t4.position(t4, j.getCouleur());
			StdDraw.pause(500);
		}
		else if(r5.region(j)==4) {
			if(j.recherche_ter(39,j)!=null) {
				j.add_armee(j.recherche_ter(39,j),c);
				j.recherche_ter(39,j).position(j.recherche_ter(39,j), j.getCouleur());
				StdDraw.pause(500);
			}
			else {
				territoire t1= j.recherche_ter(28, j);
				j.add_armee(t1,c);
				t1.position(t1, j.getCouleur());
				StdDraw.pause(500);
			}
		}
		else if(r6.region(j)==12) {
			territoire t1= j.recherche_ter(39, j);
			territoire t2=j.recherche_ter(36, j);
			territoire t3=j.recherche_ter(41, j);
			territoire t4=j.recherche_ter(31, j);
			territoire t5=j.recherche_ter(37, j);
			if(j.recherche_ter(25,j)!=null) {
				j.add_armee(j.recherche_ter(25,j),w-1);
				j.add_armee(t1,w-1);
				j.add_armee(t2,w-1);
				j.add_armee(t5,c-3*(w-1));
				t1.position(t1, j.getCouleur());
				t2.position(t2, j.getCouleur());
				t5.position(t5, j.getCouleur());
				j.recherche_ter(25,j).position(j.recherche_ter(25,j), j.getCouleur());
				StdDraw.pause(500);
			}
			else {
				j.add_armee(t1,w-2);
				j.add_armee(t2,w-2);
				j.add_armee(t3,c-(w-2)*4);
				j.add_armee(t4,w-2);
				j.add_armee(t5,w-2);
				t1.position(t1, j.getCouleur());
				t2.position(t2, j.getCouleur());
				t3.position(t3, j.getCouleur());
				t4.position(t4, j.getCouleur());
				t5.position(t5, j.getCouleur());
				StdDraw.pause(500);		
			}	
		}
		else {
			ArrayList<Double> list=  new ArrayList<Double>();
			double a1 = Math.round(((double)r1.region(j)/(double)9)*100);
			list.add(a1);
			double a2=Math.round(((double)r2.region(j)/(double)4)*100);
			list.add(a2);
			double a3 = Math.round(((double)r3.region(j)/(double)6)*100);
			list.add(a3);
			double a4 = Math.round(((double)r4.region(j)/(double)7)*100);
			list.add(a4);
			double a5 = Math.round(((double)r5.region(j)/(double)4)*100);
			list.add(a5);
			double a6 = Math.round(((double)r6.region(j)/(double)12)*100);
			list.add(a6);
			
			double f= Collections.max(list);
			System.out.println(f);
			//Amérique du nord
			if (f==a1) {
				territoire t1= j.recherche_ter(1, j);
				territoire t2=j.recherche_ter(2, j);
				territoire t3=j.recherche_ter(3, j);
				territoire t4= j.recherche_ter(4, j);
				territoire t5=j.recherche_ter(5, j);
				territoire t6=j.recherche_ter(6, j);
				territoire t7= j.recherche_ter(7, j);
				territoire t8=j.recherche_ter(8, j);
				territoire t9=j.recherche_ter(9, j);
				if (r1.region(j)==8) {
					if(t1==null) {
						j.add_armee(t6,w-1);
						j.add_armee(t2,c-3*(w-1));
						j.add_armee(t3,w-1);
						j.add_armee(t5,w-1);
						t6.position(t6, j.getCouleur());
						t2.position(t2, j.getCouleur());
						t3.position(t3, j.getCouleur());
						t5.position(t5, j.getCouleur());
						StdDraw.pause(500);	
					}
					else if(t3==null) {
						j.add_armee(t4,w-1);
						j.add_armee(t9,c-3*(w-1));
						j.add_armee(t5,w-1);
						j.add_armee(t1,w-1);
						t4.position(t4, j.getCouleur());
						t9.position(t9, j.getCouleur());
						t5.position(t5, j.getCouleur());
						t1.position(t1, j.getCouleur());
						StdDraw.pause(500);	
					}
					else if(t5==null) {
						j.add_armee(t6,w-2);
						j.add_armee(t8,c-(w-2)*4);
						j.add_armee(t7,w-2);
						j.add_armee(t3,w-2);
						j.add_armee(t1,w-2);
						t6.position(t6, j.getCouleur());
						t8.position(t8, j.getCouleur());
						t7.position(t7, j.getCouleur());
						t3.position(t3, j.getCouleur());
						t1.position(t1, j.getCouleur());
						StdDraw.pause(500);	
					}
					else {
						j.add_armee(t1, w);
						j.add_armee(t3, w);
						j.add_armee(t5, c-w*2);
						t1.position(t1, j.getCouleur());
						t3.position(t3, j.getCouleur());
						t5.position(t5, j.getCouleur());
						StdDraw.pause(500);	
					}
				}
				else if(r1.region(j)==7) {
					if(t1==null&&t5==null) {
						j.add_armee(t2,c-(w-2)*4);
						j.add_armee(t6,w-2);
						j.add_armee(t7,w-2);
						j.add_armee(t8,w-2);
						j.add_armee(t3,w-2);
						t2.position(t2, j.getCouleur());
						t6.position(t6, j.getCouleur());
						t7.position(t7, j.getCouleur());
						t8.position(t8, j.getCouleur());
						t3.position(t3, j.getCouleur());
						StdDraw.pause(500);	
					}
					else if(t1==null&&t3==null) {
						j.add_armee(t2,c-(w-2)*4);
						j.add_armee(t6,w-2);
						j.add_armee(t9,w-2);
						j.add_armee(t4,w-2);
						j.add_armee(t5,w-2);
						t2.position(t2, j.getCouleur());
						t6.position(t6, j.getCouleur());
						t9.position(t9, j.getCouleur());
						t4.position(t4, j.getCouleur());
						t5.position(t5, j.getCouleur());
						StdDraw.pause(500);	
					}
					else if(t3==null&&t5==null) {
						j.add_armee(t8,c-(w-2)*4);
						j.add_armee(t6,w-2);
						j.add_armee(t9,w-2);
						j.add_armee(t4,w-2);
						j.add_armee(t1,w-2);
						t8.position(t8, j.getCouleur());
						t6.position(t6, j.getCouleur());
						t9.position(t9, j.getCouleur());
						t4.position(t4, j.getCouleur());
						t1.position(t1, j.getCouleur());
						StdDraw.pause(500);	
					}
					else if(t1==null) {
						if(t6==null) {
							j.add_armee(t2,w-1);
							j.add_armee(t7,c-3*(w-1));
							j.add_armee(t5,w-1);
							j.add_armee(t3,w-1);
							t2.position(t2, j.getCouleur());
							t7.position(t7, j.getCouleur());
							t5.position(t5, j.getCouleur());
							t3.position(t3, j.getCouleur());
							StdDraw.pause(500);	
						}
						else if(t2==null) {
							j.add_armee(t6,c-(w-2)*4);
							j.add_armee(t7,w-2);
							j.add_armee(t9,w-2);
							j.add_armee(t3,w-2);
							j.add_armee(t5,w-2);
							t6.position(t6, j.getCouleur());
							t7.position(t7, j.getCouleur());
							t9.position(t9, j.getCouleur());
							t3.position(t3, j.getCouleur());
							t5.position(t5, j.getCouleur());
							StdDraw.pause(500);	
						}
						else {
							j.add_armee(t6,w-1);
							j.add_armee(t2,c-3*(w-1));
							j.add_armee(t3,w-1);
							j.add_armee(t5,w-1);
							t6.position(t6, j.getCouleur());
							t2.position(t2, j.getCouleur());
							t3.position(t3, j.getCouleur());
							t5.position(t5, j.getCouleur());
							StdDraw.pause(500);	
						}
					}
					else if(t3==null) {
						if(t4==null) {
							j.add_armee(t9,c-(w-2)*4);
							j.add_armee(t7,w-2);
							j.add_armee(t8,w-2);
							j.add_armee(t1,w-2);
							j.add_armee(t5,w-2);
							t9.position(t9, j.getCouleur());
							t7.position(t7, j.getCouleur());
							t8.position(t8, j.getCouleur());
							t1.position(t1, j.getCouleur());
							t5.position(t5, j.getCouleur());
							StdDraw.pause(500);	
						}
						else if(t9==null) {
							j.add_armee(t2,c-(w-2)*4);
							j.add_armee(t7,w-2);
							j.add_armee(t4,w-2);
							j.add_armee(t1,w-2);
							j.add_armee(t5,w-2);
							t2.position(t2, j.getCouleur());
							t7.position(t7, j.getCouleur());
							t4.position(t4, j.getCouleur());
							t1.position(t1, j.getCouleur());
							t5.position(t5, j.getCouleur());
							StdDraw.pause(500);	
						}
						else {
							j.add_armee(t4,w-1);
							j.add_armee(t9,c-3*(w-1));
							j.add_armee(t5,w-1);
							j.add_armee(t1,w-1);
							t4.position(t4, j.getCouleur());
							t9.position(t9, j.getCouleur());
							t5.position(t5, j.getCouleur());
							t1.position(t1, j.getCouleur());
							StdDraw.pause(500);	
						}
					}
					else if(t5==null) {
						if(t6==null) {
							j.add_armee(t1,w);
							j.add_armee(t8,w);
							j.add_armee(t3,c-w*2);
							t1.position(t1, j.getCouleur());
							t8.position(t8, j.getCouleur());
							t3.position(t3, j.getCouleur());
							StdDraw.pause(500);	
						}else if(t7==null) {
							j.add_armee(t6,w-1);
							j.add_armee(t8,c-3*(w-1));
							j.add_armee(t3,w-1);
							j.add_armee(t1,w-1);
							t6.position(t6, j.getCouleur());
							t8.position(t8, j.getCouleur());
							t3.position(t3, j.getCouleur());
							t1.position(t1, j.getCouleur());
							StdDraw.pause(500);	
						}else if(t8==null) {
							j.add_armee(t7,w-2);
							j.add_armee(t6,c-(w-2)*4);
							j.add_armee(t4,w-2);
							j.add_armee(t1,w-2);
							j.add_armee(t3,w-2);
							t7.position(t7, j.getCouleur());
							t6.position(t6, j.getCouleur());
							t4.position(t4, j.getCouleur());
							t1.position(t1, j.getCouleur());
							t3.position(t3, j.getCouleur());
							StdDraw.pause(500);	
						}else {
							j.add_armee(t6,c-(w-2)*4);
							j.add_armee(t8,w-2);
							j.add_armee(t7,w-2);
							j.add_armee(t3,w-2);
							j.add_armee(t1,w-2);
							t6.position(t6, j.getCouleur());
							t8.position(t8, j.getCouleur());
							t7.position(t7, j.getCouleur());
							t3.position(t3, j.getCouleur());
							t1.position(t1, j.getCouleur());
							StdDraw.pause(500);	
						}
						
					}else {
						j.add_armee(t1, w);
						j.add_armee(t3, w);
						j.add_armee(t5, c-w*2);
						t1.position(t1, j.getCouleur());
						t3.position(t3, j.getCouleur());
						t5.position(t5, j.getCouleur());
						StdDraw.pause(500);	
					}
				}else {
					Random rand = new Random();
					territoire t = null;
					while (t==null) {
						t = j.recherche_ter(rand.nextInt(10 - 1) + 1, j);
						
					}
					j.add_armee(t, c);
					t.position(t, j.getCouleur());
					StdDraw.pause(500);	
					
				}
				
				
			}
			//amerique du sud
			else if(f==a2) {
				territoire t10= j.recherche_ter(10, j);
				territoire t11=j.recherche_ter(11, j);
				territoire t12=j.recherche_ter(12, j);
				territoire t13= j.recherche_ter(13, j);
				if (r2.region(j)==3) {
					if(t13==null) {
						j.add_armee(t12, w+3);
						j.add_armee(t11, c-(w+3));
						t12.position(t12, j.getCouleur());
						t11.position(t11, j.getCouleur());
						StdDraw.pause(500);	
					}else if(t11==null) {
						j.add_armee(t13, c-2*w);
						j.add_armee(t12, w);
						j.add_armee(t10, w);
						t13.position(t13, j.getCouleur());
						t12.position(t12, j.getCouleur());
						t10.position(t10, j.getCouleur());
						StdDraw.pause(500);	
					}else {
						j.add_armee(t13, w+3);
						j.add_armee(t11, c-(w+3));
						t13.position(t13, j.getCouleur());
						t11.position(t11, j.getCouleur());
						StdDraw.pause(500);	
					}
				}else if(r2.region(j)==2) {
					if(t13==null&&t11==null) {
						j.add_armee(t10, w+3);
						j.add_armee(t12, c-(w+3));
						t10.position(t10, j.getCouleur());
						t12.position(t12, j.getCouleur());
						StdDraw.pause(500);
					}else if(t13==null&&t12==null) {
						j.add_armee(t11, w+3);
						j.add_armee(t10, c-(w+3));
						t10.position(t10, j.getCouleur());
						t11.position(t11, j.getCouleur());
						StdDraw.pause(500);
					}else if(t13==null&&t10==null) {
						j.add_armee(t12, w+3);
						j.add_armee(t11, c-(w+3));
						t12.position(t12, j.getCouleur());
						t11.position(t11, j.getCouleur());
						StdDraw.pause(500);
					}else if(t12==null&&t11==null) {
						j.add_armee(t13, c-(w+3));
						j.add_armee(t10, w+3);
						t13.position(t13, j.getCouleur());
						t10.position(t10, j.getCouleur());
						StdDraw.pause(500);
					}else if(t12==null&&t10==null) {
						j.add_armee(t13, w+3);
						j.add_armee(t11, c-(w+3));
						t13.position(t13, j.getCouleur());
						t11.position(t11, j.getCouleur());
						StdDraw.pause(500);
					}else if(t11==null&&t10==null) {
						j.add_armee(t12, w+3);
						j.add_armee(t13, c-(w+3));
						t12.position(t12, j.getCouleur());
						t13.position(t13, j.getCouleur());
						StdDraw.pause(500);
					}
				}else {
					Random rand = new Random();
					territoire t = null;
					while (t==null) {
						t = j.recherche_ter(rand.nextInt(14 - 10) + 10, j);
					}
					j.add_armee(t, c);
					t.position(t, j.getCouleur());
					StdDraw.pause(500);
				}
			}
			//Afrique
			else if(f==a3) {
				territoire t14= j.recherche_ter(14, j);
				territoire t15=j.recherche_ter(15, j);
				territoire t16=j.recherche_ter(16, j);
				territoire t17= j.recherche_ter(17, j);
				territoire t18= j.recherche_ter(18, j);
				territoire t19=j.recherche_ter(19, j);
				if (r3.region(j)==5) {
					if(t18==null) {
						j.add_armee(t15, w);
						j.add_armee(t16, c-2*w);
						j.add_armee(t14, w);
						t15.position(t15, j.getCouleur());
						t16.position(t16, j.getCouleur());
						t14.position(t14, j.getCouleur());
						StdDraw.pause(500);
					}else if(t16==null) {
						j.add_armee(t15, c-(w+3));
						j.add_armee(t18, w+3);
						t15.position(t15, j.getCouleur());
						t18.position(t18, j.getCouleur());
						StdDraw.pause(500);
					}else if(t15==null) {
						j.add_armee(t14, c-(w-2)*4);
						j.add_armee(t17, w-2);
						j.add_armee(t19, w-2);
						j.add_armee(t16, w-2);
						j.add_armee(t18, w-2);
						t14.position(t14, j.getCouleur());
						t17.position(t17, j.getCouleur());
						t19.position(t19, j.getCouleur());
						t16.position(t16, j.getCouleur());
						t18.position(t18, j.getCouleur());
						StdDraw.pause(500);
					}else {
						j.add_armee(t15, w);
						j.add_armee(t16, c-2*w);
						j.add_armee(t18, w);
						t15.position(t15, j.getCouleur());
						t16.position(t16, j.getCouleur());
						t18.position(t18, j.getCouleur());
						StdDraw.pause(500);
					}
				}
				else if(r3.region(j)==4) {
					if(t18==null&&t16==null) {
						j.add_armee(t15, c-(w+3));
						j.add_armee(t14, w+3);
						t15.position(t15, j.getCouleur());
						t14.position(t14, j.getCouleur());
						StdDraw.pause(500);
					}else if(t18==null&&t15==null) {
						j.add_armee(t16, c-2*w);
						j.add_armee(t14, w);
						j.add_armee(t17, w);
						t16.position(t16, j.getCouleur());
						t14.position(t14, j.getCouleur());
						t17.position(t17, j.getCouleur());
						StdDraw.pause(500);
					}else if(t15==null&&t16==null) {
						j.add_armee(t18, c-2*w);
						j.add_armee(t14, w);
						j.add_armee(t17, w);
						t18.position(t18, j.getCouleur());
						t14.position(t14, j.getCouleur());
						t17.position(t17, j.getCouleur());
						StdDraw.pause(500);
					}
					else if(t18==null) {
						if(t14==null) {
							j.add_armee(t16, c-2*w);
							j.add_armee(t15, w);
							j.add_armee(t19,w);
							t16.position(t16, j.getCouleur());
							t15.position(t15, j.getCouleur());
							t19.position(t19, j.getCouleur());
							StdDraw.pause(500);
						}else {
							j.add_armee(t14, c-2*w);
							j.add_armee(t15, w);
							j.add_armee(t16, w);
							t14.position(t14, j.getCouleur());
							t15.position(t15, j.getCouleur());
							t16.position(t16, j.getCouleur());
							StdDraw.pause(500);
						}
					}else if(t16==null) {
						j.add_armee(t18, c-(w+3));
						j.add_armee(t15, w+3);
						t18.position(t18, j.getCouleur());
						t15.position(t15, j.getCouleur());
						StdDraw.pause(500);
					}else if(t15==null) {
						if(t14==null) {
							j.add_armee(t18, w-1);
							j.add_armee(t16, w-1);
							j.add_armee(t17, w-1);
							j.add_armee(t19, c-3*(w-1));
							t18.position(t18, j.getCouleur());
							t16.position(t16, j.getCouleur());
							t17.position(t17, j.getCouleur());
							t19.position(t19, j.getCouleur());
							StdDraw.pause(500);
						}else if(t19==null) {
							j.add_armee(t18, w-1);
							j.add_armee(t16, w-1);
							j.add_armee(t17, w-1);
							j.add_armee(t14, c-3*(w-1));
							t18.position(t18, j.getCouleur());
							t16.position(t16, j.getCouleur());
							t17.position(t17, j.getCouleur());
							t14.position(t14, j.getCouleur());
							StdDraw.pause(500);
						}else if(t17==null) {
							j.add_armee(t18, w-1);
							j.add_armee(t16, w-1);
							j.add_armee(t14, c-3*(w-1));
							j.add_armee(t19, w-1);
							t18.position(t18, j.getCouleur());
							t16.position(t16, j.getCouleur());
							t14.position(t14, j.getCouleur());
							t19.position(t19, j.getCouleur());
							StdDraw.pause(500);
						}
					}else {
						j.add_armee(t15, w);
						j.add_armee(t16, c-2*w);
						j.add_armee(t18, w);
						t15.position(t15, j.getCouleur());
						t16.position(t16, j.getCouleur());
						t18.position(t18, j.getCouleur());
						StdDraw.pause(500);
					}
				}
				else {
					Random rand = new Random();
					territoire t = null;
					while (t==null) {
						t = j.recherche_ter(rand.nextInt(20 - 14) + 14, j);
					}
					j.add_armee(t, c);
					t.position(t, j.getCouleur());
					StdDraw.pause(500);
				}
			}
			//Océanie
			else if(f==a5) {
				territoire t27= j.recherche_ter(27, j);
				territoire t28=j.recherche_ter(28, j);
				territoire t29=j.recherche_ter(29, j);
				territoire t30= j.recherche_ter(30, j);
				if (r5.region(j)==3) {
					if(t28==null||t27==null) {
						j.add_armee(t29, w+3);
						j.add_armee(t30, c-(w+3));
						t29.position(t29, j.getCouleur());
						t30.position(t30, j.getCouleur());
						StdDraw.pause(500);
					}else {
						j.add_armee(t28, c);
						t30.position(t28, j.getCouleur());
						StdDraw.pause(500);
					}
				}
				else if(r5.region(j)==2) {
					if(t28==null&&t27==null) {
						j.add_armee(t29, w+3);
						j.add_armee(t30, c-(w+3));
						t29.position(t29, j.getCouleur());
						t30.position(t30, j.getCouleur());
						StdDraw.pause(500);
					}else if(t28==null&&t29==null) {
						j.add_armee(t27, w+3);
						j.add_armee(t30, c-(w+3));
						t27.position(t27, j.getCouleur());
						t30.position(t30, j.getCouleur());
						StdDraw.pause(500);
					}else if(t28==null&&t30==null) {
						j.add_armee(t27, w+3);
						j.add_armee(t29, c-(w+3));
						t27.position(t27, j.getCouleur());
						t29.position(t29, j.getCouleur());
						StdDraw.pause(500);
					}else if(t29==null&&t30==null) {
						j.add_armee(t27, w+3);
						j.add_armee(t28, c-(w+3));
						t27.position(t27, j.getCouleur());
						t28.position(t28, j.getCouleur());
						StdDraw.pause(500);
					}else if(t29==null&&t27==null) {
						j.add_armee(t28, w+3);
						j.add_armee(t30, c-(w+3));
						t28.position(t28, j.getCouleur());
						t30.position(t30, j.getCouleur());
						StdDraw.pause(500);
					}else if(t30==null&&t27==null) {
						j.add_armee(t28, w+3);
						j.add_armee(t29, c-(w+3));
						t29.position(t29, j.getCouleur());
						t28.position(t28, j.getCouleur());
						StdDraw.pause(500);
					}
				}
				else {
					Random rand = new Random();
					territoire t = null;
					while (t==null) {
						t = j.recherche_ter(rand.nextInt(31 - 27) + 27, j);
					}
					j.add_armee(t, c);
					t.position(t, j.getCouleur());
					StdDraw.pause(500);
				}
			}
			//Europe 
			else if(f==a4) {
				territoire t20= j.recherche_ter(20, j);
				territoire t21=j.recherche_ter(21, j);
				territoire t22=j.recherche_ter(22, j);
				territoire t23= j.recherche_ter(23, j);
				territoire t24= j.recherche_ter(24, j);
				territoire t25=j.recherche_ter(25, j);
				territoire t26=j.recherche_ter(26, j);
				if (r4.region(j)==6) {
					if (t20==null) {
						j.add_armee(t21, w);
						j.add_armee(t23, w);
						j.add_armee(t26, c-(2*w));
						t21.position(t21, j.getCouleur());
						t23.position(t23, j.getCouleur());
						t26.position(t26, j.getCouleur());
						StdDraw.pause(500);
					}
					else if(t21==null) {
						j.add_armee(t20, w-1);
						j.add_armee(t23, w-1);
						j.add_armee(t26, w-1);
						j.add_armee(t25, c-(3*w));
						t20.position(t20, j.getCouleur());
						t23.position(t23, j.getCouleur());
						t26.position(t26, j.getCouleur());
						t25.position(t25, j.getCouleur());
						StdDraw.pause(500);
					}
					else if(t22==null) {
						j.add_armee(t21, w-1);
						j.add_armee(t24, w-1);
						j.add_armee(t25, w-1);
						j.add_armee(t26, c-(3*w));
						t21.position(t21, j.getCouleur());
						t24.position(t24, j.getCouleur());
						t25.position(t25, j.getCouleur());
						t26.position(t26, j.getCouleur());
						StdDraw.pause(500);
					}
					else if(t23==null) {
						j.add_armee(t21, w-1);
						j.add_armee(t25, w-1);
						j.add_armee(t26, w-1);
						j.add_armee(t24, c-(3*w));
						t21.position(t21, j.getCouleur());
						t25.position(t25, j.getCouleur());
						t26.position(t26, j.getCouleur());
						t24.position(t24, j.getCouleur());
						StdDraw.pause(500);
					}
					else if(t24==null) {
						j.add_armee(t26, w);
						j.add_armee(t25, w);
						j.add_armee(t21, c-(2*w));
						t26.position(t26, j.getCouleur());
						t25.position(t25, j.getCouleur());
						t21.position(t21, j.getCouleur());
						StdDraw.pause(500);
					}
					else if(t25==null) {
						j.add_armee(t21, w);
						j.add_armee(t26, w);
						j.add_armee(t24, c-(2*w));
						t21.position(t21, j.getCouleur());
						t26.position(t26, j.getCouleur());
						t24.position(t24, j.getCouleur());
						StdDraw.pause(500);
					}
					else if(t26==null) {
						j.add_armee(t21, w-1);
						j.add_armee(t25, w-1);
						j.add_armee(t24, w-1);
						j.add_armee(t20, c-(3*w));
						t21.position(t21, j.getCouleur());
						t25.position(t25, j.getCouleur());
						t24.position(t24, j.getCouleur());
						t20.position(t20, j.getCouleur());
						StdDraw.pause(500);
					}
					
				}
				else {
					Random rand = new Random();
					territoire t1 = null;
					territoire t2 = null;
					territoire t3 = null;
					while (t1==null||t2==null||t3==null) {
						t1 = j.recherche_ter(rand.nextInt(27 - 20) + 20, j);
						t2 = j.recherche_ter(rand.nextInt(27 - 20) + 20, j);
						t3 = j.recherche_ter(rand.nextInt(27 - 20) + 20, j);
					}
					j.add_armee(t1, w);
					j.add_armee(t2, w);
					j.add_armee(t3, c-(2*w));
					t1.position(t1, j.getCouleur());
					t2.position(t2, j.getCouleur());
					t3.position(t3, j.getCouleur());
					StdDraw.pause(500);
				}
			}
			
			//Asie
			else {
				Random rand = new Random();
				territoire t1 = null;
				territoire t2 = null;
				while (t1==null||t2==null) {
					t1 = j.recherche_ter(rand.nextInt(43 - 31) + 31, j);
					t2 = j.recherche_ter(rand.nextInt(43 - 31) + 31, j);
					
				}
				j.add_armee(t1, w+3);
				j.add_armee(t2, c-(w+3));
				t1.position(t1, j.getCouleur());
				t2.position(t2, j.getCouleur());
				StdDraw.pause(500);
			}
		}
	}
	
	public void IA_phase_attaque(int a, Joueur j1, Joueur j2, Joueur j3, Joueur j4, Joueur j5, Joueur j6) throws InterruptedException {
		while (a != 0) {
			if(j1.list_ter==null) {
				break;
			}
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(25, 105, "Chat-Box : ");//texte
			StdDraw.text(60, 105, "J"+j1.getNumero()+" attaque" );
			//StdDraw.pause(100);
			
					System.out.println("choisir un pays");
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(25, 105, "Chat-Box : ");//texte
					StdDraw.text(60, 105, "choisir un pays" );
					
					int b=0;
					while(b!=10) {
						if(verif_armee(j1)==false) {
							break;
						}
						else {
							territoire t1 =choix_joueur(j);
					
							
							t1.position(t1, StdDraw.YELLOW); // affichage du pays qui attaque
							System.out.println("choisir un pays à attaquer");
							StdDraw.setPenColor(StdDraw.ORANGE);
							StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
							StdDraw.setPenColor(StdDraw.BLACK);
							StdDraw.text(25, 105, "Chat-Box : ");//texte
							StdDraw.text(60, 105, "choisir un pays à attaquer" );
							
							Random rand= new Random();
							int h = p.getNbre_joueur();
							int e = rand.nextInt((h+1) - 2) + 2; 
							System.out.println("le joueur choisit est j"+e);
							if(e==2) {
								territoire t2 = IA_verif(t1,j2);
								if(t2==null) {
									t1.position(t1, j1.getCouleur());
									b++;
								}
								else {
									//while(t1.getA()>1) {
										System.out.println(t2.getA());
										IA_phase_attaque2(t1,t2,j,j2);
										t1.position(t1, j1.getCouleur());
										System.out.println(t2.getA());
										StdDraw.pause(1500);
									//}
								}

							}
							else if(e==3) {
								territoire t3 = IA_verif(t1,j3);
								
								if(t3==null) {
									t1.position(t1, j.getCouleur());
									b++;
								}
								else {
									//while(t1.getA()>1) {
										IA_phase_attaque2(t1,t3,j,j3);
										t1.position(t1, j.getCouleur());
										System.out.println(j2.getCouleur());
								//	StdDraw.pause(1500);
										
								//}
								}
								
								
							}
							else if(e==4) {
								territoire t4 = IA_verif(t1,j4);
								if(t4==null) {
									t1.position(t1, j.getCouleur());
									b++;
								}
								else {
								//	while(t1.getA()>1) {
										IA_phase_attaque2(t1,t4,j,j4);
									//	StdDraw.pause(1500);
									//	t1.position(t1, j.getCouleur());
										
								//}
								}
							}
							else if(e==5) {
								territoire t5 = IA_verif(t1,j5);
								if(t5==null) {
									t1.position(t1, j.getCouleur());
									b++;
								}
								else {
								//	while(t1.getA()>1) {
										IA_phase_attaque2(t1,t5,j,j5);
										//StdDraw.pause(1500);
									//	t1.position(t1, j.getCouleur());
										
							//	}
								}
							}
							else if(e==6) {
								territoire t6 = IA_verif(t1,j6);
								if(t6==null) {
									t1.position(t1, j.getCouleur());
									b++;
								}
								else {
							//		while(t1.getA()>1) {
										IA_phase_attaque2(t1,t6,j,j6);
									//	StdDraw.pause(1500);
									//	t1.position(t1, j.getCouleur());
										
							//	}
								}
							}
									//StdDraw.pause(500);
						}
							
		}
									break;
								}
							}

	public void IA_phase_attaque2(territoire t1, territoire t2, Joueur j1, Joueur j2) throws InterruptedException {
		//if (j.verif(t1, t2) == true) {
			int[] att = j1.att(j1, t1); // résultat du dé joueur attaquant
			int[] def = j2.def(j2, t2); // résultat du dé joueur defenseur
			System.out.println("attaque :");
			j1.PrintTab(att);
			System.out.println("def :");
			j2.PrintTab(def);
			System.out.println("la taille de att est : " + att.length);
			System.out.println("la taille de def est : " + def.length);
			StdDraw.picture(110, 30, "Image/parchemin_combat.png");
			StdDraw.picture(105, 40,"Image/cache.png" );
			StdDraw.picture(105,42,j1.getPhoto());//105,40
			StdDraw.picture(110, 40, "Image/cache.png");
			StdDraw.picture(110, 40, "Image/versus2.png");
			StdDraw.picture(115, 42, j2.getPhoto());//115,40

			if(att.length==3) {
				for (int w1 = 1; w1 <= 3; w1++) {
					if (att[w1 - 1] == 1) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_1.png");
					} else if (att[w1 - 1] == 2) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_2.png");
					} else if (att[w1 - 1] == 3) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_3.png");
					} else if (att[w1 - 1] == 4) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_4.png");
					} else if (att[w1 - 1] == 5) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_5.png");
					} else if (att[w1 - 1] == 6) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_6.png");
					} else {

					}
				}
			}
			else if(att.length==2) {
				for (int w1 = 1; w1 <= 2; w1++) {
					if (att[w1 - 1] == 1) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_1.png");
					} else if (att[w1 - 1] == 2) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_2.png");
					} else if (att[w1 - 1] == 3) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_3.png");
					} else if (att[w1 - 1] == 4) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_4.png");
					} else if (att[w1 - 1] == 5) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_5.png");
					} else if (att[w1 - 1] == 6) {
						StdDraw.picture(100 + ((w1) * 5), 30, "Image/de_6.png");
					}else {

					}
				}
				StdDraw.picture(115, 30, "Image/cache.png");
			}
			else {
				for (int w2 = 1; w2 <= 1; w2++) {
					if (att[w2 - 1] == 1) {
						StdDraw.picture(100 + ((w2) * 5), 30, "Image/de_1.png");
					} else if (att[w2 - 1] == 2) {
						StdDraw.picture(100 + ((w2) * 5), 30, "Image/de_2.png");
					} else if (att[w2 - 1] == 3) {
						StdDraw.picture(100 + ((w2) * 5), 30, "Image/de_3.png");
					} else if (att[w2 - 1] == 4) {
						StdDraw.picture(100 + ((w2) * 5), 30, "Image/de_4.png");
					} else if (att[w2 - 1] == 5) {
						StdDraw.picture(100 + ((w2) * 5), 30, "Image/de_5.png");
					} else if (att[w2 - 1] == 6) {
						StdDraw.picture(100 + ((w2) * 5), 30, "Image/de_6.png");
					}
					else {

					}
				}
				StdDraw.picture(115, 30,"Image/cache.png");
				StdDraw.picture(110, 30, "Image/cache.png");
			}
			
			if(def.length==2){
				for (int z = 1; z <= 2; z++) {
					if (def[z - 1] == 1) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_1.png");
					} else if (def[z - 1] == 2) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_2.png");
					} else if (def[z - 1] == 3) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_3.png");
					} else if (def[z - 1] == 4) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_4.png");
					} else if (def[z - 1] == 5) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_5.png");
					} else if (def[z - 1] == 6) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_6.png");
					}
					else {

					}
				}
			}
			else {
				for (int z = 1; z <= 1; z++) {
					if (def[z - 1] == 1) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_1.png");
					} else if (def[z - 1] == 2) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_2.png");
					} else if (def[z - 1] == 3) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_3.png");
					} else if (def[z - 1] == 4) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_4.png");
					} else if (def[z - 1] == 5) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_5.png");
					} else if (def[z - 1] == 6) {
						StdDraw.picture(100 + ((z) * 5), 20, "Image/de_vert_6.png");
					}
					else {

					}
					
				}
				StdDraw.picture(110, 20,"Image/cache.png");
			}
			if ((att.length == 3 && def.length == 2)
					|| (att.length == 2 && def.length == 2)) { // situation possible de
																// combat
				if (att[0] > def[0] && att[1] <= def[1]
						|| att[0] <= def[0] && att[1] > def[1]) { // résultat possible aux
																	// dés
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(25, 105, "Chat-Box : ");//texte
					StdDraw.text(60, 105, "le Joueur" + j1.getNumero() + " gagne mais perd 1 unité" );
					System.out.println(
							"le Joueur" + j1.getNumero() + " gagne mais perd 1 unité");
					
					j.sup_armee(t2, 1); // suppression d'une unité sur le territoire du joueur
										// défenseur
					j.sup_armee(t1, 1); // suppression d'une unité sur le territoire du joueur
										// attaquant
					t2.position(t2, j2.getCouleur());
					t1.position(t1, j1.getCouleur());
				} else if (att[0] > def[0] && att[1] > def[1]) {
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(25, 105, "Chat-Box : ");//texte
					StdDraw.text(60, 105, "le Joueur" + j1.getNumero() + " gagne" );
					System.out.println("le Joueur" + j1.getNumero() + " gagne");
					if (t2.getA() == 2) {
						
						int c = t1.getA() - 1; // unité max que le joueur peut déplacer
						
						j.sup_armee(t2, 2);
						j.add_armee(t2, c-1); // déplacement armée joueur
														// attaquant
						j.sup_armee(t1, c-1);
						j1.getList_ter().add(t2); // ajout du territoire au joueur attaquant
						j2.getList_ter().remove(t2); // suppression du territoire au joueur
												// defenseur
						t2.position(t2, j1.getCouleur()); // affichage territoire conquis
						t1.position(t1, j1.getCouleur()); // affichage territoire attaquant
					} else if (t2.getA() > 2) {
						j.sup_armee(t2, 2);
						t2.position(t2, j2.getCouleur());
						t1.position(t1, j1.getCouleur());
					}

				} else if (att[0] <= def[0] && att[1] <= def[1]) {StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(25, 105, "Chat-Box : ");//texte
					StdDraw.text(60, 105, "le Joueur" + j1.getNumero() + " perd" );
					j.sup_armee(t1, 2);
					t1.position(t1, j1.getCouleur());
					t2.position(t2, j2.getCouleur());
				}
			} else if ((att.length == 3 && def.length == 1)
					|| (att.length == 2 && def.length == 1)
					|| (att.length == 1 && def.length == 1)) {
				if (att[0] > def[0]) {StdDraw.setPenColor(StdDraw.ORANGE);
				StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(25, 105, "Chat-Box : ");//texte
				StdDraw.text(60, 105, "le Joueur" + j1.getNumero() + " gagne" );
				
					if(t1.getA()<=4) {
						j.sup_armee(t2, 1);
						j.add_armee(t2, (t1.getA()-1)); // déplacement armée joueur attaquant
						j.sup_armee(t1, (t1.getA()-1));
						j1.getList_ter().add(t2); // ajout du territoire au joueur attaquant
						j2.getList_ter().remove(t2); // suppression du territoire au joueur defenseur
						t2.position(t2, j1.getCouleur()); // affichage territoire conquis
						t1.position(t1, j1.getCouleur()); // affichage territoire attaquant
					}
					else {
						int c = t1.getA() - 1; // unité max que le joueur peut déplacer
		
						//Sliders slide = new Sliders(att.length, c); // création de la fenêtre pop up
						//slide.setVisible(true); // rend visible cette fenêtre
						//TimeUnit.SECONDS.sleep(5); // laisse un temps de réponse au joueur
						//int h = slide.getResultat(); // récupère le choix du joueur
						
							j.sup_armee(t2, 1);
							j.add_armee(t2, c-2); // déplacement armée joueur attaquant
							j.sup_armee(t1, c-2);
							j1.getList_ter().add(t2); // ajout du territoire au joueur attaquant
							j2.getList_ter().remove(t2); // suppression du territoire au joueur defenseur
							t2.position(t2, j1.getCouleur()); // affichage territoire conquis
							t1.position(t1, j1.getCouleur()); // affichage territoire attaquant
					}
				} else if (att[0] <= def[0]) {
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(25, 105, "Chat-Box : ");//texte
					StdDraw.text(60, 105, "le Joueur" + j1.getNumero() + " perd" );
					j.sup_armee(t1, 1);
					t1.position(t1, j1.getCouleur());
					t2.position(t2, j2.getCouleur());
				}
			} else if ((att.length == 1 && def.length == 2)) {
				if (att[0] > def[0]) {
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(25, 105, "Chat-Box : ");//texte
					StdDraw.text(60, 105, "le Joueur" + j1.getNumero() + " gagne" );
					j.sup_armee(t2, 1);
					t2.position(t2, j2.getCouleur());
					t1.position(t1, j1.getCouleur());
					StdDraw.pause(500);
				} else if (att[0] <= def[0]) {
					StdDraw.setPenColor(StdDraw.ORANGE);
					StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
					StdDraw.setPenColor(StdDraw.BLACK);
					StdDraw.text(25, 105, "Chat-Box : ");//texte
					StdDraw.text(60, 105, "le Joueur" + j1.getNumero() + " perd" );
					j.sup_armee(t1, 1);
					t1.position(t1, j1.getCouleur());
					t2.position(t2, j2.getCouleur());
				}
			}
		else {
			t1.position(t1, j1.getCouleur()); // renvoie la couleur du joueur
												// lorsqu'il se trompe
		}
	}
	public territoire choix_joueur(Joueur j) {
		territoire t1=null;
		int t=0;
		while(t==0) {
			t1 = territoire_hasard(j); // selection du pays qui attaque
			if (t1.getA()>=2) {
				t=1;
			}
		}
		return t1;
	}
	
	public territoire territoire_hasard(Joueur j) {
		Random rand= new Random();
		int i = rand.nextInt(j.getList_ter().size() - 0) + 0;
		territoire t=j.getList_ter().get(i);
		return t;
	}
	
	public territoire IA_verif(territoire t1, Joueur j) {
		// Amérique du nord
		Random rand = new Random();
		ArrayList<Integer> list_voisins = new ArrayList<Integer>();
		if (t1.getNumero() == 1) {
			list_voisins.add(2);
			list_voisins.add(6);
			list_voisins.add(36);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 2) {
			list_voisins.add(1);
			list_voisins.add(6);
			list_voisins.add(7);
			list_voisins.add(9);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 3) {
			list_voisins.add(4);
			list_voisins.add(9);
			list_voisins.add(13);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 4) {
			list_voisins.add(3);
			list_voisins.add(7);
			list_voisins.add(8);
			list_voisins.add(9);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 5) {
			list_voisins.add(6);
			list_voisins.add(7);
			list_voisins.add(8);
			list_voisins.add(21);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 6) {
			list_voisins.add(1);
			list_voisins.add(2);
			list_voisins.add(5);
			list_voisins.add(7);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 7) {
			list_voisins.add(2);
			list_voisins.add(4);
			list_voisins.add(5);
			list_voisins.add(6);
			list_voisins.add(8);
			list_voisins.add(9);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 8) {
			list_voisins.add(4);
			list_voisins.add(5);
			list_voisins.add(7);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 9) {
			list_voisins.add(2);
			list_voisins.add(3);
			list_voisins.add(4);
			list_voisins.add(7);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		// Amerique du Sud
		else if (t1.getNumero() == 10) {
			list_voisins.add(11);
			list_voisins.add(12);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 11) {
			list_voisins.add(10);
			list_voisins.add(12);
			list_voisins.add(13);
			list_voisins.add(18);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 12) {
			list_voisins.add(10);
			list_voisins.add(11);
			list_voisins.add(13);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 13) {
			list_voisins.add(11);
			list_voisins.add(12);
			list_voisins.add(3);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		// Afrique
		else if (t1.getNumero() == 14) {
			list_voisins.add(15);
			list_voisins.add(18);
			list_voisins.add(19);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 15) {
			list_voisins.add(14);
			list_voisins.add(16);
			list_voisins.add(17);
			list_voisins.add(18);
			list_voisins.add(19);
			list_voisins.add(37);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 16) {
			list_voisins.add(15);
			list_voisins.add(18);
			list_voisins.add(24);
			list_voisins.add(37);
			territoire t2 =fonction(list_voisins,j);
			return t2;
			}
		else if (t1.getNumero() == 17) {
			list_voisins.add(15);
			list_voisins.add(19);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 18) {
			list_voisins.add(16);
			list_voisins.add(15);
			list_voisins.add(14);
			list_voisins.add(11);
			list_voisins.add(25);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 19) {
			list_voisins.add(14);
			list_voisins.add(15);
			list_voisins.add(17);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		// Europe
		else if (t1.getNumero() == 20) {
			list_voisins.add(21);
			list_voisins.add(22);
			list_voisins.add(23);
			list_voisins.add(26);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 21) {
			list_voisins.add(5);
			list_voisins.add(23);
			list_voisins.add(20);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 22) {
			list_voisins.add(23);
			list_voisins.add(20);
			list_voisins.add(26);
			list_voisins.add(24);
			list_voisins.add(25);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 23) {
			list_voisins.add(21);
			list_voisins.add(20);
			list_voisins.add(22);
			list_voisins.add(25);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 24) {
			list_voisins.add(22);
			list_voisins.add(26);
			list_voisins.add(25);
			list_voisins.add(16);
			list_voisins.add(37);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 25) {
			list_voisins.add(23);
			list_voisins.add(22);
			list_voisins.add(24);
			list_voisins.add(37);
			list_voisins.add(31);
			list_voisins.add(41);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 26) {
			list_voisins.add(20);
			list_voisins.add(22);
			list_voisins.add(24);
			list_voisins.add(18);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		// Océanie
		else if (t1.getNumero() == 27) {
			list_voisins.add(29);
			list_voisins.add(30);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 28) {
			list_voisins.add(39);
			list_voisins.add(29);
			list_voisins.add(30);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 29) {
			list_voisins.add(27);
			list_voisins.add(28);
			list_voisins.add(30);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 30) {
			list_voisins.add(27);
			list_voisins.add(28);
			list_voisins.add(29);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		// Asie
		else if (t1.getNumero() == 31) {
			list_voisins.add(25);
			list_voisins.add(37);
			list_voisins.add(41);
			list_voisins.add(33);
			list_voisins.add(32);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 32) {
			list_voisins.add(39);
			list_voisins.add(33);
			list_voisins.add(31);
			list_voisins.add(41);
			list_voisins.add(40);
			list_voisins.add(38);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 33) {
			list_voisins.add(39);
			list_voisins.add(32);
			list_voisins.add(31);
			list_voisins.add(37);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 34) {
			list_voisins.add(38);
			list_voisins.add(36);
			list_voisins.add(42);
			list_voisins.add(40);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 35) {
			list_voisins.add(38);
			list_voisins.add(36);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 36) {
			list_voisins.add(1);
			list_voisins.add(35);
			list_voisins.add(38);
			list_voisins.add(34);
			list_voisins.add(42);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 37) {
			list_voisins.add(15);
			list_voisins.add(16);
			list_voisins.add(24);
			list_voisins.add(25);
			list_voisins.add(31);
			list_voisins.add(33);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 38) {
			list_voisins.add(32);
			list_voisins.add(34);
			list_voisins.add(35);
			list_voisins.add(36);
			list_voisins.add(40);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 39) {
			list_voisins.add(32);
			list_voisins.add(33);
			list_voisins.add(28);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 40) {
			list_voisins.add(32);
			list_voisins.add(38);
			list_voisins.add(34);
			list_voisins.add(42);
			list_voisins.add(41);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 41) {
			list_voisins.add(25);
			list_voisins.add(31);
			list_voisins.add(32);
			list_voisins.add(40);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		else if (t1.getNumero() == 42) {
			list_voisins.add(36);
			list_voisins.add(34);
			list_voisins.add(40);
			territoire t2 =fonction(list_voisins,j);
			return t2;
		}
		return null;
	}

	public territoire fonction(ArrayList<Integer> list_voisins, Joueur j1) {
		int a=0;
		for (int i=0;i<list_voisins.size();i++) {
			territoire t2= j1.recherche_ter((int) list_voisins.get(i), j1);
			
			if(t2==null) {
				a++;
			}else {
				System.out.println(t2.getNumero());
				return t2;
			}
		}
		if(a==list_voisins.size()) {
			return null;
		}
		return null;
	}
	
	
	public void IA_deplacement(Joueur j) {
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(25, 105, "Chat-Box : ");//texte
			StdDraw.text(60, 105, "J"+j.getNumero()+" déplace" );
			StdDraw.pause(100);
				
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(25, 105, "Chat-Box : ");//texte
			StdDraw.text(60, 105, "choisir un pays" );
			System.out.println("choisir un pays");
			StdDraw.pause(500);
					
			territoire t1 = armee_max(j); // selection armée à déplacer
			Random rand = new Random();
			if(t1.getA()==1) {
				
			}
			else {
				int r= rand.nextInt(t1.getA() - 1) + 1;
				t1.position(t1, StdDraw.YELLOW); // affichage du pays qui attaque
				StdDraw.setPenColor(StdDraw.ORANGE);
				StdDraw.filledRectangle(50, 105, 35, 5);// chat-box
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(25, 105, "Chat-Box : ");//texte
				StdDraw.text(60, 105, "choisir le territoire" );
				System.out.println("choisir le territoire");
				StdDraw.pause(500);
				
				territoire t2 = IA_verif(t1, j);
				if(t2==null) {
					t1.position(t1, j.getCouleur());
					IA_deplacement(j);
				}
				else {
					j.add_armee(t2, r); // ajout armee sur territoire de destination
					j.sup_armee(t1, r); // suppression armee sur territoire source
					t2.position(t2, j.getCouleur()); // affichage territoire destination
					t1.position(t1, j.getCouleur()); // affichage territoire source
				}
			}
					
		}

	public territoire armee_max(Joueur j) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0;i<j.list_ter.size();i++){
			territoire t = j.list_ter.get(i);
			int a = t.getA();
			list.add(a);
		}
		int m = Collections.max(list);
		int a = list.indexOf(m);
		territoire t2 = j.list_ter.get(a);
		return t2;
	}
	
	public boolean verif_armee(Joueur j) {
		int b=0;
		for (int i=0;i<j.list_ter.size();i++){
			territoire t = j.list_ter.get(i);
			int a = t.getA();
			if (a==1) {
				b++;
			}
		}
		if(b==j.list_ter.size()) {
			return false;
		}
		else {
			return true;
		}
	}
}
