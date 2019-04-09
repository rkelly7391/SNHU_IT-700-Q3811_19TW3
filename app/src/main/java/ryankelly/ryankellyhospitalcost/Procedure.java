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

public class Procedure extends AppCompatActivity {

    //Create the buttons
    Button XRayButton, MRIButton, LabButton, CastButton;

    //Create a Dummy String for sections of the app that are under construction
    private final String DUMMYMESSAGE = "This Section of the App is under construction";

    static private boolean xraySelected = false;
    static private boolean mriSelected = false;
    static private boolean castSelected = false;
    static private boolean labsSelected = false;
    /**
     * onCreate will create the buttons when the app is first started or when the homescreen is visted
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procedure);

        //Have the buttons find their IDs
        XRayButton = findViewById(R.id.metro_west);
        MRIButton = findViewById(R.id.lmh);
        LabButton = findViewById(R.id.bw);
        CastButton = findViewById(R.id.mgh);


        //Display a dummy MESSAGE for the section of the app that is not support.
        XRayButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();
                System.out.println("Xray button was selected");
                xraySelected = true;
                Intent xray = new Intent(Procedure.this, PriceByProcedure.class);
                startActivity(xray);

            }
        });

        //Display a dummy MESSAGE for the section of the app that is not support.
        MRIButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();
                System.out.println("MRI button was selected");
                mriSelected = true;
                Intent mri = new Intent(Procedure.this, PriceByProcedure.class);
                startActivity(mri);


            }
        });

        //Display a dummy MESSAGE for the section of the app that is not support.
        CastButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();
                System.out.println("Cast button was selected");
                castSelected = true;
                Intent cast = new Intent(Procedure.this, PriceByProcedure.class);
                startActivity(cast);

            }
        });

        //Display a dummy MESSAGE for the section of the app that is not support.
        LabButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();
                System.out.println("Lab button was selected");
                labsSelected = true;
                Intent labWork = new Intent(Procedure.this, PriceByProcedure.class);
                startActivity(labWork);


            }
        });
    }

    // Setters and getters for other methods in other classes
    public static boolean getIsXraySelected() {
        return xraySelected;
    }

    public static boolean getIsMriSelected() {
        return mriSelected;
    }

    public static boolean getIsCastSelected() {
        return castSelected;
    }

    public static boolean getIsLabsSelected() { return labsSelected; }

    public static void setIsXraySelected(boolean newValue) {
        xraySelected = newValue;
    }

    public static void setIsMriSelected(boolean newValue) {
        mriSelected = newValue;
    }

    public static void setIsCastSelected(boolean newValue) {
        castSelected = newValue;
    }

    public static void setIsLabsSelected(boolean newValue) {
        labsSelected = newValue;
    }
}
