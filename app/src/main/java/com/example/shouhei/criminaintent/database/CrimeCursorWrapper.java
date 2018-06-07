package com.example.shouhei.criminaintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.shouhei.criminaintent.Crime;
import com.example.shouhei.criminaintent.database.CrimeDbSchema.CrimeTable;

import java.time.LocalDate;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
  public CrimeCursorWrapper(Cursor cursor) {
    super(cursor);
  }

  public Crime getCrime() {

    String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
    String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
    String date = getString(getColumnIndex(CrimeTable.Cols.DATE));
    int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
    String suspect = getString(getColumnIndex(CrimeTable.Cols.SUSPECT));

    Crime crime = new Crime(UUID.fromString(uuidString));
    crime.setTitle(title);
    crime.setDate(LocalDate.parse(date));
    crime.setSolved(isSolved != 0);
    crime.setSuspect(suspect);

    return crime;
  }
}
