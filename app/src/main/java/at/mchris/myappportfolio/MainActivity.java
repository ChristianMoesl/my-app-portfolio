package at.mchris.myappportfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAppStartRequested(View view) {
        if (toast != null) {
            toast.cancel();
        }

        final Button button = (Button)findViewById(view.getId());
        String msg = "This Button will launch my "
                + button.getText().toString().toLowerCase()
                + " app!";

        toast = Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}
