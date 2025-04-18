package vn.hcmute.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.hcmute.R;
import vn.hcmute.adapter.IconAdapter;
import vn.hcmute.decorator.LinePagerIndicatorDecoration;
import vn.hcmute.model.IconModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcIcon;
    private List<IconModel> arrayList1;
    private IconAdapter iconAdapter;

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ánh xạ RecyclerView
        rcIcon = findViewById(R.id.rcIcon);

        // Khởi tạo danh sách icon
        arrayList1 = new ArrayList<>();
        loadIconData();

        // Cấu hình RecyclerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        rcIcon.setLayoutManager(gridLayoutManager);
        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration(this));

        // Thiết lập Adapter
        iconAdapter = new IconAdapter(this, arrayList1);
        rcIcon.setAdapter(iconAdapter);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterListener(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);
                return true;
            }
        });

    }

    // Hàm load dữ liệu vào list
    private void loadIconData() {
        arrayList1.add(new IconModel(R.drawable.icon1, "Khuyến mãi"));
        arrayList1.add(new IconModel(R.drawable.icon2, "Món mới"));
        arrayList1.add(new IconModel(R.drawable.icon3, "Best Seller"));
        arrayList1.add(new IconModel(R.drawable.icon4, "Món Việt"));
        arrayList1.add(new IconModel(R.drawable.icon5, "Món Tây"));
        arrayList1.add(new IconModel(R.drawable.icon6, "Đồ uống"));
        arrayList1.add(new IconModel(R.drawable.icon7, "Bánh ngọt"));
        arrayList1.add(new IconModel(R.drawable.icon8, "Tráng miệng"));
        arrayList1.add(new IconModel(R.drawable.icon9, "Món chay"));
        arrayList1.add(new IconModel(R.drawable.icon1, "Khuyến mãi"));
        arrayList1.add(new IconModel(R.drawable.icon2, "Món mới"));
        arrayList1.add(new IconModel(R.drawable.icon3, "Best Seller"));
        arrayList1.add(new IconModel(R.drawable.icon4, "Món Việt"));
        arrayList1.add(new IconModel(R.drawable.icon5, "Món Tây"));
        arrayList1.add(new IconModel(R.drawable.icon6, "Đồ uống"));
        arrayList1.add(new IconModel(R.drawable.icon7, "Bánh ngọt"));
        arrayList1.add(new IconModel(R.drawable.icon8, "Tráng miệng"));
        arrayList1.add(new IconModel(R.drawable.icon9, "Món chay"));
        arrayList1.add(new IconModel(R.drawable.icon1, "Khuyến mãi"));
        arrayList1.add(new IconModel(R.drawable.icon2, "Món mới"));
        arrayList1.add(new IconModel(R.drawable.icon3, "Best Seller"));
        arrayList1.add(new IconModel(R.drawable.icon4, "Món Việt"));
        arrayList1.add(new IconModel(R.drawable.icon5, "Món Tây"));
        arrayList1.add(new IconModel(R.drawable.icon6, "Đồ uống"));
        arrayList1.add(new IconModel(R.drawable.icon7, "Bánh ngọt"));
        arrayList1.add(new IconModel(R.drawable.icon8, "Tráng miệng"));
        arrayList1.add(new IconModel(R.drawable.icon9, "Món chay"));
    }

    private void filterListener(String text) {
        List<IconModel> list = new ArrayList<>();

        if (text == null || text.trim().isEmpty()) {
            iconAdapter.setListenerList(arrayList1); // Hiển thị toàn bộ danh sách nếu ô tìm kiếm trống
            return;
        }

        for (IconModel iconModel : arrayList1) {
            if (iconModel.getDesc().toLowerCase().contains(text.toLowerCase())) { // Sửa getDecs() thành getDesc()
                list.add(iconModel);
            }
        }


        if (list.isEmpty()) {
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            iconAdapter.setListenerList(list);
        }
    }

}
