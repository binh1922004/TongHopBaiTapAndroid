package vn.iotstar.btlistview28_02.RecyclerView.Animation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.iotstar.btlistview28_02.R;

public class AnimationActivity extends AppCompatActivity {
    private Button btnAddItem;
    private RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animation);
        btnAddItem = (Button) findViewById(R.id.btn_add_item);
        rvItems = (RecyclerView) findViewById(R.id.rv_items);
        List<String> data = new ArrayList<>();
        for(int i = 0; i<5; i++){
            data.add("item" + i);
        }
        final CustomAnimationAdapter adapter = new CustomAnimationAdapter(data);
        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));
        //Set ItemAnimator for RecylerView
        rvItems.setItemAnimator(new DefaultItemAnimator());
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem("new Item");
                rvItems.scrollToPosition(adapter.getItemCount()-1);
            }
        });

    }
}