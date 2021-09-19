import java.util.ArrayList;
import java.util.NoSuchElementException;



public class FIFO implements Queue{
	
//	Skapar en ArrayList för att lagra objekt
	
    private ArrayList<Object> list = new ArrayList<Object>();  
    
//    Variabel som håller reda på historiska maxvärdet på listans storlek
    
    private int count = list.size();
    
//	Lägger till objekt i list och ökar count med 1 om den är lika stor som listans storlek.
//	Eftersom att bara ett objekt kan läggas in i taget blir listans storlek aldrig större
//	än count endast mindre
    
	@Override
	public void add(Object arg0) {
		if(list.size()== count) {
			count++;
		}
		list.add(arg0);
		
	}

	
//	Returnerar det första objektet i list och ger ett error meddelande om den är tom
	
	@Override
	public Object first() throws NoSuchElementException {
		if(list.size() == 0) {
			throw new NoSuchElementException("Listan är tom");
		}else {
			return list.get(0);
		}
		
	}

//	Kollar om listan är tom
	
	@Override
	public boolean isEmpty() {
		if (list.size() == 0 ) {
			return true;
		}else {
			return false;
		}
	
	}
	
//	Returnerar count

	@Override
	public int maxSize() {
		// TODO Auto-generated method stub
		return count;
	}

//  Tar bort det första objektet i list och ger ett error meddelande om den är tom	
	
	@Override
	public void removeFirst() throws NoSuchElementException {
		if(list.size() == 0) {
			throw new NoSuchElementException("Listan är tom");
		}else {
			list.remove(0);
		}
		
		
	}

//  Returnerar nuvarande storlek på list	
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}
	
//	Kollar igenom listan och jämför den med ett f objekt. Om elementet på index i är null
//	så ska elementet på samma index i f också vara null och kollar även om det är 
//	refernser till objekt där samma regler som med null gäller. Om f bryter mot nån av 
//	två regler så returneras false annars så true. f måste även vara samma typ som den 
//	här klassen annars så kastas ClassCastException.
	
	public boolean equals(Object f) {
        if (f instanceof FIFO) {
            if (list.size() == ((FIFO) f).size()) {
                for (int i = 0; i < list.size(); i++) {
                    if ((list.get(i) != null && ((FIFO) f).list.get(i) == null)
                        || ((list.get(i) == null && ((FIFO) f).list.get(i) != null)
                          && (list.get(i) != ((FIFO) f).list.get(i)))) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            throw new ClassCastException("Ogiltig typ på objekt.");
        }
        return true;
    }
	
//	Returnerar en string som innehåller alla objekt i listan med () omkring varje objekt
//	och Queue: längst fram.
	
	public String toString() {
		String result = "";
		for(int i = 0; i < list.size(); i++) {
			result += "(" + String.valueOf(list.get(i)) + ") ";
		}
		return "Queue: " + result;

	}


}
