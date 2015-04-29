package edu.erau.scoutfrc;

/**
 * Created by Cierra on 4/28/2015.
 */
public class ScoutFormData {
    // Auto Tab
    private String COMPETITION_COLUMN = "competition";
    private String TEAMUMBER_COLUMN = "number";
    private String MATCH_COLUMN = "match";
    private String POSITION_COLUMN = "startposition";
    private String SCOUTERNAME_COLUMN = "scoutername";
    private String AYMOVE_COLUMN = "aymove";
    private String AYPUSH_COLUMN = "aypush";
    private String AYPUSHNUM_COLUMN = "aypush_num";
    private String AYSTACK_COLUMN = "aystack";
    private String AYSTACKNUM_COLUMN = "aystack_num";
    private String ARMOVE_COLUMN = "armove";
    private String ARMOVENUM_COLUMN = "armove_num";
    private String ARCENTER_COLUMN = "arcenter";
    private String ARCENTERNUM_COLUMN = "arcenter_num";
    private String AGMOVE_COLUMN = "agmove";

    //Teleop tab
    private String TCONTROL_COLUMN = "tcontrol";
    private String TWHERE_COLUMN = "ttotes_where";
    private String TCONTROLHOW_COLUMN = "tcontrol_how";
    private String GSTACK_COLUMN = "gstack";
    private String GSTACKNUM_COLUMN = "gstack_num";
    private String GHIGHSTACK_COLUMN = "ghigh_stack";
    private String TBINSTOP_COLUMN = "tbinstop";
    private String TBINSHIGH_COLUMN = "tbinshigh";
    private String TBINSCENTER_COLUMN = "tbinscenter";
    private String TBINSTHROUGH_COLUMN = "tbinsthrough";
    private String TLITTERSCORE_COLUMN = "tlitterscore";
    private String TLITTERHOW_COLUMN = "tlitterhow";
    private String TLITTERNUM_COLUMN = "tlitter_num";
    private String TLITTERHERD_COLUMN = "tlitterherd";
    private String TLITTERPICK_COLUMN = "tlitterpick";

    // End Game Tab
    private String EBONUSYELLOW_COLUMN = "ebonusyellow";
    private String EBONUSTOP_COLUMN = "ebonustop";
    private String EBONUSBOTTOM_COLUMN = "ebonusbottom";
    private String EBONUSTOTAL_COLUMN = "ebonustotal";
    private String EHPCOLLECT_COLUMN = "ehpcollect";
    private String EHPCOLLECTWHAT_COLUMN = "ehpcollect_what";
    private String EHPSTACKER_COLUMN = "estacker";
    private String EHPHERDER_COLUMN = "eherder";
    private String EHPBIN_COLUMN = "ebin";
    private String EHPNOODLE_COLUMN = "enoodle";
    private String EHPINBOUND_COLUMN = "einbound";
    private String EHPOTHER_COLUMN = "eother";
    private String ENOTES_COLUMN = "notes";

    /**
     * Empty Constructor
     */
    public ScoutFormData(){

    }

