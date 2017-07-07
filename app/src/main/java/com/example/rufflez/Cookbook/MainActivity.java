package com.example.rufflez.Cookbook;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
<<<<<<< HEAD
import android.support.v4.app.Fragment;
=======
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
<<<<<<< HEAD
import android.view.Gravity;
=======
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
import android.view.Menu;
import android.view.MenuItem;

import com.example.rufflez.Cookbook.fragments.FavoritesFragment;
import com.example.rufflez.Cookbook.fragments.HomeFragment;
import com.example.rufflez.Cookbook.fragments.ShoppingListFragment;
<<<<<<< HEAD
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
=======
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD
    private Drawer.Result navigationBar;
    private AccountHeader.Result accountHeaderNAV;
    private BottomBar bottomBar;
    private Fragment fragment;
=======

    BottomBar bottomBar;

>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        ///=====================================================//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //=========================================================//
=======
//        final CollapsingToolbarLayout collapsingToolbarMain =
//                (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
//        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //collapsingToolbarMain.setTitleEnabled(false);


>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if(tabId == R.id.tab_home){
<<<<<<< HEAD
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


=======
                    HomeFragment homeFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,homeFragment).commit();
                }
                if (tabId == R.id.tab_favorites){
                   FavoritesFragment favoritesFragment = new FavoritesFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,favoritesFragment).commit();
                }
                if(tabId == R.id.tab_shop){
                    ShoppingListFragment shoppingListFragment = new ShoppingListFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,shoppingListFragment).commit();
                }
            }
        });


//        //Show CollapsingToolbarLayout Title ONLY when collapsed
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//
//            boolean isVisible = true;
//            int scrollRange = -1;
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    collapsingToolbarMain.setTitle("Hôm nay bạn nấu gì?");
//                    isVisible = true;
//                } else if(isVisible) {
//                    collapsingToolbarMain.setTitle("");
//                    isVisible = false;
//                }
//            }
//        });
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
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
<<<<<<< HEAD
        return super.onCreateOptionsMenu(menu);
=======
          return super.onCreateOptionsMenu(menu);
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
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
<<<<<<< HEAD
        return super.onOptionsItemSelected(item);
    }


=======




        return super.onOptionsItemSelected(item);
    }
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
}
