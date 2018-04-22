package com.tamaproject.minigames;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tamaproject.C0573R;
import com.tamaproject.util.MiniGameListConstants;

public class MiniGameListActivity extends ListActivity implements MiniGameListConstants {
    static final String[] MINIGAMES = new String[]{MiniGameListConstants.RACING, MiniGameListConstants.TAMANINJA};

    class C05771 implements OnItemClickListener {
        C05771() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            String s = ((TextView) view).getText().toString();
            if (MiniGameListConstants.RACING.equals(s)) {
                MiniGameListActivity.this.startActivity(new Intent(MiniGameListActivity.this, MiniGame.class));
            } else if (MiniGameListConstants.TAMANINJA.equals(s)) {
                MiniGameListActivity.this.startActivity(new Intent(MiniGameListActivity.this, TamaNinja.class));
            }
            Toast.makeText(MiniGameListActivity.this.getApplicationContext(), ((TextView) view).getText(), 0).show();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter(this, C0573R.layout.list, MINIGAMES));
        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new C05771());
    }
}
