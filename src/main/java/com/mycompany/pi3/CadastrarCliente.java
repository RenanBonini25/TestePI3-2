/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pi3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author renan.bfsilva
 */
@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
            String nome = request.getParameter("TxtNome");
            String cpf = request.getParameter("TxtCPF");
            String sexo = request.getParameter("Sexo");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //Date dataNasc = new Date();
            
            String data = request.getParameter("DataNascimento");
            //Date dataNasc = dateFormat.parse(data);
            
            String estadoCivil = request.getParameter("EstadoCivil");
            String endereco = request.getParameter("TxtEndereco");
            String complemento = request.getParameter("TxtComplemento");
            String numero = request.getParameter("TxtNumeroEnd");
            String bairro = request.getParameter("TxtBairro");
            String cep = request.getParameter("TxtCep");
            String cidade = request.getParameter("TxtCidade");
            String estado = request.getParameter("Estados");
            
            Cliente cliente = new Cliente (nome,cpf,sexo,data,estadoCivil,endereco,complemento,
            numero,bairro,cep,cidade,estado);
            
        try {
            DAO.incluir(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            response.sendRedirect("/pi3-1.0-SNAPSHOT/Listagem");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
