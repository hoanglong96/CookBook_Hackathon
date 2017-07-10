package com.example.rufflez.Cookbook.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rufflez.Cookbook.databases.DatabaseHandle;
import com.example.rufflez.Cookbook.databases.FoodModel;
import com.example.rufflez.myapplication.R;

import java.util.Arrays;
import java.util.List;

public class DetailFoodActivity extends AppCompatActivity {

    private ViewPager mViewPager, mViewPagerStep;
    ImageView imgBookMark;
    boolean isBookMark;
    private FoodModel foodModel;
    private ImageView imageToolbar;
    private TextView titleToolbar, nameTypeFood;
    Toolbar toolbar;
    private TextView tv_content_cach_nau;
    private TextView tv_khauphan;
    private TextView tv_calo;
    private TextView tv_soNguyenLieu;
    private TextView tv_thoigian;
    private TextView tv_typeFood;
    //CardView
    private ListView mListView;
    private TextView mTextView;
    private boolean isCheckAll;
    public static List<String> trees = Arrays.asList(
            "7-8 lạng gà ta",
            "50ml mật ong rừng",
            "Nước mắm",
            "Mì chính",
            "Hạt tiêu",
            "Tỏi khô",
            "Gừng tươi băm nhỏ",
            "Bột mỳ",
            "Ớt tươi",
            "Dầu ăn"
    );
    SparseBooleanArray clickedItemPositions = new SparseBooleanArray();
    String valueItemCheck = null;
    FloatingActionButton fab;
    public static String[] itemCheckList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);
        final ImageView ivBookMark;
        //Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        setSupportActionBar(toolbar);

        //Intent
        Intent intent = this.getIntent();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBookMark();
            }
        });
        setupUI();
        loadData();


        mListView = (ListView) findViewById(R.id.lv);
        mTextView = (TextView) findViewById(R.id.tv);

        //NGuyen lieu
        String i[] = foodModel.getIngredientFood().split("-");
        ArrayAdapter<String> adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_multiple_choice, i
        );

        clickedItemPositions = mListView.getCheckedItemPositions();
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mTextView.setText("");
                for (int index = 0; index < clickedItemPositions.size(); index++) {
                    // Get the checked status of the current item
                    boolean checked = clickedItemPositions.valueAt(index);
                    if (checked) {
                        // If the current item is checked
                        int key = clickedItemPositions.keyAt(index);
                        String item = (String) mListView.getItemAtPosition(key);
                        // Display the checked items on TextView
                        mTextView.setText(mTextView.getText() + item + ",");
                        valueItemCheck = mTextView.getText().toString();
                    }
                }
                itemCheckList = valueItemCheck.split(",");
                Log.d("ab", "onItemClick: " + itemCheckList.length);
            }
        });

        setListViewHeightBasedOnChildren(mListView);

    }


    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount()-1));
        listView.setLayoutParams(params);
        Log.i("height of listItem:", String.valueOf(totalHeight));
    }

    private void setBookMark() {
        if(foodModel.isBookmark()){
            fab.setImageResource(R.drawable.heart_outline);
            DatabaseHandle.getInstance(this).setBookmark(false,foodModel);
            foodModel.setBookmark(false);
        }else{
            fab.setImageResource(R.drawable.heart);
            DatabaseHandle.getInstance(this).setBookmark(true,foodModel);
            foodModel.setBookmark(true);
        }
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

        return super.onOptionsItemSelected(item);
    }

    private void MenuCookToday() {
        Intent intent = new Intent(this, CookToday.class);
        startActivity(intent);
    }

    public void setupUI() {
        imageToolbar = (ImageView) findViewById(R.id.header);
        titleToolbar = (TextView) findViewById(R.id.toolbar_title);
        tv_content_cach_nau = (TextView) findViewById(R.id.content_cach_nau);
        tv_khauphan = (TextView) findViewById(R.id.khau_phan);
        tv_calo = (TextView) findViewById(R.id.calo);
        tv_soNguyenLieu = (TextView) findViewById(R.id.so_nguyen_lieu);
        tv_thoigian = (TextView) findViewById(R.id.thoi_gian_nau);
        tv_typeFood = (TextView) findViewById(R.id.type_food);
    }

    public void loadData() {
        foodModel = (FoodModel) getIntent().getExtras().getSerializable("singleItemModel");
        String image[] = foodModel.getAvatarFood().split(",");
        byte[] decodebyte = Base64.decode(image[1], Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodebyte, 0, decodebyte.length);
        imageToolbar.setImageBitmap(bitmap);
        tv_content_cach_nau.setText(foodModel.getMethodFood());
        tv_khauphan.setText(foodModel.getKhauPhan());
        tv_calo.setText(foodModel.getCalo());
        tv_soNguyenLieu.setText(foodModel.getSoNguyenLieu());
        tv_thoigian.setText(foodModel.getThoiGianNau());
        titleToolbar.setText(foodModel.getTitleFood());
        tv_typeFood.setText(foodModel.getTypeFood());
        toolbar.setTitle(foodModel.getTitleFood());
    }
}
