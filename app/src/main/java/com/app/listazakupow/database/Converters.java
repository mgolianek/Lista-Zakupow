package com.app.listazakupow.database;

import androidx.room.TypeConverter;

import com.app.listazakupow.models.enums.QuantityType;

public class Converters {
    @TypeConverter
    public static int fromQuantityTypeToInt(QuantityType value) {
        return value.ordinal();
    }

    @TypeConverter
    public static QuantityType fromIntToQuantityType(int value) {
        return (QuantityType.values()[value]);
    }
}