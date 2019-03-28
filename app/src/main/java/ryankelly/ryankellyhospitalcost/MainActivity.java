package ryankelly.ryankellyhospitalcost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * The MainActivity is the home screen of the app
 * It will display different buttons that the user can select
 * Only two buttons will bring the user to a new section
 *
 * @author  Ryan Kelly
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {

    //Create the buttons
    Button HSButton, PSButton;

    //Create a Dummy String for sections of the app that are under construction
    private final String DUMMYMESSAGE = "This Section of the App is under construction";
    /**
     * onCreate will create the buttons when the app is first started or when the homescreen is visted
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Have the buttons find their IDs
        HSButton = findViewById(R.id.search_by_hospital);
        PSButton = findViewById(R.id.search_by_procedure);


        //Display a dummy MESSAGE for the section of the app that is not support.
        HSButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();
                System.out.println("Hospital button was selected");

            }
        });

        //Display a dummy MESSAGE for the section of the app that is not support.
        PSButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Will display a message informing the user that this section of the app is under construction
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), DUMMYMESSAGE,Toast.LENGTH_LONG).show();
                System.out.println("Procedure button was selected");


            }
        });
    }
}
