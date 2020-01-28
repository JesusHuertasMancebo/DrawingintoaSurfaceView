package es.b.drawingintoasurfaceview;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class MyBouncingBallActivity extends MainMenu {

    public static MyBouncingBallSurfaceView myBouncingBallSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_bouncing_ball);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myBouncingBallSurfaceView = new MyBouncingBallSurfaceView(this);
        setContentView(myBouncingBallSurfaceView);

    }

}
