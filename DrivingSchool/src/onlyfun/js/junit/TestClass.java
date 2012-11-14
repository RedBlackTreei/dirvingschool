package onlyfun.js.junit;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestClass {

	@Test
	public void createTable() {
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure();
		SchemaExport export = new SchemaExport(configuration);
		export.execute(true, true, false, true);
	}

	@Test
	public void testGit() {
		System.out.println("SUCCESS TOO!!!!");
	}
}
