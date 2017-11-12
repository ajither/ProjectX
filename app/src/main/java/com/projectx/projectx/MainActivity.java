package com.projectx.projectx;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.projectx.projectx.Config.ProjectXPref;
import com.projectx.projectx.Fragment.ActionLikeDislike;
import com.projectx.projectx.Fragment.DeleteMyAccountScreen;
import com.projectx.projectx.Fragment.HomeScreen;
import com.projectx.projectx.Fragment.LikeDislikeScreen;
import com.projectx.projectx.Login.LoginActivity;
import com.projectx.projectx.Login.Logout;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Ajith E R on 01/9/17.
 * @brief Application Main Activity
 */

public class MainActivity extends AppCompatActivity implements Logout.OnFragmentInteractionListener,ActionLikeDislike.OnFragmentInteractionListener,HomeScreen.OnFragmentInteractionListener,
        LikeDislikeScreen.OnFragmentInteractionListener, DeleteMyAccountScreen.OnFragmentInteractionListener{
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
        setContentView(R.layout.activity_main);
        logoutFragment = new Logout();
        actionLikeDislike = new ActionLikeDislike();
        homeScreen = new HomeScreen();
        likeDislikeScreen = new LikeDislikeScreen();
        deleteMyAccountScreen = new DeleteMyAccountScreen();
        prefManager = new ProjectXPref(this);

        checkLikeDislikeSet();

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
