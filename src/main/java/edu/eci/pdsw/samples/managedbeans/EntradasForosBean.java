/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosForosFactory;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name = "mb")
@SessionScoped
public class EntradasForosBean {
    
    private int id;
    private List<Comentario> comentarios;
    private EntradaForo foro;
    private List<EntradaForo> forosVul;

                
    public List<EntradaForo> getData() throws Exception{
        try {
            return ServiciosForosFactory.getInstance().getForumsServices().consultarForos();
        } catch (ExcepcionServiciosSuscripciones ex) {
            
            throw ex;
        }
        
    }
    
    public EntradaForo getForo() throws Exception{
        try{
            foro=ServiciosForosFactory.getInstance().getForumsServices().consultarForosPorId(id);
            return foro;
        }catch (ExcepcionServiciosSuscripciones ex){
            throw ex;
        }
    }
    
    public void setForo(EntradaForo foro) {
        this.foro = foro;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public List<Comentario> getComentarios() throws Exception {
        try{
            comentarios=ServiciosForosFactory.getInstance().getForumsServices().consultarForosPorId(id).getRespuestas();
            return comentarios;
        }catch (ExcepcionServiciosSuscripciones ex){
            throw ex;
        }
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public List<EntradaForo> getForosVul() throws Exception{
        try{
            forosVul=ServiciosForosFactory.getInstance().getForumsServices().consultarForosConVulgaridades();
            return forosVul;
        }catch (ExcepcionServiciosSuscripciones ex){
            throw ex;
        }
    }

    public void setForosVul(List<EntradaForo> forosVul) {
        this.forosVul = forosVul;
    }
    
}
