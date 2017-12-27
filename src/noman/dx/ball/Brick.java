package noman.dx.ball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Paint.Style;

public class Brick implements Drawable {
	
    float brtop,brbottom,brleft,brright;
    Paint paint;


 public Brick(float lft,float tp,float rght,float btm,Paint p){

        this.brleft=lft;
        this.brtop=tp;
        this.brright=rght;
        this.brbottom=btm;
        this.paint = p;
    }

   public void Draw(Canvas canvas) 
   {	   
	   paint.setStyle(Style.STROKE);
	   paint.setColor(Color.BLACK);
       canvas.drawRect(brleft, brtop+20, brright, brbottom+20, paint);
       
       paint.setStyle(Style.FILL);
	   paint.setColor(Color.BLUE);
       canvas.drawRect(brleft, brtop+20, brright, brbottom+20, paint);
	}

}

