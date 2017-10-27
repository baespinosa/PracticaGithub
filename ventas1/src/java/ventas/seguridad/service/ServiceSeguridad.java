/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.seguridad.service;

import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import ventas.seguridad.model.ManagerSeguridad;
import ventas.seguridad.model.dto.LoginDTO;

/**
 *
 * @author BRYAN - PC
 */
@WebService(serviceName = "ServiceSeguridad")
public class ServiceSeguridad {
    @EJB
    private ManagerSeguridad ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "crearUsuario")
    @Oneway
    public void crearUsuario(@WebParam(name = "idUsuario") String idUsuario, @WebParam(name = "nombres") String nombres, @WebParam(name = "tipoUsuario") String tipoUsuario, @WebParam(name = "correo") String correo) {
        ejbRef.crearUsuario(idUsuario, nombres, tipoUsuario, correo);
    }

    @WebMethod(operationName = "login")
    public LoginDTO login(@WebParam(name = "correo") String correo) throws Exception {
        return ejbRef.login(correo);
    }
    
}
