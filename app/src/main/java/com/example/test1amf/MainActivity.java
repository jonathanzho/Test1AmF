package com.example.test1amf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentA.OnFragmentInteractionListener {
  private static final String TAG = "Test1AmF MainAcxtivity";

  private Fragment fragmentA;
  private Fragment fragmentB;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.d(TAG, "onCreate");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState == null) {
      fragmentA = FragmentA.newInstance("fragmentA", "fragmentA");
      fragmentB = FragmentB.newInstance("fragmentB", "fragmentB");
    }
  }

  @Override
  protected void onDestroy() {
    Log.d(TAG, "onDestroy");

    super.onDestroy();
  }

  @Override
  protected void onResume() {
    Log.d(TAG, "onResume");

    super.onResume();

    displayFragmentA();
  }

  @Override
  protected void onPause() {
    Log.d(TAG, "onPause");

    super.onPause();
  }

  private void displayFragmentA() {
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    if (fragmentA.isAdded()) {
      ft.show(fragmentA);
    } else {
      ft.add(R.id.fragment_holder, fragmentA, "A");
    }
    if (fragmentB.isAdded()) {
      ft.hide(fragmentB);
    }
    ft.commit();
  }

  @Override
  public void onFragmentInteraction(Uri uri) {

  }
}
