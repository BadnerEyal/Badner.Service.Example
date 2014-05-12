package com.example.badner.service.example;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service{
	
	//��� ��� ����� �� ���� ������ ��� �� ������ ���� ����� ������
	 boolean isThreadOn = false;
	 public final String TAG = "MyService";
	
	/* onCreate()
	 * ���� ��� ��� ���� ����� ������� 
	 * ������ �� startService
	 * Service����� ����� ��� ��� �
	 *startService
	 * ���� ��� �
	 * onStartCommand
	 *  �� ����� ���� ����
	 *  stopService
	 * ���� ���� �����
	 */
	@Override
	public void onCreate() {
		super.onCreate();
	 //���� ����� 
		 Toast.makeText(this,"My Service is onCreate", Toast.LENGTH_LONG).show();
		 Log.d(TAG," onCreate");
	}

	/*������ ���� �� �����  �� 
	 * startServce
	 * ���� �������� �� ����� �� ������ ���� �� ��� ���� ������� ������
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
	 * ������ �-callback �� stopService.
	 * @see android.app.Service#onDestroy()
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		 Toast.makeText(this, "My Service is onDestroy", Toast.LENGTH_LONG).show();
	}

	/*onBind, ������ ���� ��� Service.
	* ���� ������� ��� �������
	*  inter-process communication �� IPC
	* ���� ���� ������ ������ �� �����  NULL
	*/
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
    /* ���� ���� �� ���
     * ��� ����� �� ������
     */
	 public class Sleepthread extends Thread {

	        public void run() {
	        	//�� ���� ���� �� ���� �� �����
	        	try {Thread.sleep(10000);
	        	    } 
	        	catch (InterruptedException e) {
	        		
	        	}
	        	isThreadOn = false;
	        	
	        }
	       
	    }
		
}
