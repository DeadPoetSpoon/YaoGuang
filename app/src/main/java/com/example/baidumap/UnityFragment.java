package com.example.baidumap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UnityFragment extends Fragment {
    private Activity mcontext;
    View playerView;

    @Override
    public void onAttach(Context context) {
        mcontext = (Activity) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        playerView = Constants.mUnityPlayer.getView();
        if(playerView.getParent() != null){
            ((ViewGroup)playerView.getParent()).removeAllViews();
        }
        playerView.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean b) {
                Constants.mUnityPlayer.windowFocusChanged(b);
            }
        });
        return playerView;
    }

    @Override
    public void onPause() {
        Constants.mUnityPlayer.pause();
        super.onPause();
    }

    @Override
    public void onResume() {
        Constants.mUnityPlayer.resume();
        super.onResume();
    }
}
