package vn.hcmute.baitap5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.hcmute.baitap5.MainActivity;
import vn.hcmute.baitap5.R;
import vn.hcmute.baitap5.model.NotesModel;

public class NotesAdapter extends BaseAdapter {
    private MainActivity context; //Truyen goi ham update diaglog
    private int layout;
    private ArrayList<NotesModel> noteList;

    public NotesAdapter(MainActivity context, int layout, ArrayList<NotesModel> notes) {
        this.context = context;
        this.layout = layout;
        this.noteList = notes;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewHolder.textViewNote = (TextView) convertView.findViewById(R.id.textViewNameNote);
            viewHolder.imageViewEdit = (ImageView) convertView.findViewById(R.id.imageViewEdit);
            viewHolder.imageViewDelete = (ImageView) convertView.findViewById(R.id.imageViewDelete);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final NotesModel note = noteList.get(position);
        viewHolder.textViewNote.setText(note.getNameNote());
        viewHolder.imageViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
                //Goi dialog trong mainActivity
                context.DialogUpdateTheme(note.getNameNote(),note.getIdNote());
            }
        });
        viewHolder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogDeleteTheme(note.getNameNote(),note.getIdNote());
            }
        });
        return convertView;
    }

    private class ViewHolder{
        TextView textViewNote;
        ImageView imageViewEdit;
        ImageView imageViewDelete;
    }
}
