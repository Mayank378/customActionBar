package com.example.customactionbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar topAppBar;
    MaterialButtonToggleGroup themeButtonsGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        TopAppBar();
        SetTheme();

    }

    private void initialize() {

        //MaterialToolbar {@link activity_main.xml}
        topAppBar=(MaterialToolbar)findViewById(R.id.top_app_bar);

        //MaterialButtonToggleGroup {@link activity_main.xml
        themeButtonsGroup=(MaterialButtonToggleGroup)findViewById(R.id.btg_theme);
    }

    private void TopAppBar() {

        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Navigation Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        topAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.favorite){
                    Toast.makeText(MainActivity.this, "Favorite Set", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(item.getItemId()==R.id.search){
                    Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(item.getItemId()==R.id.more){
                    Toast.makeText(MainActivity.this, "More", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else {
                    return false;
                }
            }
        });
    }

    private void SetTheme() {
        themeButtonsGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if(checkedId==R.id.btn_dark && isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Toast.makeText(MainActivity.this, "Theme dark", Toast.LENGTH_SHORT).show();
                }
                else if(checkedId==R.id.btn_light && isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Toast.makeText(MainActivity.this, "Theme light", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}