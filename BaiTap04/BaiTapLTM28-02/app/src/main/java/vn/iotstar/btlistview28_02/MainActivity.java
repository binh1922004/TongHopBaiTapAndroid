package vn.iotstar.btlistview28_02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import vn.iotstar.btlistview28_02.GridView.GridViewActivity;
import vn.iotstar.btlistview28_02.ListView.ListviewActivity;
import vn.iotstar.btlistview28_02.RecyclerView.Animation.AnimationActivity;
import vn.iotstar.btlistview28_02.RecyclerView.MultipleViewType.UserActivity;
import vn.iotstar.btlistview28_02.RecyclerView.RecylerViewActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_Listview, btn_Gridview, btn_Recylerview, btn_mulRecylerview,
        btn_animationRc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn_Listview = findViewById(R.id.btn_listview);
        btn_Listview.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
            startActivity(intent);
        });
        btn_Gridview = findViewById(R.id.btn_gridview);
        btn_Gridview.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
            startActivity(intent);
        });
        btn_Recylerview = findViewById(R.id.btn_recylerview);
        btn_Recylerview.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RecylerViewActivity.class);
            startActivity(intent);
        });

        btn_mulRecylerview = findViewById(R.id.btn_mtbRecyview);
        btn_mulRecylerview.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UserActivity.class);
            startActivity(intent);
        });
        btn_animationRc = findViewById(R.id.btn_animation);
        btn_animationRc.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
            startActivity(intent);
        });
    }
}