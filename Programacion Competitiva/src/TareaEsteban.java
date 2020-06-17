import java.util.Scanner;

public class TareaEsteban {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Cuanto vale n: ");
		int n = sc.nextInt(); // PREGUNTAMOS N
		System.out.print("Cuantos  productos son");
		int productos = sc.nextInt(); // PREGUNTAMOS cuantos productos son
		
		long total = 0;
		double totaldescuento = 0;
		double totalpagar = 0;
		
		int precio = 0;
		double descuento = .20;
		int auxiliar = 1;
		long totaln = 0;
		for (int i = 1; i <= productos; i++) {
			System.out.print("Precio producto " + i + ": ");
			precio = sc.nextInt();
			total = total + precio;
			totaln = totaln + precio;
			
			if(auxiliar == n) {
				totaldescuento = totaldescuento + (totaln * (descuento));
				descuento = descuento / 2;
				auxiliar = 0;
				totaln = 0;
			}
			auxiliar++;
		}
		totalpagar = total - totaldescuento;
		System.out.println("Total de su compra: " + total);
		System.out.println("su descuento es de:" + totaldescuento);
		System.out.println("Total a pagar: " + totalpagar);
	}

}
