import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

/*
 * 	@author David Torralbo
 */

public class QuadraticEquation {

	//declarem objectes globals
	static Scanner sc = new Scanner(System.in);
	
	//declarem variables globals
	static String[] nombres;

	
	public static void main(String[] args) {
				
		IniciProgramaEquacions();
	
	}
	
	public static void IniciProgramaEquacions(){
		
		int entrades;
		boolean seguir = false;
		
		//entrem els tres nombres double
		entrades = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < entrades; i++){
			do{
				try {
					nombres = sc.nextLine().split(" ");
					
					//Si els nombres entrats no són doubles, afegim excepció.
					if(Double.valueOf(nombres[0]) == null && Double.valueOf(nombres[1]) == null && Double.valueOf(nombres[2]) == null){
						throw new Exception();
					}
					CalculaSolucio(nombres);
					RetornaSolucio(CalculaSolucio(nombres));
					seguir = false;
				} catch (Exception e){
					System.out.println("No s'han entrat correctament els tres nombres, si us plau, torni-ho a intentar.\rEXEMPLE: 1 -2 3");
					seguir = true;
				}
			} while(seguir);
		}
	}
	
	public static double[] CalculaSolucio(String nombres[]){
	
	   //processem els tres nombres entrats i els afegim a la fòrmula de la equació de segon grau
	   double solucio1 = (-Double.parseDouble(nombres[1]) + Math.sqrt(Math.pow(Double.parseDouble(nombres[1]), 2) - (4*Double.parseDouble(nombres[0])*Double.parseDouble(nombres[2])))) / (2*Double.parseDouble(nombres[0]));
	   double solucio2 = (-Double.parseDouble(nombres[1]) - Math.sqrt(Math.pow(Double.parseDouble(nombres[1]), 2) - (4*Double.parseDouble(nombres[0])*Double.parseDouble(nombres[2])))) / (2*Double.parseDouble(nombres[0]));
	   
	   //afegim les dos solucions en un double de tipus array
	   return new double[] {solucio1, solucio2};
		
	}
	
	public static void RetornaSolucio(double solucions[]){
		
		/*
		 * Formatem el decimal de forma que quan hi hagi algun zero, exemple: 3.0, mostri solament el 3.
		 * També es mostrarà un punt (.) en lloc d'una coma en els decimals.
		 */
		DecimalFormat df = new DecimalFormat("###.#", new DecimalFormatSymbols(Locale.US));
		
		//comprovem que les solucions siguin correctes
		if(!Double.isNaN(solucions[0]) && !Double.isNaN(solucions[1])){
			//si les dos solucions són les mateixes, imprimim només un valor
			if(solucions[0] == solucions[1]){
			System.out.println(df.format(solucions[0]));
			} else {
			System.out.println(df.format(solucions[0])+" "+df.format(solucions[1]));	
			}
		} else {
			System.out.println("NO SOLUTION");
		}
		
	}

}
