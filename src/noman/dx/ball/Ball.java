package noman.dx.ball;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Ball implements Drawable {
	
	float ballx=0, bally=0,radius=20, ballxx = 0 , ballyy = 0, dx=-10,dy=-10;
	public static float	score=0,life = 4;
	Paint paint;
	
	public Ball( float cx , float cy , Paint cp , float cw , float ch  )
	{
		this.ballx = cx;
		this.bally = cy;
		this.ballxx = cw;
		this.ballyy = ch;
		this.paint = cp;
	}

	public void Draw(Canvas canvas) 
	{
		if (canvas == null || paint == null) 
		{
			return;
		}
		
		 canvas.drawCircle(ballx, bally, radius, paint);
		 paint.setColor(Color.RED);
		 paint.setStyle(Style.FILL);
	}
	
	public void move(float mx , float my)
	{
		this.ballx=mx;
		this.bally=my;
		
		if(ballx == radius) //left 
		{
			dx=-dx;
		}
		if(bally == radius) //top
		{
			dy=-dy;
		}
		if(ballx == (ballxx-radius)) //right
		{
			dx=-dx;
		}
		if(bally == (ballyy-radius)) //bottom
		{
			dy=-dy;
			life--;
		}
		
	}
	
	public void collisionWithPaddle( paddle pd , Canvas canvas )
	{
		float X = (this.ballx < pd.pdleft ? pd.pdleft : (this.ballx > pd.pdleft+width  ? pd.pdleft+width : this.ballx));
		float Y = (this.bally < pd.pdtop ? pd.pdtop : (this.bally > pd.pdtop+height ? pd.pdtop+height: this.bally));
		float dxx = X - ballx;
		float dyy = Y - bally;
		
		float dis = (dxx * dxx) + (dyy * dyy);
		
		if (dis  < (this.radius * this.radius)) 
		{
            dy = -this.dy;
        }
	}
	
	public void collisionWithBrick(ArrayList<Brick> brcs , Canvas canvas)
	{
		for( int i=0;i<brcs.size();i++ )
		{
			if( this.ballx >= brcs.get(i).brleft && (this.bally + this.radius) >= brcs.get(i).brtop && 
				this.ballx <= brcs.get(i).brright && (this.bally - this.radius) <= brcs.get(i).brbottom	)
			{
				brcs.remove(i);
	            score++;
	            dy=-dy;
			}
		}
	}

}
