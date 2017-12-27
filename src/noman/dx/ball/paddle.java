package noman.dx.ball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class paddle implements Drawable{
	
	float pdleft=0, pdtop=0;
	Paint paint;
	
	public paddle( float lft, float tp , Paint p) {
		this.pdleft=lft;
		this.pdtop=tp;
		this.paint = p;
	}
	
	public void Draw(Canvas canvas) 
	{
       canvas.drawRect(pdleft, pdtop, pdleft+width, pdtop+height, paint);
	   paint.setColor(Color.BLUE);
	}
}
