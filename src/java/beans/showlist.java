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
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@RequestScoped
@Named
public class showlist implements Serializable {
    static final String URL = "jdbc:mysql://localhost:3306/test";
    static final String USERNAME = "root";
    static final String PASSWORD = "password";  
    private List<Person> showList;

    public List<Person> getShowList() {
        return showList;
    }

    public void setShowList(List<Person> showList) {
        this.showList = showList;
    }

    @PostConstruct
    public void item() {
          this.showList = new ArrayList<>();
          String sql = "SELECT * FROM touroku";
                             
        try {
             Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = connect.prepareStatement(sql);                         
             ResultSet result = stmt.executeQuery(sql);
             int row = 1;
                while (result.next()){
                    Person record = new Person();
                    record.syoken_id = result.getInt(1);
                    record.hoken_syumoku = result.getString(2); 
                    record.sikibi = result.getString(3);
                    record.syukibi = result.getString(4);
                    record.kokyaku_mei = result.getString(5);                    
                    this.showList.add(record);
                    row ++;
                } 
             }catch (SQLException e){
                e.printStackTrace();
         }  
    };

    public class Person{
        private int syoken_id;
        private String hoken_syumoku;
        private String sikibi;
        private String syukibi;
        private String kokyaku_mei;

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

        public String getKokyaku_mei() {
            return kokyaku_mei;
        }

        public void setKokyaku_mei(String kokyaku_mei) {
            this.kokyaku_mei = kokyaku_mei;
        }
    }
}
