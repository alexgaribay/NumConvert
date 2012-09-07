package com.alexgaribay.numconvert;

import com.alexgaribay.numconvert.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class NumConvert extends Activity {
	// Constants for Buttons and Radio Buttons.
	private Boolean baseChosen, convertChosen;

	private enum Type {
		binary, octal, decimal, hex
	};

	private int maxInputChar;
	private Type baseType, convertType;
	private TextView mEntry, mResult;
	private Button mZero, mOne, mTwo, mThree, mFour, mFive, mSix, mSeven,
			mEight, mNine, mHexA, mHexB, mHexC, mHexD, mHexE, mHexF, mClear;
	private RadioButton radio_BaseBinary, radio_BaseOctal, radio_BaseDecimal,
			radio_BaseHex, radio_ConvertBinary, radio_ConvertOctal,
			radio_ConvertDecimal, radio_ConvertHex;
	private CharSequence valueString;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// TextViews
		mEntry = (TextView) findViewById(R.id.entry);
		mResult = (TextView) findViewById(R.id.result_box);

		// Buttons
		mOne = (Button) findViewById(R.id.one);
		mTwo = (Button) findViewById(R.id.two);
		mThree = (Button) findViewById(R.id.three);
		mFour = (Button) findViewById(R.id.four);
		mFive = (Button) findViewById(R.id.five);
		mSix = (Button) findViewById(R.id.six);
		mSeven = (Button) findViewById(R.id.seven);
		mEight = (Button) findViewById(R.id.eight);
		mNine = (Button) findViewById(R.id.nine);
		mZero = (Button) findViewById(R.id.zero);
		mHexA = (Button) findViewById(R.id.a);
		mHexB = (Button) findViewById(R.id.b);
		mHexC = (Button) findViewById(R.id.c);
		mHexD = (Button) findViewById(R.id.d);
		mHexE = (Button) findViewById(R.id.e);
		mHexF = (Button) findViewById(R.id.f);
		mClear = (Button) findViewById(R.id.clear_button);
		// mClearEntry = (Button) findViewById(R.id.clearEntry_button);
		// mConvert = (Button) findViewById(R.id.convert_button);

		// Radio Buttons
		radio_BaseBinary = (RadioButton) findViewById(R.id.base_binary);
		radio_BaseOctal = (RadioButton) findViewById(R.id.base_octal);
		radio_BaseDecimal = (RadioButton) findViewById(R.id.base_decimal);
		radio_BaseHex = (RadioButton) findViewById(R.id.base_hexadecimal);
		radio_ConvertBinary = (RadioButton) findViewById(R.id.convert_binary);
		radio_ConvertOctal = (RadioButton) findViewById(R.id.convert_octal);
		radio_ConvertDecimal = (RadioButton) findViewById(R.id.convert_decimal);
		radio_ConvertHex = (RadioButton) findViewById(R.id.convert_hexadecimal);

		// Disables all buttons except binary.
		mZero.setEnabled(true);
		mOne.setEnabled(true);
		mTwo.setEnabled(false);
		mThree.setEnabled(false);
		mFour.setEnabled(false);
		mFive.setEnabled(false);
		mSix.setEnabled(false);
		mSeven.setEnabled(false);
		mEight.setEnabled(false);
		mNine.setEnabled(false);
		mHexA.setEnabled(false);
		mHexB.setEnabled(false);
		mHexC.setEnabled(false);
		mHexD.setEnabled(false);
		mHexE.setEnabled(false);
		mHexF.setEnabled(false);

		// Makes the default selections.
		baseType = Type.binary;
		convertType = Type.decimal;
		maxInputChar = 32;
		valueString = "";

		baseChosen = true;
		convertChosen = true;

		// '0' button press adds "0" to the text in mEntry.
		mZero.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "0";
				CharSequence temp;
				if ( baseType == Type.binary ) {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				else if ( baseType == Type.decimal ) {
					temp = threeCharFormat(valueString, true);
					mEntry.setText(temp);
				}
				else if ( baseType == Type.octal ) {
					temp = threeCharFormat(valueString, false);
					mEntry.setText(temp);
				}
				else {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				convert();
				checkEntryLength();
			}
		});

		// '1' button press adds "1" to the text in mEntry.
		mOne.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "1";
				CharSequence temp;
				if ( baseType == Type.binary ) {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				else if ( baseType == Type.decimal ) {
					temp = threeCharFormat(valueString, true);
					mEntry.setText(temp);
				}
				else if ( baseType == Type.octal ) {
					temp = threeCharFormat(valueString, false);
					mEntry.setText(temp);
				}
				else {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				convert();
				checkEntryLength();
			}
		});

		// '2' button press adds "2" to the text in mEntry.
		mTwo.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "2";
				CharSequence temp;
				if ( baseType == Type.decimal ) {
					temp = threeCharFormat(valueString, true);
					mEntry.setText(temp);
				}
				else if ( baseType == Type.octal ) {
					temp = threeCharFormat(valueString, false);
					mEntry.setText(temp);
				}
				else {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				convert();
				checkEntryLength();
			}
		});

		// '3' button press adds "3" to the text in mEntry.
		mThree.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "3";
				CharSequence temp;
				if ( baseType == Type.decimal ) {
					temp = threeCharFormat(valueString, true);
					mEntry.setText(temp);
				}
				else if ( baseType == Type.octal ) {
					temp = threeCharFormat(valueString, false);
					mEntry.setText(temp);
				}
				else {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				convert();
				checkEntryLength();
			}
		});

		// '4' button press adds "4" to the text in mEntry.
		mFour.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "4";
				CharSequence temp;
				if ( baseType == Type.decimal ) {
					temp = threeCharFormat(valueString, true);
					mEntry.setText(temp);
				}
				else if ( baseType == Type.octal ) {
					temp = threeCharFormat(valueString, false);
					mEntry.setText(temp);
				}
				else {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				convert();
				checkEntryLength();
			}
		});

		// '5' button press adds "5" to the text in mEntry.
		mFive.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Perform action on clicks
				valueString = valueString + "5";
				CharSequence temp;
				if ( baseType == Type.decimal ) {
					temp = threeCharFormat(valueString, true);
					mEntry.setText(temp);
				}
				else if ( baseType == Type.octal ) {
					temp = threeCharFormat(valueString, false);
					mEntry.setText(temp);
				}
				else {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				convert();
				checkEntryLength();
			}
		});

		// '6' button press adds "6" to the text in mEntry.
		mSix.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "6";
				CharSequence temp;
				if ( baseType == Type.decimal ) {
					temp = threeCharFormat(valueString, true);
					mEntry.setText(temp);
				}
				else if ( baseType == Type.octal ) {
					temp = threeCharFormat(valueString, false);
					mEntry.setText(temp);
				}
				else {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				convert();
				checkEntryLength();
			}
		});

		// '7' button press adds "7" to the text in mEntry.
		mSeven.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "7";
				CharSequence temp;
				if ( baseType == Type.decimal ) {
					temp = threeCharFormat(valueString, true);
					mEntry.setText(temp);
				}
				else if ( baseType == Type.octal ) {
					temp = threeCharFormat(valueString, false);
					mEntry.setText(temp);
				}
				else {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				convert();
				checkEntryLength();
			}
		});

		// 'F' button press adds "8" to the text in mEntry.
		mEight.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "8";
				CharSequence temp;
				if ( baseType == Type.decimal ) {
					temp = threeCharFormat(valueString, true);
					mEntry.setText(temp);
				}
				else {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				convert();
				checkEntryLength();
			}
		});

		// '9' button press adds "9" to the text in mEntry.
		mNine.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "9";
				CharSequence temp;
				if ( baseType == Type.decimal ) {
					temp = threeCharFormat(valueString, true);
					mEntry.setText(temp);
				}
				else {
					temp = fourCharFormat(valueString);
					mEntry.setText(temp);
				}
				convert();
				checkEntryLength();
			}
		});

		// 'A' button press adds "A" to the text in mEntry.
		mHexA.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "A";
				CharSequence temp = fourCharFormat(valueString);
				mEntry.setText(temp);
				convert();
				checkEntryLength();
			}
		});

		// 'B' button press adds "B" to the text in mEntry.
		mHexB.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "B";
				CharSequence temp = fourCharFormat(valueString);
				mEntry.setText(temp);
				convert();
				checkEntryLength();
			}
		});

		// 'C' button press adds "C" to the text in mEntry.
		mHexC.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "C";
				CharSequence temp = fourCharFormat(valueString);
				mEntry.setText(temp);
				convert();
				checkEntryLength();
			}
		});

		// 'D' button press adds "D" to the text in mEntry.
		mHexD.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "D";
				CharSequence temp = fourCharFormat(valueString);
				mEntry.setText(temp);
				convert();
				checkEntryLength();
			}
		});

		// 'E' button press adds "E" to the text in mEntry.
		mHexE.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "E";
				CharSequence temp = fourCharFormat(valueString);
				mEntry.setText(temp);
				convert();
				checkEntryLength();
			}
		});

		// 'F' button press adds "F" to the text in mEntry.
		mHexF.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs actions on click
				valueString = valueString + "F";
				CharSequence temp = fourCharFormat(valueString);
				mEntry.setText(temp);
				convert();
				checkEntryLength();
			}
		});

		// 'Clear' button press clears input value
		mClear.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Performs action on click
				clearLast();
				checkEntryLength();
				if (mEntry.getText().length() != 0){
					convert();
				}
			}
		});

		// 'Clear' long button press clears the text in mEntry and mResult.
		mClear.setOnLongClickListener(new OnLongClickListener() {
			public boolean onLongClick(View V) {
				// Performs action on click
				clearText();
				buttonsClickable();
				return true;
			}
		});

		// 'Base Number Type' Radio Buttons.
		radio_BaseBinary.setOnClickListener(radio_Base);
		radio_BaseOctal.setOnClickListener(radio_Base);
		radio_BaseDecimal.setOnClickListener(radio_Base);
		radio_BaseHex.setOnClickListener(radio_Base);

		// 'Convert To' Radio Buttons.
		radio_ConvertBinary.setOnClickListener(radio_Convert);
		radio_ConvertOctal.setOnClickListener(radio_Convert);
		radio_ConvertDecimal.setOnClickListener(radio_Convert);
		radio_ConvertHex.setOnClickListener(radio_Convert);
	}

	// 'Base Number Type' Radio Button Actions. Enables and disables specific
	// buttons
	// depending upon 'Base Number Type' selection to avoid and prevent
	// conflicts.
	private OnClickListener radio_Base = new OnClickListener() {
		public void onClick(View v) {
			// Perform separate actions for each radio click.
			if ( v.getId() == R.id.base_binary ) {
				mZero.setEnabled(true);
				mOne.setEnabled(true);
				mTwo.setEnabled(false);
				mThree.setEnabled(false);
				mFour.setEnabled(false);
				mFive.setEnabled(false);
				mSix.setEnabled(false);
				mSeven.setEnabled(false);
				mEight.setEnabled(false);
				mNine.setEnabled(false);
				mHexA.setEnabled(false);
				mHexB.setEnabled(false);
				mHexC.setEnabled(false);
				mHexD.setEnabled(false);
				mHexE.setEnabled(false);
				mHexF.setEnabled(false);
				baseChosen = true;
				changeBaseType(Type.binary);
				baseType = Type.binary;
				maxInputChar = 32;
				buttonsClickable();
			}

			else if ( v.getId() == R.id.base_octal ) {
				mZero.setEnabled(true);
				mOne.setEnabled(true);
				mTwo.setEnabled(true);
				mThree.setEnabled(true);
				mFour.setEnabled(true);
				mFive.setEnabled(true);
				mSix.setEnabled(true);
				mSeven.setEnabled(true);
				mEight.setEnabled(false);
				mNine.setEnabled(false);
				mHexA.setEnabled(false);
				mHexB.setEnabled(false);
				mHexC.setEnabled(false);
				mHexD.setEnabled(false);
				mHexE.setEnabled(false);
				mHexF.setEnabled(false);
				baseChosen = true;
				changeBaseType(Type.octal);
				baseType = Type.octal;
				maxInputChar = 14;
				buttonsClickable();
			}
			else if ( v.getId() == R.id.base_decimal ) {
				mZero.setEnabled(true);
				mOne.setEnabled(true);
				mTwo.setEnabled(true);
				mThree.setEnabled(true);
				mFour.setEnabled(true);
				mFive.setEnabled(true);
				mSix.setEnabled(true);
				mSeven.setEnabled(true);
				mEight.setEnabled(true);
				mNine.setEnabled(true);
				mHexA.setEnabled(false);
				mHexB.setEnabled(false);
				mHexC.setEnabled(false);
				mHexD.setEnabled(false);
				mHexE.setEnabled(false);
				mHexF.setEnabled(false);
				baseChosen = true;
				changeBaseType(Type.decimal);
				baseType = Type.decimal;
				maxInputChar = 12;
				buttonsClickable();
			}
			else if ( v.getId() == R.id.base_hexadecimal ) {
				mZero.setEnabled(true);
				mOne.setEnabled(true);
				mTwo.setEnabled(true);
				mThree.setEnabled(true);
				mFour.setEnabled(true);
				mFive.setEnabled(true);
				mSix.setEnabled(true);
				mSeven.setEnabled(true);
				mEight.setEnabled(true);
				mNine.setEnabled(true);
				mHexA.setEnabled(true);
				mHexB.setEnabled(true);
				mHexC.setEnabled(true);
				mHexD.setEnabled(true);
				mHexE.setEnabled(true);
				mHexF.setEnabled(true);
				baseChosen = true;
				changeBaseType(Type.hex);
				baseType = Type.hex;
				maxInputChar = 10;
				buttonsClickable();
			}
			checkEntryLength();
		}
	};

	// 'Convert To' Radio Button Actions. Enables and disables specific radio
	// buttons
	// to avoid and prevent conflicts.
	private OnClickListener radio_Convert = new OnClickListener() {
		public void onClick(View v) {
			// Perform action on clicks
			if ( v.getId() == R.id.convert_binary ) {
				convertType = Type.binary;
				convert();
			}
			else if ( v.getId() == R.id.convert_octal ) {
				convertType = Type.octal;
				convert();
			}
			else if ( v.getId() == R.id.convert_decimal ) {
				convertType = Type.decimal;
				convert();
			}
			else if ( v.getId() == R.id.convert_hexadecimal ) {
				convertType = Type.hex;
				convert();
			}
		}
	};

	// Creates the options menu
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	// @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
			case R.id.help:
				AlertDialog alertDialog = new AlertDialog.Builder(this)
						.create();
				alertDialog.setTitle("Help");
				alertDialog
						.setMessage("NumConvert Version 1.2.0"
								+ "\n - Choose a 'Base Type' and 'Convert To Type' first and input "
								+ "the value you want to convert. Numbers are converted on the fly!"
								+ "\n\nNOTE:"
								+ "\n - Long press 'Clear' to remove all text."
								+ "\n - The limit for binary input is 32 digits."
								+ "\n - The limit for octal input is 14 digits."
								+ "\n - The limit for decimal input is 12 digits."
								+ "\n - The limit for hex input is 12 digits."
								+ "\n\nFor quesitons or suggestions, send a message to: \n     ftmtech@gmail.com");
				alertDialog.setButton("OK",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								// here you can add functions
							}
						});
				alertDialog.setIcon(R.drawable.ic_menu_help);
				alertDialog.show();
				return true;
			case R.id.quit:
				this.finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	// Makes all input buttons clickable.
	private void buttonsClickable() {
		mZero.setClickable(true);
		mOne.setClickable(true);
		mTwo.setClickable(true);
		mThree.setClickable(true);
		mFour.setClickable(true);
		mFive.setClickable(true);
		mSix.setClickable(true);
		mSeven.setClickable(true);
		mEight.setClickable(true);
		mNine.setClickable(true);
		mHexA.setClickable(true);
		mHexB.setClickable(true);
		mHexC.setClickable(true);
		mHexD.setClickable(true);
		mHexE.setClickable(true);
		mHexF.setClickable(true);
	}

	/**
	 * Converts the base value to the proper converted value. Formatting takes
	 * place in here.
	 */
	public void convert() {
		if ( (baseChosen == true) && (convertChosen == true) ) {
			// 'Base Number Type' is selected as 'Binary'
			CharSequence temp = valueString;
			if ( baseType == Type.binary ) {
				if ( convertType == Type.octal ) {
					CharSequence tempChar = binaryToOctal(temp);
					tempChar = threeCharFormat(tempChar, false);
					mResult.setText(tempChar);
				}
				else if ( convertType == Type.decimal ) {
					CharSequence tempChar = binaryToDecimal(temp);
					tempChar = threeCharFormat(tempChar, true);
					mResult.setText(tempChar);
				}
				else if ( convertType == Type.hex ) {
					CharSequence tempChar = binaryToHex(temp);
					tempChar = fourCharFormat(tempChar);
					mResult.setText(tempChar);
				}
				else {
					CharSequence tempChar = mEntry.getText();
					mResult.setText(tempChar);
				}
			}
			// 'Base Number Type' is selected as 'Octal'.
			else if ( baseType == Type.octal ) {
				if ( convertType == Type.binary ) {
					CharSequence tempChar = octalToBinary(temp);
					tempChar = fourCharFormat(tempChar);
					mResult.setText(tempChar);
				}
				else if ( convertType == Type.decimal ) {
					CharSequence tempChar = octalToBinary(temp);
					tempChar = binaryToDecimal(tempChar);
					tempChar = threeCharFormat(tempChar, true);
					mResult.setText(tempChar);
				}
				else if ( convertType == Type.hex ) {
					CharSequence tempChar = octalToBinary(temp);
					tempChar = binaryToHex(tempChar);
					tempChar = fourCharFormat(tempChar);
					mResult.setText(tempChar);
				}
				else {
					temp = mEntry.getText();
					mResult.setText(temp);
				}
			}
			// 'Base Number Type' is selected as 'Decimal'.
			else if ( baseType == Type.decimal ) {
				if ( convertType == Type.binary ) {
					CharSequence tempChar = decimalToBinary(temp);
					tempChar = fourCharFormat(tempChar);
					mResult.setText(tempChar);
				}
				else if ( convertType == Type.octal ) {
					CharSequence tempChar = decimalToBinary(temp);
					tempChar = binaryToOctal(tempChar);
					tempChar = threeCharFormat(tempChar, false);
					mResult.setText(tempChar);
				}
				else if ( convertType == Type.hex ) {
					CharSequence tempChar = decimalToBinary(temp);
					tempChar = binaryToHex(tempChar);
					tempChar = fourCharFormat(tempChar);
					mResult.setText(tempChar);
				}
				else {
					CharSequence tempChar = mEntry.getText();
					mResult.setText(tempChar);
				}
			}
			// 'Base Number Type' is selected as 'Hexadecimal'.
			else if ( baseType == Type.hex ) {
				if ( convertType == Type.binary ) {
					CharSequence tempChar = hexToBinary(temp);
					tempChar = fourCharFormat(tempChar);
					mResult.setText(tempChar);
				}
				else if ( convertType == Type.octal ) {
					CharSequence tempChar = hexToBinary(temp);
					tempChar = binaryToOctal(tempChar);
					tempChar = threeCharFormat(tempChar, false);
					mResult.setText(tempChar);
				}
				else if ( convertType == Type.decimal ) {
					CharSequence tempChar = hexToBinary(temp);
					tempChar = binaryToDecimal(tempChar);
					tempChar = threeCharFormat(tempChar, true);
					mResult.setText(tempChar);
				}
				else {
					CharSequence tempChar = mEntry.getText();
					mResult.setText(tempChar);
				}
			}
		}

	}

	// Method to clear the contents of the 'Entry' and 'Result' TextViews.
	private void clearText() {
		mEntry.setText("");
		mResult.setText("");
		valueString = "";
	}

	/**
	 * Converts the Entry text to a new base type.
	 * 
	 * @param changeTo
	 *            : the type desired for the base type
	 */
	private void changeBaseType(Type changeTo) {
		CharSequence tempChar;
		if ( baseType == Type.binary ) {
			if ( changeTo == Type.binary ) {
				// Do nothing
			}
			else if ( changeTo == Type.octal ) {
				valueString = binaryToOctal(valueString);
				tempChar = threeCharFormat(valueString, false);
				mEntry.setText(tempChar);
			}
			else if ( changeTo == Type.decimal ) {
				valueString = binaryToDecimal(valueString);
				tempChar = threeCharFormat(valueString, true);
				mEntry.setText(tempChar);
			}
			else {
				valueString = binaryToHex(valueString);
				tempChar = fourCharFormat(valueString);
				mEntry.setText(tempChar);
			}
		}
		else if ( baseType == Type.octal ) {
			if ( changeTo == Type.binary ) {
				valueString = octalToBinary(valueString);
				tempChar = fourCharFormat(valueString);
				mEntry.setText(tempChar);
			}
			else if ( changeTo == Type.octal ) {
				// Do nothing
			}
			else if ( changeTo == Type.decimal ) {
				valueString = octalToBinary(valueString);
				valueString = binaryToDecimal(valueString);
				tempChar = threeCharFormat(valueString, true);
				mEntry.setText(tempChar);
			}
			else {
				valueString = octalToBinary(valueString);
				valueString = binaryToHex(valueString);
				tempChar = fourCharFormat(valueString);
				mEntry.setText(tempChar);
			}
		}
		else if ( baseType == Type.decimal ) {
			if ( changeTo == Type.binary ) {
				valueString = decimalToBinary(valueString);
				tempChar = fourCharFormat(valueString);
				mEntry.setText(tempChar);
			}
			else if ( changeTo == Type.octal ) {
				valueString = decimalToBinary(valueString);
				valueString = binaryToOctal(valueString);
				tempChar = threeCharFormat(valueString, false);
				mEntry.setText(tempChar);
			}
			else if ( changeTo == Type.decimal ) {
				// Do nothing
			}
			else {
				valueString = decimalToBinary(valueString);
				valueString = binaryToHex(valueString);
				tempChar = fourCharFormat(valueString);
				mEntry.setText(tempChar);
			}
		}
		else {
			if ( changeTo == Type.binary ) {
				valueString = hexToBinary(valueString);
				tempChar = fourCharFormat(valueString);
				mEntry.setText(tempChar);
			}
			else if ( changeTo == Type.octal ) {
				valueString = hexToBinary(valueString);
				valueString = binaryToOctal(valueString);
				tempChar = threeCharFormat(valueString, false);
				mEntry.setText(tempChar);
			}
			else if ( changeTo == Type.decimal ) {
				valueString = hexToBinary(valueString);
				valueString = binaryToDecimal(valueString);
				tempChar = threeCharFormat(valueString, false);
				mEntry.setText(tempChar);
			}
			else {
				// Do nothing
			}
		}
	}

	/**
	 * Method to remove the last entry in 'Entry'.
	 */
	private void clearLast() {
		int length = valueString.length();
		if ( length > 1 ) {
			valueString = valueString.subSequence(0, length - 1);
			CharSequence temp;
			if ( baseType == Type.binary ) {
				temp = fourCharFormat(valueString);
			}
			else if ( baseType == Type.octal ) {
				temp = threeCharFormat(valueString, false);
			}
			else if ( baseType == Type.decimal ) {
				temp = threeCharFormat(valueString, true);
			}
			else {
				temp = fourCharFormat(valueString);
			}
			mEntry.setText(temp);
		}
		else {
			mEntry.setText("");
			mResult.setText("");
			valueString = "";
		}
	}

	/**
	 * Converts an input value binary to Octal. Returns the result as a CharSequence.
	 * @param tempChar: value to get converted
	 * @return: the value converted in CharSequence type
	 */
	private CharSequence binaryToOctal(CharSequence tempChar) {
		if (tempChar.length() == 0){
			return "";
		}
		else {
			String[] Octal = { "0", "1", "2", "3", "4", "5", "6", "7" };
			int len = tempChar.length();
			String octEquivRev = "";
			String octEquiv = "";
			int numIterations;
			if ( len % 3 == 0 ) {
				numIterations = len / 3;
			}
			else {
				numIterations = len / 3 + 1;
			}
			int stoppingPoint;
			if ( numIterations > 1 ) {
				stoppingPoint = len - 3;
			}
			else {
				stoppingPoint = 0;
			}
			int result = 0;
			for (int j = 0; j < numIterations; j++) {
				for (int i = len - 1; i >= stoppingPoint; i--) {
					if ( tempChar.charAt(i) == '1' ) {
						result += power2(len - i - 1);
					}
				}
				len = len - 3;
				if ( len > 3 ) {
					stoppingPoint -= 3;
				}
				else {
					stoppingPoint = 0;
				}
				octEquivRev += Octal[result];
				result = 0;
			}
			octEquiv = stringReverse(octEquivRev);
			tempChar = (CharSequence) octEquiv;
			return tempChar;
		}
	}

	// Method to convert an input value from binary to decimal.
	// Returns the result as a CharSequence.
	private CharSequence binaryToDecimal(CharSequence tempChar) {
		if (tempChar.length() == 0){
			return "";
		}
		long result = 0;
		int len = tempChar.length();
		for (int i = len - 1; i >= 0; i--) {
			if ( tempChar.charAt(i) == '1' ) {
				result += power2(len - i - 1);
			}
		}
		tempChar = (CharSequence) String.valueOf(result);
		return tempChar;
	}

	// Method to perform 2^(exponent) where the exponent is an input.
	// Returns the value of the function.
	private long power2(int z) {
		if ( z == 0 ) {
			return 1;
		}
		else {
			long result = 1;
			int i;
			for (i = 0; i < z; i++) {
				result = result * 2;
			}
			return result;
		}
	}

	// Method to convert an input value binary to hexadecimal. Returns the
	// result
	// as a CharSequence.
	private CharSequence binaryToHex(CharSequence tempChar) {
		if (tempChar.length() == 0){
			return "";
		}
		else {
			String[] Hex = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
					"A", "B", "C", "D", "E", "F" };
			int len = tempChar.length();
			String hexEquivRev = "";
			String hexEquiv = "";
			int numIterations;
			if ( len % 4 == 0 ) {
				numIterations = len / 4;
			}
			else {
				numIterations = len / 4 + 1;
			}
			int stoppingPoint;
			if ( numIterations > 1 ) {
				stoppingPoint = len - 4;
			}
			else {
				stoppingPoint = 0;
			}
			int result = 0;
			for (int j = 0; j < numIterations; j++) {
				for (int i = len - 1; i >= stoppingPoint; i--) {
					if ( tempChar.charAt(i) == '1' ) {
						result += power2(len - i - 1);
					}
				}
				len = len - 4;
				if ( len > 4 ) {
					stoppingPoint -= 4;
				}
				else {
					stoppingPoint = 0;
				}
				hexEquivRev += Hex[result];
				result = 0;
			}
			hexEquiv = stringReverse(hexEquivRev);
			tempChar = (CharSequence) hexEquiv;
			return tempChar;
		}
	}

	// Method to convert octal to binary. Returns the result
	// as a CharSequence
	private CharSequence octalToBinary(CharSequence tempChar) {
		if (tempChar.length() == 0){
			return "";
		}
		else {
			String[] Binary = { "0", "1", "10", "11", "100", "101", "110",
					"111" };
			String[] Binary1 = { "000", "001", "010", "011", "100", "101",
					"110", "111" };
			String binaryEquiv = "";
			int length = tempChar.length();
			int index;
			for (int i = 0; i < length; i++) {
				String temp = Character.toString(tempChar.charAt(i));
				index = Integer.parseInt(temp);
				if ( i == 0 ) {
					binaryEquiv += Binary[index];
				}
				else {
					binaryEquiv += Binary1[index];
				}
			}
			return binaryEquiv;
		}
	}

	// Method to convert decimal to binary. Returns the result as
	// a CharSequence.
	private CharSequence decimalToBinary(CharSequence tempChar) {
		if (tempChar.length() == 0){
			return "";
		}
		else {
			String binaryEquivRev = "";
			String binaryEquiv;
			long number = Long.parseLong(tempChar.toString());
			if ( number == 0 ) {
				tempChar = (CharSequence) "0";
				return tempChar;
			}
			else {
				long remainder;
				boolean notDone = true;
				while (notDone) {
					remainder = number % 2;
					number = number / 2;
					if ( remainder == 1 && number != 0 ) {
						binaryEquivRev += "1";
					}
					else if ( number == 0 ) {
						binaryEquivRev += "1";
						notDone = false;
					}
					else {
						binaryEquivRev += "0";
					}
				}
				binaryEquiv = stringReverse(binaryEquivRev);
				tempChar = (CharSequence) binaryEquiv;
				return tempChar;
			}
		}
	}

	// Method to convert hexadecimal to binary. Returns the result as
	// a CharSequence.
	private CharSequence hexToBinary(CharSequence tempChar) {
		if (tempChar.length() == 0){
			return "";
		}
		else {
			String[] Binary = { "0", "1", "10", "11", "100", "101", "110",
					"111", "1000", "1001", "1010", "1011", "1100", "1101",
					"1110", "1111" };
			String[] Binary1 = { "0000", "0001", "0010", "0011", "0100",
					"0101", "0110", "0111", "1000", "1001", "1010", "1011",
					"1100", "1101", "1110", "1111" };
			String binaryEquiv = "";
			int length = tempChar.length();
			int index;
			for (int i = 0; i < length; i++) {
				if ( tempChar.charAt(i) == 'A' ) {
					index = 10;
				}
				else if ( tempChar.charAt(i) == 'B' ) {
					index = 11;
				}
				else if ( tempChar.charAt(i) == 'C' ) {
					index = 12;
				}
				else if ( tempChar.charAt(i) == 'D' ) {
					index = 13;
				}
				else if ( tempChar.charAt(i) == 'E' ) {
					index = 14;
				}
				else if ( tempChar.charAt(i) == 'F' ) {
					index = 15;
				}
				else {
					String temp = Character.toString(tempChar.charAt(i));
					index = Integer.parseInt(temp);
				}
				if ( i == 0 ) {
					binaryEquiv += Binary[index];
				}
				else {
					binaryEquiv += Binary1[index];
				}
			}
			return binaryEquiv;
		}
	}

	/**
	 * Checks the length of the input and disables all input if it
	 * exceeds the maximum value.
	 * maxInputChar's value is updated when base types are changed.
	 */
	private void checkEntryLength() {
		if ( valueString.length() >= maxInputChar ) {
			mZero.setClickable(false);
			mOne.setClickable(false);
			mTwo.setClickable(false);
			mThree.setClickable(false);
			mFour.setClickable(false);
			mFive.setClickable(false);
			mSix.setClickable(false);
			mSeven.setClickable(false);
			mEight.setClickable(false);
			mNine.setClickable(false);
			mHexA.setClickable(false);
			mHexB.setClickable(false);
			mHexC.setClickable(false);
			mHexD.setClickable(false);
			mHexE.setClickable(false);
			mHexF.setClickable(false);
		}
		else{
			buttonsClickable();
		}
	}

	// Method to take a string as and input to have it reversed.
	// The reversed string is returned.
	String stringReverse(String z) {
		int len = z.length();
		String tempString = "";
		for (int i = len - 1; i >= 0; i--) {
			tempString += z.charAt(i);
		}
		return tempString;
	}

	// Method to take in a CharSequence that represents a binary sequence
	// and insert spaces every four bits.
	// Returns a CharSequence
	private CharSequence fourCharFormat(CharSequence z) {
		if (z.length() == 0){
			return "";
		}
		String temp = z.toString();
		CharSequence bin;
		int length = temp.length();
		int numStrings;
		if ( length % 4 == 0 ) {
			numStrings = length / 4;
		}
		else {
			numStrings = length / 4 + 1;
		}
		temp = stringReverse(temp);
		String temp2 = "";
		for (int i = 0; i < numStrings; i++) {
			if ( i == numStrings - 1 ) {
				temp2 += temp.substring(4 * i, length);
			}
			else {
				temp2 += temp.substring(4 * i, 4 * (i + 1));
				temp2 += " ";
			}
		}
		temp = stringReverse(temp2);
		bin = (CharSequence) temp;
		return bin;
	}

	/**
	 * Formats a decimal sequence to include a comma every 10^3 digits.
	 * 
	 * @param z
	 *            : the decimal sequence.
	 * @return: the formatted decimal sequence.
	 */
	private CharSequence threeCharFormat(CharSequence z, boolean forDecimal) {
		if (z.length() == 0){
			return "";
		}
		String temp = z.toString();
		CharSequence ret;
		int length = temp.length();
		int numStrings = (length % 3 == 0) ? length / 3 : length / 3 + 1;
		temp = stringReverse(temp);
		String temp2 = "";
		for (int i = 0; i < numStrings; i++) {
			if ( i == numStrings - 1 ) {
				temp2 += temp.substring(3 * i, length);
			}
			else {
				temp2 += temp.substring(3 * i, 3 * (i + 1));
				if ( forDecimal == true ) {
					temp2 += ",";
				}
				else {
					temp2 += " ";
				}
			}
		}
		temp = stringReverse(temp2);
		ret = (CharSequence) temp;
		return ret;
	}
}