/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package han.dev.admin;

import han.dev.data.dao.Database;
import han.dev.data.dao.DatabaseDao;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

/**
 *
 * @author Admin
 */
public class BaseAdminServlet extends HttpServlet {
    
    public void init(ServletConfig config) throws ServletException {
            super.init(config);
            DatabaseDao.init(new Database());
}
}
