package net.gbs.calcu_v1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
    	 
		//Se definen botones y listeners
		Button Bt_Suma   =(Button)  findViewById(R.id.Bt_Suma) ;
		Bt_Suma.setOnClickListener(this);
		Button Bt_Resta  =(Button)  findViewById(R.id.Bt_Resta);
		Bt_Resta.setOnClickListener(this);
		Button Bt_Multi  =(Button)  findViewById(R.id.Bt_Multi);
		Bt_Multi.setOnClickListener(this);
		Button Bt_Divi   =(Button)  findViewById(R.id.Bt_Divi);
		Bt_Divi.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//Aquí se administra cuando un botón es pulsado
	public void onClick(View v) {
    	EditText ET_Oper1=(EditText)findViewById(R.id.ET_Oper1);
    	EditText ET_Oper2=(EditText)findViewById(R.id.ET_Oper2);
    	TextView TV_Resul=(TextView)findViewById(R.id.TV_Resul);
    	Double oper1, oper2,resul;
    	
    	//Capturamos una excepción si algún operando está vacío.
    	try{
    		oper1 = Double.parseDouble(ET_Oper1.getText().toString());
    		oper2 = Double.parseDouble(ET_Oper2.getText().toString());
    		resul = 0.0;
    		
    		if (v.getId() == R.id.Bt_Suma){ 
        		resul = oper1+oper2;
        	}
        	if (v.getId() == R.id.Bt_Resta){ 
        		resul = oper1-oper2;
        	} 
        	if (v.getId() == R.id.Bt_Multi){ 
        		resul = oper1*oper2;
        	}
        	if (v.getId() == R.id.Bt_Divi){
        		if (oper2 != 0){
        			resul = oper1/oper2;
        		} else {
        			Toast.makeText(getApplicationContext(), "DIVISION POR 0 NO PERMITIDA", Toast.LENGTH_SHORT).show();
        		}
        	}
        	
        	//Se escribe resultado en el TextView de salida
        	TV_Resul.setText(resul.toString());
        	
    	}catch(NumberFormatException e){
    		Toast.makeText(getApplicationContext(), "OPERANDO VACIO", Toast.LENGTH_SHORT).show();
    	}
	}
}
