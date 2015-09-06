package ussdmaster.divum.phelp.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import ussdmaster.divum.phelp.exception.DatabaseException;
import ussdmaster.divum.phelp.model.DialCode;

public class DialCodeTable extends BaseTable {


    public static final String SQL_CREATE_TABLE =
            CREATE_TABLE + DialCodeEntry.TABLE_NAME + "(" +
                    DialCodeEntry.DIAL_CODE_ID + INTEGER_TYPE + PRIMARY_KEY + AUTOINCREMENT + COMMA_SEP +
                    DialCodeEntry.DIAL_CODE_NAME + TEXT_TYPE + COMMA_SEP +
                    DialCodeEntry.DIAL_CODE_CODE + TEXT_TYPE + COMMA_SEP +
                    DialCodeEntry.DIAL_CODE_LANGUAGE + INTEGER_TYPE + COMMA_SEP +
                    ")";
    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + DialCodeEntry.TABLE_NAME;
    private static final String DEBUG_TAG = "TABLE_DIAL_CODE";

    public static void addDialCode(MySQLiteHelper db, DialCode dialcode) throws DatabaseException {

        final SQLiteDatabase writableDatabase = db.getWritableDatabase();

        final ContentValues cv = new ContentValues();
        cv.put(DialCodeEntry.DIAL_CODE_NAME, dialcode.getName());
        cv.put(DialCodeEntry.DIAL_CODE_CODE, dialcode.getCode());
        cv.put(DialCodeEntry.DIAL_CODE_LANGUAGE, dialcode.getLanguage());
        Log.d(DEBUG_TAG, "Content values to insert : " + cv.toString());

        final long insert = writableDatabase.insert(DialCodeEntry.TABLE_NAME, null, cv);
        writableDatabase.close();
        if (insert == -1) {
            throw new DatabaseException("Error adding DialCode " + dialcode + " To database");
        }
    }

    protected static abstract class DialCodeEntry implements BaseColumns {
        public static final String TABLE_NAME = "DialCode";
        public static final String DIAL_CODE_ID = "Id";
        public static final String DIAL_CODE_NAME = "Name";
        public static final String DIAL_CODE_CODE = "Code";
        public static final String DIAL_CODE_LANGUAGE = "Language";


        public static final String[] GET_COLUMNS = {DIAL_CODE_NAME, DIAL_CODE_CODE, DIAL_CODE_LANGUAGE};
    }

}
