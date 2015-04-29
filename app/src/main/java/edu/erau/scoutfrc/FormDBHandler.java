package edu.erau.scoutfrc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Cierra
 * @date 4/28/2015.
 */
public class FormDBHandler extends SQLiteOpenHelper {
    public static final String DB_NAME = "scouting_data_frc";
    public static final int DB_VERSION = 2;

    // Auto Tab
    public static final String TABLE_NAME = "scouted_data";
    public static final String COMPETITION_COLUMN = "competition";
    public static final String TEAMUMBER_COLUMN = "number";
    public static final String MATCH_COLUMN = "match";
    public static final String POSITION_COLUMN = "startposition";
    public static final String SCOUTERNAME_COLUMN = "scoutername";
    public static final String AYMOVE_COLUMN = "aymove";
    public static final String AYPUSH_COLUMN = "aypush";
    public static final String AYPUSHNUM_COLUMN = "aypush_num";
    public static final String AYSTACK_COLUMN = "aystack";
    public static final String AYSTACKNUM_COLUMN = "aystack_num";
    public static final String ARMOVE_COLUMN = "armove";
    public static final String ARMOVENUM_COLUMN = "armove_num";
    public static final String ARCENTER_COLUMN = "arcenter";
    public static final String ARCENTERNUM_COLUMN = "arcenter_num";
    public static final String AGMOVE_COLUMN = "agmove";

    //Teleop tab
    public static final String TCONTROL_COLUMN = "tcontrol";
    public static final String TWHERE_COLUMN = "ttotes_where";
    public static final String TCONTROLHOW_COLUMN = "tcontrol_how";
    public static final String GSTACK_COLUMN = "gstack";
    public static final String GSTACKNUM_COLUMN = "gstack_num";
    public static final String GHIGHSTACK_COLUMN = "ghigh_stack";
    public static final String TBINSTOP_COLUMN = "tbinstop";
    public static final String TBINSHIGH_COLUMN = "tbinshigh";
    public static final String TBINSCENTER_COLUMN = "tbinscenter";
    public static final String TBINSTHROUGH_COLUMN = "tbinsthrough";
    public static final String TLITTERSCORE_COLUMN = "tlitterscore";
    public static final String TLITTERHOW_COLUMN = "tlitterhow";
    public static final String TLITTERNUM_COLUMN = "tlitter_num";
    public static final String TLITTERHERD_COLUMN = "tlitterherd";
    public static final String TLITTERPICK_COLUMN = "tlitterpick";

    // End Game Tab
    public static final String EBONUSYELLOW_COLUMN = "ebonusyellow";
    public static final String EBONUSTOP_COLUMN = "ebonustop";
    public static final String EBONUSBOTTOM_COLUMN = "ebonusbottom";
    public static final String EBONUSTOTAL_COLUMN = "ebonustotal";
    public static final String EHPCOLLECT_COLUMN = "ehpcollect";
    public static final String EHPCOLLECTWHAT_COLUMN = "ehpcollect_what";
    public static final String EHPSTACKER_COLUMN = "estacker";
    public static final String EHPHERDER_COLUMN = "eherder";
    public static final String EHPBIN_COLUMN = "ebin";
    public static final String EHPNOODLE_COLUMN = "enoodle";
    public static final String EHPINBOUND_COLUMN = "einbound";
    public static final String EHPOTHER_COLUMN = "eother";
    public static final String ENOTES_COLUMN = "notes";

    public static FormDBHandler instance;

