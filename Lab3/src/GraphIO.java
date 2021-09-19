import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GraphIO{
	
	static public void readFile(Graph g, String filename){
		try {
			
//	Skapar ett scanner objekt som läser av filen
			
			Scanner scanner = new Scanner(new File(filename));
						
//	Tilldelar en variabel värdet på hur många noder som ska skapas
			
			int antal = scanner.nextInt();
			
//	Loopar igenom med antalet noder som gräns 
//	och lägger till alla noder på sin plats
			
			for(int i = 0; i < antal; i++) {
				g.addNode(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
					
				}
			
//	Lägger till edges med informationen från resten av filen
			
			while (scanner.hasNextInt()) {
				g.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

				}
			
			scanner.close();
			
//	Om filen inte kan hittas		
			
		} catch (IOException e) {
			System.out.println("Filen kunde inte hittas");
		}
	}
}

