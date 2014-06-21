package kzlv.tlk.alias6.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by АНАТОЛИЙ on 14.06.2014.
 */
public class FirstFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.first_fragment, container, false);
        Button button = (Button)root.findViewById(R.id.button_new_game);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
        //сдесь в fragment_container загружаеться ListFragment
                android.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,new ListFragment());
                fragmentTransaction.commit();
            }
        });

        registerForContextMenu(button);
        return root;
    }
}
