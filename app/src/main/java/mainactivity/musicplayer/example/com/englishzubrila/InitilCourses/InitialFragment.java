package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import mainactivity.musicplayer.example.com.englishzubrila.R;

public class InitialFragment  extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_fragmint);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        viewPager = findViewById(R.id.frame_container);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        setupViewPager();
        setupNavigationView();

    }
    private void setupNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.backward:
                                viewPager.setCurrentItem(0);
                                return true;
                            case R.id.further:
                                viewPager.setCurrentItem(1);
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/u/1/folders/1AyFJdtTna0ujmlCweK1zIsCuSiezquXT"));
                                startActivity(intent);
                                return true;
                        }
                        return false;
                    }
                });
    }

    private void setupViewPager(){
        ViewPegerAdaptor adaptor = new ViewPegerAdaptor(getSupportFragmentManager());
        adaptor.addFragment(new HomeFragment());
        viewPager.setAdapter(adaptor);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.backward);
                        break;
                    case 1:
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/drive/u/1/folders/1AyFJdtTna0ujmlCweK1zIsCuSiezquXT"));
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }
}
