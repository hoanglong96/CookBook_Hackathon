package com.example.rufflez.Cookbook;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rufflez.Cookbook.fragments.FavoritesFragment;
import com.example.rufflez.Cookbook.fragments.HomeFragment;
import com.example.rufflez.Cookbook.fragments.ShoppingListFragment;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends AppCompatActivity {
    private Drawer.Result navigationBar;
    private AccountHeader.Result accountHeaderNAV;
    private BottomBar bottomBar;
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///=====================================================//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //=========================================================//
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if(tabId == R.id.tab_home){
                    fragment = new HomeFragment();
                }
                if (tabId == R.id.tab_favorites){
                    fragment = new FavoritesFragment();
                }
                if(tabId == R.id.tab_shop){
                    fragment = new ShoppingListFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content,fragment).commit();

            }
        });
        //===========================================================//
        // **** Navigation Bar ***
        // setting header of navigation
        accountHeaderNAV = new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.drawable.background) // bacground header
                .build();
        // setting for navigation
        navigationBar = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(accountHeaderNAV)
                .withSelectedItem(0)
                .build();
        // add item for navigation
        navigationBar.addItem(new PrimaryDrawerItem().withName("Món Ăn Sáng").withIcon(getResources().getDrawable(R.drawable.ic_home_24)));
        navigationBar.addItem(new PrimaryDrawerItem().withName("Món Khai Vị").withIcon(getResources().getDrawable(R.drawable.ic_home_24)));
        navigationBar.addItem(new PrimaryDrawerItem().withName("Món Ăn Chính").withIcon(getResources().getDrawable(R.drawable.ic_home_24)));
        navigationBar.addItem(new PrimaryDrawerItem().withName("Món Tráng Miệng").withIcon(getResources().getDrawable(R.drawable.ic_home_24)));
        navigationBar.addItem(new PrimaryDrawerItem().withName("Home").withIcon(getResources().getDrawable(R.drawable.ic_home_24)));
        navigationBar.addItem(new PrimaryDrawerItem().withName("Home").withIcon(getResources().getDrawable(R.drawable.ic_home_24)));


    }

    @Override
    public void onBackPressed() {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MainActivity.this.getComponentName()));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }


}
