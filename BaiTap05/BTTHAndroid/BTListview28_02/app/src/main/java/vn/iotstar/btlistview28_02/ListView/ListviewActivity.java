package vn.iotstar.btlistview28_02.ListView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import vn.iotstar.btlistview28_02.R;

public class ListviewActivity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    ListView listView;
    EditText editTextName;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listview);
        listView = findViewById(R.id.listView);
        editTextName = findViewById(R.id.editTextName);
        buttonAdd = findViewById(R.id.buttonAdd);


        int[] imageList = {R.drawable.cake, R.drawable.burger, R.drawable.maggi, R.drawable.fries};
        String[] nameList = {"Cake", "Burger", "Maggi", "Fries"};
        for(int i = 0 ; i<imageList.length; i++){
            listData= new ListData(nameList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(ListviewActivity.this, dataArrayList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                if(!name.isEmpty()){
                    ListData newItem = new ListData(name, R.drawable.burger);
                    dataArrayList.add(newItem);
                    listAdapter.notifyDataSetChanged();
                    editTextName.setText("");
                }
            }
            });
    }
}