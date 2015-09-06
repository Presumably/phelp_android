package ussdmaster.divum.phelp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "PHELP_DIVUM.db";
    private static final int CURRENT_VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, DB_NAME, null, CURRENT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DialCodeTable.SQL_CREATE_TABLE);
        db.execSQL(UssdCodeTable.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DialCodeTable.SQL_DROP_TABLE);
        db.execSQL(UssdCodeTable.SQL_DROP_TABLE);
        this.onCreate(db);
    }

}
