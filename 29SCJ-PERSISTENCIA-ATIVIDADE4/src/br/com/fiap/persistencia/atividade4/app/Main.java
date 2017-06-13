package br.com.fiap.persistencia.atividade4.app;

public class Main {

	public static void main(String[] args) {
		
		String cpfExemplo = "12312312373";
		new CreateRegistries().exec(cpfExemplo); // Create all registries
		new Queries().exec(cpfExemplo); // Do search
		
	}
	
	
	
	
	
	
	
	

}
