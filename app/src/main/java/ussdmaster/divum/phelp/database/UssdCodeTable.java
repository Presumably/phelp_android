package ussdmaster.divum.phelp.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import ussdmaster.divum.phelp.exception.DatabaseException;
import ussdmaster.divum.phelp.model.UssdCode;


public class UssdCodeTable extends BaseTable {


    public static final String SQL_CREATE_TABLE =
            CREATE_TABLE + UssdCodeEntry.TABLE_NAME + "(" +
                    UssdCodeEntry.USSD_CODE_ID + INTEGER_TYPE + PRIMARY_KEY + AUTOINCREMENT + COMMA_SEP +
                    UssdCodeEntry.USSD_CODE_NAME + TEXT_TYPE + COMMA_SEP +
                    UssdCodeEntry.USSD_CODE_CODE + TEXT_TYPE + COMMA_SEP +
                    UssdCodeEntry.USSD_CODE_LANGUAGE + INTEGER_TYPE + COMMA_SEP +
                    ")";
    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + UssdCodeEntry.TABLE_NAME;
    private static final String DEBUG_TAG = "TABLE_DIAL_CODE";

    public static void addAnswerToRequest(MySQLiteHelper db, UssdCode ussdcode) throws DatabaseException {

        final SQLiteDatabase writableDatabase = db.getWritableDatabase();

        final ContentValues cv = new ContentValues();
        cv.put(UssdCodeEntry.USSD_CODE_NAME, ussdcode.getName());
        cv.put(UssdCodeEntry.USSD_CODE_CODE, ussdcode.getCode());
        cv.put(UssdCodeEntry.USSD_CODE_LANGUAGE, ussdcode.getLanguage());
        Log.d(DEBUG_TAG, "Content values to insert : " + cv.toString());

        final long insert = writableDatabase.insert(UssdCodeEntry.TABLE_NAME, null, cv);
        writableDatabase.close();
        if (insert == -1) {
            throw new DatabaseException("Error adding DialCode " + ussdcode + " To database");
        }
    }

    protected static abstract class UssdCodeEntry implements BaseColumns {
        public static final String TABLE_NAME = "DialCode";
        public static final String USSD_CODE_ID = "Id";
        public static final String USSD_CODE_NAME = "Name";
        public static final String USSD_CODE_CODE = "Code";
        public static final String USSD_CODE_LANGUAGE = "Language";


        public static final String[] GET_COLUMNS = {USSD_CODE_NAME, USSD_CODE_CODE, USSD_CODE_LANGUAGE};
    }

}
