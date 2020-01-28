package es.b.drawingintoasurfaceview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

public class MyBallSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    //Radi del crecle
    int radius = 50;
    //Moving the cercle
    //Initial values for the starting coordinates
    int x = 50;
    int y = 50;

    //The thread to control the animation
    private MyAnimationThread animationThread = null;

    //Constructores
    public MyBallSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
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
    public void newDraw(Canvas canvas){
        int widht = canvas.getWidth();
        int height = canvas.getHeight();
        int middleW = widht / 2;
        int middleH = height / 2;
        canvas.drawColor(Color.WHITE);
        Paint circle = new Paint();
        circle.setColor(Color.BLUE);
        circle.setStyle(Paint.Style.FILL);
        //canvas.drawCircle(middleW,middleH,radius,circle);
        canvas.drawCircle(x,y,radius,circle);
    }
    public boolean onTouchEvent(MotionEvent motionEvent){
        float currentDown;
        float currentUp;

        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:{
                if (radius<100){
                    radius = radius + 20;
                }else {
                    radius = 10;
                }

                x = (int) motionEvent.getX();
                y = (int) motionEvent.getY();
                break;
            }
        }

        return true;
    }

    //Metodos
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (animationThread!=null){
            return;
        }
        animationThread = new MyAnimationThread(getHolder());
        animationThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopThread();

    }

    private void stopThread() {
        animationThread.stop = true;
    }

    private class MyAnimationThread extends Thread{
        public boolean stop = false;
        private SurfaceHolder surfaceHolder;
        //Constructor
        public MyAnimationThread(SurfaceHolder surfaceHolder) {
            this.surfaceHolder = surfaceHolder;
        }
        public void run(){
            //Thread operations
            while (!stop){
                // TODO: New values for the attributes: position, colors, ...
                // New painting on the canvas
                Canvas c = null;
                try {// Getting the canvas for drawing
                    c = surfaceHolder.lockCanvas(null);
                    //Drawing into the canvas
                    synchronized (surfaceHolder){
                        newDraw(c);
                    }
                }finally {// Showing the canvas on the screen
                    if(c != null){
                        surfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }
        }

    }
}
