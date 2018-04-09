package com.test.annotation;

import com.test.annotation.FruitColor.Color;

/**
 * 注解使用.
 */
public class Apple {

  @FruitName("Apple")
  private String appleName;

  @FruitColor(fruitColor = Color.RED)
  private String appleColor;

  @FruitProvider(id = 1, name = "陕西红富士", address = "陕西省西安市")
  private String appleProvider;

  public String getAppleName() {
    return appleName;
  }

  public void setAppleName(String appleName) {
    this.appleName = appleName;
  }

  public String getAppleColor() {
    return appleColor;
  }

  public void setAppleColor(String appleColor) {
    this.appleColor = appleColor;
  }

  public String getAppleProvider() {
    return appleProvider;
  }

  public void setAppleProvider(String appleProvider) {
    this.appleProvider = appleProvider;
  }
}
