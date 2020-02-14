import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExplicacion {
	
	public static void main(String[] args) {
		
		
		List<Integer> unaListaDeEnteros = null;
		Integer unEntero = 3;
		Optional<Integer> optionalInteger = Optional.of(3);
		
		optionalInteger.get();
		
		if(unaListaDeEnteros == null) {
			System.out.println("LA LISTA ES NULA");
		}
		
		
		if(unEntero == null) {
			System.out.println("HACE ALGO");
		}
		
		if(!optionalInteger.isPresent()) {
			
		}
		
		
		
		
	
	}

}
