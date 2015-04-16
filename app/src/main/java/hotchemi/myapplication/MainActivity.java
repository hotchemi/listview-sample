package hotchemi.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private static final int ITEM_SIZE = 10;

    private ListView listView;

    private ArrayAdapter<String> adapter;

    private Button buttonA;

    private Button buttonB;

    private Button buttonC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, createItems(ITEM_SIZE));
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    void setUpView() {
        listView = (ListView) findViewById(R.id.list_view);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
    }

    static List<String> createItems(int number) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonA:
                adapter.addAll(createItems(ITEM_SIZE));
                break;
            case R.id.buttonB:
                adapter.clear();
                break;
            case R.id.buttonC:
                String item = adapter.getItem(adapter.getCount() - 1);
                adapter.remove(item);
        }

    }

}
