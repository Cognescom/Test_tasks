package by.mbicycle.test.three;

import java.sql.*;
import java.util.Scanner;
/**
 *  Main
 * @author Stas Nesteruk
 */
public class Main {
    //Declare constants
    private static final String CLASSNAME = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/db_books";
    private static final String USERNAME = "temp";
    private static final String PASS = "temp";

    public static void main(String[] args) {
        String query = "SELECT name FROM books WHERE book_id " +
                "IN(SELECT book_id FROM link_table INNER JOIN authors USING(author_id) " +
                "WHERE authors.name LIKE '%s' and authors.surname LIKE '%s')";
        Scanner in = new Scanner(System.in);
        String nameAuthor = in.nextLine();
        String[] author = nameAuthor.split(" ");
        String sqlQuery = String.format(query, author[0],author[1]);
        try{
            Class.forName(CLASSNAME);
            try(Connection cn = DriverManager.getConnection(URL, USERNAME, PASS);
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sqlQuery);){
                while (rs.next()) {
                    String name = rs.getString("name");
                    System.out.println(name);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}