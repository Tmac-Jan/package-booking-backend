package com.oocl.packagebooking.Utils;

import com.oocl.packagebooking.enums.StatusEnum;

public class EnumUtils {

  public static <T extends StatusEnum> T getByCode(Integer code, Class<T> enumClass) {
    for (T each : enumClass.getEnumConstants()) {
      if (code.equals(each.getStatus())) {
        return each;
      }
    }
    return null;
  }
}
