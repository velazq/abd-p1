package abd.p1;

import javax.swing.JDialog;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import abd.p1.dao.Facade;
import abd.p1.model.Usuario;
import abd.p1.view.InicioSesionJDialog;
import abd.p1.view.PrincipalJFrame;

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
            
            Facade.setSessionFactory(sf);
            
            //TEST
            InicioSesionJDialog loginDialog = new InicioSesionJDialog(null, true);
            loginDialog.setVisible(true);
            if (loginDialog.isAceptar()) {
            	String email = loginDialog.getEmail();
            	String pass = loginDialog.getPassword();
            	Usuario usr = Facade.getInstance().findUserByEmail(email);
            	if (usr != null) {
            		PrincipalJFrame ppal = new PrincipalJFrame();
            	}
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (sf != null) sf.close();
        }
    }

}
