package es.b.drawingintoasurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

public class MyBouncingBallSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private BouncingBallAnimationThread bbThread = null;

    //The position of the ball
    int x;
    int y;

    //The vector speed of the ball
    private int xDirection = 20;
    private int yDirection = 40;

    private static int radius = 20;
    private static int ballColor = Color.RED;

    Paint paint = new Paint();
    boolean primerClick = false;





    //Constructores
    public MyBouncingBallSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    public MyBouncingBallSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyBouncingBallSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyBouncingBallSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //Métodos
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (bbThread != null) {
            return;
        }
            bbThread = new BouncingBallAnimationThread(getHolder());
            bbThread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopThread();
    }

    private void stopThread() {
        bbThread.stop = true;
    }


    //To paint into the canvas
    public void newDraw(Canvas canvas){
        paint.setColor(Color.BLACK);
        paint.setColor(ballColor);

        canvas.drawRect(0,0,getWidth(),getHeight(),paint);
        canvas.drawCircle(x,y,radius,paint);
    }

    // The thread to program the animation

    private class BouncingBallAnimationThread extends Thread{
        public boolean stop = false;
        private SurfaceHolder surfaceHolder;

        public BouncingBallAnimationThread(SurfaceHolder surfaceHolder){
            this.surfaceHolder = surfaceHolder;
        }
        public void run(){

        }
    }
}
