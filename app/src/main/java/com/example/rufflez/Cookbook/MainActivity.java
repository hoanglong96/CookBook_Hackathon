package com.example.rufflez.Cookbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rufflez.Cookbook.fragments.FavoritesFragment;
import com.example.rufflez.Cookbook.fragments.HomeFragment;
import com.example.rufflez.Cookbook.fragments.ShoppingListFragment;
import com.example.rufflez.myapplication.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomBar bottomBar;
    private Toolbar toolbar;
    private String isMonSang = "Món sáng", isMonKhaiVi = "Món khai vị" , isMonChinh = "Món chính" , isMonTrangMieng = "Món tráng miệng";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_home) {
                    HomeFragment homeFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, homeFragment).commit();
                    toolbar.setTitle("Hôm nay bạn nấu gì?");
                }
                if (tabId == R.id.tab_favorites) {
                    FavoritesFragment favoritesFragment = new FavoritesFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, favoritesFragment).commit();
                    toolbar.setTitle("Món ăn yêu thích");
                }
                if (tabId == R.id.tab_shop) {
                    ShoppingListFragment shoppingListFragment = new ShoppingListFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content, shoppingListFragment).commit();
                    toolbar.setTitle("Danh sách nguyên liệu");
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Bạn muốn đóng tôi :( ?");
            builder.setCancelable(true);
            builder.setNegativeButton("Không!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.setPositiveButton("Vâng", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Intent search = new Intent(this, SearchActivity.class);
            startActivity(search);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content, homeFragment).commit();
            toolbar.setTitle("Hôm nay bạn nấu gì?");

        } else if (id == R.id.nav_fav) {
            FavoritesFragment favoritesFragment = new FavoritesFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content, favoritesFragment).commit();
            toolbar.setTitle("Món ăn yêu thích");
        } else if (id == R.id.nav_list_food) {

        } else if (id == R.id.nav_shop) {
            ShoppingListFragment shoppingListFragment = new ShoppingListFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content, shoppingListFragment).commit();
            toolbar.setTitle("Đi chợ mua gì?");
        } else if (id == R.id.nav_mon_sang) {
            Intent intent = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("isMonSang" , isMonSang);
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (id == R.id.nav_mon_khai_vi) {
            Intent intent2 = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle2 = new Bundle();
            bundle2.putString("isMonSang" , isMonKhaiVi);
            intent2.putExtras(bundle2);
            startActivity(intent2);
        } else if (id == R.id.nav_mon_chinh) {
            Intent intent3 = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle3 = new Bundle();
            bundle3.putString("isMonSang" , isMonChinh);
            intent3.putExtras(bundle3);
            startActivity(intent3);
        } else if (id == R.id.nav_mon_trang_mieng) {
            Intent intent4 = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle4 = new Bundle();
            bundle4.putString("isMonSang" , isMonTrangMieng);
            intent4.putExtras(bundle4);
            startActivity(intent4);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
