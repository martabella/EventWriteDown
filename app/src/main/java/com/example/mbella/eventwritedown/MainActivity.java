package com.example.mbella.eventwritedown;

import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private long numMen=0; //Men count
    private long numWomen=0; //Women count

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the delete Name button is clicked.
     * Allows delete the edit text name
     **/
    public void deleteName (View view){
        EditText name_field = (EditText)this.findViewById(R.id.name_field);
        name_field.setText("");
    }
    /**
     * This method is called when the delete quantity button is clicked.
     * Allows set the men/women quantity to 0. Sets the quantity_text_view to initial value.
     **/
    public void deleteQuantity (View view){
        numMen=0;
        numWomen=0;
        this.updateQuantityTextView();
    }
    /**
     * This method is called when the decrement button is clicked.
     * Allows decrement the men/women values. Depends on radiobutton selection.
     * Updates the quantity_text_view.
     **/
    public void decrementValues(View view){
        RadioButton male_radiobutton = (RadioButton) this.findViewById(R.id.male_radiobutton);
        if (male_radiobutton.isChecked()){
            if (numMen>0) numMen--;
        }else{
            //female_button is checked
            if (numMen>0) numWomen--;
        }
        this.updateQuantityTextView();
    }
    /**
     * This method is called when the decrement button is clicked.
     * Allows increment the men/women values. Depends on radiobutton selection.
     * Updates the quantity_text_view.
     **/
    public void addValues(View view){
        RadioButton male_radiobutton = (RadioButton) this.findViewById(R.id.male_radiobutton);
        if (male_radiobutton.isChecked()){
            numMen++;
        }else{
            //female_button is checked
            numWomen++;
        }
        this.updateQuantityTextView();
    }

    /**
     * Updates the quantity_text_view reading  numMen and numWomen values
     */
    private void updateQuantityTextView(){
        TextView quantity_text_view = (TextView)this.findViewById(R.id.quantity_text_view);
        quantity_text_view.setText(numMen+" "+this.getResources().getString(R.string.men)
                +" / "+numWomen+" "+this.getResources().getString(R.string.women));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
