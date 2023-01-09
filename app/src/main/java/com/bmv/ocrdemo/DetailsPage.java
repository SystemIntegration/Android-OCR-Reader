package com.bmv.ocrdemo;

import static com.bmv.ocrdemo.MainActivity.PROFILE_DATA_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.bmv.ocdemo.R;

import java.util.ArrayList;

public class DetailsPage extends AppCompatActivity {


    TextView txtResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.outputlayout);

//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setHomeButtonEnabled(true);

        txtResult = (TextView) findViewById(R.id.txtResult);
        Bundle bundle = getIntent().getExtras();
        if (bundle.getStringArrayList(PROFILE_DATA_KEY) != null) {
            ArrayList<String> mresult = bundle.getStringArrayList(PROFILE_DATA_KEY);

            try{
                String mm=mresult.get(0);
                txtResult.setText(""+mm);
            }catch (Exception e){
                e.printStackTrace();
            }

            /*for (int m=0; m<mresult.size();m++){
                mm+= mresult.get(m);
            }*/

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);

                Intent myIntent = new Intent(DetailsPage.this,MainActivity.class);
                startActivity(myIntent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
