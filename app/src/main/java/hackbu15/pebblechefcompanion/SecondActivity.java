/* Copyright by Doris Wong and Kevin Varughese 2015 */

package hackbu15.pebblechefcompanion;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SecondActivity extends ActionBarActivity implements IPebbleReceiver{

    private PebbleConn conn;
    ArrayList<PebbleMessage> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        PebbleMessage message = new PebbleMessage();
        message.setSequence((byte) 1);
        message.setTitle("Step 1:");
        message.setDescription("Preheat oven to 450 degrees Fahrenheit");
        message.setMore((byte) 0);
        list.add(message);
        message = new PebbleMessage();
        message.setSequence((byte)2);
        message.setTitle("Step 2:");
        message.setDescription("Melt chocolate in a double broiler");
        message.setMore((byte) 0);
        list.add(message);
        message = new PebbleMessage();
        message.setSequence((byte)3);
        message.setTitle("Step 3:");
        message.setDescription("Cream butter and sugar");
        message.setMore((byte) 0);
        list.add(message);
        message = new PebbleMessage();
        message.setSequence((byte)4);
        message.setTitle("Step 4:");
        message.setDescription("Mix in eggs and flour");
        message.setMore((byte) 0);
        list.add(message);
        message = new PebbleMessage();
        message.setSequence((byte)5);
        message.setTitle("Step 5:");
        message.setDescription("Stir in the chocolate mixture");
        message.setMore((byte) 0);
        list.add(message);
        message = new PebbleMessage();
        message.setSequence((byte) 6);
        message.setTitle("Step 6:");
        message.setDescription("Pour into cake pan and bake for 10 minutes");
        message.setDuration("600");
        message.setMore((byte) 0);
        list.add(message);

        Button button = (Button) findViewById(R.id.sendPebbleButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conn.sendMessage(list.get(0));
            }
        });
        conn = new PebbleConn(this);
        conn.setPebbleMessageListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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

    @Override
    public void onReceive(PebbleMessage message) {
        byte seq = message.getSequence();
        int i = seq - 1;
        if ((i > 0) && (i < list.size())) {
            PebbleMessage m = list.get(i);
            conn.sendMessage(m);
        }
    }
}
