package onlyfun.js.junit;

import java.util.Date;

import onlyfun.js.model.Coach;
import onlyfun.js.model.Person;
import onlyfun.js.model.Student;
import onlyfun.js.uitl.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;


public class TestClass {
	
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;
	@SuppressWarnings("deprecation")
	@Test
	public void createTable(){
		 Configuration configuration = new AnnotationConfiguration(); 
	        configuration.configure(); 
	        SchemaExport export = new SchemaExport(configuration); 
	        export.execute(true, true, false, true); 
	}

	@Test
	public void testGit(){
		System.out.println("SUCCESS TOO!!!!");
	}
}
