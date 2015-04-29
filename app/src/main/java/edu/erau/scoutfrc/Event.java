package edu.erau.scoutfrc;

import java.util.ArrayList;

/**
 * Using Event List Request from TheBlueAlliance.com to create an event
 * and populate the desired fields. The format to query an event list is as follows:
 *  http://www.thebluealliance.com/api/v2/events/<year>
 * Where <year> is an integer starting from 1992 to the present year. This defaults to the
 * current year if the year is not specified.
 *
 * The Event Teams Request uses the following format:
 *  http://www.thebluealliance.com/api/v2/event/<event key>/teams
 * where <event key> is in the format of yyyy[EVENT_CODE]. y = event year and EVENT_CODE is the
 * event's code.
 *
 * Created by Cierra Sparks on 4/23/2015.
 */
public class Event {
    private String year;   // event year
    private String eventKey;   // the event key, format: yyyy[EVENT_CODE}
    private String competitionName; //short_name
    private String location;    // City, State, Country event held
    private ArrayList<String> eventKeys;
    private ArrayList<String> eventNames;
    private ArrayList<String> teamList;
    private Parser parse;
    private String eventResponse;

    /**
     * Retrieves the unparsed Event List from The Blue Alliance for the specified year.
     *
     * @param year - the year in which to retrieve the event list from
     * @return a string of all events for the entered year
     */
    /*private String getEventListResponse(int year){
        eventResponse = HTTPBlueAlliance.GET("http://www.thebluealliance.com/api/v2/events/" + year);
        return eventResponse;
    }*/

    /**
     * String representation of an event.
     * @return - String of the event's name, year, eventkey, and location
     */
    public String toString(){
        return ""+competitionName+", "+year+", "+eventKey+", "+location;
    }

    /**
     * Parses the Event list for the specified year. Uses the "short_name" to parse.
     *
     * @param year - the year in which to retrieve the event list from
     * @return an ArrayList of all event names for the year.
     */
    /*public ArrayList<String> getEventNamesList(int year){
        eventNames = new ArrayList<>();
        getEventListResponse(year); // retrieve the info from the website
        eventNames = parse.EventListParser(eventResponse);    //parse and store
        return eventNames;
    }*/

    /**
     * Parses the Event list for all event keys.
     * @return an ArrayList of all event keys for the current year
     */
    /*public ArrayList<String> getEventKeys(){
        eventKeys = new ArrayList<>();
        eventKeys = parse.EventKeyParser(eventResponse);
        return eventKeys;
    }*/

    /**
     * Quries the Event Team Request from The Blue Alliance website to receive the list of teams
     * in attendance for the entered event.
     *
     * @param eventkey - the eventkey of the event
     * @return - an ArrayList of teams attending the event.
     */
    /*private ArrayList<String> getEventTeamResponse(String eventkey){
        teamList = new ArrayList<>();
        HTTPBlueAlliance.GET("http://www.thebluealliance.com/api/v2/event/" + eventKey + "/teams");
        return teamList;
    }*/

    /**
     * @return - the four digit year of the competition
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets the year of the competition
     * @param year - the year of the competition
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return - the event key in the format: yyyy[EVENT_CODE]
     */
    public String getEventKey() {
        return eventKey;
    }

    /**
     * Sets the event key for the event.
     * @param eventKey - the event key in the format: yyyy[EVENT_CODE]
     */
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    /**
     * @return - the short_name of the competition/event
     */
    public String getCompetitionName() {
        return competitionName;
    }

    /**
     * Sets the event's name
     * @param competitionName - the event's name
     */
    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    /**
     * @return - the location of the event in the format: [City, State, Country]
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the event.
     * @param location - the location of the event in the format: [City, State, Country]
     */
    public void setLocation(String location) {
        this.location = location;
    }
}
