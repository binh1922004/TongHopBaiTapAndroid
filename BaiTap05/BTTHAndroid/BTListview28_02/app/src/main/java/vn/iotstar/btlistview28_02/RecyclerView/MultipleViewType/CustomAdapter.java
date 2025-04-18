package vn.iotstar.btlistview28_02.RecyclerView.MultipleViewType;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.iotstar.btlistview28_02.R;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Object> mOjects;
    public static final int TEXT =0 ;
    public static final int IMAGE =1 ;
    public static final int USER =2 ;

    public CustomAdapter(Context mContext, List<Object> mOjects) {
        this.mContext = mContext;
        this.mOjects = mOjects;
    }
    @Override
    public int getItemViewType (int position) {
        if (mOjects.get(position) instanceof String)
            return TEXT;
        else if (mOjects.get(position) instanceof Integer)
            return IMAGE;
        else if (mOjects.get(position) instanceof UserModel)
            return USER;
        return -1;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(mContext);
        switch (viewType){
            case TEXT:
                View itemView0 = li.inflate(R.layout.row_text, parent, false);
                return new TextViewHolder(itemView0);
            case IMAGE:
                View itemView1 = li.inflate(R.layout.row_image, parent, false);
                return new ImageViewHolder(itemView1);
            case USER:
                View itemView2 = li.inflate(R.layout.row_user, parent, false);
                return new UserViewHolder(itemView2);
            default:
                break;

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TEXT:
                TextViewHolder textViewHolder = (TextViewHolder) holder;
                textViewHolder.tvText.setText(mOjects.get(position).toString());
                break;
            case IMAGE:
                ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
                imageViewHolder.imvImage.setImageResource((int) mOjects.get(position));
                break;
            case USER:
                UserModel user = (UserModel) mOjects.get(position);
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                userViewHolder.tvName.setText(user.getName());
                userViewHolder.tvAdress.setText(user.getAddress());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mOjects.size();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder{
        private TextView tvText;
        public TextViewHolder(View itemView){
            super(itemView);
            tvText = (TextView) itemView.findViewById(R.id.tv_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*Toast.makeText(mContext, mOjects.get(getAdapterPosition()).toString(),Toast.LENGTH_SHORT).show();*/
                }
            });
        }
    }
    public class ImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView imvImage;
        public ImageViewHolder(View itemView){
            super(itemView);
                imvImage = (ImageView) itemView.findViewById(R.id.imv_image);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*Toast.makeText(mContext, mOjects.get(getAdapterPosition()).toString(),Toast.LENGTH_SHORT).show();*/
                    }
                });
        }
    }
    public class UserViewHolder extends  RecyclerView.ViewHolder{
        private TextView tvName, tvAdress;
        public UserViewHolder (View itemView){
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvAdress = (TextView) itemView.findViewById(R.id.tv_address);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UserModel user = (UserModel) mOjects.get(getAdapterPosition());
                    /*Toast.makeText(mContext,user.getName() + ", " +user.getAddress(), Toast.LENGTH_SHORT).show();*/
                }
            });
        }

    }




}
