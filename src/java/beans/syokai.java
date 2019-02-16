package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
        
public class syokai implements Serializable{
    static final String URL = "jdbc:mysql://localhost:3306/test";
    static final String USERNAME = "root";
    static final String PASSWORD = "password";  
    private List<item> savelist;

    public List<item> getSavelist() {
        return savelist;
    }

    public void setSavelist(List<item> savelist) {
        this.savelist = savelist;
    }

    @PostConstruct
    public void item() {
          this.savelist = new ArrayList<>();                
          String sql = "SELECT * FROM touroku";    
          
        try {
             Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = connect.prepareStatement(sql);                         
             ResultSet result = stmt.executeQuery(sql);
             int row = 1;
                while (result.next()){
                    System.out.println(result.getInt(17));
                    System.out.println(result.getString(13));
                    item record = new item();
                    record.syoken_id = result.getInt(1);
                    record.hoken_syumoku = result.getString(2);
                    record.hoken_syurui = result.getString(3);
                    record.sikibi = result.getString(4);
                    record.syukibi = result.getString(5);
                    record.mosikomibi = result.getString(6);
                    record.kokyaku_mei = result.getString(7);
                    record.kokyaku_sei = result.getString(8);
                    record.kokyaku_kozin_hozin = result.getString(9);
                    record.kokyaku_nenrei = result.getInt(10);
                    record.sibo = result.getString(13);
                    record.koisyogai = result.getString(14);
                    record.syuzyutu = result.getString(15);
                    record.nyuin = result.getString(16);
                    record.tuin = result.getString(17);     
                    
                    this.savelist.add(record);
                    row ++;
                } 
             }catch (SQLException e){
                e.printStackTrace();
         }  
       
    };

    public static class item{
        private int syoken_id;
        private String hoken_syumoku;
        private String hoken_syurui;
        private String sikibi;
        private String syukibi;
        private String mosikomibi;
        private String kokyaku_sei;
        private String kokyaku_mei;
        private String kokyaku_kozin_hozin;
        private int kokyaku_nenrei;
        private String sibo;
        private String koisyogai;
        private String syuzyutu;
        private String nyuin;
        private String tuin;
        private int gokei_hokenryo;

        public int getSyoken_id() {
            return syoken_id;
        }

        public void setSyoken_id(int syoken_id) {
            this.syoken_id = syoken_id;
        }

        public String getHoken_syumoku() {
            return hoken_syumoku;
        }

        public void setHoken_syumoku(String hoken_syumoku) {
            this.hoken_syumoku = hoken_syumoku;
        }

        public String getHoken_syurui() {
            return hoken_syurui;
        }

        public void setHoken_syurui(String hoken_syurui) {
            this.hoken_syurui = hoken_syurui;
        }

        public String getSikibi() {
            return sikibi;
        }

        public void setSikibi(String sikibi) {
            this.sikibi = sikibi;
        }

        public String getSyukibi() {
            return syukibi;
        }

        public void setSyukibi(String syukibi) {
            this.syukibi = syukibi;
        }

        public String getMosikomibi() {
            return mosikomibi;
        }

        public void setMosikomibi(String mosikomibi) {
            this.mosikomibi = mosikomibi;
        }

        public String getKokyaku_sei() {
            return kokyaku_sei;
        }

        public void setKokyaku_sei(String kokyaku_sei) {
            this.kokyaku_sei = kokyaku_sei;
        }

        public String getKokyaku_mei() {
            return kokyaku_mei;
        }

        public void setKokyaku_mei(String kokyaku_mei) {
            this.kokyaku_mei = kokyaku_mei;
        }

        public String getKokyaku_kozin_hozin() {
            return kokyaku_kozin_hozin;
        }
 
        public int getKokyaku_nenrei() {
            return kokyaku_nenrei;
        }

        public void setKokyaku_nenrei(int kokyaku_nenrei) {
            this.kokyaku_nenrei = kokyaku_nenrei;
        }       

        public void setKokyaku_kozin_hozin(String kokyaku_kozin_hozin) {
            this.kokyaku_kozin_hozin = kokyaku_kozin_hozin;
        }

        public String getSibo() {
            return sibo;
        }

        public void setSibo(String sibo) {
            this.sibo = sibo;
        }

        public String getKoisyogai() {
            return koisyogai;
        }

        public void setKoisyogai(String koisyogai) {
            this.koisyogai = koisyogai;
        }

        public String getSyuzyutu() {
            return syuzyutu;
        }

        public void setSyuzyutu(String syuzyutu) {
            this.syuzyutu = syuzyutu;
        }

        public String getNyuin() {
            return nyuin;
        }

        public void setNyuin(String nyuin) {
            this.nyuin = nyuin;
        }

        public String getTuin() {
            return tuin;
        }

        public void setTuin(String tuin) {
            this.tuin = tuin;
        }

        public int getGokei_hokenryo() {
            return gokei_hokenryo;
        }

        public void setGokei_hokenryo(int gokei_hokenryo) {
            this.gokei_hokenryo = gokei_hokenryo;
        }

    }
}
