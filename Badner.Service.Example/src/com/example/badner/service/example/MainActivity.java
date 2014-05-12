package com.example.badner.service.example;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


/**
 *התוכנית באה להראות את מעגל החיים של 
 *service
 *שימוש עיקרים 
 *1.
 *ביצוע פעולות רקע באפלקציה שלא צריכות את המסך
 *UI
 *2.
 *תקשורת בין תהליכים שונים במערכת 
 *Processes
 *הערה:
 *כאשר רוצים לעשות פעולה של קריאה נתונים או פעולה ארוכה
 *יש להשתמש ב
 *Thread
 *בתוך 
 *service
 **
**/

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		//כאשר לוחצים על כפתור התחל
		Button buttonServiceStart = (Button)findViewById(R.id.buttonstartservice);
       
        buttonServiceStart.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
 	   	   	  // Toast.makeText(MainActivity.this,"odgdg", Toast.LENGTH_LONG).show();

        		Intent intent = new Intent(MainActivity.this, MyService.class);
				
				startService(intent);		
        	
        	}	        	
        });
        //כאשר לוחצים על כפתור סיום
        Button buttonServiceDestroy = (Button)findViewById(R.id.buttondestroyservice);
        buttonServiceDestroy.setOnClickListener(new OnClickListener() {
        	public void onClick(View v){
        		stopService(new Intent(MainActivity.this,MyService.class));
        	}	        	
        });
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
