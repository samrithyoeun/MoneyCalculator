package com.fluffy.samrith.money;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NumberFormatException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.calculate);
        final TextView results = (TextView)findViewById(R.id.result);
        final EditText total = (EditText)findViewById(R.id.total);
        final EditText sengly = (EditText)findViewById(R.id.sengly);
        final EditText sovan = (EditText)findViewById(R.id.sovan);
        final EditText thira = (EditText)findViewById(R.id.thira);
        final EditText samrith = (EditText)findViewById(R.id.samrith);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                results.setText("");
                try{
                    float totals = 0;
                    if(!total.getText().toString().equals("")){
                    String[] all = total.getText().toString().split("-");

                    for (int i = 0; i < all.length; i++)
                        totals += Float.valueOf(all[i]);
                    }

                    float samriths = 0;
                    if(!samrith.getText().toString().equals("")) {
                        String[] samrit = samrith.getText().toString().split("-");

                        for (int i = 0; i < samrit.length; i++)
                            samriths += Float.valueOf(samrit[i]);
                    }

                    float senglys = 0;
                    if(!sengly.getText().toString().equals("")) {
                        String[] sengl = sengly.getText().toString().split("-");

                        for (int i = 0; i < sengl.length; i++)
                            senglys += Float.valueOf(sengl[i]);
                    }

                    float sovans = 0;
                    if(!sovan.getText().toString().equals("")) {
                        String[] sova = sovan.getText().toString().split("-");

                        for (int i = 0; i < sova.length; i++)
                            sovans += Float.valueOf(sova[i]);
                    }

                    float thiras = 0;
                    if(!thira.getText().toString().equals("")) {
                        String[] thir = thira.getText().toString().split("-");

                        for (int i = 0; i < thir.length; i++)
                            thiras += Float.valueOf(thir[i]);
                    }

                    String result ="";
                    totals = totals -(sovans + senglys+ samriths+thiras);
                    totals /=4;
                    senglys += totals;
                    sovans +=totals;
                    samriths +=totals;
                    thiras += totals;

                    result = "Sengly : "+senglys +" --- Sovann : "+sovans + "\nSamrith : "+samriths +" --- B.Thira : "+thiras;

                    results.setText(result);
                }catch (Exception e){

                    e.printStackTrace();
                    results.setText("Invalid input! ");
                }


            }
        });
    }
}
