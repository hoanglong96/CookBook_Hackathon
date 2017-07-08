package com.example.rufflez.Cookbook;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rufflez.Cookbook.databases.FoodModel;
import com.example.rufflez.Cookbook.fragments.NguyenLieuFragment;
import com.example.rufflez.Cookbook.fragments.StepFragment;
import com.example.rufflez.Cookbook.model.MonChinhModel;
import com.example.rufflez.Cookbook.model.MonSangModel;
import com.example.rufflez.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DetailFoodActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    ImageView imgBookMark;
    boolean isBookMark;
    private FoodModel foodModel;
    MonSangModel monSangModel;
    MonChinhModel monChinhModel;
    private ImageView imageToolbar;
    private TextView titleToolbar;

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

        NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScroolView);
        nestedScrollView.setFillViewport(true);

        //Intent
        Intent intent = this.getIntent();

        //Bookmark
        //imgBookMark = (ImageView) findViewById(R.id.book_mark);
//        imgBookMark.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setBookmark();
//            }
//        });
        setupUI();
        loadData();

    }

//    private void setBookmark() {
//        if (/*isBookMark*/foodModel.isBookmark()) {
//            imgBookMark.setImageResource(R.drawable.heart_outline);
//            Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), "Bạn đã xóa món ăn khỏi yêu thích", Snackbar.LENGTH_SHORT);
//            snackbar.show();
//            //isBookMark = false;
//            DatabaseHandle.getHandle(this).setBookmark(false,foodModel);
//            foodModel.setBookmark(false);
//        } else {
//            imgBookMark.setImageResource(R.drawable.heart_book_mark);
//            Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), "Bạn đã thêm món ăn vào yêu thích", Snackbar.LENGTH_SHORT)
//                    .setAction("Yêu thích", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                        }
//                    });
//            snackbar.setActionTextColor(Color.YELLOW);
//            snackbar.show();
////            DatabaseHandle.getHandle(this).setBookmark(true,foodModel);
////            foodModel.setBookmark(true);
//            //isBookMark = true;
//        }
//    }

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

    public void setupUI(){
        imageToolbar = (ImageView) findViewById(R.id.header);
        titleToolbar = (TextView) findViewById(R.id.toolbar_title);
    }
    public void loadData() {
//        monChinhModel = (MonChinhModel) getIntent().getExtras().getSerializable("singleItemModel");
//        String image1[] = monChinhModel.getAvatarFood().split(",");
//        byte[] decodebyte1 = Base64.decode(image1[1], Base64.DEFAULT);
//        Bitmap bitmap1 = BitmapFactory.decodeByteArray(decodebyte1, 0, decodebyte1.length);
//        imageToolbar.setImageBitmap(bitmap1);
//        titleToolbar.setText(monChinhModel.getTitleFood());
//
//        monSangModel = (MonSangModel) getIntent().getExtras().getSerializable("singleItemModel");
//        String image[] = monSangModel.getAvatarFood().split(",");
//        byte[] decodebyte = Base64.decode(image[1], Base64.DEFAULT);
//        Bitmap bitmap = BitmapFactory.decodeByteArray(decodebyte, 0, decodebyte.length);
//        imageToolbar.setImageBitmap(bitmap);
//        titleToolbar.setText(monSangModel.getTitleFood());'

        foodModel = (FoodModel) getIntent().getExtras().getSerializable("singleItemModel");
        String image[] = foodModel.getAvatarFood().split(",");
        byte[] decodebyte = Base64.decode(image[1], Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodebyte, 0, decodebyte.length);
        imageToolbar.setImageBitmap(bitmap);
        titleToolbar.setText(foodModel.getTitleFood());

    }
}
