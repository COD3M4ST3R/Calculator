package com.example.lifeassistant;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.ViewManager;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.w3c.dom.Text;

        import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.zip.Inflater;

public class GradeActivity extends AppCompatActivity
{
    int counter = 0;
    int counter2 = 0;
    int cnt = 0;

    int assignmentNumber;
    int id = 0;

    int n1, n2;
    EditText ed1, ed2;

    //ArrayList<EditText> allEds = new ArrayList<>();
    EditText array[] = new EditText[14];
    int arrayValue[] = new int[14];


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        // INITIALIZE AND CASTING
        ImageView imageView11 = (ImageView) findViewById(R.id.imageView11);
        final Button button17 = (Button) findViewById(R.id.button17);
        Button button21 = (Button)findViewById(R.id.button21);
        final EditText editText4 = (EditText)findViewById(R.id.editText4);
        final TextView textView7 = (TextView)findViewById(R.id.textView7);


        // INTENT
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCGPA();
            }
        });

         // CREATE BUTTON
         button17.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 int counterOFF = 0;

                 assignmentNumber = Integer.parseInt(editText4.getText().toString());

                 if (assignmentNumber >= 8) {
                     Toast.makeText(GradeActivity.this, "Maximum allowed assignment number is 7", Toast.LENGTH_SHORT).show();
                     assignmentNumber = 0;
                 }


                 for (; cnt < assignmentNumber; cnt++) {
                     LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.linearLayout3);
                     LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);

                     ed1 = new EditText(GradeActivity.this);
                     ed2 = new EditText(GradeActivity.this);

                     // RECORDING editTEXT THEMSELFS
                     array[counterOFF] = ed1;
                     array[counterOFF + 1] = ed2;
                     counterOFF = counterOFF + 2;

                     ed1.setId(id);
                     ed2.setId(id + 1);

                     linearLayout2.addView(ed1);
                     linearLayout3.addView(ed2);
                 }
             }
         });


        // CALCULATE BUTTON ONCLICK
        button21.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int number1 = 0, number2 = 0, temp = 0, result = 0;

                // GETTING INPUT
                for(; counter < assignmentNumber*2; counter++)
                {
                    arrayValue[counter] = Integer.parseInt(array[counter].getText().toString());
                }


                // CALCULATING ALGORITHM
                for(; counter2 < assignmentNumber*2; counter2++)
                {
                    temp = (arrayValue[counter2] * arrayValue[counter2 + 1]) / 100;
                    result = result + temp;
                    counter2++;
                }

                textView7.setText(String.valueOf(result) + "/100");
            }
        });
    }

    public void openCGPA()
    {
        Intent intet_CGPA = new Intent(this, CGPAActivity.class);
        startActivity(intet_CGPA);
    }
}
