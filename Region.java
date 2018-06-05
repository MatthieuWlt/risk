import java.util.ArrayList;

public class Region {
	int numero;
	public ArrayList<Integer> list_terr;
	
	public Region(int num) {
		this.numero=num;
		this.list_terr=new ArrayList<Integer>();
	}
	
	public int region (Joueur j) {
		ArrayList<Integer> L = new ArrayList<Integer>();
		switch (numero) {
		case 1:
			int a1=0;
			for (int i=1;i<=9;i++) {
				list_terr.add(i);
				territoire t =j.recherche_ter(i,j);
				if (t==null) {
				}
				else {
					a1++;
				}
			}
			return a1;
		case 2:
			int a2=0;
			for (int i=10;i<=13;i++) {
				list_terr.add(i);
				territoire t =j.recherche_ter(i,j);
				if (t==null) {
				}
				else {
					a2++;
				}
			}
			return a2;
		case 3:
			int a3=0;
			for (int i=14;i<=19;i++) {
				list_terr.add(i);
				territoire t =j.recherche_ter(i,j);
				if (t==null) {
				}
				else {
					a3++;
				}
			}
			return a3;
		case 4:
			int a4=0;
			for (int i=20;i<=26;i++) {
				list_terr.add(i);
				territoire t =j.recherche_ter(i,j);
				if (t==null) {
				}
				else {
					a4++;
				}
			}
			return a4;
		case 5:
			int a5=0;
			for (int i=27;i<=30;i++) {
				list_terr.add(i);
				territoire t =j.recherche_ter(i,j);
				if (t==null) {
				}
				else {
					a5++;
				}
			}
			return a5;
		case 6:
			int a6=0;
			for (int i=31;i<=42;i++) {
				list_terr.add(i);
				territoire t =j.recherche_ter(i,j);
				if (t==null) {
				}
				else {
					a6++;
				}
			}
			return a6;
		}
		return (Integer) null;
	}
}
