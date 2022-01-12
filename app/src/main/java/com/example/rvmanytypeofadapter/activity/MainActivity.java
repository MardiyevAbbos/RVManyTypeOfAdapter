package com.example.rvmanytypeofadapter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.rvmanytypeofadapter.R;
import com.example.rvmanytypeofadapter.adapter.MemberAdapter;
import com.example.rvmanytypeofadapter.model.Member;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<Member> members = getMembers();
        refreshAdapter(members);
    }

    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    private void refreshAdapter(ArrayList<Member> members) {
        MemberAdapter adapter = new MemberAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Member> getMembers() {
        ArrayList<Member> members = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            if (i == 4 || i == 8 || i == 12 || i == 16 || i == 20 || i == 24) {
                members.add(new Member("Abbos" + i, "Mardiyev" + i, false));
            } else {
                members.add(new Member("Abbos" + i, "Mardiyev" + i, true));
            }
        }
        return members;
    }

}