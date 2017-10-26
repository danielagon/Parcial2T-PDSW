package edu.eci.pdsw.samples.services;


import java.sql.Date;
import java.util.List;
import java.util.Set;
import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;

/**
 *
 * @author 2106913
 */
public interface ServiciosForos {

    
    public List<EntradaForo> consultarForos() throws ExcepcionServiciosSuscripciones;
        

    

}