    public FormDBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        instance = this;
    }

    public static FormDBHandler getInstance(Context c)
    {
        if (instance == null)
            instance = new FormDBHandler(c);
        return instance;
    }

    /**
     * Creates a new table for storring all scouted data.
     * @param db - the SQLite database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SCOUTING_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COMPETITION_COLUMN + " TEXT,"
                + TEAMUMBER_COLUMN + " TEXT,"
                + MATCH_COLUMN + " TEXT,"
                + POSITION_COLUMN + " TEXT,"
                + SCOUTERNAME_COLUMN + " TEXT,"
                + AYMOVE_COLUMN + " TEXT,"
                + AYPUSH_COLUMN + " TEXT,"
                + AYPUSHNUM_COLUMN + " TEXT,"
                + AYSTACK_COLUMN + " TEXT,"
                + AYSTACKNUM_COLUMN + " TEXT,"
                + ARMOVE_COLUMN + " TEXT,"
                + ARMOVENUM_COLUMN + " TEXT,"
                + ARCENTER_COLUMN + " TEXT,"
                + ARCENTERNUM_COLUMN + " TEXT,"
                + AGMOVE_COLUMN + " TEXT,"
                + TCONTROL_COLUMN + " TEXT,"
                + TWHERE_COLUMN + " TEXT,"
                + TCONTROLHOW_COLUMN + " TEXT,"
                + GSTACK_COLUMN + " TEXT,"
                + GSTACKNUM_COLUMN + " TEXT,"
                + GHIGHSTACK_COLUMN + " TEXT,"
                + TBINSTOP_COLUMN + " TEXT,"
                + TBINSHIGH_COLUMN + " TEXT,"
                + TBINSCENTER_COLUMN + " TEXT,"
                + TBINSTHROUGH_COLUMN + " TEXT,"
                + TLITTERSCORE_COLUMN + " TEXT,"
                + TLITTERHOW_COLUMN + " TEXT,"
                + TLITTERNUM_COLUMN + " TEXT,"
                + TLITTERHERD_COLUMN + " TEXT,"
                + TLITTERPICK_COLUMN + " TEXT,"
                + EBONUSYELLOW_COLUMN + " TEXT,"
                + EBONUSTOP_COLUMN + " TEXT,"
                + EBONUSBOTTOM_COLUMN + " TEXT,"
                + EBONUSTOTAL_COLUMN + " TEXT,"
                + EHPCOLLECT_COLUMN + " TEXT,"
                + EHPCOLLECTWHAT_COLUMN + " TEXT,"
                + EHPSTACKER_COLUMN + " TEXT,"
                + EHPHERDER_COLUMN + " TEXT,"
                + EHPBIN_COLUMN + " TEXT,"
                + EHPNOODLE_COLUMN + " TEXT,"
                + EHPINBOUND_COLUMN + " TEXT,"
                + EHPOTHER_COLUMN + " TEXT,"
                + ENOTES_COLUMN + " TEXT"
                + ")";
        db.execSQL(CREATE_SCOUTING_TABLE);
    }

    /**
     * When upgrading the DB, delete the old table and create a new table
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * Add all scouted values to a new row in the database.
     * @param sfd - instance of the ScoutFormData
     * @return
     */
    public long addScoutedData(ScoutFormData sfd){
        SQLiteDatabase sql = this.getWritableDatabase();

        // Create a new SQL row
        ContentValues values = new ContentValues();
        values.put(COMPETITION_COLUMN, sfd.getCOMPETITION_COLUMN());
        values.put(TEAMUMBER_COLUMN, sfd.getTEAMUMBER_COLUMN());
        values.put(MATCH_COLUMN, sfd.getMATCH_COLUMN());
        values.put(POSITION_COLUMN, sfd.getPOSITION_COLUMN());
        values.put(SCOUTERNAME_COLUMN, sfd.getSCOUTERNAME_COLUMN());
        values.put(AYMOVE_COLUMN, sfd.getAYMOVE_COLUMN());
        values.put(AYPUSH_COLUMN, sfd.getAYPUSH_COLUMN());
        values.put(AYPUSHNUM_COLUMN, sfd.getAYPUSHNUM_COLUMN());
        values.put(AYSTACK_COLUMN, sfd.getAYSTACK_COLUMN());
        values.put(AYSTACKNUM_COLUMN, sfd.getAYSTACKNUM_COLUMN());
        values.put(ARMOVE_COLUMN, sfd.getARMOVE_COLUMN());
        values.put(ARMOVENUM_COLUMN, sfd.getARMOVENUM_COLUMN());
        values.put(ARCENTER_COLUMN, sfd.getARCENTER_COLUMN());
        values.put(ARCENTERNUM_COLUMN, sfd.getARCENTERNUM_COLUMN());
        values.put(AGMOVE_COLUMN, sfd.getAGMOVE_COLUMN());
        values.put(TCONTROL_COLUMN, sfd.getTCONTROL_COLUMN());
        values.put(TWHERE_COLUMN, sfd.getTWHERE_COLUMN());
        values.put(TCONTROLHOW_COLUMN, sfd.getTCONTROLHOW_COLUMN());
        values.put(GSTACK_COLUMN, sfd.getGSTACK_COLUMN());
        values.put(GSTACKNUM_COLUMN, sfd.getGSTACKNUM_COLUMN());
        values.put(GHIGHSTACK_COLUMN, sfd.getGHIGHSTACK_COLUMN());
        values.put(TBINSTOP_COLUMN, sfd.getTBINSTOP_COLUMN());
        values.put(TBINSHIGH_COLUMN, sfd.getTBINSHIGH_COLUMN());
        values.put(TBINSCENTER_COLUMN, sfd.getTBINSCENTER_COLUMN());
        values.put(TBINSTHROUGH_COLUMN, sfd.getTBINSTHROUGH_COLUMN());
        values.put(TLITTERSCORE_COLUMN, sfd.getTLITTERSCORE_COLUMN());
        values.put(TLITTERHOW_COLUMN, sfd.getTLITTERHOW_COLUMN());
        values.put(TLITTERNUM_COLUMN, sfd.getTLITTERNUM_COLUMN());
        values.put(TLITTERHERD_COLUMN, sfd.getTLITTERHERD_COLUMN());
        values.put(TLITTERPICK_COLUMN, sfd.getTLITTERPICK_COLUMN());
        values.put(EBONUSYELLOW_COLUMN, sfd.getEBONUSYELLOW_COLUMN());
        values.put(EBONUSTOP_COLUMN, sfd.getEBONUSTOP_COLUMN());
        values.put(EBONUSBOTTOM_COLUMN, sfd.getEBONUSBOTTOM_COLUMN());
        values.put(EBONUSTOTAL_COLUMN, sfd.getEBONUSTOTAL_COLUMN());
        values.put(EHPCOLLECT_COLUMN, sfd.getEHPCOLLECT_COLUMN());
        values.put(EHPCOLLECTWHAT_COLUMN, sfd.getEHPCOLLECTWHAT_COLUMN());
        values.put(EHPSTACKER_COLUMN, sfd.getEHPSTACKER_COLUMN());
        values.put(EHPHERDER_COLUMN, sfd.getEHPHERDER_COLUMN());
        values.put(EHPBIN_COLUMN, sfd.getEHPBIN_COLUMN());
        values.put(EHPNOODLE_COLUMN, sfd.getEHPNOODLE_COLUMN());
        values.put(EHPINBOUND_COLUMN, sfd.getEHPINBOUND_COLUMN());
        values.put(EHPOTHER_COLUMN, sfd.getEHPOTHER_COLUMN());
        values.put(ENOTES_COLUMN, sfd.getENOTES_COLUMN());


        return sql.insert(TABLE_NAME, null, values);
    }

    public List<ScoutFormData> getScoutedData(){
        SQLiteDatabase sql = this.getWritableDatabase();
        List<ScoutFormData> sfd = new ArrayList<>();

        // Query all from the table
        String query = "select * from " + TABLE_NAME;
        Cursor cursor = sql.rawQuery(query, null);

        ScoutFormData newScoutData;

        // loop through all rows to add the row to the list
        if (cursor.moveToFirst()) {
            do {
                newScoutData = new ScoutFormData(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11),
                        cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16), cursor.getString(17),
                        cursor.getString(18), cursor.getString(19), cursor.getString(20), cursor.getString(21), cursor.getString(22), cursor.getString(23),
                        cursor.getString(24), cursor.getString(25), cursor.getString(26), cursor.getString(27), cursor.getString(28), cursor.getString(29),
                        cursor.getString(30), cursor.getString(31), cursor.getString(32), cursor.getString(33), cursor.getString(34), cursor.getString(35),
                        cursor.getString(36), cursor.getString(37), cursor.getString(38), cursor.getString(39), cursor.getString(40), cursor.getString(41),
                        cursor.getString(42), cursor.getString(43));
                sfd.add(newScoutData);
            } while (cursor.moveToNext());
        }
        return sfd;
    }

    /**
     * Checks if the database is empty.
     * @return
     */
    public boolean isEmpty()
    {
        SQLiteDatabase sql = this.getWritableDatabase();

        String query = "select * from " + TABLE_NAME;
        Cursor cursor = sql.rawQuery(query, null);

        return (!cursor.moveToFirst());
    }
}