    /**
     * Constructor creates a new instance of ScoutFormData
     */
    public ScoutFormData(String COMPETITION_COLUMN, String TEAMUMBER_COLUMN, String MATCH_COLUMN,
                         String POSITION_COLUMN, String SCOUTERNAME_COLUMN, String AYMOVE_COLUMN,
                         String AYPUSH_COLUMN, String AYPUSHNUM_COLUMN, String AYSTACK_COLUMN,
                         String AYSTACKNUM_COLUMN, String ARMOVE_COLUMN, String ARMOVENUM_COLUMN,
                         String ARCENTER_COLUMN, String ARCENTERNUM_COLUMN, String AGMOVE_COLUMN,
                         String TCONTROL_COLUMN, String TWHERE_COLUMN, String TCONTROLHOW_COLUMN,
                         String GSTACK_COLUMN, String GSTACKNUM_COLUMN, String GHIGHSTACK_COLUMN,
                         String TBINSTOP_COLUMN, String TBINSHIGH_COLUMN, String TBINSCENTER_COLUMN,
                         String TBINSTHROUGH_COLUMN, String TLITTERSCORE_COLUMN, String TLITTERHOW_COLUMN,
                         String TLITTERNUM_COLUMN, String TLITTERHERD_COLUMN, String TLITTERPICK_COLUMN,
                         String EBONUSYELLOW_COLUMN, String EBONUSTOP_COLUMN, String EBONUSBOTTOM_COLUMN,
                         String EBONUSTOTAL_COLUMN, String EHPCOLLECT_COLUMN, String EHPCOLLECTWHAT_COLUMN,
                         String EHPSTACKER_COLUMN, String EHPHERDER_COLUMN, String EHPBIN_COLUMN,
                         String EHPNOODLE_COLUMN, String EHPINBOUND_COLUMN, String EHPOTHER_COLUMN,
                         String ENOTES_COLUMN){
        this.COMPETITION_COLUMN = COMPETITION_COLUMN; this.TEAMUMBER_COLUMN = TEAMUMBER_COLUMN;
        this.MATCH_COLUMN = MATCH_COLUMN; this.POSITION_COLUMN = POSITION_COLUMN;
        this.SCOUTERNAME_COLUMN = SCOUTERNAME_COLUMN; this.AYMOVE_COLUMN = AYMOVE_COLUMN;
        this.AYPUSH_COLUMN = AYPUSH_COLUMN; this.AYPUSHNUM_COLUMN = AYPUSHNUM_COLUMN;
        this.AYSTACK_COLUMN = AYSTACK_COLUMN; this.AYSTACKNUM_COLUMN = AYSTACKNUM_COLUMN;
        this.ARMOVE_COLUMN = ARMOVE_COLUMN; this.ARMOVENUM_COLUMN = ARMOVENUM_COLUMN;
        this.ARCENTER_COLUMN = ARCENTER_COLUMN; this.ARCENTERNUM_COLUMN = ARCENTERNUM_COLUMN;
        this.AGMOVE_COLUMN = AGMOVE_COLUMN; this.TCONTROL_COLUMN = TCONTROL_COLUMN;
        this.TWHERE_COLUMN = TWHERE_COLUMN; this.TCONTROLHOW_COLUMN = TCONTROLHOW_COLUMN;
        this.GSTACK_COLUMN = GSTACK_COLUMN; this.GSTACKNUM_COLUMN = GSTACKNUM_COLUMN;
        this.GHIGHSTACK_COLUMN = GHIGHSTACK_COLUMN; this.TBINSTOP_COLUMN = TBINSTOP_COLUMN;
        this.TBINSHIGH_COLUMN = TBINSHIGH_COLUMN; this.TBINSCENTER_COLUMN = TBINSCENTER_COLUMN;
        this.TBINSTHROUGH_COLUMN = TBINSTHROUGH_COLUMN; this.TLITTERSCORE_COLUMN = TLITTERSCORE_COLUMN;
        this.TLITTERHOW_COLUMN = TLITTERHOW_COLUMN; this.TLITTERNUM_COLUMN = TLITTERNUM_COLUMN;
        this.TLITTERHERD_COLUMN = TLITTERHERD_COLUMN; this.TLITTERPICK_COLUMN = TLITTERPICK_COLUMN;
        this.EBONUSYELLOW_COLUMN = EBONUSYELLOW_COLUMN; this.EBONUSTOP_COLUMN = EBONUSTOP_COLUMN;
        this.EBONUSBOTTOM_COLUMN = EBONUSBOTTOM_COLUMN; this.EBONUSTOTAL_COLUMN = EBONUSTOTAL_COLUMN;
        this.EHPCOLLECT_COLUMN = EHPCOLLECT_COLUMN; this.EHPCOLLECTWHAT_COLUMN = EHPCOLLECTWHAT_COLUMN;
        this.EHPSTACKER_COLUMN = EHPSTACKER_COLUMN; this.EHPHERDER_COLUMN = EHPHERDER_COLUMN;
        this.EHPBIN_COLUMN = EHPBIN_COLUMN; this.EHPNOODLE_COLUMN = EHPNOODLE_COLUMN;
        this.EHPINBOUND_COLUMN = EHPINBOUND_COLUMN; this.EHPOTHER_COLUMN = EHPOTHER_COLUMN;
        this.ENOTES_COLUMN = ENOTES_COLUMN;
    }

