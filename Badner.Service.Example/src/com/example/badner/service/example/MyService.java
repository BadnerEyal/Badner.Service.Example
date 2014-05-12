package com.example.badner.service.example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service{
	
	//דגל כדי לראות אם הטרד בפעולה כדי לא להפעיל מספר טרדים במקביל
	 boolean isThreadOn = false;
	 public final String TAG = "MyService";
	
	/* onCreate()
	 * נקרא פעם אחת בלבד ביצרת האוביקט 
	 * בקריאה של startService
	 * Serviceבמקרה שנקרא עוד פעם ל
	 *startService
	 * נגיע ישר ל
	 * onStartCommand
	 *  רק במקרה שהוא נעצר
	 *  stopService
	 * נכנס חזרה ליצרה
	 */
	@Override
	public void onCreate() {
		super.onCreate();
	 //טוסט להצגה 
		 Toast.makeText(this,"My Service is onCreate", Toast.LENGTH_LONG).show();
		 Log.d(TAG," onCreate");
	}

	/*מופעלת עבור כל הפעלה  של 
	 * startServce
	 * בעצם בפונקציה זו נרשום מה שרוצים לבצע כל פעם מחדש שקוראים לשירות
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
	
		
		if(!isThreadOn)
	  	   {
	  		   isThreadOn = true;
	  		 Sleepthread isleepthread = new Sleepthread();
	  		 isleepthread.start();
	   	   	   Toast.makeText(this,"My Service is onStartCommand New Thread Go Sleep", Toast.LENGTH_LONG).show();
	    	}
	  	   else
		   	   Toast.makeText(this,"My Service is onStartCommand Thread No Fins Sleep" , Toast.LENGTH_LONG).show();
	   	
		//return super.onStartCommand(intent, flags, startId);
	        return START_STICKY; 
		
	}

	/*
	 * מופעלת כ-callback של stopService.
	 * @see android.app.Service#onDestroy()
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		 Toast.makeText(this, "My Service is onDestroy", Toast.LENGTH_LONG).show();
	}

	/*onBind, חייבים לממש בכל Service.
	* קשור לתקשורת בין תהליכים
	*  inter-process communication או IPC
	* בגלל שאין תקשורת בדוגמא זו נחזיר  NULL
	*/
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
    /* אינר קלאס של טרד
     * כדי שנראה את השימוש
     */
	 public class Sleepthread extends Thread {

	        public void run() {
	        	//לא נעשה כלום רק ניתן לו לישון
	        	try {Thread.sleep(10000);
	        	    } 
	        	catch (InterruptedException e) {
	        		
	        	}
	        	isThreadOn = false;
	        	
	        }
	       
	    }
		
}
