import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String firstname=request.getParameter("firstname");  
        String lastname=request.getParameter("lastname");  
        String address=request.getParameter("address");  
        String country=request.getParameter("country"); 
        String city=request.getParameter("city");  
        String postcode=request.getParameter("postcode");  
        String telephone=request.getParameter("telephone");
        String salary=request.getParameter("salary");

          
        Emp e=new Emp();  
        e.setName(firstname);  
        e.setPassword(lastname);  
        e.setEmail(address);  
        e.setCountry(country);  
        e.setCity(city);
        e.setPostcode(postcode);
        e.setTelephone(telephone);
        e.setSalary(salary);
        
        int status=EmpDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}