    /**
     * Generates a String representation of the final submitted scouting form.
     * @return String of all submitted scouting data
     */
    public String toString(){
        return ""+ COMPETITION_COLUMN +", "+ TEAMUMBER_COLUMN +", "+ MATCH_COLUMN +", "+ POSITION_COLUMN
                +", "+ SCOUTERNAME_COLUMN +", "+ AYMOVE_COLUMN +", "+ AYPUSH_COLUMN +", "+ AYPUSHNUM_COLUMN
                +", "+ AYSTACK_COLUMN +", "+ AYSTACKNUM_COLUMN +", "+ ARMOVE_COLUMN +", "+ ARMOVENUM_COLUMN
                +", "+ ARCENTER_COLUMN +", "+ ARCENTERNUM_COLUMN +", "+ AGMOVE_COLUMN +", "+ TCONTROL_COLUMN
                +", "+ TWHERE_COLUMN +", "+ TCONTROLHOW_COLUMN +", "+ GSTACK_COLUMN +", "+ GSTACKNUM_COLUMN
                +", "+ GHIGHSTACK_COLUMN +", "+ TBINSTOP_COLUMN +", "+ TBINSHIGH_COLUMN +", "+ TBINSCENTER_COLUMN
                +", "+ TBINSTHROUGH_COLUMN +", "+  TLITTERSCORE_COLUMN +", "+ TLITTERHOW_COLUMN +", "+ TLITTERNUM_COLUMN
                +", "+ TLITTERHERD_COLUMN +", "+ TLITTERPICK_COLUMN +", "+ EBONUSYELLOW_COLUMN +", "+ EBONUSTOP_COLUMN
                +", "+ EBONUSBOTTOM_COLUMN +", "+ EBONUSTOTAL_COLUMN +", "+ EHPCOLLECT_COLUMN +", "+ EHPCOLLECTWHAT_COLUMN
                +", "+ EHPSTACKER_COLUMN +", "+ EHPHERDER_COLUMN +", "+ EHPBIN_COLUMN +", "+  EHPNOODLE_COLUMN
                +", "+ EHPINBOUND_COLUMN +", "+ EHPOTHER_COLUMN +", "+ ENOTES_COLUMN;
    }

    public String getCOMPETITION_COLUMN() {
        return COMPETITION_COLUMN;
    }

    public void setCOMPETITION_COLUMN(String COMPETITION_COLUMN) {
        this.COMPETITION_COLUMN = COMPETITION_COLUMN;
    }

    public String getTEAMUMBER_COLUMN() {
        return TEAMUMBER_COLUMN;
    }

    public void setTEAMUMBER_COLUMN(String TEAMUMBER_COLUMN) {
        this.TEAMUMBER_COLUMN = TEAMUMBER_COLUMN;
    }

    public String getMATCH_COLUMN() {
        return MATCH_COLUMN;
    }

    public void setMATCH_COLUMN(String MATCH_COLUMN) {
        this.MATCH_COLUMN = MATCH_COLUMN;
    }

    public String getPOSITION_COLUMN() {
        return POSITION_COLUMN;
    }

    public void setPOSITION_COLUMN(String POSITION_COLUMN) {
        this.POSITION_COLUMN = POSITION_COLUMN;
    }

    public String getSCOUTERNAME_COLUMN() {
        return SCOUTERNAME_COLUMN;
    }

    public void setSCOUTERNAME_COLUMN(String SCOUTERNAME_COLUMN) {
        this.SCOUTERNAME_COLUMN = SCOUTERNAME_COLUMN;
    }

    public String getAYMOVE_COLUMN() {
        return AYMOVE_COLUMN;
    }

    public void setAYMOVE_COLUMN(String AYMOVE_COLUMN) {
        this.AYMOVE_COLUMN = AYMOVE_COLUMN;
    }

    public String getAYPUSH_COLUMN() {
        return AYPUSH_COLUMN;
    }

    public void setAYPUSH_COLUMN(String AYPUSH_COLUMN) {
        this.AYPUSH_COLUMN = AYPUSH_COLUMN;
    }

    public String getAYPUSHNUM_COLUMN() {
        return AYPUSHNUM_COLUMN;
    }

    public void setAYPUSHNUM_COLUMN(String AYPUSHNUM_COLUMN) {
        this.AYPUSHNUM_COLUMN = AYPUSHNUM_COLUMN;
    }

    public String getAYSTACK_COLUMN() {
        return AYSTACK_COLUMN;
    }

    public void setAYSTACK_COLUMN(String AYSTACK_COLUMN) {
        this.AYSTACK_COLUMN = AYSTACK_COLUMN;
    }

    public String getAYSTACKNUM_COLUMN() {
        return AYSTACKNUM_COLUMN;
    }

    public void setAYSTACKNUM_COLUMN(String AYSTACKNUM_COLUMN) {
        this.AYSTACKNUM_COLUMN = AYSTACKNUM_COLUMN;
    }

    public String getARMOVE_COLUMN() {
        return ARMOVE_COLUMN;
    }

    public void setARMOVE_COLUMN(String ARMOVE_COLUMN) {
        this.ARMOVE_COLUMN = ARMOVE_COLUMN;
    }

    public String getARMOVENUM_COLUMN() {
        return ARMOVENUM_COLUMN;
    }

