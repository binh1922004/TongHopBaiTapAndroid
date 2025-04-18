package vn.iotstar.btlistview28_02.GridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.iotstar.btlistview28_02.R;

public class MonHocAdapter extends BaseAdapter {

    //khai báo
    private Context context;
    private int layout;
    private List<MonHoc> monHocList;

    public MonHocAdapter(Context context, int layout, List<MonHoc> monHocList) {
        this.monHocList = monHocList;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return monHocList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //lấy context
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //gọi view chứa layout
        view = inflater.inflate(R.layout.row_monhoc,null);
        //ánh xạ view
        TextView textName = (TextView) view.findViewById(R.id.textView3);
        TextView textDesc = (TextView) view.findViewById(R.id.textView4);
        ImageView imagePic = (ImageView) view.findViewById(R.id.imageView);
        //gán giá trị
        MonHoc monHoc = monHocList.get(i);
        textName.setText(monHoc.getName());
        textDesc.setText(monHoc.getDecs());
        imagePic.setImageResource(monHoc.getPic());
        //trả về view
        return view;
    }
}
