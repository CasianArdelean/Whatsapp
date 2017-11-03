package com.example.dm2.whatsapp;

import android.content.ClipData;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    private int menuToChoose = R.menu.menu_main;
    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Whatsapp");

        Resources res = getResources();

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Llamadas", null);
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Chat",null );
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Contactos",null );
        tabs.addTab(spec);

        tabs.setCurrentTab(1);

        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("mitab1")){
                    menuToChoose = R.menu.menu_tel;
                    invalidateOptionsMenu();
                }
                if(tabId.equals("mitab2")){
                    menuToChoose = R.menu.menu_main;
                    invalidateOptionsMenu();
                }
                if(tabId.equals("mitab3")){
                    menuToChoose = R.menu.menu_contactos;
                    invalidateOptionsMenu();
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(menuToChoose, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_favorite:
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void verTel(int id)
    {
        MenuItem item = menu.findItem(id);
        item.setVisible(false);
    }

    private void ocultarTel(int id)
    {
        MenuItem item = menu.findItem(id);
        item.setVisible(true);
    }

    private void setOptionTitle(int id, String title)
    {
        MenuItem item = menu.findItem(id);
        item.setTitle(title);
    }
}
