import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

/*
 * 	@author David Torralbo
 */

public class QuadraticEquation {

	static Scanner sc = new Scanner(System.in);
	
	static String[] nombres;

	
	public static void main(String[] args) {
				
		IniciProgramaEquacions();
	
	}
	
	public static void IniciProgramaEquacions(){
		
		int entrades;
		boolean seguir = false;
		
		//entering three doubles
		entrades = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < entrades; i++){
			do{
				try {
					nombres = sc.nextLine().split(" ");
					
					//If the entry is not double, do an exception.
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
	
	   double solucio1 = (-Double.parseDouble(nombres[1]) + Math.sqrt(Math.pow(Double.parseDouble(nombres[1]), 2) - (4*Double.parseDouble(nombres[0])*Double.parseDouble(nombres[2])))) / (2*Double.parseDouble(nombres[0]));
	   double solucio2 = (-Double.parseDouble(nombres[1]) - Math.sqrt(Math.pow(Double.parseDouble(nombres[1]), 2) - (4*Double.parseDouble(nombres[0])*Double.parseDouble(nombres[2])))) / (2*Double.parseDouble(nombres[0]));
	   
	   return new double[] {solucio1, solucio2};
		
	}
	
	public static void RetornaSolucio(double solucions[]){
		
		/*
		 * Formatting the result by ignoring .0 decimal if the result is Integer
		 */
		DecimalFormat df = new DecimalFormat("###.#", new DecimalFormatSymbols(Locale.US));
		
		//Checking if the solution is not NaN
		if(!Double.isNaN(solucions[0]) && !Double.isNaN(solucions[1])){
			//if both solutions are the same number, print only one
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
