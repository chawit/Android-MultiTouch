package com.example.multitouch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.multitouch.databinding.FragmentFirstBinding;
import android.widget.RelativeLayout;
import android.widget.TextView;
public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //RelativeLayout mylayout = (RelativeLayout)getView().findViewById(R.id.FirstFragment);

         binding.getRoot().setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View view, MotionEvent motionEvent) {
                 handleTouch(motionEvent);
                 return true;
             }
         });
        /*
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        */

    }
    void handleTouch(MotionEvent m){
        TextView text1 = (TextView)getView().findViewById(R.id.textView1);
        TextView text2 = (TextView)getView().findViewById(R.id.textView2);

        int poiterCount = m.getPointerCount();

        for(int i=0; i<poiterCount;i++){
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);

            String touchStatus = " ID "+id+" X: "+x+"Y: "+y;

            if(id==0){
                text1.setText(touchStatus);
            }else{
                text2.setText(touchStatus);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}