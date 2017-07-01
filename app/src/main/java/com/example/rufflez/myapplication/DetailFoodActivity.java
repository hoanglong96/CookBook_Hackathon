package com.example.rufflez.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rufflez.myapplication.fragments.NguyenLieuFragment;
import com.example.rufflez.myapplication.fragments.StepFragment;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DetailFoodActivity extends AppCompatActivity {

    private boolean isBookMark;
    private ViewPager mViewPager;
    private ImageView ivBookMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        final ImageView ivBookMark;

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        setSupportActionBar(toolbar);


        //View paper
        mViewPager = (ViewPager) findViewById(R.id.container_detail_food);
        if (mViewPager != null) {
            setupViewPager(mViewPager);
        }

        //TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_detail_food);
        tabLayout.setupWithViewPager(mViewPager);

        //CollapsingToolbar
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_detail_food);
        collapsingToolbar.setTitle("Gà rán mật ong");

        //Intent
        Intent intent = this.getIntent();

        //Floating Action Button
        final View actionB = findViewById(R.id.action_b);
        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "Bạn đã thêm nguyên liệu vào danh sách cần mua", Snackbar.LENGTH_SHORT)
                        .setAction("View List", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            }
                        });
                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();
                //Toast.makeText(DetailFoodActivity.this, "Bạn đã thêm nguyên liệu vào danh sách cần mua", Toast.LENGTH_SHORT).show();
            }
        });

        final FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailFoodActivity.this, "Bắt đầu nấu thôi nào !", Toast.LENGTH_SHORT).show();
            }
        });

        //Bookmark

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new NguyenLieuFragment(), "Nguyên liệu");
        adapter.addFrag(new StepFragment(), "Cách làm");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_food, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_bookmark) {
            if(isBookMark){
                item.setIcon(R.drawable.heart_outline);
                isBookMark = false;

                Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), "Bạn đã xóa món ăn khỏi danh sách yêu thích", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
            else{
                item.setIcon(R.drawable.heart_book_mark);
                isBookMark = true;
                Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), "Bạn đã thêm món ăn vào danh sách yêu thích", Snackbar.LENGTH_SHORT)
                        .setAction("Favourites", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            }
                        });
                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
