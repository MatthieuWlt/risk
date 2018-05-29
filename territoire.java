import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class territoire {
	public int numero;
	public int a;
	public Joueur j;

	public territoire(int numero, int a, Joueur j) {
		this.numero = numero;
		this.a = a;
		this.j=j;
	}

	public Joueur getJ() {
		return j;
	}

	public void setJ(Joueur j) {
		this.j = j;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public void position(territoire t, Color r) {
		switch (t.numero) {
		// Amérique du Nord
		case 1:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(7.2, 88.7, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(7.2, 88.7, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(7.2, 88.7, "" + t.a + "");
			break;
		case 2:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(12.1, 81.0, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(12.1, 81.0, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(12.1, 81, "" + t.a + "");
			break;
		case 3:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(11.8, 58.9, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(11.8, 58.9, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(11.8, 58.9, "" + t.a + "");
			break;
		case 4:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(17.9, 69.6, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(17.9, 69.6, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(17.9, 69.6, "" + t.a + "");
			break;
		case 5:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(35.8, 93, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(35.8, 93, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(35.8, 93, "" + t.a + "");
			break;
		case 6:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(15.3, 88.3, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(15.3, 88.3, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(15.3, 88.3, "" + t.a + "");
			break;
		case 7:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(19.3, 80.9, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(19.3, 80.9, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(19.3, 80.9, "" + t.a + "");
			break;
		case 8:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(26.1, 79.9, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(26.1, 79.9, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(26.1, 79.9, "" + t.a + "");
			break;
		case 9:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(11.4, 72, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(11.4, 72, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(11.4, 72.1, "" + t.a + "");
			break;

		// Amérique du Sud
		case 10:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(24.3, 19.7, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(24.3, 19.7, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(24.3, 19.7, "" + t.a + "");
			break;
		case 11:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(27.9, 34.5, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(27.9, 34.5, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(27.9, 34.5, "" + t.a + "");
			break;
		case 12:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(23.2, 30.9, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(23.2, 30.9, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(23.2, 30.9, "" + t.a + "");
			break;
		case 13:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(22.5, 47.2, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(22.5, 47.2, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(22.5, 47.2, "" + t.a + "");
			break;

		// Afrique
		case 14:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(52.1, 42.2, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(52.1, 42.2, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(52.1, 42.2, "" + t.a + "");
			break;
		case 15:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(58.6, 48.6, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(58.6, 48.6, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(58.6, 48.6, "" + t.a + "");
			break;
		case 16:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(52.5, 62.7, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(52.5, 62.7, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(52.5, 62.7, "" + t.a + "");
			break;
		case 17:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(60.7, 28.2, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(60.7, 28.2, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(60.7, 28.2, "" + t.a + "");
			break;
		case 18:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(44.6, 55.6, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(44.6, 55.6, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(44.6, 55.6, "" + t.a + "");
			break;
		case 19:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(52.5, 28.2, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(52.5, 28.2, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(52.5, 28.2, "" + t.a + "");
			break;

		// Europe
		case 20:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(44.3, 81, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(44.3, 81, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(44.3, 81, "" + t.a + "");
			break;
		case 21:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(40.7, 86.6, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(40.7, 86.6, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(40.7, 86.6, "" + t.a + "");
			break;
		case 22:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(49.6, 79.6, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(49.6, 79.6, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(49.6, 79.6, "" + t.a + "");
			break;
		case 23:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(49.6, 86.6, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(49.6, 86.6, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(49.6, 86.6, "" + t.a + "");
			break;
		case 24:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(52.1, 73.9, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(52.1, 73.9, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(52.1, 73.9, "" + t.a + "");
			break;
		case 25:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(55.7, 81.7, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(55.7, 81.7, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(55.7, 81.7, "" + t.a + "");
			break;
		case 26:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(45.7, 73.9, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(45.7, 73.9, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(45.7, 73.9, "" + t.a + "");
			break;

		// Océanie
		case 27:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(92.1, 23.9, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(92.1, 23.9, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(92.1, 23.9, "" + t.a + "");
			break;
		case 28:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(83.9, 43, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(83.9, 43, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(83.9, 43, "" + t.a + "");
			break;
		case 29:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(92.9, 38.7, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(92.9, 38.7, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(92.9, 38.7, "" + t.a + "");
			break;
		case 30:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(85, 23.2, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(85, 23.2, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(85, 23.2, "" + t.a + "");
			break;

		// Asie
		case 31:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(65, 74.6, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(65, 74.6, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(65, 74.6, "" + t.a + "");
			break;
		case 32:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(77.1, 66.2, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(77.1, 66.2, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(77.1, 66.2, "" + t.a + "");
			break;
		case 33:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(70.7, 59.9, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(70.7, 59.9, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(70.7, 59.9, "" + t.a + "");
			break;
		case 34:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(77.5, 81, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(77.5, 81, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(77.5, 81, "" + t.a + "");
			break;
		case 35:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(90.3, 69, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(90.3, 69, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(90.3, 69, "" + t.a + "");
			break;
		case 36:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(87.1, 88, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(87.1, 88, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(87.1, 88, "" + t.a + "");
			break;
		case 37:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(58.9, 66.2, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(58.9, 66.2, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(58.9, 66.2, "" + t.a + "");
			break;
		case 38:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(78.6, 74.6, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(78.6, 74.6, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(78.6, 74.6, "" + t.a + "");
			break;
		case 39:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(79.3, 54.2, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(79.3, 54.2, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(79.3, 54.2, "" + t.a + "");
			break;
		case 40:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(70.4, 88, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(70.4, 88, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(70.4, 88, "" + t.a + "");
			break;
		case 41:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(64.6, 85.2, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(64.6, 85.2, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(64.6, 85.2, "" + t.a + "");
			break;
		case 42:
			StdDraw.setPenColor(r);
			StdDraw.filledCircle(78.2, 88, 2.5);
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.filledCircle(78.2, 88, 2);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(78.2, 88.1, "" + t.a + "");
			break;
		}
	}

}
