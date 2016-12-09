package arekusanda.lyrical.aplicaciodadb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, GatActivity.class);
        //startActivity(intent);
        intent = new Intent(MainActivity.this, ColoniaActivity.class);
        //startActivity(intent);


        init();
    }

    private void init() {
        Button list_gats, list_colonies;
        list_gats = (Button) findViewById(R.id.bt_list_gats);
        list_colonies = (Button) findViewById(R.id.bt_list_colonies);

        list_gats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListGatsActivity.class);
                startActivity(intent);
            }
        });

        list_colonies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListColoniesActivity.class);
                startActivity(intent);
            }
        });
    }
}
