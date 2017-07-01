package com.example.rufflez.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.rufflez.myapplication.adapter.MoreFoodGridAdapter;

public class MoreActivity extends AppCompatActivity {


    GridView grid;
    String[] web = {
            "Cháo gà",
            "Phở bò",
            "Xôi xéo",
            "Gà tần",
            "Cơm rang",
            "Bánh mỳ",
            "Hoành thánh",
            "Mỳ tôm",
            "Bánh bao",
            "Bánh gạo",
            "Kimbap",
            "Bánh mỳ cuộn",
            "Bún măng",
            "Bánh bông lanh",
            "Sữa tươi"

    } ;
    int[] imageId = {
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar_more_food);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        toolbar.setTitle("Món ăn sáng");
        setSupportActionBar(toolbar);


        MoreFoodGridAdapter adapter = new MoreFoodGridAdapter(MoreActivity.this, web, imageId);
        grid=(GridView)findViewById(R.id.grid_view);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MoreActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                Intent detailFood = new Intent(MoreActivity.this,DetailFoodActivity.class);
                startActivity(detailFood);
            }
        });

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) MoreActivity.this.getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MoreActivity.this.getComponentName()));
        }
        return super.onCreateOptionsMenu(menu);
    }
}
