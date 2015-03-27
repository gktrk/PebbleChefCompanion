/* Copyright by Doris Wong and Kevin Varughese 2015 */

package hackbu15.pebblechefcompanion;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Activity main_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_activity = this;

        //Sets up tabs
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("myRecipes");
        tabSpec.setContent(R.id.myRecipesTab);
        tabSpec.setIndicator("My Recipes");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("searchRecipes");
        tabSpec.setContent(R.id.searchRecipesTab);
        tabSpec.setIndicator("Search Recipes");
        tabHost.addTab(tabSpec);

        //Buttons!
        Button chocoRecipeButton = (Button)findViewById(R.id.recipe1Button);
        Button soupRecipeButton = (Button) findViewById(R.id.recipe2Button);

        chocoRecipeButton.setOnClickListener(this);
        soupRecipeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        //System.out.println(b.getText().toString());
        //System.out.println(b.getId());
        if (b.getId()==2131296323)
        {Intent intent;
         intent = new Intent(main_activity, ThirdActivity.class);
         main_activity.startActivity(intent);}
        else
        {Intent intent;
        intent = new Intent(main_activity, SecondActivity.class);
        main_activity.startActivity(intent);}


    }
}


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}*/
