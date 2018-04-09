package com.test.annotation;

import java.lang.reflect.Field;

/**
 * 注解处理器
 */
public class FruitInfoUtil {

  public static void getFruitInfo(Class<?> clazz) {
    String strFruitName = "水果名称:";
    String strFruitColor = "水果颜色:";
    String strFruitProvicer = "供应商信息:";

    Field[] fields = clazz.getDeclaredFields();
    for(Field field : fields) {
      if (field.isAnnotationPresent(FruitName.class)) {
        FruitName fruitName = field.getAnnotation(FruitName.class);
        System.out.println(strFruitName + fruitName.value());
      } else if (field.isAnnotationPresent(FruitColor.class)) {
        FruitColor fruitColor = field.getAnnotation(FruitColor.class);
        System.out.println(strFruitColor + fruitColor.fruitColor());
      } else if(field.isAnnotationPresent(FruitProvider.class)) {
        FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
        System.out.println(strFruitProvicer + " 名称:" + fruitProvider.name()
            + " 地址:" + fruitProvider.address());
      }
    }
  }
}
