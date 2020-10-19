package com.terabits.portfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import com.terabits.portfolio.cv.CVFragment;
import com.terabits.portfolio.home.HomeFragment;
import com.terabits.portfolio.portfolio.PortfolioFragment;
import com.terabits.portfolio.sidemenu.Callback;
import com.terabits.portfolio.sidemenu.MenuAdapter;
import com.terabits.portfolio.sidemenu.MenuItem;
import com.terabits.portfolio.sidemenu.MenuUtil;
import com.terabits.portfolio.team.TeamFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {


    RecyclerView menuRv;
    List<MenuItem> menuItems;
    MenuAdapter adapter;
    int selectedMenuPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //setup sideMenu

        setupSideMenu();

        //set the default fragment
        setHomeFragment();
    }

    private void setupSideMenu() {
        menuRv = findViewById(R.id.rv_side_menu);

        //get menu list item will get data from a static data class

        menuItems = MenuUtil.getMenuList();
        adapter = new MenuAdapter(menuItems, this);
        menuRv.setLayoutManager(new LinearLayoutManager(this));
        menuRv.setAdapter(adapter);



    }

    void setPortfolioFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PortfolioFragment()).commit();
    }

    void setTeamFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TeamFragment()).commit();
    }


    void setCVFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CVFragment()).commit();
    }


    void setHomeFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    @Override
    public void onSideMenuItemClick(int i) {

        switch (menuItems.get(i).getCode()){

            case MenuUtil.HOME_FRAGMENT_CODE : setHomeFragment();
                break;
            case MenuUtil.CV_FRAGMENT_CODE : setCVFragment();
                break;
            case MenuUtil.TEAM_FRAGMENT_CODE : setTeamFragment();
                break;
            case MenuUtil.PORTFOLIO_FRAGMENT_CODE : setPortfolioFragment();
                break;
            default:setHomeFragment();
        }

        //punto de menu de seleccion

        menuItems.get(selectedMenuPos).setSelected(false);
        menuItems.get(i).setSelected(true);
        selectedMenuPos = i;
        adapter.notifyDataSetChanged();




    }
}