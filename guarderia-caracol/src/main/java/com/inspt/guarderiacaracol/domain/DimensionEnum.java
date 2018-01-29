package com.inspt.guarderiacaracol.domain;

import java.util.ArrayList;
import java.util.List;

public enum DimensionEnum {
	
    BIG("B", "10m", "4m"), MEDIUM("M", "6m", "3m"), SMALL("S", "4m", "2m");
	
    private String idDimension;
    
    private String depth;
    
    private String width;
    
    private DimensionEnum(String idDimension, String depth, String width){
        this.idDimension = idDimension;
        this.depth = depth;
        this.width = width;
    }
    
    public static DimensionEnum getDimensionByString(String idDimension){
        for(DimensionEnum dimensionEnumValue: DimensionEnum.values()){
            if(dimensionEnumValue.idDimension.equals(idDimension)){
                return dimensionEnumValue;
            }
        }
        return null;
    }
    
    public static String[] getDimensionsStringArray(){
        List<String> dimensions = new ArrayList<String>();
        for(DimensionEnum dimensionEnumValue: DimensionEnum.values()){
            String dimensionString = dimensionEnumValue.name().toLowerCase();
            dimensionString = String.valueOf(dimensionString.charAt(0)).toUpperCase() + dimensionString.substring(1);
            dimensions.add(dimensionString.replaceAll("_", " "));
        }
        return dimensions.toArray(new String[0]);
    }

    public String getIdDimension() {
        return idDimension;
    }

    public String getDepth() {
        return depth;
    }

    public String getWidth() {
        return width;
    }
    
}