package vn.hcmute.fragment_tablayout_viewpaper2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.tabs.TabLayoutMediator;

import vn.hcmute.fragment_tablayout_viewpaper2.adpater.ViewPaper2Adapter;
import vn.hcmute.fragment_tablayout_viewpaper2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ViewPaper2Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new ViewPaper2Adapter(this);
        binding.viewPager2.setAdapter(adapter); // Gán adapter để ViewPager2 hiển thị danh sách Fragment khi lướt

        //Tạo tab và lướt viewPaper2 thì tab cũng luot theo _ Liên kết tab với viewpaper2
        new TabLayoutMediator(binding.tabLayout, binding.viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Đơn mới");
                    break;
                case 1:
                    tab.setText("Đang xử lý");
                    break;
                case 2:
                    tab.setText("Hoàn thành");
                    break;
            }
        }).attach();
    }
}
