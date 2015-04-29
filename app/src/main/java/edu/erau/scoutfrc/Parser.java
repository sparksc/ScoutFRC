package edu.erau.scoutfrc;

import android.util.Log;

import java.util.ArrayList;

/**
 * This class takes in the response retrieved from The Blue Alliance website and parses the
 * response to retrieve the Events and the Teams attending the events.
 *
 * The parser was tested in Java with the sample provided from "http://www.thebluealliance.com/apidocs"
 *
 * Created by Cierra Sparks on 4/27/2015.
 */
public class Parser {
    /**
     * Parses all keys from the entered response.
     *
     * @param response - the response retrieved from The Blue Alliance website
     * @return an ArrayList of all keys
     */
    public ArrayList<String> EventKeyParser(String response) {
        ArrayList<String> keys = new ArrayList<>();
        String[] words = response.split("\"");    // ignore/delimit these characters

        for(int i = 0; i < words.length; i++) {
            if (words[i].contentEquals("key")) {
                keys.add(words[i + 2]);
            }
            //System.out.println("Output: " + words[j]);
        }
        //System.out.println("keys: "+ keys.toString());
        return keys;
    }

    /**
     * Parses an Event Response to retrieve all event's for the year. Creates a new event
     * to store in an ArrayList of Events.
     * Can be used with the url "http://www.thebluealliance.com/api/v2/events/2015" for Event List Request.
     *
     * @param response - the response retrieved from The Blue Alliance website
     * @return - an ArrayList of all events
     */
    public ArrayList<Event> EventListParser(String response) {
        ArrayList<Event> events = new ArrayList<>();    // Create the array of events to return
        String[] words = response.split(":|\"");    // ignore/delimit these characters
        Event event = new Event();

        for(int i = 0; i < words.length; i++) {
            //Log.i("words[i]:", "words[i]");
            if (words[i].contentEquals("key")) {    // Set the event key
                event.setEventKey(words[i + 3]);
            }
            if (words[i].contentEquals("name")) {   //set the event name
                if(words[i+3].length() >= 26){  // if the name is larger than 26 characters, save the short_name
                    event.setCompetitionName(words[i+8].trim());
                }
                else{   // Otherwise use the full name
                    event.setCompetitionName(words[i+3].trim());
                }
            }
            if (words[i].contentEquals("location")) {   // Set the event location
                event.setLocation(words[i + 3]);
            }
            if (words[i].contentEquals("year")) {   // set the event's year
                String[] newYear = words[i+2].split(",");

                event.setYear(newYear[0].trim());
                events.add(event);  // Add the new event to the list
                //Log.i("Event:", ""+event.toString());
                event = new Event();
            }
        }
        return events;
    }

    /**
     * Creates an ArrayList of event names after the response was parsed with EventListParser().
     *
     * @param ALEvents - the ArrayList of events
     * @return - an ArrayList of all event names
     */
    public ArrayList<String> EventListStringParser(ArrayList<Event> ALEvents) {
        ArrayList<String> events = new ArrayList<>();

        // Loop through all Events and store only the event name into the new ArrayList
        for(int i = 0; i < ALEvents.size(); i++) {
            events.add(ALEvents.get(i).getCompetitionName());
        }
        return events;
    }

    /**
     * Parses an Event Response to retrieve all event's for the year. Creates a new event
     * to store in an ArrayList of Events.
     * Can be used with the url "http://www.thebluealliance.com/api/v2/events/2015" for Event List Request.
     *
     * @param response - the response retrieved from The Blue Alliance website
     * @return an ArrayList of all teams attending the event
     */
    public ArrayList<Team> EventListTeamParser(String response){
        ArrayList<Team> teams = new ArrayList<>();
        String[] words = response.split("\"");    // ignore/delimit these characters
        Team team;

        for(int i = 0; i < words.length;i++) {
            team = new Team();
            if (words[i].contentEquals("website")) {
                team.setWebsite(words[i+2]);
            }
            if (words[i].contentEquals("team_number")) {
                team.setTeamNumber(words[i + 2]);
            }
            if (words[i].contentEquals("location")) {
                team.setLocation(words[i+2]);
            }
            if (words[i].contentEquals("nickname")) {
                team.setNickname(words[i + 2]);
            }
            teams.add(team);
        }
        return teams;
    }

    public ArrayList<String> EventTeamStringParser(ArrayList<Team> ALTeams) {
        ArrayList<String> teams = new ArrayList<>();

        // Loop through all Events and store only the event name into the new ArrayList
        for(int i = 0; i < ALTeams.size(); i++) {
            teams.add(ALTeams.get(i).getTeamNumber());
        }
        return teams;
    }
}
