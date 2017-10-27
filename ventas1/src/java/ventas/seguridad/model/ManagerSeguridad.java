/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.seguridad.model;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ventas.model.dao.Usuario;
import ventas.seguridad.model.dto.LoginDTO;

/**
 *
 * @author Anita
 */
@Stateful
public class ManagerSeguridad {

    @PersistenceContext (unitName = "ventasDS")
    private EntityManager em;
    
    //crear usuario
    public void crearUsuario (String idUsuario, String nombres, String tipoUsuario, String correo){
        Usuario u= new Usuario(idUsuario, nombres,tipoUsuario);
        u.setCorreo(correo);
        em.persist(u);
    }
    
    //acceder al sistema
    public LoginDTO login (String correo)throws Exception{
     Query q;
     q=em.createNamedQuery("Usuario.findByCorreo",Usuario.class);
     q.setParameter("correo",correo);
     Usuario u=(Usuario)q.getSingleResult();
     if(u==null)
         throw  new Exception("NO EXISTE EL CORREO");
     LoginDTO loginDTO=new LoginDTO(u.getCorreo(),u.getTipoUsuario());
     loginDTO.setIdUsuario(u.getIdUsuario());
     return loginDTO;
    }
    
}

