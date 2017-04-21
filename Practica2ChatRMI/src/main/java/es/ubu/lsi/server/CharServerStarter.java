package es.ubu.lsi.server;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.server.RMIClassLoader;
import java.util.Properties;

public class CharServerStarter {
	
   	public static void main(String args[]) {
        // Crea e instala el gestor de seguridad
        if (System.getSecurityManager() == null) {
          System.setSecurityManager(new SecurityManager());
        }
        
        try {
          Properties p = System.getProperties();
          
          // lee el goodbyes
          String url = p.getProperty("java.rmi.server.codebase");
          
          // Cargador de clases dinámico ...
          Class<?> serverclass = RMIClassLoader.loadClass(url, "es.ubu.lsi.Servidor");
          Naming.rebind("/Servidor", (Remote) serverclass.newInstance());
          System.out.println("Servidor registrado...");
        } 
        catch (Exception e) {
  		System.err.println("Excepcion recogida: " + e.toString());
        }
     }
   	
   	

}
