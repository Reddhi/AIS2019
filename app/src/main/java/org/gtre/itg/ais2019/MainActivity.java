package org.gtre.itg.ais2019;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import org.gtre.itg.ais2019.contact.ContactFragment;
import org.gtre.itg.ais2019.faq.FAQFragment;
import org.gtre.itg.ais2019.registration.RegistrationFragment;
import org.gtre.itg.ais2019.schedule.ScheduleFragment;
import org.gtre.itg.ais2019.schedule.SeminarEvent;
import org.gtre.itg.ais2019.seminar.SeminarFragment;
import org.gtre.itg.ais2019.schedule.SpeakersFragment;
import org.gtre.itg.ais2019.sponsorship.SponsorshipFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private FragmentManager mFragmentManager;
    private ArrayList<SeminarEvent> events = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerToggle = setupDrawerToggle();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        setupDrawerContent(navigationView);
        mFragmentManager = getSupportFragmentManager();
        setInitialFragment();

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.home:
                fragmentClass = HomeFragment.class;
                break;
            case R.id.message_from_chairman:
                fragmentClass = ChairmanFragment.class;
                break;
            case R.id.seminar:
                fragmentClass = SeminarFragment.class;
                break;
            case R.id.schedule:
                fragmentClass = ScheduleFragment.class;
                break;
            case R.id.speakers:
                fragmentClass = SpeakersFragment.class;
                break;
            case R.id.registration:
                fragmentClass = RegistrationFragment.class;
                break;
            case R.id.sponsorship:
                fragmentClass = SponsorshipFragment.class;
                break;
            case R.id.venue:
                fragmentClass = VenueFragment.class;
                break;
            case R.id.contact:
                fragmentClass = ContactFragment.class;
                break;
            case R.id.faq:
                fragmentClass = FAQFragment.class;
                break;
            default:
                fragmentClass = HomeFragment.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment

        mFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawerLayout.closeDrawers();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open,  R.string.drawer_close);
        mDrawerToggle.syncState();
        return mDrawerToggle;
    }

    private void setInitialFragment(){
        Class c = HomeFragment.class;
        Fragment f = null;
        try {
            f = (Fragment) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mFragmentManager.beginTransaction().replace(R.id.fragmentContainer, f).commit();
    }

    //v.ajith@gmail.com
}
