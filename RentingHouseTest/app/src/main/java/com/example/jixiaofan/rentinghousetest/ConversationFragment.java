package com.example.jixiaofan.rentinghousetest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jixiaofan on 2022/7/10.
 */

public class ConversationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.conversation_frag, container, false);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.conversation_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        final List<Msg> msgList = initMsgs();
        final ConversationFragment.ConversationAdapter conversationAdapter = new ConversationFragment.ConversationAdapter(msgList);
        recyclerView.setAdapter(conversationAdapter);
        final EditText inputText = (EditText) view.findViewById(R.id.input_text);
        Button send = (Button) view.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content,Msg.TYPR_SEND);
                    msgList.add(msg);
                    conversationAdapter.notifyItemInserted(msgList.size() - 1);
                    recyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                }
            }
        });
        return view;
    }

    private List<Msg> initMsgs() {
        List<Msg> msgList = new ArrayList<>();
        Msg msg1 = new Msg("你好，一起合租吗？", Msg.TYPE_RECEVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("是的，这套房目前有几个人合租？", Msg.TYPR_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("目前有两个人了。", Msg.TYPE_RECEVED);
        msgList.add(msg3);
        return msgList;
    }

    class ConversationAdapter extends RecyclerView.Adapter<ConversationFragment.ConversationAdapter.ViewHolder> {

        private List<Msg> mMsgList;

        class ViewHolder extends RecyclerView.ViewHolder{

            LinearLayout leftLayout;
            LinearLayout rightLayout;
            TextView leftMsg;
            TextView rightMsg;

            public ViewHolder (View view) {
                super(view);
                leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
                rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
                leftMsg = (TextView) view.findViewById(R.id.left_msg);
                rightMsg = (TextView) view.findViewById(R.id.right_msg);
            }
        }

        public ConversationAdapter(List<Msg> msgList) {
            mMsgList = msgList;
        }

        @Override
        public ConversationFragment.ConversationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conversation_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ConversationFragment.ConversationAdapter.ViewHolder holder, int position) {
            Msg msg = mMsgList.get(position);
            if (msg.getType() == Msg.TYPE_RECEVED) {
                holder.leftLayout.setVisibility(View.VISIBLE);
                holder.rightLayout.setVisibility(View.GONE);
                holder.leftMsg.setText(msg.getContent());
            }
            if (msg.getType() == Msg.TYPR_SEND) {
                holder.leftLayout.setVisibility(View.GONE);
                holder.rightLayout.setVisibility(View.VISIBLE);
                holder.rightMsg.setText(msg.getContent());
            }
        }


        @Override
        public int getItemCount() {
            return mMsgList.size();
        }
    }
}