    public void setARMOVENUM_COLUMN(String ARMOVENUM_COLUMN) {
        this.ARMOVENUM_COLUMN = ARMOVENUM_COLUMN;
    }

    public String getARCENTER_COLUMN() {
        return ARCENTER_COLUMN;
    }

    public void setARCENTER_COLUMN(String ARCENTER_COLUMN) {
        this.ARCENTER_COLUMN = ARCENTER_COLUMN;
    }

    public String getARCENTERNUM_COLUMN() {
        return ARCENTERNUM_COLUMN;
    }

    public void setARCENTERNUM_COLUMN(String ARCENTERNUM_COLUMN) {
        this.ARCENTERNUM_COLUMN = ARCENTERNUM_COLUMN;
    }

    public String getAGMOVE_COLUMN() {
        return AGMOVE_COLUMN;
    }

    public void setAGMOVE_COLUMN(String AGMOVE_COLUMN) {
        this.AGMOVE_COLUMN = AGMOVE_COLUMN;
    }

    public String getTCONTROL_COLUMN() {
        return TCONTROL_COLUMN;
    }

    public void setTCONTROL_COLUMN(String TCONTROL_COLUMN) {
        this.TCONTROL_COLUMN = TCONTROL_COLUMN;
    }

    public String getTWHERE_COLUMN() {
        return TWHERE_COLUMN;
    }

    public void setTWHERE_COLUMN(String TWHERE_COLUMN) {
        this.TWHERE_COLUMN = TWHERE_COLUMN;
    }

    public String getTCONTROLHOW_COLUMN() {
        return TCONTROLHOW_COLUMN;
    }

    public void setTCONTROLHOW_COLUMN(String TCONTROLHOW_COLUMN) {
        this.TCONTROLHOW_COLUMN = TCONTROLHOW_COLUMN;
    }

    public String getGSTACK_COLUMN() {
        return GSTACK_COLUMN;
    }

    public void setGSTACK_COLUMN(String GSTACK_COLUMN) {
        this.GSTACK_COLUMN = GSTACK_COLUMN;
    }

    public String getGSTACKNUM_COLUMN() {
        return GSTACKNUM_COLUMN;
    }

    public void setGSTACKNUM_COLUMN(String GSTACKNUM_COLUMN) {
        this.GSTACKNUM_COLUMN = GSTACKNUM_COLUMN;
    }

    public String getGHIGHSTACK_COLUMN() {
        return GHIGHSTACK_COLUMN;
    }

    public void setGHIGHSTACK_COLUMN(String GHIGHSTACK_COLUMN) {
        this.GHIGHSTACK_COLUMN = GHIGHSTACK_COLUMN;
    }

    public String getTBINSTOP_COLUMN() {
        return TBINSTOP_COLUMN;
    }

    public void setTBINSTOP_COLUMN(String TBINSTOP_COLUMN) {
        this.TBINSTOP_COLUMN = TBINSTOP_COLUMN;
    }

    public String getTBINSHIGH_COLUMN() {
        return TBINSHIGH_COLUMN;
    }

    public void setTBINSHIGH_COLUMN(String TBINSHIGH_COLUMN) {
        this.TBINSHIGH_COLUMN = TBINSHIGH_COLUMN;
    }

    public String getTBINSCENTER_COLUMN() {
        return TBINSCENTER_COLUMN;
    }

    public void setTBINSCENTER_COLUMN(String TBINSCENTER_COLUMN) {
        this.TBINSCENTER_COLUMN = TBINSCENTER_COLUMN;
    }

    public String getTBINSTHROUGH_COLUMN() {
        return TBINSTHROUGH_COLUMN;
    }

    public void setTBINSTHROUGH_COLUMN(String TBINSTHROUGH_COLUMN) {
        this.TBINSTHROUGH_COLUMN = TBINSTHROUGH_COLUMN;
    }

    public String getTLITTERSCORE_COLUMN() {
        return TLITTERSCORE_COLUMN;
    }

    public void setTLITTERSCORE_COLUMN(String TLITTERSCORE_COLUMN) {
        this.TLITTERSCORE_COLUMN = TLITTERSCORE_COLUMN;
    }

    public String getTLITTERHOW_COLUMN() {
        return TLITTERHOW_COLUMN;
    }

    public void setTLITTERHOW_COLUMN(String TLITTERHOW_COLUMN) {
        this.TLITTERHOW_COLUMN = TLITTERHOW_COLUMN;
    }

    public String getTLITTERNUM_COLUMN() {
        return TLITTERNUM_COLUMN;
    }

