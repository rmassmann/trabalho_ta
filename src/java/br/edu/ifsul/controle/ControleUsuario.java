/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.ejb.BeanChat;
import br.edu.ifsul.ejb.BeanUsuario;
import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Renan
 */
@Named(value="controleUsuario")
@SessionScoped
public class ControleUsuario implements Serializable
{
    @EJB
    private BeanUsuario beanUsuario;
    @EJB
    private BeanChat beanChat;
    
    public ControleUsuario(){
        
    }
    public String InformarUsuario(){
       if(!beanChat.getListaUsuarios().contains(beanUsuario.getUsuario())){
            beanChat.novoUsuario(beanUsuario.getUsuario()); 
            return "chat";
       } 
       else{
            FacesMessage msg = new FacesMessage("Usuario já existe, tente novamente");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "index";
       }
      
    }
    
    public String excluirUsuario(){
        String user = beanUsuario.getUsuario();
        beanChat.excluirUsuario(beanUsuario.getUsuario()); 
        System.out.println("aquiLLLLLLLLLLLLLLL");
      return "chat";
    }
    
    public BeanUsuario getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(BeanUsuario beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public BeanChat getBeanChat() {
        return beanChat;
    }

    public void setBeanChat(BeanChat beanChat) {
        this.beanChat = beanChat;
    }

  
    
    
    
}
