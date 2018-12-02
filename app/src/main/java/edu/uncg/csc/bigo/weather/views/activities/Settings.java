package edu.uncg.csc.bigo.weather.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import edu.uncg.csc.bigo.weather.R;
import edu.uncg.csc.bigo.weather.data.DataInterface;
import edu.uncg.csc.bigo.weather.data.DataStore;


public class Settings extends AppCompatActivity {

    private String button;
    private Button eraseLocationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        eraseLocationButton = findViewById(R.id.eraseLocationButton);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.eraseLocationButton).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // This is used for CRUD operations.
                DataInterface dataModifier = new DataStore();

                dataModifier.remove();

                // Displays a confirmation message when deletion is complete.
                CharSequence textMessage = "Deletion Complete!";
                int textLength = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), textMessage, textLength);
                toast.show();
            }
        });
        {

        }
        ;
    }

    public void Navigation(View View) {
        button = ((Button) View).getText().toString();
        if (button.equals("Location")) {
            Intent a = new Intent(this, Location.class);
            startActivity(a);
        }
        if (button.equals("Time and Date")) {
            Intent b = new Intent(this, TimeDate.class);
            startActivity(b);
        }
        if (button.equals("About")) {
            Intent c = new Intent(this, About.class);
            startActivity(c);
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
