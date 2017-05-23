package program.animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends Activity {
    private Timer mTimer;
    private LinearLayout mConstraintLayout;
int i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConstraintLayout = (LinearLayout) findViewById(R.id.constraintLayout);

        final ImageView image = (ImageView) findViewById(R.id.image);
        final ImageView imager = (ImageView) findViewById(R.id.imager);
        final Button btnStart = (Button) findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Animation anim = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.crazycat);
                image.startAnimation(anim);

              final  Animation animt = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.falling_down);


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {

                        mConstraintLayout.setBackgroundColor(ContextCompat
                                .getColor(MainActivity.this, R.color.colorBlue));
                        image.setVisibility(View.GONE);
                        imager.setVisibility(View.VISIBLE);
                        imager.startAnimation(animt);
                    }
                }, 3000);

            }
        });
    }


}
