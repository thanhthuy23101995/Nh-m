package com.example.blue.gasbuy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.blue.gasbuy.Activity.SanPhamActivity;
import com.example.blue.gasbuy.Adapter.DSSanPhamAdapter;
import com.example.blue.gasbuy.R;
import com.example.blue.gasbuy.SanPham;

import java.util.List;

/**
 * Created by blue on 23/02/2017.
 */

public class SanPhamfragment extends Fragment {
    private static List<SanPham> arrSanpham;

    public SanPhamfragment() {
    }

    public void setArrSanpham(List<SanPham> arrSanpham) {
        this.arrSanpham = arrSanpham;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_san_pham, container, false);
        DSSanPhamAdapter sanPhamAdapter = new DSSanPhamAdapter(getContext(), R.layout.grid_sanpham, arrSanpham);
        GridView gridView = (GridView) rootView.findViewById(R.id.grid_SanPham);
        gridView.setAdapter(sanPhamAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), SanPhamActivity.class);
                int idm = arrSanpham.get(position).getId();
                intent.putExtra("logic",false);
                intent.putExtra("key", idm);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
