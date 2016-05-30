package p1user;


import static org.junit.Assert.fail;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import abd.p1.controller.PreguntaController;
import abd.p1.controller.UsuarioController;

public class P1Test {
	
	public static SessionFactory sf = null;

	public static PreguntaController preguntaController = null; 
	public static UsuarioController usuarioController = null;
	
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

    @BeforeClass
    public static void setUpClass() throws ClassNotFoundException {
        try {
            sf = buildSessionFactory();
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Cannot instantiate SessionFactory");
        }
        
        //SessionMgr.setSessionFactory(sf);
        
        //preguntaController = new PreguntaController(sf);
        usuarioController = new UsuarioController(sf);
    }
    
    @AfterClass
    public static void tearDownClass() {
    	if (sf != null) {
    		sf.close();
    	}
    }

    @Before
    public void setUp() {
    	
    }

    @After
    public void tearDown() {
    	
    }
    
    @Test
    public void dummyTest() {
    	
    }
    
}
