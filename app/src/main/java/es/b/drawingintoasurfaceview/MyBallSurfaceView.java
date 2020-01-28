package es.b.drawingintoasurfaceview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

public class MyBallSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    //Constructores
    public MyBallSurfaceView(Context context) {
        super(context);
    }

    public MyBallSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyBallSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyBallSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //Metodos
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private class MyAnimationThread extends Thread{
        private SurfaceHolder surfaceHolder;
        //Constructor
        public MyAnimationThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
        }

    }
}
