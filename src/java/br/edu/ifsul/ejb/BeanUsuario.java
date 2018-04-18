/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.ejb;

import br.edu.ifsul.modelo.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.inject.Inject;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renan
 */
@Stateful
public class BeanUsuario implements Serializable{
    @NotBlank(message = "pessoa.nome.notblank")
    @Length(message = "pessoa.nome.length")
    private String usuario;
    private String mensagem;
    

    public BeanUsuario(){
        
    }

    @PostConstruct
    public void iniciar(){
        
    }
    @PreDestroy
    public void destruir(){
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
  
}
