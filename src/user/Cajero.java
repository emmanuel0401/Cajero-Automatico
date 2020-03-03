package user;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.List;


public class Cajero {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		BaseDatos bd = new BaseDatos();
		Usuario user = new Usuario();
		int seleccion;
		System.out.println("  ---------------------------------");
		System.out.println("  ----                         ----");
		System.out.println("  ----   Bienvenido a Bancumex ----");
		System.out.println("  ----                         ----");
		System.out.println("  ---------------------------------");
		do {
			System.out.println("Eliga una de las siguientes opciones:");
			System.out.println(" 1.-  Crear usuario");
			System.out.println(" 2.-  Consutar saldo");
			System.out.println(" 3.-   Retiro");
			System.out.println(" 4.-   Salir");
			seleccion = teclado.nextInt();
			
			//opcion 1 para crear cuenta
			if (seleccion==1) {
				System.out.print(" Nombre: ");
				user.setNombre(teclado.next());
				System.out.print(" Nip: ");
				user.setNip(teclado.nextInt());
				System.out.print(" NumTarjeta: ");
				user.setNumTarjeta(teclado.nextInt());
				System.out.print(" Fondos: $");
				user.setFondos(teclado.nextInt());
				bd.RegistroUsuario(user);
				System.out.println(user);
				
			}
			//opcion 2 para consultar saldo
			else if (seleccion==2) {
				System.out.print(" NumTarjeta: ");
				user.setNumTarjeta(teclado.nextInt());
				user.setNip(teclado.nextInt());
				System.out.println("");
				System.out.print("Tu saldo es: ");
			}
			else if(seleccion==3){
				System.out.println("¿Cuanto deseas retirar?:");
			}
			else if(seleccion==4) {
				System.out.println(" Transaccion finalizada ");
				System.exit(0);
				}
			else {
				System.out.println(" Elige una opción valida");
			}
		}
		while(seleccion==0);	
		}
	}


