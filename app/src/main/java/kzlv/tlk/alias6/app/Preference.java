package kzlv.tlk.alias6.app;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by АНАТОЛИЙ on 15.06.2014.
 */
public class Preference extends PreferenceFragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.preference);
    }



}
