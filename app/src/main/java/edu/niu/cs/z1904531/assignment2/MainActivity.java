package edu.niu.cs.z1904531.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText numAET, numBET, numCET;
    private Button calcBtn, clearBtn;
    private TextView xValue1, xValue2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up a connection between variables and item on screen
        numAET = findViewById(R.id.numAEditText);
        numBET = findViewById(R.id.numBEditText);
        numCET = findViewById(R.id.numCEditText);

        calcBtn = findViewById(R.id.calcButton);

        clearBtn = findViewById(R.id.clearButton);

        xValue1 = findViewById(R.id.answerTextView);
        xValue2 = findViewById(R.id.answerTextView2);

        //set up a named listener for the arithmetic
        calcBtn.setOnClickListener(mathListener);


        //set up an anonymous listener for the clear button
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clear the num edit text fields
                numAET.setText("");
                numBET.setText("");
                numCET.setText("");

                //clear the x values
                xValue1.setText("");
                xValue2.setText("");

                //set the focus to the numA edittext field
                numAET.requestFocus();
            }//end onClick Listener

        });//end clear button listener

    }//end onCreate

    private View.OnClickListener mathListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Double numA, numB, numC, result = 0.0;
            String result_string = "";

            //check for empty fields
            if( numAET.getText().toString().matches("") ||
                    numBET.getText().toString().matches("")||
                    numCET.getText().toString().matches("") )
            {
                //display error message
                Toast.makeText(view.getContext(),
                        "The value fields cannot be empty",
                        Toast.LENGTH_LONG).show();
                return;
            }

            //get the numbers from the edittext fields
            numA = Double.parseDouble( numAET.getText().toString() );
            numB = Double.parseDouble( numBET.getText().toString() );
            numC = Double.parseDouble( numCET.getText().toString() );

            //check if the a value is 0
            if (numAET.getText().toString().matches("0")) {
                Toast.makeText(view.getContext(), "A value cannot be 0",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            //setting up decimal format
            DecimalFormat df = new DecimalFormat(".##");

            //calculate discriminant
            double discriminant = Math.pow(numB, 2.0) - (4 * (numA * numC));

            //handle cases of x values depending on discriminant value
            if( discriminant < 0){

                //handle non-real values for x
                xValue1.setText("Imaginary");
                xValue2.setText("Imaginary");

            }
            else if(discriminant == 0){

                //calculate the x values
                double x = (-numB + Math.sqrt(discriminant)) / (2 * numA);

                //display x values
                xValue1.setText("" + df.format(x));
                xValue2.setText("" + df.format(x));


            }
            else if(discriminant > 0){

                //calculate the x values
                double x1 = (-numB + Math.sqrt(discriminant)) / (2 * numA);
                double x2 = (-numB - Math.sqrt(discriminant)) / (2 * numA);

                //display x values
                xValue1.setText("" + df.format(x1));
                xValue2.setText("" + df.format(x2));
            }

        }//end OnClick

    }; //end of mathListener

}//end MainActivity