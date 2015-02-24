package com.kdn.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list")
public class BoardList extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물목록</title></head><body>");
    out.println("<h1>게시물 목록</h1>");
    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("<th>번호</th>");
    out.println("<th>제목</th>");
    out.println("<th>등록일</th>");
    out.println("<th>조회수</th>");
    out.println("</tr>");
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          /* JDBC URL */ "jdbc:mysql://localhost:3306/kdndb",
          /* User ID */ "kdn",
          /* User Password */ "123456789");
      stmt = con.createStatement();
      rs = stmt.executeQuery("select bno, title, create_date, view from boards");
      while(rs.next()) { //DBMS 서버에서 레코드를 하나 가져온다.
        out.println("<tr>");
        out.println("<td>" + rs.getInt("bno") + "</td>");
        out.println("<td><a href='detail?no=" 
            + rs.getInt("bno") + "'>" 
            + rs.getString("title") 
            + "</a></td>");
        out.println("<td>" + rs.getDate("create_date") + "</td>");
        out.println("<td>" + rs.getInt("view") + "</td>");
        out.println("</tr>");
      }
      out.println("</table>");
      out.println("<p><a href='form.html'>[새 글]</a></p>");
      out.println("</body></html>");
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }

  }
}
