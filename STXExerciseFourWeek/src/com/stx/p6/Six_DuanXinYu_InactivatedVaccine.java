package com.stx.p6;

import java.util.Date;

public class Six_DuanXinYu_InactivatedVaccine extends Six_DuanXinYu_Vaccine{
    private static final String description="灭活疫苗,2针。第二针间隔14~28天。重症保护效力100%。\n";
    public Six_DuanXinYu_InactivatedVaccine(String name, String needTime, Date inoculateDate, Date appointmentDate, int status) {
        super("灭活疫苗", needTime, inoculateDate, appointmentDate, 1);
    }
    public String description(){
        return description;
    }
}
