package mutacion;

import java.util.ArrayList;
import java.util.Random;

import funciones.Decode;
import base.AlgoritmoGenetico;
import base.Cromosoma;
import base.Gen;

public class Intercambio extends Mutacion {
	private double probMutacion;
	private AlgoritmoGenetico agCopy;
	ArrayList<Cromosoma> poblacion;
	private int lPoblacion;

	public Intercambio(double probMutacion) {
		this.probMutacion = probMutacion;
	}

	public ArrayList<Cromosoma> mutar(AlgoritmoGenetico ag) {

		this.agCopy = ag.copy();	
		this.poblacion = this.agCopy.getPoblacion();
		this.lPoblacion = this.agCopy.getlPoblacion();

		Cromosoma c = new Decode();

		double prob;
		for (int i = 0; i < this.lPoblacion; i++){
			prob = Math.random();

			if(prob < this.probMutacion) {
				c = mutarCromosoma(this.poblacion.get(i).copy());
				this.poblacion.set(i, c);
			}
		}
		return this.poblacion;
	}
	private Cromosoma mutarCromosoma(Cromosoma c) {

		Gen g;
		Cromosoma mutado;
		ArrayList<Character> alelos = new ArrayList<Character>();
		g = c.getGen().copy();
		alelos = g.getAlelos();
		

		int posI;
		int posJ;
		Random r = new Random();
		posI = r.nextInt(26);
		posJ = r.nextInt(26);

		char letra;
		letra = alelos.get(posJ);
		alelos.set(posJ, alelos.get(posI));
		alelos.set(posI, letra);

		g.setAlelos(alelos);
		c.setGen(g);
		c.calcularFitness();
		
		mutado = c.copy();
		return mutado;
	}
}