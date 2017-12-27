package noman.dx.ball;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;

public class DxBallGameActivity extends Activity implements OnKeyListener {
	//StringBuilder builder = new StringBuilder();
	
	public boolean onKey(View view, int keyCode, KeyEvent event) {
    	switch(event.getAction())
    	{
	    	case KeyEvent.ACTION_DOWN:
	    	//builder.append("down, ");
	    	break;
	    	case KeyEvent.ACTION_UP:
	    	//builder.append("up, ");
	    	break;
    	}
    	/*builder.append(event.getKeyCode());
    	builder.append(", ");
    	builder.append((char) event.getUnicodeChar());
    	String text = builder.toString();*/
    	Log.d("KeyTest", keyCode+"");
    	//return event.getKeyCode() != KeyEvent.KEYCODE_BACK;
    	return true;
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        GameControl g= new GameControl(this);
        g.setOnKeyListener(this);
        g.setFocusableInTouchMode(true);
        g.requestFocus();
        setContentView(g); 
        
    }
}