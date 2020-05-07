package com.example.coursevisualizer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    private float[] xData = {25.0f, 25.0f, 25.0f, 25.0f};
    private String[] yData = {"a", "b", "c", "d"};
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        pieChart = (PieChart) findViewById(R.id.idPieChart);
        Description desc = new Description();
        desc.setText("**Course Name here** bleb");
        pieChart.setDescription(desc);

        pieChart.setRotationEnabled(true);
        addDataSet(pieChart);
    }

    private void addDataSet(PieChart pieChart) {
        ArrayList<PieEntry> xEntries = new ArrayList<>();
        ArrayList<String> yEntries = new ArrayList<>();

        for(int i = 0; i < xData.length; i++) {
            xEntries.add(new PieEntry(xData[i]));
            yEntries.add(yData[i]);
        }

        // create dataset to display- i.e. markers for what color represents what(maybe)
        PieDataSet pieDataSet = new PieDataSet(xEntries, "Course componenets");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        // add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);

        // add legend
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);

        // create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }
}
