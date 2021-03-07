package empresa;

public class Main {

//En el main instanciaremos el buffer, y los 3 hilos Productores como los 2 hilos Consumidores, además de iniciarlos.	
	
	public static void main(String[] args) {
		
		Buffer buffer=new Buffer();
			
		
		Productores p1= new Productores("Productor 1",buffer);
		Productores p2= new Productores("Productor 2",buffer);
		Productores p3= new Productores("Productor 3",buffer);
		
		Consumidores c1= new Consumidores("Consumidor 1",buffer);
		Consumidores c2= new Consumidores("Consumidor 2",buffer);
		
		p1.start();
		p2.start();
		p3.start();
		
		c1.start();
		c2.start();
		

	}

}
