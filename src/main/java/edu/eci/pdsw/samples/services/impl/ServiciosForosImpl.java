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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class ServiciosForosImpl implements ServiciosForos {

    @Inject
    private DaoEntradaForo daoef;
    
    @Inject
    private DaoUsuario daou;

    @Override
    public List<EntradaForo> consultarForos() throws ExcepcionServiciosSuscripciones {
        try {
            return daoef.loadAll();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<EntradaForo> consultarForosPorId(int id) throws ExcepcionServiciosSuscripciones {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntradaForo> consultarForosConVulgaridades() throws ExcepcionServiciosSuscripciones {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
}
