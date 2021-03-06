package ryankelly.ryankellyhospitalcost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class PriceByHospital extends AppCompatActivity {

    private ArrayAdapter<String> arrayAdapter = null;
    private ListView list = null;
    private ArrayList<String> hospitals = null;
    private String JSONFILE = "values.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_by_hospital);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //get the json file

        String jsonValues = readJSON();



        hospitals = new ArrayList<>();
        // Leave a space so the values look correct
        hospitals.add("");

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

            for (String currentProcedure: Constants.procedureArray)
            {
                System.out.println(currentProcedure);
//                hospitals.add(currentProcedure + " $" + getValueToDisplay(jsonValues,currentProcedure, Constants.BWH));

                hospitals.add(currentProcedure + " $" + HospitalPriceUtils.getValueToDisplay(jsonValues, currentProcedure, Constants.BWH));
            }
            // reset the value
            HospitalActivity.setIsBWHSelected(false);

        } else if(HospitalActivity.getIsLMHSelected()){
            hospitals.add("Lenord Moris Hospital");
            System.out.println(wasItLmh);

            for (String currentProcedure: Constants.procedureArray)
            {
                System.out.println(currentProcedure);
//                hospitals.add(currentProcedure + " $" + getValueToDisplay(jsonValues,currentProcedure, Constants.LMH));
                hospitals.add(currentProcedure + " $" + HospitalPriceUtils.getValueToDisplay(jsonValues, currentProcedure, Constants.LMH));

            }
            // reset the value
            HospitalActivity.setIsLMHSelected(false);

        } else if (HospitalActivity.getIsMGHSelected()){
            hospitals.add("Mass General");
            System.out.println(wasItMgh);

            for (String currentProcedure: Constants.procedureArray)
            {
                System.out.println(currentProcedure);
                //hospitals.add(currentProcedure + " $" + getValueToDisplay(jsonValues,currentProcedure, Constants.MGH));

                hospitals.add(currentProcedure + " $" + HospitalPriceUtils.getValueToDisplay(jsonValues, currentProcedure, Constants.MGH));
            }
            // reset the value
            HospitalActivity.setIsMGHSelected(false);

        }else if (HospitalActivity.getIsMWHSelected()){
            hospitals.add("Metro West");
            System.out.println(wasItMwh);

            for (String currentProcedure: Constants.procedureArray)
            {
                System.out.println(currentProcedure);
                //hospitals.add(currentProcedure + " $" + getValueToDisplay(jsonValues,currentProcedure, Constants.MWH));
                // test this out
                //HospitalPriceUtils.getValue(jsonValues, currentProcedure, Constants.MWH);
                //hospitals.add("The following are the new methods");
                hospitals.add(currentProcedure + " $" + HospitalPriceUtils.getValueToDisplay(jsonValues, currentProcedure, Constants.MWH));
                //hospitals.add("Did this work?");

            }


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

    /**
     * readJSON will read a josn file from the assets directory.
     * @return json which is the json file that was just read
     */
    private String readJSON(){

        // The name of the file to open
        System.out.println("Reading "+JSONFILE);
        //Will return the json file contents inside jsonFile
        String jsonFile = null;
        try {
            //Open the json file
            InputStream readJSON = getAssets().open(JSONFILE);
            //create a buffer of the size of the file
            byte[] buffer = new byte[readJSON.available()];
            //read the file
            readJSON.read(buffer);
            //Use the json file
            jsonFile = new String(buffer, "UTF-8");
            //close the file
            readJSON.close();
        } catch (IOException e) {
            //Catch the exception and print the reason
            System.out.println("ERROR while reading json file: "+JSONFILE+" ERROR: "+e);
            e.printStackTrace();
        }
        //Return the json file
        return jsonFile;
    }

}
