package base;

import GUI.Menu;
import GestionArchivos.Leer;
import funciones.Decode;
// https://people.cs.uct.ac.za/~jkenwood/JasonBrownbridge.pdf
// http://norvig.com/mayzner.html
// http://practicalcryptography.com/cryptanalysis/letter-frequencies-various-languages/english-letter-frequencies/
public class Main {
	public static void main(String[] args) {
		Leer l = new Leer();
		l.LeerArvhivo("Cuatro.txt");
		l.mostrarTexto();
		nGramas n = new nGramas();
		Menu menu = new Menu();
		menu.setVisible(true);
		l = new Leer();
		l.LeerArvhivo("Dos.txt");
		Decode d = new Decode(l.getTexto().toCharArray());
	}
}
