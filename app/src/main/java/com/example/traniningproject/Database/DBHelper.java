/**
 * @author karmakar sourabh
 */

package com.example.traniningproject.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    /**
     * static it will point to the same
     * memory, so it utilise space not to allocate for every instance.
     */

    private static String CREAT_TABLE_QUERY = "CREATE TABLE " + DBConfig.TABLE_NAME_1 + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + DBConfig.DB_CO1 + " VARCHAR(15)," + DBConfig.DB_CO2 + " INTEGER)";
    private static String DROP_IF_EXISTS_QUERY = "DROP TABLE IF EXISTS " + DBConfig.TABLE_NAME_1;

    public DBHelper(Context context) {
        //Creating Database
        super(context, DBConfig.DB_NAME, null, DBConfig.DB_VERSION);
        Log.e("DATABASE LOG", "DBHelper: DBHelper constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /**
         * @param CREATE_TABLE_QUERY
         * it will generate the Table with
         * its necessary arguments.
         */

        db.execSQL(CREAT_TABLE_QUERY);
        Log.e("Database LOG", "onCreate: " + db.getPath());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /**
         * @param DROP_IF_EXISTS_QUERY
         * it will Drop the table if it is already there
         * and update it or we can say replace it with NEW VERSION
         */

        db.execSQL(DROP_IF_EXISTS_QUERY);
        onCreate(db);
    }

    /**
     * @author karmakar Sourabh
     * created this format to easily
     * perform the DATA BASE CRUD operation
     * ...
     *
     * @param db database instances
     * @param Projection which columns you want [col1, col2, ..]
     * @param Selection eg : where title = "MY_TITLE" (where clause)
     * @param SelectionArgs Where clause Arguments [..]
     * @param SortOrder OrderBy which sorted order DESC or ACES
     * @return Cursor which store all the data receive by the Select Operation
     */
    public static Cursor dbSelection(SQLiteDatabase db, String[] Projection, String Selection, String[] SelectionArgs, String SortOrder) {

        return db.query(
                DBConfig.TABLE_NAME_1,
                Projection,
                Selection,
                SelectionArgs,
                null,
                null,
                SortOrder
        );

    }

    /**
     *
     * @param db database instances
     * @param values name value pair array which is use to store values in table
     * @return last inserted _ID
     */
    public static Long dbInsertion(SQLiteDatabase db, ContentValues values) {

        return db.insert(
                DBConfig.TABLE_NAME_1,
                null,
                values);

    }

    /**
     *
     * @param db database instances
     * @param Selection eg : where title = "MY_TITLE" (where clause)
     * @param SelectionArgs Where clause Arguments [..]
     * @return last deleted _ID
     */
    public static int dbDeletion(SQLiteDatabase db, String Selection, String[] SelectionArgs) {

        return db.delete(
                DBConfig.TABLE_NAME_1,
                Selection,
                SelectionArgs
        );
    }

    /**
     *
     * @param db database instances
     * @param values name value pair array which is use to update values in table
     * @param Selection eg : where title = "MY_TITLE" (where clause)
     * @param SelectionArgs Where clause Arguments [..]
     * @return last updated _ID
     */
    public static int dbUpdation(SQLiteDatabase db, ContentValues values, String Selection, String[] SelectionArgs) {

        return db.update(
                DBConfig.TABLE_NAME_1,
                values,
                Selection,
                SelectionArgs
        );
    }

}
