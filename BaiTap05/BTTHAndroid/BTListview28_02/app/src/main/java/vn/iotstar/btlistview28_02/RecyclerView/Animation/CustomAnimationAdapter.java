package vn.iotstar.btlistview28_02.RecyclerView.Animation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import vn.iotstar.btlistview28_02.R;

public class CustomAnimationAdapter extends RecyclerView.Adapter<CustomAnimationAdapter.ViewHolder> {
    private List<String> mDatas;

    public CustomAnimationAdapter(List<String> mDatas) {
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.row_animation, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item =  mDatas.get(position);
        holder.tvItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addItem(String item){
        mDatas.add(item);
        notifyItemInserted(mDatas.size()-1);
    }
    public void addItem(int position, String item){
        mDatas.add(position, item);
        notifyItemInserted(position);
    }
    public void removeItem(int position){
        mDatas.remove(position);
        notifyItemRemoved(position);
    }
    public void removeItem(String item){
        int index = mDatas.indexOf(item);
        if(index<0){
            return;
        }
        mDatas.remove(index);
        notifyItemRemoved(index);
    }
    public void replaceItem(int position, String item){
        mDatas.remove(position);
        mDatas.add(position, item);
        notifyItemChanged(position);
    }




    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvItem;
        public ViewHolder(final View itemView){
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tv_item);
            itemView.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View view){
                    removeItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(),"Removed Animation", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    replaceItem(getAdapterPosition(),"Item Changed");
                    Toast.makeText(itemView.getContext(),"Changed Animation", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
