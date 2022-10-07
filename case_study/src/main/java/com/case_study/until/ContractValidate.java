package com.case_study.until;

import java.time.LocalDate;
import java.time.Period;

public class ContractValidate {
    public static boolean checkStartDay(LocalDate startTime){
        LocalDate now = LocalDate.now();

        if (startTime.equals(now)){
            return true;
        }
        return false;
    }

    public static boolean checkEndDay(LocalDate endDay){
        LocalDate now = LocalDate.now();

        if (endDay.equals(now) || endDay.isAfter(now)){
            return true;
        }
        return false;
    }
}
