package ryankelly.ryankellyhospitalcost;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ryankelly on 4/9/19.
 */

class HospitalPriceUtils {

    /**
     * getValue will retrun the value of an item that is for sale based on the json file.
     * @param jsonFile json file that holds the values
     * @param item the item that you want the value
     * @param price is the price that you are looking for, either discount or full cost
     * @return value is the value of the item passed in.  It can be the value or the discount value
     */

    private static double getValue (String jsonFile, String item, String price){

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

    static String getValueToDisplay(String file, String procedure, String hospital){

        double cost = getValue(file, procedure, hospital);
        String costAsString = String.valueOf(cost);
        return costAsString;

    }
}
