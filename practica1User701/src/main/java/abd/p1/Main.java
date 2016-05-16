package abd.p1;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import abd.p1.controller.UsuarioController;
import abd.p1.dao.SessionMgr;
import abd.p1.model.Usuario;
import abd.p1.view.InicioSesionJDialog;
import abd.p1.view.PrincipalJFrame;
import abd.p1.view.ViewMgr;

/**
 * Ésta es la clase que arranca la aplicación. La ejecución del método main()
 * no reconstruirá la base de datos. La base de datos se supone ya construida
 * por el método CreateDB.main()
 *
 */
public class Main {
    
    private static SessionFactory buildSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            return null;
        } 
    }
   
    
    public static void main(String[] args) {

        SessionFactory sf = null;
        
        try {
            sf = buildSessionFactory();
            
            // Mostrar ventana de login y comprobar validez del usuario y contraseña.
            // Si son validos, mostrar ventana principal.
            
            SessionMgr.setSessionFactory(sf);
            
            InicioSesionJDialog inicioSesion = new InicioSesionJDialog(null, true);
            inicioSesion.setVisible(true);
            String email = inicioSesion.getEmail();
            String password = inicioSesion.getPassword();
            boolean isNuevoUsuario = inicioSesion.isNuevoUsuario();
            inicioSesion.dispose();
            
            UsuarioController usuarioCtrl = new UsuarioController();
            Usuario usuario = null;
            
            if (isNuevoUsuario) {
            	usuario = new Usuario();
            	usuario.setEmail(email);
            	usuario.setContrasena(password);
            	usuario.setNombre("<Sin nombre>");
            	GregorianCalendar cal = new GregorianCalendar(1970, 0, 1);
            	usuario.setFechaNacimiento(cal.getTime());
            } else {
            	usuario = usuarioCtrl.doLogin(email, password);
            	//System.out.println(usuario);//FIXME
            }
            
            if (usuario == null) {
            	JOptionPane.showMessageDialog(null, "El usuario no existe o la contraseña es incorrecta");
            	return;
            }
            
            ViewMgr.setUsuario(usuario);
            
            PrincipalJFrame mainWindow = new PrincipalJFrame();
            
            if (isNuevoUsuario) {
            	mainWindow.getVentanaPerfil().setVisible(true);
            } else {
            	mainWindow.setVisible(true);
            }
            
            mainWindow.waitUntilClose();
            
            System.out.println("BYE");
            //System.exit(0);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (sf != null) sf.close();
        }
    }

}
