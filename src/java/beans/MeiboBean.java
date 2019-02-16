package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
 
public class MeiboBean {
        static final String URL = "jdbc:mysql://localhost:3306/test";
        static final String USERNAME = "root";
        static final String PASSWORD = "password";        
        
    private String name;
    private String password;
    private Integer syoken_id;
    private String sikibi;
    private String syukibi;
    private String hoken_syumoku;
    private String kokyaku_mei;

	private  string kk;

    private List< Expense> peopleList;
    public void init() {
        
    }
    public String getSikibi() {
        return sikibi;
    }

    public List<Expense> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<Expense> peopleList) {
        this.peopleList = peopleList;
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

    public String getHoken_syumoku() {
        return hoken_syumoku;
    }

    public void setHoken_syumoku(String hoken_syumoku) {
        this.hoken_syumoku = hoken_syumoku;
    }

    public String getKokyaku_mei() {
        return kokyaku_mei;
    }

    public void setKokyaku_mei(String kokyaku_mei) {
        this.kokyaku_mei = kokyaku_mei;
    }
    
    public Integer getSyoken_id() {
        return syoken_id;
    }

    public void setSyoken_id(Integer syoken_id) {
        this.syoken_id = syoken_id;
    }

    public void toConsole(){
        System.out.println("name="+this.name+"/ password="+this.password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
public String select(){  
        String sql = "SELECT * FROM users WHERE name = \"" + name + "\" AND password= \"" + password + "\";";
            
        try {
            // MySQLに接続
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = conn.createStatement();            
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                System.out.println(rs.getString("name"));
                return "select.xhtml";
            }
                        
            stm.close();
            conn.close();           

            if(name.equals("") || password.equals("")){
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage errorMessage = new FacesMessage("ユーザーＩＤ、もしくはパスワードが未入力です!");
                facesContext.addMessage(null, errorMessage);
            }else if(!(name.matches("[0-9a-zA-Z]+")) || !(password.matches("[0-9a-zA-Z]+"))){
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage errorMessage = new FacesMessage("ユーザーＩＤ、もしくはパスワードの入力が半角英数字以外です!");
                facesContext.addMessage(null, errorMessage);
            }else{
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage errorMessage = new FacesMessage("ユーザーＩＤ、もしくはパスワードの入力誤っています");
                facesContext.addMessage(null, errorMessage);
            }
            
        } catch (SQLException e) {
            System.out.println("MySQLに接続できませんでした。");
        } 
            return null;
    }
    
    public String design(){
        
        String sql = "SELECT * FROM record WHERE number = \"" + syoken_id + "\";";
        
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = conn.createStatement();            
            ResultSet rs = stm.executeQuery(sql);            
            while(rs.next()){
                System.out.println(rs.getInt("number"));
                return "design.xhtml";
            }      
            
        } catch (SQLException e) {
            System.out.println("MySQLに接続できませんでした。");
        } 
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage errorMessage = new FacesMessage("照会番号が違います!");
            facesContext.addMessage(null, errorMessage);
            return null;
    }
 
   public String syokai(){
       String sql = "SELECT * FROM record WHERE number = \"" + syoken_id + "\";";
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement stm = conn.createStatement();            
            ResultSet rs = stm.executeQuery(sql);            
            while(rs.next()){
                return "syokai.xhtml";
            }      
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage errorMessage = new FacesMessage("入力した照会番号の情報見つかりませんでした!");
            facesContext.addMessage(null, errorMessage);
            return null;
    }  
     
     public String showList() throws ClassNotFoundException{       
         return "showlist.xhtml";
    };
 
}

