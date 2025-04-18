package vn.iotstar.btlistview28_02.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

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

public class RecylerViewActivity extends AppCompatActivity {
    private RecyclerView rvSongs;
    private SongAdapter mSongAdapter;
    private List<SongModel> mSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recyler_view);
        rvSongs = findViewById(R.id.rv_items);
        mSongs = new ArrayList<>();
        mSongs.add(new SongModel("98765", "CHUYỆN TÌNH TÔI", "Tiếng chuông vang bên tay có một dòng thư gửi đến", "Đăng Khoa ft.KayTran"));
        mSongs.add(new SongModel("37001", "MẤT KẾT NỐI", "Ta mất nhau thật rồi em ơi", "Dương Domic"));
        mSongs.add(new SongModel("98713", "THIỆP HỒNG NGƯỜI DƯNG", "Ngậm ngùi nước mắt nghe tin cô theo chồng", "Phát Hồ"));
        mSongs.add(new SongModel("98712", "NƠI NÀY CÓ ANH", "Em là ai từ đâu bước đến nơi đây", "Sơn Tùng MTP"));
        mSongs.add(new SongModel("12345", "HỒN QUÊ", "Xa xa ánh mắt ai như đang chờ mong", "Đan Trường"));
        mSongs.add(new SongModel("67890", "EM CỦA NGÀY HÔM QUA", "Đừng vội vàng em hãy là em của ngày hôm qua", "Sơn Tùng MTP"));
        mSongs.add(new SongModel("54321", "CÓ CHÀNG TRAI VIẾT LÊN CÂY", "Có chàng trai viết lên cây, lời yêu thương cô gái ấy", "Phan Mạnh Quỳnh"));
        mSongs.add(new SongModel("11223", "GẶP NHƯ CHƯA TỪNG QUEN", "Gặp lại nhau nhưng ta đã khác xưa rồi", "Vương Anh Tú"));
        mSongs.add(new SongModel("33445", "LẠC TRÔI", "Bầu trời dường như có những ánh sao đổi ngôi", "Sơn Tùng MTP"));
        mSongs.add(new SongModel("55667", "THƯƠNG EM", "Anh thương em hơn chính anh cuộc đời này", "Châu Khải Phong"));
        mSongAdapter = new SongAdapter(this, mSongs);
        rvSongs.setAdapter(mSongAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvSongs.setLayoutManager(linearLayoutManager);

    }
}