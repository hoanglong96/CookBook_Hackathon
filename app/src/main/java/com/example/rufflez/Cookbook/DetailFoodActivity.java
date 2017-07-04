package com.example.rufflez.Cookbook;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
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

import com.example.rufflez.Cookbook.fragments.NguyenLieuFragment;
import com.example.rufflez.Cookbook.fragments.StepFragment;

import java.util.ArrayList;
import java.util.List;

public class DetailFoodActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    ImageView imgBookMark;
    boolean isBookMark;


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
        setTitle("Gà rán mật ong");
        setSupportActionBar(toolbar);


        //View paper
        mViewPager = (ViewPager) findViewById(R.id.container_detail_food);
        if (mViewPager != null) {
            setupViewPager(mViewPager);
        }

        //TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_detail_food);
        tabLayout.setupWithViewPager(mViewPager);

        //Show CollapsingToolbarLayout Title ONLY when collapsed
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_detail_food);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar_detail_food);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Gà rán mật ong");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });


        //Intent
        Intent intent = this.getIntent();

        //Bookmark
        imgBookMark = (ImageView) findViewById(R.id.book_mark);
        imgBookMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBookMark) {
                    imgBookMark.setImageResource(R.drawable.heart_outline);
                    Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), "Bạn đã xóa món ăn khỏi yêu thích", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                    isBookMark = false;
                } else {
                    imgBookMark.setImageResource(R.drawable.heart_book_mark);
                    Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), "Bạn đã thêm món ăn vào yêu thích", Snackbar.LENGTH_SHORT)
                            .setAction("Yêu thích", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                }
                            });
                    snackbar.setActionTextColor(Color.YELLOW);
                    snackbar.show();
                    isBookMark = true;
                }
            }
        });

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
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_cooktoday) {
            Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), "Bạn đã thêm vào thực đơn hôm nay", Snackbar.LENGTH_SHORT)
                    .setAction("Thực đơn", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MenuCookToday();
                        }
                    });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
            return true;
        }
        if (id == R.id.action_cooknow) {
            Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), "Bắt đầu nấu ăn thôi ^^", Snackbar.LENGTH_SHORT);
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void MenuCookToday() {
        Intent intent = new Intent(this,CookToday.class);
        startActivity(intent);
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
