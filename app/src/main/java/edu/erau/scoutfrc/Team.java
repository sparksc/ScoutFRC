package edu.erau.scoutfrc;

/**
 * Uses the Team Request from TheBlueAlliance.com.
 * The request format for a Team Request is as follows:
 *  http://www.thebluealliance.com/api/v2/team/<team key>
 * where <team key> is in the format of (frcyyyy). For example: frc48
 *
 * Created by Cierra Sparks on 4/23/2015.
 */
public class Team {
    private String website; // the team's website
    private String location;    // the team's hometown (City, State, Country)
    private String teamNumber; // the team's official FRC number
    private String nickname;   // the team's nickname

    /*private String getTeamRequestResponse(String teamNumber){
        String teamResponse;
        teamResponse = HTTPBlueAlliance.GET("http://www.thebluealliance.com/api/v2/team/frc" + teamNumber);
        return teamResponse;
    }*/

    /**
     * String representation of a team.
     * @return - String of the team's number, nickname, location, and website
     */
    public String toString(){
        return ""+ teamNumber +", "+ nickname +", "+ location +", "+ website;
    }


    /**
     * @return the team's website if available
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets the team's website
     * @param website - the url of the team's website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * @return the team's hometown in the format: [City, State, Country]
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the team's hometown location.
     * @param location - the team's hometown in the format: [City, State, Country]
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the team's official FRC number
     */
    public String getTeamNumber() {
        return teamNumber;
    }

    /**
     * Sets the team's official FRC number
     * @param teamNumber - the team's official FRC number
     */
    public void setTeamNumber(String teamNumber) {
        this.teamNumber = teamNumber;
    }

    /**
     * @return the team's nickname recognized by FIRST
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the team's nickname as recognized by FIRST
     * @param nickname - the team's nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
