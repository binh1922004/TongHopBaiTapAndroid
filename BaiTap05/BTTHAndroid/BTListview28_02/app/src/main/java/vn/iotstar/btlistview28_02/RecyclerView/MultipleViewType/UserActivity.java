package vn.iotstar.btlistview28_02.RecyclerView.MultipleViewType;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.iotstar.btlistview28_02.R;

public class UserActivity extends AppCompatActivity {
    private RecyclerView rvMultipViewType;
    private List<Object> mdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);
        rvMultipViewType = (RecyclerView) findViewById(R.id.rv_multipe_view_type);
        mdata = new ArrayList<>();
        mdata.add(new UserModel("Trần Trọng Nghĩa", "An Giang"));
        mdata.add(R.drawable.iconuser);
        mdata.add("Đẹp trai");
        mdata.add("Ế :((((");
        mdata.add(new UserModel("Hồ Vũ Thanh Bình", "Đồng Nai"));
        mdata.add(R.drawable.iconuser);
        mdata.add("Text 1");
        mdata.add("Text 0");
        mdata.add(new UserModel("Võ Phú Hào", "Đồng Tháp"));
        mdata.add(R.drawable.iconuser);
        mdata.add("Text 2");
        mdata.add("Text 3");
        CustomAdapter adapter = new CustomAdapter(this, mdata);
        rvMultipViewType.setAdapter(adapter);
        rvMultipViewType.setLayoutManager(new LinearLayoutManager(this));

    }
}