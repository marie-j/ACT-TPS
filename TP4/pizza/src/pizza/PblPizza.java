package pizza;

import java.util.List;

public class PblPizza {

	protected int ham; 
	protected int max; 
	//true if it's ham , else false
	protected boolean[][] pizza;
	
	public PblPizza(int ham, int max, boolean[][] pizza) {
		this.ham = ham;
		this.max = max; 
		this.pizza = pizza; 
	}
	
	public int getHam() {
		return this.ham;
	}
	
	public int getMax() {
		return this.max; 
	}
	
	public boolean[][] getPizza() {
		return this.pizza;
	}
	
	public List<Part> generateAll() {
		
	}
}
