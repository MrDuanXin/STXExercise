package com.stx.p6;

import java.util.Date;

public class Six_DuanXinYu_AdenovirusVaccine extends Six_DuanXinYu_Vaccine{
    private static final String description="疫苗信息:腺病毒载体疫苗，1针...重症保护效力90.07%。\n";
    public Six_DuanXinYu_AdenovirusVaccine(String name, String needTime, Date inoculateDate, Date appointmentDate, int status) {
        super("腺病毒载体疫苗", needTime, inoculateDate, appointmentDate, 1);
    }

    public String description(){
        return description;
    }
}
