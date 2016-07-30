package at.mchris.myappportfolio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Toast toast;

    private HashMap<String, String> activites = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activites.put(getString(R.string.first_app_name), "at.mchris.popularmovies");
    }

    public void onAppStartRequested(View view) {
        if (toast != null) {
            toast.cancel();
        }

        final Button button = (Button)findViewById(view.getId());

        String packageName = activites.get(button.getText());

        if (packageName != null) {

            Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
            startActivity(intent);

        } else {
            final String msg = "This Button will launch my "
                    + button.getText().toString().toLowerCase()
                    + " app!";

            toast = Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
