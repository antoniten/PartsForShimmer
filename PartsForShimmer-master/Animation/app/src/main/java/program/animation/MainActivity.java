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
import android.widget.ImageButton;
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

        final ImageButton image = (ImageButton) findViewById(R.id.image);
        final ImageButton imager = (ImageButton) findViewById(R.id.imager);
        final Handler handler = new Handler();

        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.image:
                        final Animation anim = AnimationUtils.loadAnimation(
                                getApplicationContext(), R.anim.crazycat);
                        image.startAnimation(anim);

                        final  Animation animt = AnimationUtils.loadAnimation(
                                getApplicationContext(), R.anim.falling_down);

                handler.postDelayed(new Runnable() {
                    public void run() {

                        mConstraintLayout.setBackgroundColor(ContextCompat
                                .getColor(MainActivity.this, R.color.colorBlue));
                        imager.setBackgroundColor(ContextCompat
                                .getColor(MainActivity.this, R.color.colorBlue));
                        image.setVisibility(View.GONE);
                        imager.setVisibility(View.VISIBLE);
                        imager.startAnimation(animt);
                    }
                }, 3000);

                break;
                        case R.id.imager:

                            final Animation animm = AnimationUtils.loadAnimation(
                                    getApplicationContext(), R.anim.crazycat);

                            imager.startAnimation(animm);
                            final  Animation animtt = AnimationUtils.loadAnimation(
                                    getApplicationContext(), R.anim.falling_down);


                            handler.postDelayed(new Runnable() {
                                public void run() {

                                    mConstraintLayout.setBackgroundColor(ContextCompat
                                            .getColor(MainActivity.this, R.color.colorWhite));
                                    imager.setVisibility(View.GONE);
                                    image.setVisibility(View.VISIBLE);
                                    image.startAnimation(animtt);
                                }
                            }, 3000);

                            break;
            }
            }

        });
    }


}
