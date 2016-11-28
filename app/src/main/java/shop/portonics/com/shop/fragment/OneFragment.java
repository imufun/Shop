package shop.portonics.com.shop.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import shop.portonics.com.shop.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {


    GridLayout gridLayout;
    Button btn_GL_1, btn_GL_2, btn_GL_3, btn_GL_4, btn_GL_5, btn_GL_6, btn_GL_7, btn_GL_8, btn_GL_9;

    List<Button> buttons = new ArrayList<>();

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        gridLayout = (GridLayout) view.findViewById(R.id.GridLayoutList);
        btn_GL_1 = (Button) view.findViewById(R.id.btn_GL_1);
        btn_GL_2 = (Button) view.findViewById(R.id.btn_GL_2);
        btn_GL_3 = (Button) view.findViewById(R.id.btn_GL_3);
        btn_GL_4 = (Button) view.findViewById(R.id.btn_GL_4);
        btn_GL_5 = (Button) view.findViewById(R.id.btn_GL_5);
        btn_GL_6 = (Button) view.findViewById(R.id.btn_GL_6);
        btn_GL_7 = (Button) view.findViewById(R.id.btn_GL_7);
        btn_GL_8 = (Button) view.findViewById(R.id.btn_GL_8);
        btn_GL_9 = (Button) view.findViewById(R.id.btn_GL_9);
        // Inflate the layout for this fragment


        btn_GL_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OneFragment oneFragment = new OneFragment();
                oneFragment.reTurnArray();
                btn_GL_1.setText("1");
              //  Toast.makeText(getContext(), "this", Toast.LENGTH_LONG).show();

                //    OneFragment oneFragment = new OneFragment();
                //   oneFragment.reTurnArray();
            }
        });

        return view;
    }


    void reTurnArray() {
        // int[] ints = new int[10];
        int[] ints = new int[]{1, 3, 5, 3, 5, 2, 0, 8, 6, 3};
        for (int i = 0; i < ints.length; i++) {
            Toast.makeText(getContext(), "i", Toast.LENGTH_LONG).show();
            System.out.print(i);
        }


        // int[] Number = new int[]{1, 0, 3, 6, 4, 3, 7};
//        Toast.makeText(getContext(), "this is number + Number + ", Toast.LENGTH_LONG).show();
    }


}
