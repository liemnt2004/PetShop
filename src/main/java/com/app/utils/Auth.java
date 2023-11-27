package com.app.Utils;


import com.app.Daos.NhanVienDao;
import com.app.Entitys.NhanVien;
import com.app.Entitys.TaiKhoan;


public class Auth {
    static NhanVienDao dao = new NhanVienDao();
    public static TaiKhoan user = null;
    public static void clear(){
        Auth.user =  null;
    }
    public static boolean isLogin(){
        return Auth.user != null;
    }
    public static boolean isManager(){
        NhanVien nv = new NhanVien();
        nv = dao.selectById(user.getMaNhanVien());
        return Auth.isLogin() && nv.isMaVaitro() ;
    }
//      public static void checkLogin(Component btnXoa){
//        if(!Auth.isLogin()){
//            System.exit(0);
//        }
//        else if(btnXoa == null){
//            
//        } else if(!isManager()){
//            btnXoa.setEnabled(false);
//        }
//    }
}
