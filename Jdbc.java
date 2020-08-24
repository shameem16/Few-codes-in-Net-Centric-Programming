

import java.sql.*;
import java.io.*;
import java.util.*;

public class Jdbc{
public static void main(String[] args) throws Exception {
try {
Class.forName("com.mysql.jdbc.Driver");
Connection con = (Connection)
DriverManager.getConnection("jdbc:mysql://localhost:3306/student_profile", "root","shameem");
System.out.println("success");
Statement stmt=con.createStatement();
Scanner sc=new Scanner(System.in);
String uid, uname, mobile, email, resume_link, dob, isadmin, gend, pwd,query;
System.out.println("Enter your user ID: ");
uid=sc.nextLine();
System.out.println("Enter your username: ");
uname=sc.nextLine();
System.out.println("Enter your mobile number: ");
mobile=sc.nextLine();
System.out.println("Enter your email id: ");
email=sc.nextLine();
System.out.println("Enter your resume link: ");
resume_link=sc.nextLine();
System.out.println("Enter your date of birth:dd/mm/yyyy ");
dob=sc.nextLine();
System.out.println("Are you an admin (0 if no/1 if yes): ");
isadmin=sc.nextLine();
System.out.println("Enter your Gender (M for male/F fro female): ");
gend=sc.nextLine();
System.out.println("Enter  password: ");
pwd=sc.nextLine();
query="insert into users values('"+uid+"','"+uname+"','"+mobile+"','"+email+"','"+resume_link+"','"+dob+"','"+isadmin+"','"+gend+"','"+pwd+"')";
if(stmt.executeUpdate(query)==1)
{System.out.println("Successful Execution");
ResultSet rs=stmt.executeQuery("select * from users");
while(rs.next())
System.out.println(rs.getString(1)+" "+rs.getString(2)+""+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+""+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9));
}
else
{
System.out.println("Execution Failed");
}
con.close();
}
catch(Exception e){ System.out.println(e);}
}
}
