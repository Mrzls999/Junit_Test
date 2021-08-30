package javaWeb.demo;


import com.google.gson.Gson;
import javaSe.Test_Serializable.Person;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Generate_Table_Servlet", urlPatterns = "/generateTableServlet")
public class Generate_Table_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> arrayList = new ArrayList<>();//创建集合用来存放 人
        //创建人
        Person person1 = new Person("zls", 20, "中国");
        Person person2 = new Person("zrs", 22, "中国");
        Person person3 = new Person("zxs", 23, "中国");
        Person person4 = new Person("zxx", 24, "中国");
        //将人 添加到集合中
        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(person3);
        arrayList.add(person4);
        Gson gson = new Gson();//得到Gson对象，用来生成json字符串
        String personJson = gson.toJson(arrayList);//将集合形式的数据转换为json字符串
        response.getWriter().write(personJson);
    }
}
