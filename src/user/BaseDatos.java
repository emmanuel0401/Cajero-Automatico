package user;
import java.util.ArrayList;
import java.util.List;
import com.db4o.ObjectContainer;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectSet;

public class BaseDatos {

	private ObjectContainer bd =null;
	
	private void abrirRegistro() {
		bd = Db4oEmbedded.openFile("RegistroUsuario");
	}
	
	private void cerrarRegistro() {
		bd.close();
	}
	void RegistroUsuario(Usuario user) {
	abrirRegistro();
	bd.store(user);
	cerrarRegistro();
	}
	
	public List<Usuario> seleccionarPersonas(){
		abrirRegistro();
		ObjectSet<Object> listaUsuarios = bd.queryByExample(Usuario.class);
		List<Usuario> lp = new ArrayList<>();

		for (Object listaUsuarios1 : listaUsuarios) {
			lp.add((Usuario) listaUsuarios1);
		}

		cerrarRegistro();

		return lp;
		}
	
	public Usuario seleccionarPersona(Usuario user) {
		abrirRegistro();
		ObjectSet<Object> resultado = bd.queryByExample(user);
		Usuario usuario = (Usuario) resultado.next();
		cerrarRegistro();
		return usuario;
	}

	public void depositarFondos(int NumTarjeta, int Nip, int Fondos) {
		abrirRegistro();
		Usuario user = new Usuario();
		user.setNumTarjeta(NumTarjeta);
		ObjectSet<Object> resultado = bd.queryByExample(user);
		Usuario preResultado = (Usuario) resultado.next();

		if (preResultado.getNip() == Nip) {
			preResultado.setFondos(preResultado.getFondos() + Fondos);
			bd.store(preResultado);
			System.out.println("Transacción exitosa!");
		} else {
			System.out.println("Contraseña erronea");
		}
		cerrarRegistro();
	}

	public void retirarFondos(int NumTarjeta, int Nip, int Fondos) {
		abrirRegistro();
		Usuario user = new Usuario();
		user.setNumTarjeta(NumTarjeta);
		ObjectSet<Object> resultado = bd.queryByExample(user);
		Usuario preResultado = (Usuario) resultado.next();

		if (preResultado.getNip() == Nip) {
			if ( preResultado.getFondos() >= Fondos) {
				preResultado.setFondos(preResultado.getFondos() - Fondos);
				bd.store(preResultado);
				System.out.println("Transacción exitosa!");
			} else {
				System.out.println("Fondos insuficientes!");
			}
		} else {
			System.out.println("Contraseña incorrecta");
		}
		cerrarRegistro();
	}

	public void eliminarUsuario(int NumTarjeta) {
		abrirRegistro();
		Usuario user = new Usuario();
		user.setNumTarjeta(NumTarjeta);
		ObjectSet<Object> resultado = bd.queryByExample(user);
		Usuario preResultado = (Usuario) resultado.next();
		bd.delete(preResultado);
		cerrarRegistro();
	}
}


