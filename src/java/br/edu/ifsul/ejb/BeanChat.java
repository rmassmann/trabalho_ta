/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ejb;

import br.edu.ifsul.controle.ControleUsuario;
import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.inject.Inject;

/**
 *
 * @author Renan
 */
@Singleton
public class BeanChat implements Serializable {
   
   private List<String> listaUsuarios; 
   private List<String> mensagens;
   private String mensagem;
   @Inject
    private ControleUsuario controleUsuario;
 
   public BeanChat(){
       listaUsuarios = new ArrayList<>();
       mensagens = new ArrayList<>();

   }
   public void novoUsuario(String usuario){
        listaUsuarios.add(usuario);
        mensagens.add(usuario + " entrou na sala!");
   }
   
   public String excluirUsuario(String usuario){
       
       mensagens.add(usuario + " saiu da sala!");
       listaUsuarios.remove(usuario); 
       
       return "index";
       }
  
   public void addMensagem() {
        String user = controleUsuario.getBeanUsuario().getUsuario();
        String mens = controleUsuario.getBeanUsuario().getMensagem();
        mensagem = user + ": " + mens;
        mensagens.add(mensagem);
        controleUsuario.getBeanUsuario().setMensagem("");
        
    }
    public List<String> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<String> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<String> mensagens) {
        this.mensagens = mensagens;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    

   
}