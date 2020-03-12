package com.jaymin.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 0= yello , 1= red

    String first,second;

    int activeplayer = 0;

    boolean gia=true;

    int[] gamestate={2,2,2,2,2,2,2,2,2};

    int[][] wp={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playgame(View view)
    {
        EditText e1=(EditText)findViewById(R.id.e1);
        first=e1.getText().toString();

        EditText e2=(EditText)findViewById(R.id.e2);
        second=e2.getText().toString();

        TextView t1=(TextView)findViewById(R.id.fp);
        t1.setText("First Player  : " + first);

        TextView t2=(TextView)findViewById(R.id.sp);
        t2.setText("Second Player : " + second);

        RelativeLayout gamelayout=(RelativeLayout) findViewById(R.id.gamelayout);
        gamelayout.setVisibility(View.VISIBLE);

        RelativeLayout name=(RelativeLayout) findViewById(R.id.name);
        name.setVisibility(View.VISIBLE);

        LinearLayout nam=(LinearLayout) findViewById(R.id.nam);
        nam.setVisibility(View.INVISIBLE);

        LinearLayout rules=(LinearLayout) findViewById(R.id.ruleslayout);
        nam.setVisibility(View.INVISIBLE);
    }

    public void rule(View view)
    {

        RelativeLayout gamelayout=(RelativeLayout) findViewById(R.id.gamelayout);
        gamelayout.setVisibility(View.INVISIBLE);

        RelativeLayout name=(RelativeLayout) findViewById(R.id.name);
        name.setVisibility(View.INVISIBLE);

        LinearLayout nam=(LinearLayout) findViewById(R.id.nam);
        nam.setVisibility(View.INVISIBLE);

        LinearLayout rules=(LinearLayout) findViewById(R.id.ruleslayout);
        rules.setVisibility(View.VISIBLE);

        LinearLayout aboutlayout=(LinearLayout) findViewById(R.id.aboutlayout);
        aboutlayout.setVisibility(View.INVISIBLE);
    }

    public void about(View view)
    {

        RelativeLayout gamelayout=(RelativeLayout) findViewById(R.id.gamelayout);
        gamelayout.setVisibility(View.INVISIBLE);

        RelativeLayout name=(RelativeLayout) findViewById(R.id.name);
        name.setVisibility(View.INVISIBLE);

        LinearLayout nam=(LinearLayout) findViewById(R.id.nam);
        nam.setVisibility(View.INVISIBLE);

        LinearLayout rules=(LinearLayout) findViewById(R.id.ruleslayout);
        rules.setVisibility(View.INVISIBLE);

        LinearLayout aboutlayout=(LinearLayout) findViewById(R.id.aboutlayout);
        aboutlayout.setVisibility(View.VISIBLE);
    }

    public void back(View view)
    {

        RelativeLayout gamelayout=(RelativeLayout) findViewById(R.id.gamelayout);
        gamelayout.setVisibility(View.INVISIBLE);

        RelativeLayout name=(RelativeLayout) findViewById(R.id.name);
        name.setVisibility(View.INVISIBLE);

        LinearLayout nam=(LinearLayout) findViewById(R.id.nam);
        nam.setVisibility(View.VISIBLE);

        LinearLayout rules=(LinearLayout) findViewById(R.id.ruleslayout);
        rules.setVisibility(View.INVISIBLE);

        LinearLayout aboutlayout=(LinearLayout) findViewById(R.id.aboutlayout);
        aboutlayout.setVisibility(View.INVISIBLE);
    }

    public void drop(View view)
    {
        ImageView v=(ImageView) view;

        int tap = Integer.parseInt(v.getTag().toString());

        if(gamestate[tap]==2 && gia)
        {
            v.setTranslationY(-1000f);
            v.setTranslationX(-1000f);

            gamestate[tap]=activeplayer;

            if (activeplayer == 0)
            {
                v.setImageResource(R.drawable.yellow);
                activeplayer = 1;
            }
            else {
                v.setImageResource(R.drawable.red);
                activeplayer = 0;
            }

            v.animate().translationXBy(1000f).translationYBy(1000f).rotationBy(1800).setDuration(250);

            for(int[] w:wp)
            {
                if(gamestate[w[0]]==gamestate[w[1]] && gamestate[w[1]]==gamestate[w[2]] && gamestate[w[0]]!=2)
                {
                    gia = false;
                    TextView win=(TextView)findViewById(R.id.w);

                    String winner=second;

                    if(gamestate[w[0]]==0)
                    {
                        winner=first;
                    }

                    win.setText(winner + " has won");

                    LinearLayout layout=(LinearLayout) findViewById(R.id.pal);
                    layout.setVisibility(View.VISIBLE);

                }
            }
            int flag=0;
            for(int i=0;i<9;i++)
            {
                if(gamestate[i]==2)
                {
                    flag=1;
                    break;
                }
            }

            if(flag==0)
            {
                TextView win=(TextView)findViewById(R.id.w);

                win.setText("Game is draw");

                LinearLayout layout=(LinearLayout) findViewById(R.id.pal);
                layout.setVisibility(View.VISIBLE);
            }
        }
    }

    public void pA(View view)
    {
        gia = true;

        LinearLayout layout=(LinearLayout) findViewById(R.id.pal);
        layout.setVisibility(View.INVISIBLE);

        activeplayer = 0;

        for(int i=0; i < gamestate.length; i++)
        {
            gamestate[i]=2;
        }


        ImageView im1= (ImageView) findViewById(R.id.imageView);
        im1.setImageResource(0);
        ImageView im2= (ImageView) findViewById(R.id.imageView2);
        im2.setImageResource(0);
        ImageView im3= (ImageView) findViewById(R.id.imageView3);
        im3.setImageResource(0);
        ImageView im4= (ImageView) findViewById(R.id.imageView4);
        im4.setImageResource(0);
        ImageView im5= (ImageView) findViewById(R.id.imageView5);
        im5.setImageResource(0);
        ImageView im6= (ImageView) findViewById(R.id.imageView6);
        im6.setImageResource(0);
        ImageView im7= (ImageView) findViewById(R.id.imageView7);
        im7.setImageResource(0);
        ImageView im8= (ImageView) findViewById(R.id.imageView8);
        im8.setImageResource(0);
        ImageView im9= (ImageView) findViewById(R.id.imageView9);
        im9.setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
