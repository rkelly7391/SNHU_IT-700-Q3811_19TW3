package ryankelly.ryankellyhospitalcost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ryankelly on 3/28/19.
 */

public class HospitalActivity extends AppCompatActivity {

    //Create the buttons
    Button MWButton, LMHButton, BWButton, MGHButton;

    //Create a Dummy String for sections of the app that are under construction
    private final String DUMMYMESSAGE = "This Section of the App is under construction";

    static private boolean mwhSelected = false;
    static private boolean lmhSelected = false;
    static private boolean bwhSelected = false;
    static private boolean mghSelected = false;

    /**
     * onCreate will create the buttons when the app is first started or when the homescreen is visted
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);

        //Have the buttons find their IDs
        MWButton = findViewById(R.id.metro_west);
        LMHButton = findViewById(R.id.lmh);
        BWButton = findViewById(R.id.bw);
        MGHButton = findViewById(R.id.mgh);


        //Display a dummy MESSAGE for the section of the app that is not support.
        MWButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();
                mwhSelected = true;
                System.out.println("Hospital button was selected");
                Intent MWH = new Intent(HospitalActivity.this, PriceByHospital.class);
                startActivity(MWH);

            }
        });

        //Display a dummy MESSAGE for the section of the app that is not support.
        LMHButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();
                lmhSelected = true;
                System.out.println("Procedure button was selected");
                Intent LMH = new Intent(HospitalActivity.this, PriceByHospital.class);
                startActivity(LMH);


            }
        });

        //Display a dummy MESSAGE for the section of the app that is not support.
        BWButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();
                bwhSelected = true;
                System.out.println("Hospital button was selected");
                Intent MGH = new Intent(HospitalActivity.this, PriceByHospital.class);
                startActivity(MGH);

            }
        });

        //Display a dummy MESSAGE for the section of the app that is not support.
        MGHButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();
                mghSelected = true;
                System.out.println("Procedure button was selected");
                Intent BWH = new Intent(HospitalActivity.this, PriceByHospital.class);
                startActivity(BWH);


            }
        });
    }

    // Setters and getters for other methods in other classes
    public static boolean getIsMWHSelected() {
        return mwhSelected;
    }

    public static boolean getIsLMHSelected() {
        return lmhSelected;
    }

    public static boolean getIsBWHSelected() {
        return bwhSelected;
    }

    public static boolean getIsMGHSelected() { return mghSelected; }

    public static void setIsMWHSelected(boolean newValue) {
        mwhSelected = newValue;
    }

    public static void setIsLMHSelected(boolean newValue) {
        lmhSelected = newValue;
    }

    public static void setIsBWHSelected(boolean newValue) {
        bwhSelected = newValue;
    }

    public static void setIsMGHSelected(boolean newValue) {
        mghSelected = newValue;
    }

}
