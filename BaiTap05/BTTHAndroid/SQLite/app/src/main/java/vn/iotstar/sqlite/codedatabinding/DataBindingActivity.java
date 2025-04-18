package vn.iotstar.sqlite.codedatabinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import vn.iotstar.sqlite.R;
import vn.iotstar.sqlite.databinding.ActivityDatabindingBinding;


public class DataBindingActivity extends AppCompatActivity {

    public ObservableField<String> title= new ObservableField<>();
    private ListUserAdapter listUserAdapter;
    private ActivityDatabindingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView( this, R.layout.activity_databinding);
        title.set("Ví dụ về DataBinding cho RecycleView");
        binding.setHome(this);
        setData();
        binding.rcView.setLayoutManager(new LinearLayoutManager(this));
        binding.rcView.setAdapter(listUserAdapter);
    }
    private void setData() {
        List<User> userList = new ArrayList<>();
        for (int i=0;i<userList.size();i++){
            User user = new User();
            user.setFirstName("Hữu" + 1);
            user.setLastName("Trung" + 1);
            userList.add(user);
        }
        listUserAdapter = new ListUserAdapter(userList);
    }
}