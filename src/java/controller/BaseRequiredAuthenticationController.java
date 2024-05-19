/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.AccountDBContext;
import entity.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author sonnt
 */
public abstract class BaseRequiredAuthenticationController extends HttpServlet {

    private Account getAuthenticatedAccount(HttpServletRequest req) {
        Account account = (Account) req.getSession().getAttribute("account");
        if (account == null) {
            return account;
        }

        String username = null;
        String password = null;

        username = account.getUsername();
        password = account.getPassword();

        if (username != null && password != null) {
            AccountDBContext db = new AccountDBContext();
            account = db.getByUsernamePassword(username, password);
            req.getSession().setAttribute("account", account);
        }
        return account;
    }

    protected abstract void doPost(HttpServletRequest req, HttpServletResponse resp, Account account)
            throws ServletException, IOException;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = getAuthenticatedAccount(req);
        if (account != null) {
            doPost(req, resp, account);
        } else {
            req.getRequestDispatcher("denied.jsp").forward(req, resp);
        }

    }

    protected abstract void doGet(HttpServletRequest req, HttpServletResponse resp, Account account)
            throws ServletException, IOException;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = getAuthenticatedAccount(req);
        if (account != null) {
            doGet(req, resp, account);
        } else {
            req.getRequestDispatcher("denied.jsp").forward(req, resp);
        }
    }

}
