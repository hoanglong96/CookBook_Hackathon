package com.example.rufflez.Cookbook.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rufflez.Cookbook.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by HoangLong on 7/1/2017.
 */

public class NguyenLieuFragment extends Fragment{

    private ListView mListView;
    private TextView mTextView;
    private RelativeLayout mRelativeLayout;
    private Button btnCheckAll;
    private boolean isCheckAll;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_nguyen_lieu, container, false);
        mListView = (ListView) rootView.findViewById(R.id.lv);
        mTextView = (TextView) rootView.findViewById(R.id.tv);
        mRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.rl);
        btnCheckAll = rootView.findViewById(R.id.btn_check_all);

        btnCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCheckAll){
                    for ( int i=0; i < mListView.getChildCount(); i++) {
                        mListView.setItemChecked(i, false);
                    }
                    btnCheckAll.setText("Chọn tất cả");
                    isCheckAll = false;
                }else{
                    for ( int i=0; i < mListView.getChildCount(); i++) {
                        mListView.setItemChecked(i, true);
                    }
                    btnCheckAll.setText("Bỏ tất cả");
                    isCheckAll = true;
                }
            }
        });

        List<String> trees = Arrays.asList(
                "7-8 lạng gà ta",
                "50ml mật ong rừng",
                "Nước mắm",
                "Mì chính",
                "Hạt tiêu",
                "Tỏi khô",
                "Gừng tươi băm nhỏ",
                "Bột mỳ",
                "Ớt tươi",
                "Dầu ăn"
        );

        ArrayAdapter<String> adapter = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_multiple_choice,
                trees
        );

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray clickedItemPositions = mListView.getCheckedItemPositions();
                mTextView.setText("Nguyên liệu đã chọn - ");
                for(int index=0;index<clickedItemPositions.size();index++) {
                    // Get the checked status of the current item
                    boolean checked = clickedItemPositions.valueAt(index);

                    if (checked) {
                        // If the current item is checked
                        int key = clickedItemPositions.keyAt(index);
                        String item = (String) mListView.getItemAtPosition(key);

                        // Display the checked items on TextView
                        mTextView.setText(mTextView.getText() + item + " | ");
                    }
                }
            }
        });

        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
