package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // One Button
    Button BSelectImage;

    // One Preview Image
    ImageView IVPreviewImage;

    // constant to compare
    // the activity result code
    int SELECT_PICTURE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // register the UI widgets with their appropriate IDs
        BSelectImage = findViewById(R.id.BSelectImage);
        IVPreviewImage = findViewById(R.id.IVPreviewImage);

        // handle the Choose Image button to trigger
        // the image chooser function
        BSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
    }

    // this function is triggered when
    // the Select Image Button is clicked
    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }
    public class Pythagoras extends AppCompatActivity implements View.OnClickListener {

        EditText aNumPyt;
        EditText bNumPyt;
        EditText cNumPyt;

        Button pythagorasCalcu;

        TextView pythagorasResultFinal;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pythagoras);

            aNumPyt = (EditText) findViewById(R.id.aNumPyt);
            bNumPyt = (EditText) findViewById(R.id.bNumPyt);

            pythagorasCalcu = (Button) findViewById(R.id.pythagorasCalcu);

            pythagorasResultFinal = (TextView) findViewById(R.id.pythagorasResultFinal);

            // set a listener
            pythagorasCalcu.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            double a=0,b=0,c=0;
            double hypot = 0.0;

    /*
    // check if the fields are empty
    if (TextUtils.isEmpty(aNumPyt.getText().toString()) || TextUtils.isEmpty(bNumPyt.getText().toString()) || TextUtils.isEmpty(cNumPyt.getText().toString())) {
        return;
    }
    */

            // read EditText and fill variables with numbers
            a = Double.parseDouble(aNumPyt.getText().toString());
            b = Double.parseDouble(bNumPyt.getText().toString());
            c = Double.parseDouble(cNumPyt.getText().toString());

            if (a>b && a>c){
                hypot=a;
                if(hypot*hypot==(b*b+c*c)){
                    //result = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
                    pythagorasResultFinal.setText(String.valueOf(hypot));
                }
            } else if (b>a && b>c){
                hypot=b;
                if(hypot*hypot==(a*a+c*c)){
                    //result = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
                    pythagorasResultFinal.setText(String.valueOf(hypot));
                }
            } else if (c>a && c>b){
                hypot=c;
                if(hypot*hypot==(a*a+b*b)){
                    //result = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
                    pythagorasResultFinal.setText(String.valueOf(hypot));
                }
            }
        }
}