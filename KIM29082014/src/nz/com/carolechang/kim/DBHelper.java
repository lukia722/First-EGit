package nz.com.carolechang.kim;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
	// All Static variables
	//Database Version
	private static final int DATABASE_VERSION=1;
	
	//Database Name
	private static final String DATABASE_NAME="memoryManager";
	
	//Memory table Name
	private static final String TABLE_NAME="mymemory";
	
	// mymemory table columns names
	private static final String KEY_ID="_id";
	private static final String KEY_DATE="Date";
	private static final String KEY_TIME="Time";
	private static final String KEY_PLACE="Place";
	private static final String KEY_EVENT="Event";
	private static final String KEY_PURPOSE="Purpose";
	private static final String KEY_PERSON="Person";
	private static final String KEY_ACTIVITY="Activity";
	private static final String KEY_FEELING="Feeling";
	private static final String KEY_NOTES="Notes";

	
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	// Creating tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_MEMORY_TABLE="CREATE TABLE " + TABLE_NAME + "("
				+ KEY_ID + "INTEGER PRIMARY KEY," + KEY_DATE + "TEXT," + KEY_TIME + "TEXT, "
				+ KEY_PLACE + "TEXT," + KEY_EVENT + "TEXT," + KEY_PURPOSE + "TEXT," + KEY_PERSON + "TEXT,"
				+ KEY_ACTIVITY + "TEXT," + KEY_FEELING + "TEXT," + KEY_NOTES + "TEXT" +")";
		db.execSQL(CREATE_MEMORY_TABLE);
	}
	
	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
		
		//Create tables again
		onCreate(db);
	}

}
