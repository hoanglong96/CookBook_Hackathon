package com.example.rufflez.Cookbook.activity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rufflez.Cookbook.databases.DatabaseHandle;
import com.example.rufflez.Cookbook.databases.FoodModel;
import com.example.rufflez.myapplication.R;

import java.util.Arrays;
import java.util.List;

public class DetailFoodActivity extends AppCompatActivity {

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
    private RecyclerView mRecycleView;
    private TextView mTextView;
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
    FloatingActionButton fab;
    Button btn_shop;

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

        setupUI();
        loadData();

        //RecycleView
        String i[] = foodModel.getIngredientFood().split("-");
        mTextView = (TextView) findViewById(R.id.tv);
        mRecycleView = (RecyclerView) findViewById(R.id.rv);
        mRecycleView.setLayoutManager(new LinearLayoutManager(mRecycleView.getContext()));
        mRecycleView.setAdapter(new SimpleStringRecyclerViewAdapter(getBaseContext(), i));

//        //Button Shop
//        btn_shop = (Button) findViewById(R.id.btn_shop);
//        btn_shop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                android.app.FragmentManager fm = getFragmentManager();
////                Bundle bundle = new Bundle();
////                bundle.putSerializable("data",foodModel);
////                DialogFragment dialogFragment = new DialogFragment();
////                dialogFragment.show(fm,"Simple fm");
////                dialogFragment.setArguments(bundle);
//
//            }
//        });
    }

    //Recycle Adapter
    public static class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {
        private String[] mValues;
        private Context mContext;
        private boolean isBuy;

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public final View mView;
            public final TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mTextView = (TextView) view.findViewById(android.R.id.text1);
            }

        }

        public String getValueAt(int position) {
            return mValues[position];
        }

        public SimpleStringRecyclerViewAdapter(Context context, String[] items) {
            mContext = context;
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_nguyen_lieu, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mTextView.setText(mValues[position]);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isBuy) {
                        holder.mTextView.setPaintFlags(holder.mTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        holder.mTextView.setTextColor(Color.CYAN);
                        isBuy = false;
                    } else {
                        holder.mTextView.setPaintFlags(0);
                        holder.mTextView.setTextColor(Color.BLACK);
                        isBuy = true;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.length;
        }
    }

    private void setBookMark() {
        if (foodModel.isBookmark()) {
            fab.setImageResource(R.drawable.heart_outline);
            DatabaseHandle.getInstance(this).setBookmark(false, foodModel);
            foodModel.setBookmark(false);
        } else {
            fab.setImageResource(R.drawable.heart);
            DatabaseHandle.getInstance(this).setBookmark(true, foodModel);
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
        if (id == R.id.action_bookmark) {
            if (foodModel.isBookmark()) {
                item.setIcon(R.drawable.heart_outline);
                DatabaseHandle.getInstance(this).setBookmark(false, foodModel);
                foodModel.setBookmark(false);
            }else {
                item.setIcon(R.drawable.heart);
                DatabaseHandle.getInstance(this).setBookmark(true, foodModel);
                foodModel.setBookmark(true);
            }
            Log.d("abc", "onOptionsItemSelected: " + foodModel.isBookmark());
            return true;
        }
        if (id == R.id.action_addcook) {
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
