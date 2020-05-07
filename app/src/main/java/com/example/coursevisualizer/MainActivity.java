package com.example.coursevisualizer;

import android.content.Intent;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button showPie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showPie = (Button) findViewById(R.id.showPie);
        showPie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPieChartActivity();
            }
        });
    }

    private void openPieChartActivity() {
        Intent pieIntent = new Intent(this, PieChartActivity.class);
        startActivity(pieIntent);
    }

}
