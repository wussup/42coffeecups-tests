/**
 * 
 */
package ua.cc.cups.test;

import ua.cc.cups.database.Data;
import ua.cc.cups.database.MySQLiteOpenHelper;
import android.test.AndroidTestCase;

/**
 * @author Taras
 *
 */
public class MySQLiteOpenHelperTests extends AndroidTestCase {

	private MySQLiteOpenHelper db;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		db = new MySQLiteOpenHelper(getContext(), null, null, 1);
		assertNotNull(db);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		db.close();
		super.tearDown();
	}

	/**
	 * Test method for {@link ua.cc.cups.database.MySQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)}.
	 */
	public void testOnCreateSQLiteDatabase() {
		assertNotNull(db);
	}

	/**
	 * Test method for {@link ua.cc.cups.database.MySQLiteOpenHelper#addData(ua.cc.cups.database.Data)}.
	 */
	public void testAddDataAndFindData() {
        Data data = new Data("Taras", "Melon", "Was born in...", "05-02-1992");
        
        db.addData(data);
        
        Data fetchedData = db.findData();
        assertEquals(data.getBio(), fetchedData.getBio());
        assertEquals(data.getDateOfBirth(), fetchedData.getDateOfBirth());
        assertEquals(data.getName(), fetchedData.getName());
        assertEquals(data.getSurname(), fetchedData.getSurname());
	}

}
