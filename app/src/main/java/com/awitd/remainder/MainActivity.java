package com.awitd.remainder;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.awitd.remainder.Model.Prefs;
import com.awitd.remainder.Model.ProgressActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtLabel;
    TextView tvGetNum,tvHour,tvMin,tvSec;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdel;
//    String num="",label="";
    public static String sec="",min="",hour="",title_label="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_main_wheel);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        edtLabel = (EditText)findViewById(R.id.editText);
        tvGetNum = (TextView)findViewById(R.id.tv_getNumber);
        tvHour = (TextView)findViewById(R.id.hour_digit);
        tvMin  = (TextView)findViewById(R.id.min_digit);
        tvSec = (TextView)findViewById(R.id.second_digit);


        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hour = tvHour.getText().toString();
                min = tvMin.getText().toString();
                sec = tvSec.getText().toString();
                title_label = edtLabel.getText().toString();
                Toast.makeText(getApplicationContext(), edtLabel.getText().toString() + hour+ " Hours " + min + " Minutes and "
                        + sec+ " Seconds has been set!", Toast.LENGTH_LONG)
                        .show();

                startActivity(new Intent(MainActivity.this, ProgressActivity.class));
            }
        });




        fab.setEnabled(false);

//        tvHour.setEnabled(false);
//        tvMin.setEnabled(false);

        final NumberPicker numberPickerH = (NumberPicker) findViewById(R.id.numberPickerH);
        numberPickerH.setMaxValue(5000);
        numberPickerH.setMinValue(0);
        numberPickerH.setWrapSelectorWheel(true);

        final NumberPicker numberPickerM = (NumberPicker) findViewById(R.id.numberPickerM);
        numberPickerM.setMaxValue(60);
        numberPickerM.setMinValue(0);
        numberPickerM.setWrapSelectorWheel(true);

        final NumberPicker numberPickerS = (NumberPicker) findViewById(R.id.numberPickerS);
        numberPickerS.setMaxValue(60);
        numberPickerS.setMinValue(0);
        numberPickerS.setWrapSelectorWheel(true);



        try {
            setDividedColor(numberPickerH);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            setDividedColor(numberPickerM);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            setDividedColor(numberPickerS);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        numberPickerH.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tvHour.setText(""+newVal);
                EditText et = (EditText) numberPickerH.getChildAt(0);
                et.setTextColor(getResources().getColor(android.R.color.black));
                fab.setEnabled(true);
                fab.setVisibility(View.VISIBLE);
            }
        });

        numberPickerM.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tvMin.setText(""+newVal);
                EditText et = (EditText) numberPickerM.getChildAt(0);
                et.setTextColor(getResources().getColor(android.R.color.black));
                fab.setEnabled(true);
                fab.setVisibility(View.VISIBLE);
            }
        });

        numberPickerS.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tvSec.setText("" + newVal);
                EditText et = (EditText) numberPickerS.getChildAt(0);
                et.setTextColor(getResources().getColor(android.R.color.black));
                if (newVal == 0) {
                    fab.setEnabled(false);
                } else {
                    fab.setEnabled(true);
                }

                fab.setVisibility(View.VISIBLE);
            }
        });

//        b1 = (Button) findViewById(R.id.b1);
//        b2 = (Button) findViewById(R.id.b2);
//        b3 = (Button) findViewById(R.id.b3);
//        b4 = (Button) findViewById(R.id.b4);
//        b5 = (Button) findViewById(R.id.b5);
//        b6 = (Button) findViewById(R.id.b6);
//        b7 = (Button) findViewById(R.id.b7);
//        b8 = (Button) findViewById(R.id.b8);
//        b9 = (Button) findViewById(R.id.b9);
//        b0 = (Button) findViewById(R.id.b0);
//        bdel = (Button) findViewById(R.id.input_delete);




        ////////////////////////////////////////////////////////////////////////
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(tvHour.isEnabled()==false){
//                    sec+=b1.getText().toString();
//                    tvSec.setText(sec);
//                }
//                if(tvSec.length()== 2 & tvMin.isEnabled()==false){
//                    tvMin.setEnabled(true);
//                    min+=b1.getText().toString();
//                    tvMin.setText(min);
//                }
//            }
//        });
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(tvHour.isEnabled()==false){
//                    sec+=b2.getText().toString();
//                    tvSec.setText(sec);
//                }
//                if(tvSec.length()== 2 & tvMin.isEnabled()==false){
//                    tvMin.setEnabled(true);
//                    min+=b2.getText().toString();
//                    tvMin.setText(min);
//                }
//            }
//        });

//        if (tvSec.isEnabled()==true) {
//            if (tvSec.length() != 2) {
//                b1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        sec += b1.getText().toString();
//                        tvSec.setText(sec);
//                    }
//                });
//                b2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        sec+=b2.getText().toString();
//                        tvSec.setText(sec);
//                    }
//                });
//                b3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        sec+=b3.getText().toString();
//                        tvSec.setText(sec);
//                    }
//                });
//            }
//        }
///////////////////////////////////////////////////////////////////////////////////////////////
//            b1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    num += b1.getText().toString();
//                    tvGetNum.setText(num);
//                    if(tvGetNum.length()== 6){
//                        Toast.makeText(getApplicationContext(),"Full"+tvGetNum.length()+" "+tvGetNum.getText(),Toast.LENGTH_SHORT).show();
//                        String split = tvGetNum.getText().toString();
//                        Splitto3(split);
//                    }
//                }
//            });
//
//            b2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    num += b2.getText().toString();
//                    tvGetNum.setText(num);
//                    Log.e("length of tv:", tvGetNum.length() + "");
//                    if(tvGetNum.length()== 6){
//                        Toast.makeText(getApplicationContext(),"Full"+tvGetNum.length()+" "+tvGetNum.getText(),Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//            });

//        bdel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tvSec.setText("");
//                tvMin.setEnabled(false);
//                tvMin.setText("");
//                sec="";
//                min="";
//            }
//        });




    }

    private void Splitto3(String split) {



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private  void setDividedColor(NumberPicker picker) throws IllegalAccessException {
        java.lang.reflect.Field[] pickerFields = NumberPicker.class.getDeclaredFields();
        for(java.lang.reflect.Field pf : pickerFields) {
            if (pf.getName().equals("mSelectionDivider")) {
                pf.setAccessible(true);
                try {
                    pf.set(picker, getResources().getDrawable(R.drawable.divider_color));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
//    public void ShowDialog(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AppCompatAlertDialogStyle);
//        LayoutInflater inflater = this.getLayoutInflater();
//        final View dialogView = inflater.inflate(R.layout.label_dialog,null);
//        builder.setView(dialogView);
//
//        final EditText edtlabel = (EditText)findViewById(R.id.editText_label);
//        l = edtlabel.getText().toString();
//
//        builder.setTitle("Label");
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//               Log.e("Typed...",l+"");
//            }
//        });
//        AlertDialog ad = builder.create();
//        ad.show();
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long/
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, Prefs.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
