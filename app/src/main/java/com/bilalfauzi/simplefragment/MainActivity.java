package com.bilalfauzi.simplefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Fragment fragmentHome, fragmentMessage, fragmentCall, fragmentPerson;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentHome = new FragmentHome();
        fragmentMessage = new FragmentMessage();
        fragmentCall = new FragmentCall();
        fragmentPerson = new FragmentPerson();
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        setCurrentFragment(fragmentHome);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menuHome:
                    setCurrentFragment(fragmentHome);
                    break;
                case R.id.menuMessage:
                    setCurrentFragment(fragmentMessage);
                    break;
                case R.id.menuCall:
                    setCurrentFragment(fragmentCall);
                    break;
                case R.id.menuPerson:
                    setCurrentFragment(fragmentPerson);
                    break;
            }
            return true;
        });
    }

    private void setCurrentFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment, fragment).commit();
    }
}