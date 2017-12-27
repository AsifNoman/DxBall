package noman.dx.ball;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class GameControl extends View {

	Paint paint;
	float ballCanvasX=0, ballCanvasY=0 , screenTop = 0 , screenLeft = 0;
	float canvasWidth=0 , canvasHeight=0;
	float brickX = 5 , brickY = 30; 
	ArrayList<Brick> bricks=new ArrayList<Brick>();
	boolean firstTime=true;
	
	Ball ball = null;
	paddle pd = null;
	
	@Override
	public boolean onTouchEvent (MotionEvent event)
	{
		int eventaction = event.getAction();
		
		switch (eventaction) 
		{
          case MotionEvent.ACTION_MOVE:
        	  
          	pd.pdleft = event.getX() + checkBoundary();
			pd.pdtop = canvasHeight-30;
			
            break;
		}
		
	    return true;
	}
	
	public int checkBoundary()
	{
		int value=0;
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		
		if( pd.pdleft >= displayMetrics.widthPixels )
		{
			value = -80;
		}
		else
		{
			value = 5 ;
		}
		
		return value;
	}
	
	protected void onDraw(Canvas canvas) {
		
		if(firstTime==true)
		{
			canvasWidth=canvas.getWidth() ;
			canvasHeight=canvas.getHeight();
			ballCanvasX = canvas.getWidth() / 2;
			ballCanvasY = canvas.getHeight() / 2;
		    screenTop = getHeight();
			screenLeft = getWidth();
			
			ball = new Ball(ballCanvasX,ballCanvasY,paint,canvasWidth,canvasHeight);
			pd = new paddle(screenLeft,screenTop,paint);
			
			for(int i=0; i<10; i++)
			{
				if(brickX>=canvas.getWidth()) 
				{
                    brickX = 5;
                    brickY += 60;
                }
				 
				bricks.add(new Brick(brickX,brickY,brickX+canvas.getWidth()/5-5,brickY+60-5,paint));
                brickX += canvas.getWidth() / 5;
			}
			
			firstTime=false;
			
		}
		
		canvas.drawRGB(255, 255, 255);
		
		 ballCanvasX += ball.dx; 
		 ballCanvasY += ball.dy;
		
		ball.Draw(canvas);
		ball.move(ballCanvasX,ballCanvasY);
		paint.setTextSize(25);
		canvas.drawText("Score: "+Ball.score,canvas.getWidth()/2+90,30,paint);
		canvas.drawText("Life: "+Ball.life,canvas.getWidth()/4-90,30,paint);
		pd.Draw(canvas);
		
		for(int i=0;i<bricks.size();i++){
			bricks.get(i).Draw(canvas);
        }
		
		ball.collisionWithPaddle(pd, canvas);
		ball.collisionWithBrick(bricks, canvas);
		          
		invalidate();
		
		gameOver(canvas);
	}
	
	public void gameOver(Canvas canvas)
	{
		if(Ball.score >= 10 || Ball.life <= 0)
		{
			canvas.drawRGB(255, 255, 255);
			paint.setTextSize(35);
			canvas.drawText("Game Over",canvas.getWidth()/2-80,canvas.getHeight()/2,paint);
		}
	}
	
	public GameControl(Context context) {
		super(context);
		paint = new Paint();
		
	}

}