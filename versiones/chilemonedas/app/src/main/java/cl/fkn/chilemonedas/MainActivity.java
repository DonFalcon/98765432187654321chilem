package cl.fkn.chilemonedas;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

import cl.fkn.chilemonedas.vista.FragmentColeccionView;
import cl.fkn.chilemonedas.vista.FragmentResumenView;
import cl.fkn.chilemonedas.adapter.PageAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();
        tabLayout.getTabAt(0).select();
    }

    @Override
    public void onRestart(){
        super.onRestart();
        setUpViewPager();
        tabLayout.getTabAt(1).select();

    }

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new FragmentResumenView());
        fragments.add(new FragmentColeccionView());

        return fragments;
    }

    public void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_casa_blanca_100);
        //tabLayout.getTabAt(1).setText("boton");
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_monedas_blancas_100);
        //tabLayout.getTabAt(0).setText("reboton");
        tabLayout.getTabAt(0).select();
    }

}
