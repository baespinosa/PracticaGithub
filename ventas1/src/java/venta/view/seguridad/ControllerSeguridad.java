/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venta.view.seguridad;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import ventas.seguridad.model.ManagerSeguridad;
import ventas.seguridad.model.dto.LoginDTO;

/**
 *
 * @author BRYAN - PC
 */
@SessionScoped
@ManagedBean
public class ControllerSeguridad {
  private String correo;
  private String idUsuario;
 @EJB
 private ManagerSeguridad managerSeguridad;
 public void actionLogin(){
     try {
         LoginDTO login= managerSeguridad.login(correo);
         idUsuario= login.getIdUsuario();
         System.out.println("id de usuario: "+idUsuario);
     }catch (Exception ex){
         System.out.println("Error: "+ex.getMessage());
     }
 }
}
