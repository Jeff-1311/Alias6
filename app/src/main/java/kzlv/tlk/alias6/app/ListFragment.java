package kzlv.tlk.alias6.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by АНАТОЛИЙ on 14.06.2014.
 */
public class ListFragment extends Fragment {

    Result result = new Result();

    Button buttonAddTeam;
    Button buttonReady;
Button  buttonPreference;
    byte teamCount;

    ArrayList<String> items;
//    final String[] items = new String[] { "Android", "iPhone", "WindowsMobile",
//            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//            "Linux", "OS/2" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        teamCount = 0;
        items = new ArrayList<String>();

        items.add("Team" + teamCount);
        result.teamList.add("Team" + teamCount);
        teamCount++;

        items.add("Team" + teamCount);
        result.teamList.add("Team" + teamCount);
        teamCount++;

        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ListView list = (ListView) view.findViewById(R.id.listView1);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);

        buttonAddTeam = (Button) view.findViewById(R.id.buttonAddTeam);
        buttonReady = (Button) view.findViewById(R.id.buttonReady);
        buttonPreference = (Button) view.findViewById(R.id.buttonPreference);



        View.OnClickListener oclButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // по id определеяем кнопку, вызвавшую этот обработчик
                switch (v.getId()) {
                    case R.id.buttonAddTeam:
                        // кнопка Add team
                        if (teamCount < 6) {
                            Toast.makeText(getActivity(), "Новая команда добавлена", Toast.LENGTH_SHORT).show();
                            items.add("Team" + teamCount);
                            result.teamList.add("Team" + teamCount);
                            teamCount++;
                            adapter.notifyDataSetChanged();
                        } else
                            Toast.makeText(getActivity(), "Сильно много команд. Хватит уже.", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.buttonPreference:
                        // кнопка Ready
                        Toast.makeText(getActivity(), "Ready", Toast.LENGTH_SHORT).show();
                        //сдесь в fragment_container загружаеться ListFragment
                        android.app.FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container,new Preference());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;

                    case R.id.buttonReady:
                        // кнопка Ready
                        Toast.makeText(getActivity(), "Ready", Toast.LENGTH_SHORT).show();
                        //сдесь в fragment_container загружаеться ListFragment
                        android.app.FragmentManager fragmentManager2 = getFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        fragmentTransaction2.replace(R.id.fragment_container,new PlayFragment());
                        fragmentTransaction2.addToBackStack(null);
                        fragmentTransaction2.commit();
                        break;
                }


            }
        };
        buttonAddTeam.setOnClickListener(oclButton);
        buttonReady.setOnClickListener(oclButton);
        buttonPreference.setOnClickListener(oclButton);

        return view;


    }

}




