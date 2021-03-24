package com.stx.p6;

import javafx.scene.control.TableRow;
import jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE;

import java.beans.beancontext.BeanContext;
import java.lang.annotation.Retention;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Six_DuanXinYu_App {
    private static Scanner scanner = new Scanner(System.in);
    private static Six_DuanXinYu_User loginSuccessUser;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
    private static List<Six_DuanXinYu_User> userList = new ArrayList<Six_DuanXinYu_User>();
    public static void main(String[] args) {

        while (true) {
            System.out.println("*****Welcome to use the new crown seedling inoculation system*****");
            System.out.println("请选择：1. user registration\t2. user login\t0. log out");
            String select = scanner.next();
            switch (select) {
                case "1":
                    //user registration
//                    Six_DuanXinYu_User user = regUser();
                    Six_DuanXinYu_User user = new Six_DuanXinYu_User();
                    user.setVaccine(new Six_DuanXinYu_Vaccine());
                    System.out.println("Please enter username：");
                    user.setUname(scanner.next());
                    System.out.println("Please enter password：");
                    user.setUpwd(scanner.next());
                    System.out.println("Please enter phone：");
                    user.setUphone(scanner.next());
                    userList.add(user);
                    break;
                case "2":
                    //user login
                    boolean loginStatus = login(userList);
                    if (loginStatus) {
                        try {
                            userOperation(loginSuccessUser);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }else {
                        adminOperation();
                    }

                    break;
                case "0":
                    //log out
                    System.out.println("log out");
                    return;
            }
        }

    }

    /**
     * registered user
     *
     * @return
     */
    public static Six_DuanXinYu_User regUser() {
        Six_DuanXinYu_User user = new Six_DuanXinYu_User();
        user.setVaccine(new Six_DuanXinYu_Vaccine());
        System.out.println("Please enter username：");
        user.setUname(scanner.next());
        System.out.println("Please enter password：");
        user.setUpwd(scanner.next());
        System.out.println("Please enter phone：");
        user.setUphone(scanner.next());
        return user;
    }

    /**
     * user login
     */
    public static boolean login(List<Six_DuanXinYu_User> userList) {
        System.out.println("Please enter username：");
        String username = scanner.next();
        if ("admin".equals(username)){
            return false;
        }
        System.out.println("Please enter password：");
        String password = scanner.next();
        for (Six_DuanXinYu_User user : userList) {
            if (username.equals(user.getUname()) && password.equals(user.getUpwd())) {
                System.out.println("login success");
                loginSuccessUser = user;
                return true;
            }
        }
        System.out.println("login failed");
        return false;
    }
    /**
     * user Operation
     */
    public static void userOperation(Six_DuanXinYu_User loginSuccessUser) throws ParseException {
        System.out.println("请选择: 1.Inactivated vaccine reservation\t2.Adenovirus vaccine reservation\t3.update phone\t4.update password\t0.log out");
        String select = scanner.next();
        switch (select) {
            case "1":
                System.out.println("Please enter the appointment date：yyyy-MM--dd");
                Date appointmentDate1 = simpleDateFormat.parse(scanner.next());
                loginSuccessUser.setVaccine(new Six_DuanXinYu_InactivatedVaccine(null, null, null, appointmentDate1, 1));
                break;
            case "2":
                System.out.println("Please enter the appointment date：yyyy-MM--dd");
                Date appointmentDate2 = simpleDateFormat.parse(scanner.next());
                loginSuccessUser.setVaccine(new Six_DuanXinYu_InactivatedVaccine(null, null, null, appointmentDate2, 1));
                break;
            case "3":
                System.out.println("Please enter a new phone number");
                loginSuccessUser.setUphone(scanner.next());
                break;
            case "4":
                System.out.println("Please enter a new password");
                loginSuccessUser.setUpwd(scanner.next());
                break;
            case "5":
                return;

        }
    }
    /**
     * administrator Operation
     */
    public static void adminOperation(){
//        System.out.println("Please enter username：");
        String username = "admin";
        System.out.println("Please enter password：");
        String password = scanner.next();
        if ("admin".equals(username)&&"admin".equals(password)){
            while (true) {
                System.out.println("Please select: 1.vaccination_Injection\t2.show_appointment_user\t3.show_Injectioned_user\t0.log out");
                String select = scanner.next();
                switch (select) {
                    case "1":
                        inoculate();
                        break;
                    case "2":
                        showAppointmentUser();
                        break;
                    case "3":
                        showInjectionUser();
                        break;
                    case "0":
                        return;
                }
            }
        }
    }
    public static void inoculate(){
        System.out.println("Please enter an inoculated user:");
        String username = scanner.next();
        for (Six_DuanXinYu_User user : userList) {
            if (username.equals(user.getUname())){
                user.getVaccine().setStatus(0);
                user.getVaccine().setNeedTime(simpleDateFormat.format(new Date()));
                System.out.println("username inoculated success");
            }
        }
    }


    private static void showAppointmentUser(){
        System.out.println("user\tphone_number\tappointment_Date\tVaccine");
        for (Six_DuanXinYu_User user : userList) {
            if (user.getVaccine().getStatus()==1){//appointed No Injection
                System.out.println(user.getUname()+"\t"+user.getUphone()+"\t"+simpleDateFormat.format(user.getVaccine().getAppointmentDate())+"\t"+user.getVaccine().description());
            };
        }
    }
    private static void showInjectionUser(){
        System.out.println("user\tphone_number\tappointment_Date\tinoculated_Date\tVaccine");
        for (Six_DuanXinYu_User user : userList) {
            if (user.getVaccine().getStatus()==0){//appointed No Injection
                System.out.println(user.getUname()+"\t"+user.getUphone()+"\t"+simpleDateFormat.format(user.getVaccine().getAppointmentDate())+"\t"+user.getVaccine().getNeedTime()+"\t"+user.getVaccine().description());
            };
        }
    }
}
