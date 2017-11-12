package com.projectx.projectx;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.projectx.projectx.Config.ProjectXPref;
import com.projectx.projectx.Fragment.ActionLikeDislike;
import com.projectx.projectx.Fragment.DeleteMyAccountScreen;
import com.projectx.projectx.Fragment.HomeScreen;
import com.projectx.projectx.Fragment.LikeDislikeScreen;
import com.projectx.projectx.Login.Logout;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Logout.OnFragmentInteractionListener,ActionLikeDislike.OnFragmentInteractionListener,HomeScreen.OnFragmentInteractionListener,
        LikeDislikeScreen.OnFragmentInteractionListener, DeleteMyAccountScreen.OnFragmentInteractionListener {
    private ProjectXPref prefManager;
    private Logout logoutFragment;
    private ActionLikeDislike actionLikeDislike;
    private HomeScreen homeScreen;
    private LikeDislikeScreen likeDislikeScreen;
    private DeleteMyAccountScreen deleteMyAccountScreen;

    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        prefManager = new ProjectXPref(this);
        logoutFragment = new Logout();
        actionLikeDislike = new ActionLikeDislike();
        homeScreen = new HomeScreen();
        likeDislikeScreen = new LikeDislikeScreen();
        deleteMyAccountScreen = new DeleteMyAccountScreen();
        checkLikeDislikeSet();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notification, menu);
        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        transaction = getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();
        if(id == R.id.action_logout) {
            if (findViewById(R.id.main_fragment_container) != null) {
                transaction.replace(R.id.main_fragment_container, logoutFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }
        if (id == R.id.action_menu_notification){
            // to do notification handler
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(@NotNull Uri uri) {

    }

    @Override
    public void onFragmentInteractionShowLikeDislike() {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fragment_container, likeDislikeScreen);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteractionGoHome() {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fragment_container, homeScreen);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteractionLogout (){
        checkLikeDislikeSet();
//        prefManager.setLogout(true);
//        transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.main_fragment_container, homeScreen);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }

    @Override
    public void onFragmentInteractionDeletAccount (){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_fragment_container, deleteMyAccountScreen);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragmentInteractionDeleteUserAccount (){
        // To do
    }

    public void checkLikeDislikeSet() {
        transaction = getSupportFragmentManager().beginTransaction();
        if (!prefManager.isLikeDislike()){
            transaction.replace(R.id.main_fragment_container, homeScreen);
            transaction.addToBackStack(null);
            transaction.commit();

        }else{
            transaction.replace(R.id.main_fragment_container, actionLikeDislike);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
