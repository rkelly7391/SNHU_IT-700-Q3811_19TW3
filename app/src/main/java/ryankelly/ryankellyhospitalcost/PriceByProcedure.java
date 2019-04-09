package ryankelly.ryankellyhospitalcost;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PriceByProcedure extends AppCompatActivity {

    private ArrayAdapter<String> arrayAdapter = null;
    private ListView list = null;
    private ArrayList<String> procedure = null;
    private String JSONFILE = "values.json";


    private static final String XRAY = "X-ray";
    private static final String MRI = "MRI";
    private static final String LABS = "Labs";
    private static final String CAST = "Cast";

    private static final String MWH = "MetroWest";
    private static final String LMH = "LenordMemorial";
    private static final String MGH = "MassGen";
    private static final String BWH = "BW";

    public String[] procedureArray = {XRAY, MRI, LABS, CAST};
    public String[] hospitalArray = {MWH, LMH, MGH, BWH};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_by_procedure);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //get the json file

        String jsonValues = readJSON();

        procedure = new ArrayList<>();
        // leave a blank space
        procedure.add("");


        // get what sent us here
        
        boolean wasItXray = Procedure.getIsXraySelected();
        boolean wasItCast = Procedure.getIsCastSelected();
        boolean wasItMri = Procedure.getIsMriSelected();
        boolean wasItLabs = Procedure.getIsLabsSelected();

        System.out.println("xray: " + wasItXray);
        System.out.println("cast:" + wasItCast);
        System.out.println("MRI" + wasItMri);
        System.out.println("Labs:" + wasItLabs);


        if(Procedure.getIsXraySelected()){
            procedure.add("Xray");
            System.out.println("Inside if:" + wasItXray);
            for (String currentHospital: hospitalArray)
            {
                System.out.println(currentHospital);
                procedure.add(currentHospital + " $" + getValueToDisplay(jsonValues,XRAY, currentHospital));

            }
            // reset the value
            Procedure.setIsXraySelected(false);

        } else if(Procedure.getIsCastSelected()){
            procedure.add("Cast");
            System.out.println(wasItCast);
            for (String currentHospital: hospitalArray)
            {
                System.out.println(currentHospital);
                procedure.add(currentHospital + " $" + getValueToDisplay(jsonValues,CAST, currentHospital));

            }
            // reset the value
            Procedure.setIsCastSelected(false);

        } else if (Procedure.getIsMriSelected()){
            procedure.add("MRI");
            System.out.println(wasItMri);
            for (String currentHospital: hospitalArray)
            {
                System.out.println(currentHospital);
                procedure.add(currentHospital + " $" + getValueToDisplay(jsonValues,MRI, currentHospital));

            }
            // reset the value
            Procedure.setIsMriSelected(false);

        }else if (Procedure.getIsLabsSelected()){
            procedure.add("Lab work");
            System.out.println(wasItLabs);
            for (String currentHospital: hospitalArray)
            {
                System.out.println(currentHospital);
                procedure.add(currentHospital + " $" + getValueToDisplay(jsonValues,LABS, currentHospital));

            }
            // reset the value
            Procedure.setIsLabsSelected(false);

        }else{
            Toast.makeText(getApplicationContext(), "ERROR GETTING PROCEDURE",Toast.LENGTH_LONG).show();
        }



        list = findViewById(R.id.listView);


        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, procedure);
        //Have list use the adapter
        list.setAdapter(arrayAdapter);

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

    /**
     * getValue will retrun the value of an item that is for sale based on the json file.
     * @param jsonFile json file that holds the values
     * @param item the item that you want the value
     * @param price is the price that you are looking for, either discount or full cost
     * @return value is the value of the item passed in.  It can be the value or the discount value
     */
    public double getValue (String jsonFile, String item, String price){

        //What will be returned
        double value = 0.0;

        try {
            //get the json file
            JSONObject jf = new JSONObject(jsonFile);
            //get the item from the json file
            JSONObject itemInFile  = jf.getJSONObject(item);
            //get the price for the item
            String StringValue = itemInFile.getString(price);

            //DEBUG for json edit
            System.out.println("Price of "+item + " is " + StringValue);
            //Convert the string into a double
            value = Double.parseDouble(StringValue);

        } catch (JSONException e) {
            //Catch the exception and print the reason
            System.out.println("ERROR getting the" + price + " for " + item + " ERROR: "+e);
            e.printStackTrace();
        }

        return value;

    }

    public String getValueToDisplay(String file, String procedure, String hospital){

        double cost = getValue(file, procedure, hospital);
        String costAsString = String.valueOf(cost);
        return costAsString;

    }

}