    public void setTLITTERNUM_COLUMN(String TLITTERNUM_COLUMN) {
        this.TLITTERNUM_COLUMN = TLITTERNUM_COLUMN;
    }

    public String getTLITTERHERD_COLUMN() {
        return TLITTERHERD_COLUMN;
    }

    public void setTLITTERHERD_COLUMN(String TLITTERHERD_COLUMN) {
        this.TLITTERHERD_COLUMN = TLITTERHERD_COLUMN;
    }

    public String getTLITTERPICK_COLUMN() {
        return TLITTERPICK_COLUMN;
    }

    public void setTLITTERPICK_COLUMN(String TLITTERPICK_COLUMN) {
        this.TLITTERPICK_COLUMN = TLITTERPICK_COLUMN;
    }

    public String getEBONUSYELLOW_COLUMN() {
        return EBONUSYELLOW_COLUMN;
    }

    public void setEBONUSYELLOW_COLUMN(String EBONUSYELLOW_COLUMN) {
        this.EBONUSYELLOW_COLUMN = EBONUSYELLOW_COLUMN;
    }

    public String getEBONUSTOP_COLUMN() {
        return EBONUSTOP_COLUMN;
    }

    public void setEBONUSTOP_COLUMN(String EBONUSTOP_COLUMN) {
        this.EBONUSTOP_COLUMN = EBONUSTOP_COLUMN;
    }

    public String getEBONUSBOTTOM_COLUMN() {
        return EBONUSBOTTOM_COLUMN;
    }

    public void setEBONUSBOTTOM_COLUMN(String EBONUSBOTTOM_COLUMN) {
        this.EBONUSBOTTOM_COLUMN = EBONUSBOTTOM_COLUMN;
    }

    public String getEBONUSTOTAL_COLUMN() {
        return EBONUSTOTAL_COLUMN;
    }

    public void setEBONUSTOTAL_COLUMN(String EBONUSTOTAL_COLUMN) {
        this.EBONUSTOTAL_COLUMN = EBONUSTOTAL_COLUMN;
    }

    public String getEHPCOLLECT_COLUMN() {
        return EHPCOLLECT_COLUMN;
    }

    public void setEHPCOLLECT_COLUMN(String EHPCOLLECT_COLUMN) {
        this.EHPCOLLECT_COLUMN = EHPCOLLECT_COLUMN;
    }

    public String getEHPCOLLECTWHAT_COLUMN() {
        return EHPCOLLECTWHAT_COLUMN;
    }

    public void setEHPCOLLECTWHAT_COLUMN(String EHPCOLLECTWHAT_COLUMN) {
        this.EHPCOLLECTWHAT_COLUMN = EHPCOLLECTWHAT_COLUMN;
    }

    public String getEHPSTACKER_COLUMN() {
        return EHPSTACKER_COLUMN;
    }

    public void setEHPSTACKER_COLUMN(String EHPSTACKER_COLUMN) {
        this.EHPSTACKER_COLUMN = EHPSTACKER_COLUMN;
    }

    public String getEHPHERDER_COLUMN() {
        return EHPHERDER_COLUMN;
    }

    public void setEHPHERDER_COLUMN(String EHPHERDER_COLUMN) {
        this.EHPHERDER_COLUMN = EHPHERDER_COLUMN;
    }

    public String getEHPBIN_COLUMN() {
        return EHPBIN_COLUMN;
    }

    public void setEHPBIN_COLUMN(String EHPBIN_COLUMN) {
        this.EHPBIN_COLUMN = EHPBIN_COLUMN;
    }

    public String getEHPNOODLE_COLUMN() {
        return EHPNOODLE_COLUMN;
    }

    public void setEHPNOODLE_COLUMN(String EHPNOODLE_COLUMN) {
        this.EHPNOODLE_COLUMN = EHPNOODLE_COLUMN;
    }

    public String getEHPINBOUND_COLUMN() {
        return EHPINBOUND_COLUMN;
    }

    public void setEHPINBOUND_COLUMN(String EHPINBOUND_COLUMN) {
        this.EHPINBOUND_COLUMN = EHPINBOUND_COLUMN;
    }

    public String getEHPOTHER_COLUMN() {
        return EHPOTHER_COLUMN;
    }

    public void setEHPOTHER_COLUMN(String EHPOTHER_COLUMN) {
        this.EHPOTHER_COLUMN = EHPOTHER_COLUMN;
    }

    public String getENOTES_COLUMN() {
        return ENOTES_COLUMN;
    }

    public void setENOTES_COLUMN(String ENOTES_COLUMN) {
        this.ENOTES_COLUMN = ENOTES_COLUMN;
    }
}
