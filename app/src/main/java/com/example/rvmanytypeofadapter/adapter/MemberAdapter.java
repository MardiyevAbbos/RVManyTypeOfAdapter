package com.example.rvmanytypeofadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rvmanytypeofadapter.R;
import com.example.rvmanytypeofadapter.model.Member;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_AVAILABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NO = 1;

    private Context context;
    private ArrayList<Member> members;

    public MemberAdapter(Context context, ArrayList<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        Member member = members.get(position);
        if (member.isAvailable()) {
            return TYPE_AVAILABLE_YES;
        } else {
            return TYPE_AVAILABLE_NO;
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_AVAILABLE_YES) {
            View viewYes = LayoutInflater.from(context).inflate(R.layout.item_member_layout_yes, parent, false);
            return new MemberViewYesHolder(viewYes);
        }

        View viewNo = LayoutInflater.from(context).inflate(R.layout.item_member_layout_no, parent, false);
        return new MemberViewNotHolder(viewNo);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
        if (holder instanceof MemberViewYesHolder) {
            TextView firstN = ((MemberViewYesHolder) holder).firstName;
            TextView lastN = ((MemberViewYesHolder) holder).lastName;

            firstN.setText(member.getFirstName());
            lastN.setText(member.getLastName());
        }

        if (holder instanceof MemberViewNotHolder) {
            TextView firstN = ((MemberViewNotHolder) holder).firstName;
            TextView lastN = ((MemberViewNotHolder) holder).lastName;

            firstN.setText(member.getFirstName());
            lastN.setText(member.getLastName());
        }

    }


    private class MemberViewYesHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView firstName;
        public TextView lastName;

        MemberViewYesHolder(View v) {
            super(v);
            this.view = v;
            firstName = view.findViewById(R.id.first_name_yes);
            lastName = view.findViewById(R.id.last_name_yes);
        }
    }

    private class MemberViewNotHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView firstName;
        public TextView lastName;

        MemberViewNotHolder(View v) {
            super(v);
            this.view = v;
            firstName = view.findViewById(R.id.first_name_no);
            lastName = view.findViewById(R.id.last_name_no);
        }
    }

}
