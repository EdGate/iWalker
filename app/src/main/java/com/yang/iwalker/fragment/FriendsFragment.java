package com.yang.iwalker.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Dataset;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.yang.iwalker.FriendInfoActivity;
import com.yang.iwalker.R;
import com.yang.iwalker.adapter.FriendsAdapter;
import com.yang.iwalker.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class FriendsFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SHOW_TEXT = "text";

    private String mContentText;


    public FriendsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    public static FriendsFragment newInstance(String param1) {
        FriendsFragment fragment = new FriendsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SHOW_TEXT, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContentText = getArguments().getString(ARG_SHOW_TEXT);
        }



    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_friends, container, false);
        TextView contentTv = rootView.findViewById(R.id.content_tv);
        contentTv.setText(mContentText);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TitleBar titlebar = getActivity().findViewById(R.id.navi_friends);

        titlebar.addAction(new TitleBar.ImageAction(R.drawable.ic_action_search2) {
            @Override
            public void performAction(View view) {

                Toast.makeText(getContext(),"搜索好友",Toast.LENGTH_SHORT).show();
            }
        });
        titlebar.addAction(new TitleBar.ImageAction(R.drawable.ic_action_add) {
            @Override
            public void performAction(View view) {
                Toast.makeText(getContext(),"添加好友",Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recycle = getActivity().findViewById(R.id.recycle_friends);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycle.setLayoutManager(layoutManager);
        List<String> datas=new ArrayList<String>();
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");
        datas.add("蔡徐坤");

        FriendsAdapter adatper=new FriendsAdapter(datas);
        adatper.setAct(new FriendsAdapter.Act1() {
            @Override
            public void click() {
                Intent intent=new Intent(getContext(), FriendInfoActivity.class);
                startActivity(intent);
            }
        });
        recycle.setAdapter(adatper);



    }


}
