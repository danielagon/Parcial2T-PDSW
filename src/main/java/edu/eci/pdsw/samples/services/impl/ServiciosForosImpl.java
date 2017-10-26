/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.persistence.DaoEntradaForo;
import edu.eci.pdsw.samples.persistence.DaoUsuario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import java.util.Set;
import edu.eci.pdsw.samples.services.ServiciosForos;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;

/**
 *
 * @author hcadavid
 */
public class ServiciosForosImpl implements ServiciosForos {

    @Inject
    private DaoEntradaForo daoef;
    
    @Inject
    private DaoUsuario daou;
    
    @Transactional
    @Override
    public List<EntradaForo> consultarForos() throws ExcepcionServiciosSuscripciones {
        try {
            return daoef.loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }

    @Transactional
    @Override
    public EntradaForo consultarForosPorId(int id) throws ExcepcionServiciosSuscripciones {
        try{
            return daoef.load(id);
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta por Id: "+ex.getLocalizedMessage(),ex);
        }
    }

    @Transactional
    @Override
    public List<EntradaForo> consultarForosConVulgaridades() throws ExcepcionServiciosSuscripciones {
        try{
            return daoef.loadForosVulgaridades();
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta de foros con vulgaridades :"+ex.getLocalizedMessage(),ex);
        }
    }


    
    
}
