import java.util.ArrayList;

public class Region {
	int numero;
	public ArrayList<Integer> list_terr;
	
	public Region(int num) {
		this.numero=num;
		this.list_terr=new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> region () {
		switch (numero) {
		case 1:
			for (int i=1;i<=9;i++) {
				territoire t = new territoire(i,0,null);
				list_terr.add(t.getNumero());
			}
			return list_terr;
		case 2:
			for (int i=10;i<=13;i++) {
				territoire t = new territoire(i,0,null);
				list_terr.add(t.getNumero());
			}
			return list_terr;
		case 3:
			for (int i=14;i<=19;i++) {
				territoire t = new territoire(i,0,null);
				list_terr.add(t.getNumero());
			}
			return list_terr;
		case 4:
			for (int i=20;i<=26;i++) {
				territoire t = new territoire(i,0,null);
				list_terr.add(t.getNumero());
			}
			return list_terr;
		case 5:
			for (int i=27;i<=30;i++) {
				territoire t = new territoire(i,0,null);
				list_terr.add(t.getNumero());
			}
			return list_terr;
		case 6:
			for (int i=31;i<=42;i++) {
				territoire t = new territoire(i,0,null);
				list_terr.add(t.getNumero());
			}
			return list_terr;
		}
		return list_terr;
	}
}
