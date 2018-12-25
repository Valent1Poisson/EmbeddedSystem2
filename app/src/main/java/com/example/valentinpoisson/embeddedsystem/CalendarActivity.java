package com.example.valentinpoisson.embeddedsystem;

        import android.icu.util.Calendar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.CalendarView;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.Switch;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

public class CalendarActivity extends AppCompatActivity {

    ListView results, sportSelect;
    Button search;
    TextView selectionSport;
    CalendarView cal;
    String j;
    String m;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        sportSelect = (ListView) findViewById(R.id.sportSelect);
        selectionSport = (TextView)findViewById(R.id.selectionSport);
        results = (ListView)findViewById(R.id.result);
        search = (Button)findViewById(R.id.search);
        cal = (CalendarView)findViewById(R.id.calendarView);


        sportSelect.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //selectionSport.setText(ArraySports.get(position));
            }
        });

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                a =String.valueOf(year);
                m =String.valueOf(month);
                j =String.valueOf(dayOfMonth);

            }
        });

    }

    public void SearchSports(View v){
        // Search sports with Filter
    }

}
