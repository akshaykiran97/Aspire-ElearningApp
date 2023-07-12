package com.akshay.aspire;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.myViewHolder> {
    List<Message> messageList;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatview= LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,null);
        myViewHolder myViewHolder=new myViewHolder(chatview);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Message message=messageList.get(position);
        if(message.getSendby().equals(message.SENT_BY_ME)){
            holder.leftchatview.setVisibility(View.GONE);
            holder.rightchatview.setVisibility(View.VISIBLE);
            holder.righttextview.setText(message.getMessage());

        }
        else {
            holder.rightchatview.setVisibility(View.GONE);
            holder.leftchatview.setVisibility(View.VISIBLE);
            holder.lefttextview.setText(message.getMessage());

        }

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftchatview,rightchatview;
        TextView lefttextview,righttextview;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            leftchatview=itemView.findViewById(R.id.left_chat_view);
            rightchatview=itemView.findViewById(R.id.right_chat_view);
            lefttextview=itemView.findViewById(R.id.left_chat_text_view);
            righttextview=itemView.findViewById(R.id.right_chat_text_view);

        }
    }

}
