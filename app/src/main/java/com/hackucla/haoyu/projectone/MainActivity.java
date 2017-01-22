package com.hackucla.haoyu.projectone;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView t;
    Button b;
    ImageView img;
    EditText textField;
    Button buttontf;
    Button buttonimage;

    // onCreate executed on application startup
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (TextView) findViewById(R.id.textView);
        b = (Button) findViewById(R.id.button);
        img = (ImageView) findViewById(R.id.imageView);
        img.setImageResource(R.drawable.bruin);
        img.setTag(1);
        buttonimage = (Button)findViewById(R.id.buttonimage);
        textField = (EditText) findViewById(R.id.editText);
        buttontf = (Button)findViewById(R.id.buttontf);


        buttontf.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String output = textField.getText().toString();
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast tftoast = Toast.makeText(context, output, duration);
                tftoast.show();
            }
        });

        buttonimage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if ((int)img.getTag() == 1) {
                    img.setImageResource(R.drawable.uclalogo);
                    img.setTag(2);
                }
                else if ((int)img.getTag() == 2) {
                    img.setImageResource(R.drawable.bruin);
                    img.setTag(1);
                }
                else {}
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            @Override
            public void onClick(View v) {
                count++;
                // gives a notification (toast)
                Context context = getApplicationContext();
                CharSequence text = "Button has been pressed " + count + " times!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);

                if (count >= 3) {
                    // Log.d() sends info message with tag "Info"
                    Log.i("Info", "Button has been pressed " + count + " times!");
                    // sets onscreen text to count
                    t.setText("" + count);

                    text = "Button has been pressed " + count + " times.";
                    toast.show();
                }
            }
        });
    }
}
