package com.example.shouhei.criminaintent;

import android.support.v4.app.Fragment;

public class CrimeListActivity extends SingleFragmentActivity {

  private static final String TAG = "CrimeListActivity";

  @Override
  protected Fragment createFragment() {
    return new CrimeListFragment();
  }
}
