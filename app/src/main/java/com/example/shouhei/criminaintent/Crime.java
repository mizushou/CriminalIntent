package com.example.shouhei.criminaintent;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Crime {

  private UUID mId;
  private String mTitle;
  private LocalDate mDate;
  private boolean mSolved;

  public Crime() {
    mId = UUID.randomUUID();
    mDate = LocalDate.now();
  }

  public UUID getId() {
    return mId;
  }

  public void setId(UUID id) {
    mId = id;
  }

  public String getTitle() {
    return mTitle;
  }

  public void setTitle(String title) {
    mTitle = title;
  }

  public LocalDate getDate() {
    return mDate;
  }

  public void setDate(LocalDate date) {
    mDate = date;
  }

  public boolean isSolved() {
    return mSolved;
  }

  public void setSolved(boolean solved) {
    mSolved = solved;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Crime crime = (Crime) o;
    return Objects.equals(mId, crime.mId);
  }

  @Override
  public int hashCode() {

    return Objects.hash(mId);
  }
}
