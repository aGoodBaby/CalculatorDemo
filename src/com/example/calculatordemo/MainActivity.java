package com.example.calculatordemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button btn_0;
	private Button btn_1;
	private Button btn_2;
	private Button btn_3;
	private Button btn_4;
	private Button btn_5;
	private Button btn_6;
	private Button btn_7;
	private Button btn_8;
	private Button btn_9;
	private Button btn_point;
	private Button btn_clear;
	private Button btn_del;
	private Button btn_multiply;
	private Button btn_divide;
	private Button btn_minus;
	private Button btn_plus;
	private Button btn_equal;
	
	private EditText et_input;
	//�������еĿؼ�
	
	
	private boolean isAllow=false;
	//isAllow��ʾ��ǰ�Ƿ��ܹ����������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btn_0=(Button) findViewById(R.id.btn_0);
		btn_1=(Button) findViewById(R.id.btn_1);
		btn_2=(Button) findViewById(R.id.btn_2);
		btn_3=(Button) findViewById(R.id.btn_3);
		btn_4=(Button) findViewById(R.id.btn_4);
		btn_5=(Button) findViewById(R.id.btn_5);
		btn_6=(Button) findViewById(R.id.btn_6);
		btn_7=(Button) findViewById(R.id.btn_7);
		btn_8=(Button) findViewById(R.id.btn_8);
		btn_9=(Button) findViewById(R.id.btn_9);
		btn_point=(Button) findViewById(R.id.btn_point);
		btn_del=(Button) findViewById(R.id.btn_del);
		btn_clear=(Button) findViewById(R.id.btn_clear);
		btn_multiply=(Button) findViewById(R.id.btn_multiply);
		btn_divide=(Button) findViewById(R.id.btn_divide);
		btn_minus=(Button) findViewById(R.id.btn_minus);
		btn_plus=(Button) findViewById(R.id.btn_plus);
		btn_equal=(Button) findViewById(R.id.btn_equal);
		
		et_input=(EditText) findViewById(R.id.et_input);
		
		
		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);
		btn_point.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
		btn_multiply.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_plus.setOnClickListener(this);
		btn_equal.setOnClickListener(this);
		
		//��ʼ���ؼ�����������¼�
		
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String str=et_input.getText().toString();
		
		switch(v.getId()){
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
		case R.id.btn_point:
			et_input.setText(str+((Button)v).getText());
			isAllow=true;
			break;
			//��������ְ�ťʱ
				//1.����ʾ���ϴ�ӡ
				//2.isAllow��Ϊtrue��֮������������
		case R.id.btn_plus:
		case R.id.btn_minus:
		case R.id.btn_multiply:
		case R.id.btn_divide:
			if(isAllow){
			et_input.setText(str+" "+((Button)v).getText()+" ");
			isAllow=false;
			}
			break;
			//����������ʱ
				//1.�жϵ�ǰ�Ƿ������������
			    	//1.1.�������
						//1.1.1.����ʾ���ϴ�ӡ
						//1.1.2.isAllow��Ϊfalse��֮�󲻿����������
		case R.id.btn_clear:
			et_input.setText("");
			isAllow=false;
			break;
			//����������ťʱ
				//1.��ʾ�����
				//2.isAllow��Ϊfalse��֮�󲻿����������
		case R.id.btn_del:
			if(!str.equals("")){
				if(str.endsWith(" ")){
					et_input.setText(str.substring(0,str.length()-3));
				}else{
			et_input.setText(str.substring(0,str.length()-1));
				}
			}
			if(str.length()<1){
				isAllow=false;
			}
			break;
			//�����������ťʱ
				//1.�жϵ�ǰ��ʾ���Ƿ�Ϊ��
					//1.1.�����Ϊ��
						//1.1.1.�жϽ�β�ַ��ǲ��ǿո񣬼��жϽ�β�ǲ��������
							//1.1.1.1.����ǣ���ô���������ַ�
							//1.1.1.2.������ǣ���ô����һ���ַ�
					//1.2.���Ϊ���򲻴���
			
		case R.id.btn_equal:
			getResult(str);
			
			break;
			//��������ڰ�ťʱ
				//��������������
			
		
		
		default:
		break;
		
		}
		
	}
	private void getResult(String str){
		
		String str1=str.substring(0, str.indexOf(" "));
		String op=str.substring(str.indexOf(" ")+1, str.indexOf(" ")+2);
		String str2=str.substring(str.indexOf(" ")+3);
		
		//����ʾ�����ݽ����и�
			//str1Ϊ��һ������	
			//o pΪ�����
			//str2Ϊ�ڶ�������
		
		double d1=Double.parseDouble(str1);
		double d2=Double.parseDouble(str2);
		
		if(op.equals("+")){
			et_input.setText(d1+d2+"");
		}
		if(op.equals("-")){
			et_input.setText(d1-d2+"");
		}
		if(op.equals("*")){
			et_input.setText(d1*d2+"");
		}
		if(op.equals("/")){
			et_input.setText(d1/d2+"");
		}
	 
		
		return;
	}

}