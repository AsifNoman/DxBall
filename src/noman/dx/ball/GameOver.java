package noman.dx.ball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class GameOver extends View {

	Paint paint;
	float x=0,y=0;
	boolean firstTime=true;
	
	protected void onDraw(Canvas canvas) {
		
		if(firstTime)
		{
			firstTime=false;
			x=canvas.getWidth() / 2;
			y=canvas.getHeight() / 2;
		}
		
		canvas.drawRGB(255, 255, 255);
		paint.setTextSize(35);
		canvas.drawText("Game Over",canvas.getWidth()/2-80,canvas.getHeight()/2,paint);
		paint.setColor(Color.RED);
		paint.setStyle(Style.FILL);
		invalidate();
	}
	
	public GameOver(Context context) {
		super(context);
		paint = new Paint();
		
	}
}
