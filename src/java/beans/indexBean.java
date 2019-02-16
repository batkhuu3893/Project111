package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped

public class indexBean implements Serializable {
        static final String URL = "jdbc:mysql://localhost:3306/test";
        static final String USERNAME = "root";
        static final String PASSWORD = "password";  
                
        private Integer syoken_id;
        private String syumoku;
        private String syurui;
        private String sikibi;
        private String syukibi;
        private String mosikomibi;
        
        private String kokyaku_sei;
        private String kokyaku_mei;
        private String kozin;
        private Integer nenrei;
        
        private Integer sibo;
        private Integer koisyogai;
        private String syuzyutu;
        private String nyuin;
        private String tuin;
        
        private Integer hokenryo;
 
    public Integer getSyoken_id() {
        return syoken_id;
    }
    
    public void setSyoken_id(Integer syoken_id) {
        this.syoken_id = syoken_id;
        System.out.println(this.syoken_id);
    }

    public String getSyumoku() {
        return syumoku;
    }

    public void setSyumoku(String syumoku) {
        this.syumoku = syumoku;
        System.out.println(this.syumoku);
    }

    public String getSyurui() {
        return syurui;
    }

    public void setSyurui(String syurui) {
        this.syurui = syurui;
        System.out.println(this.syurui);
    }
    
    public String getSikibi() {
        return sikibi;
    }

    public void setSikibi(String sikibi) {
        this.sikibi = sikibi;
        System.out.println(this.sikibi);
    }
    
    public String getSyukibi() {
        return syukibi;
    }

    public void setSyukibi(String syukibi) {
        this.syukibi = syukibi;
        System.out.println(this.syukibi);
    }

    public String getMosikomibi() {
        return mosikomibi;
    }

    public void setMosikomibi(String mosikomibi) {
        this.mosikomibi = mosikomibi;
        System.out.println(this.mosikomibi);
    }

    public String getKokyaku_sei() {
        return kokyaku_sei;
    }

    public void setKokyaku_sei(String kokyaku_sei) {
        this.kokyaku_sei = kokyaku_sei;
        System.out.println(this.kokyaku_sei);
    }

    public String getKokyaku_mei() {
        return kokyaku_mei;
    }

    public void setKokyaku_mei(String kokyaku_mei) {
        this.kokyaku_mei = kokyaku_mei;
        System.out.println(this.kokyaku_mei);
    }
    
    public String getKozin() {
        return kozin;
    }

    public void setKozin(String kozin) {
        this.kozin = kozin;
        System.out.println(this.kozin);
    }
    
    public Integer getNenrei() {
        return nenrei;
    }

    public void setNenrei(Integer nenrei) {
        this.nenrei = nenrei;
        System.out.println(this.nenrei);
    }
    
    public Integer getSibo() {
        return sibo;
    }

    public void setSibo(Integer sibo) {
        this.sibo = sibo;
        System.out.println(this.sibo);
    }
    
    public Integer getKoisyogai() {
        return koisyogai;
    }

    public void setKoisyogai(Integer koisyogai) {
        this.koisyogai = koisyogai;
        System.out.println(this.koisyogai);
    }
    
    public String getSyuzyutu() {
        return syuzyutu;
    }

    public void setSyuzyutu(String syuzyutu) {
        this.syuzyutu = syuzyutu;
        System.out.println(this.syuzyutu);
    }
    
    public String getNyuin() {
        return nyuin;
    }

    public void setNyuin(String nyuin) {
        this.nyuin = nyuin;
        System.out.println(this.nyuin);
    }

    public String getTuin() {
        return tuin;
    }

    public void setTuin(String tuin) {
        this.tuin = tuin;
        System.out.println(this.tuin);
    }

    public Integer getHokenryo() {
        return hokenryo;
    }

    public void setHokenryo(Integer hokenryo) {
        this.hokenryo = hokenryo;
        System.out.println(this.hokenryo);
    }
    
     public String save() {   
                String sql = "INSERT INTO touroku(syoken_id, hoken_syumoku, hoken_syurui, sikibi, syukibi, mosikomibi, kokyaku_sei, kokyaku_mei,kokyaku_kozin_hozin, kokyaku_nenrei, sibo, koisyogai, syuzyutu, nyuin, tuin) "
                     + "VALUES ('1000','"+syumoku+"','"+syurui+"','"+sikibi+"','"+syukibi+"','"+mosikomibi+"','"+kokyaku_sei+"','"+kokyaku_mei+"','"+kozin+"','"+nenrei+"','"+sibo+"','"+koisyogai+"','"+syuzyutu+"','"+nyuin+"','"+tuin+"')";
            
        try{
             Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = conn.prepareStatement(sql); 
             int rs = stmt.executeUpdate(sql);
                   System.out.println("結果：" + rs);
                        FacesContext facesContext = FacesContext.getCurrentInstance();
                        FacesMessage errorMessage = new FacesMessage("保存されました");
                        facesContext.addMessage(null, errorMessage);
                   return "design.xhtml";
            }catch (SQLException e) {
                       e.printStackTrace();                   
            } 
         return null;
     }


}
