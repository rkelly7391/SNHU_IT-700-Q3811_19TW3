package ryankelly.ryankellyhospitalcost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class PriceByHospital extends AppCompatActivity {

    private ArrayAdapter<String> arrayAdapter = null;
    private ListView list = null;
    private ArrayList<String> hospitals = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_by_hospital);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hospitals = new ArrayList<>();
        hospitals.add("test1");
        hospitals.add("test2");
        hospitals.add("test3");

        // get what sent us here

        boolean wasItBwh = HospitalActivity.getIsBWHSelected();
        boolean wasItLmh = HospitalActivity.getIsLMHSelected();
        boolean wasItMgh = HospitalActivity.getIsMGHSelected();
        boolean wasItMwh = HospitalActivity.getIsMWHSelected();

        System.out.println("BWH: " + wasItBwh);
        System.out.println("LMH:" + wasItLmh);
        System.out.println("MGH" + wasItMgh);
        System.out.println("MWH:" + wasItMwh);


        if(HospitalActivity.getIsBWHSelected()){
            hospitals.add("Brigham & Womens");
            System.out.println("Inside if:" + wasItBwh);
            // reset the value
            HospitalActivity.setIsBWHSelected(false);

        } else if(HospitalActivity.getIsLMHSelected()){
            hospitals.add("Lenord Moris Hospital");
            System.out.println(wasItLmh);
            // reset the value
            HospitalActivity.setIsLMHSelected(false);

        } else if (HospitalActivity.getIsMGHSelected()){
            hospitals.add("Mass General");
            System.out.println(wasItMgh);
            // reset the value
            HospitalActivity.setIsMGHSelected(false);

        }else if (HospitalActivity.getIsMWHSelected()){
            hospitals.add("Metro West");
            System.out.println(wasItMwh);
            // reset the value
            HospitalActivity.setIsMWHSelected(false);

        }else{
            Toast.makeText(getApplicationContext(), "ERROR GETTING HOSPITAL",Toast.LENGTH_LONG).show();
        }



        list = findViewById(R.id.listView);


        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, hospitals);
        //Have list use the adapter
        list.setAdapter(arrayAdapter);


        // Auto generated code  Should be removed


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
