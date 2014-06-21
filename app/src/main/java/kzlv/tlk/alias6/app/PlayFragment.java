package kzlv.tlk.alias6.app;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;

/**
 * Created by АНАТОЛИЙ on 15.06.2014.
 */
public class PlayFragment extends Fragment {

    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    private TextView timerValue;
    private long startTime = 0L;

    TextView currentTeamName;
    Button buttonStart;
    Button buttonSkip;
    Button buttonGuessed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.play_fragment, container, false);


        currentTeamName = (TextView) view.findViewById(R.id.currentTeamName);
        timerValue = (TextView) view.findViewById(R.id.timerValue);
        buttonStart = (Button) view.findViewById(R.id.buttonStart);
        buttonSkip = (Button) view.findViewById(R.id.buttonSkip);
        buttonGuessed = (Button) view.findViewById(R.id.buttonGuessed);

        View.OnClickListener oclButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // по id определеяем кнопку, вызвавшую этот обработчик
                switch (v.getId()) {
                    case R.id.buttonStart:
                        Toast.makeText(getActivity(), "нажата кнопка Start", Toast.LENGTH_SHORT).show();
                        startTime = SystemClock.uptimeMillis();
                        buttonStart.setEnabled(false);
                        new CountDownTimer(60000, 100) {  // Первый параметр это время отсчета, 2й частота с которой вызывается метод onTick
                            public void onTick(long millisUntilFinished) {
                                //  timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
                                updatedTime = millisUntilFinished;
                                int secs = (int) (updatedTime / 1000);
                                Log.d("myapp", "secs =" + secs);
                                int mins = secs / 60;
                                Log.d("myapp", "mins =" + mins);
                                secs = secs % 60;
                                int milliseconds = (int) (updatedTime % 1000);
                                timerValue.setText("" + mins + ":"
                                        + String.format("%02d", secs) + ":"
                                        + String.format("%03d", milliseconds));
                            }

                            public void onFinish() { //Этот метод вызовется по завершению работы таймера
                                buttonStart.setEnabled(true);
                                currentTeamName.setText(Result.nextTeam());
                            }

                        }.start();


                        break;
                    case R.id.buttonSkip:
                        // кнопка Skip
                        Toast.makeText(getActivity(), "нажата кнопка Skip", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.buttonGuessed:
                        // кнопка Guessed
                        Toast.makeText(getActivity(), "нажата кнопка Guessed", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        buttonStart.setOnClickListener(oclButton);
        buttonSkip.setOnClickListener(oclButton);
        buttonGuessed.setOnClickListener(oclButton);
        return view;
    }




/*
private Runnable updateTimerThread = new Runnable() {

        public void run() {




            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

            updatedTime = timeSwapBuff + timeInMilliseconds;

            int secs = (int) (updatedTime / 1000);
            Log.d("myapp", "secs =" + secs);

            currentTeamName.setText(Result.nextTeam());



            int mins = secs / 60;
            Log.d("myapp", "mins =" + mins);

            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timerValue.setText("" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds));
            customHandler.postDelayed(this, 0);
        }

    };*/

}



