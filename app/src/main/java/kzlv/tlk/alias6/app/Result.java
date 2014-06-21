package kzlv.tlk.alias6.app;

import java.util.ArrayList;

/**
 * Created by АНАТОЛИЙ on 16.06.2014.
 */
public class Result {

    static String currentTeam;
    static ArrayList<String> teamList = new ArrayList<String>();
    static byte i = 0;

    static public String nextTeam() {

        if ( i== (teamList.size()-1))
            i = 0;
        else
            i++;


        return teamList.get(i);

    }
}
