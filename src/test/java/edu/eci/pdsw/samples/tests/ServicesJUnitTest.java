/*
 * Copyright (C) 2015 hcadavid
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
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosForosFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author hcadavid
 */
public class ServicesJUnitTest {

    public ServicesJUnitTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "anonymous");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from USUARIOS");
        stmt.execute("delete from COMENTARIOS");
        stmt.execute("delete from ENTRADAS_FOROS");
        conn.commit();
        conn.close();
    }

    /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "anonymous");        
    }
    
    @Test
    public void pruebaCeroTest() throws SQLException, ExcepcionServiciosSuscripciones {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();        
        
        
        stmt.execute("INSERT INTO `COMENTARIOS` (`id`, `fecha_hora`, `contenido`, `ENTRADAS_FOROS_id`, `USUARIOS_email`) VALUES (1,'2017-10-26 08:02:08','Sin comentarios',3,'juan.perez@gmail.com')");

        stmt.execute("INSERT INTO `ENTRADAS_FOROS` (`id`, `fecha_hora`, `contenido`, `USUARIOS_email`) VALUES (3,'2017-10-26 07:19:06','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.','juan.perez@gmail.com')");

        stmt.execute("INSERT INTO `USUARIOS` (`email`, `nombre`) VALUES ('juan.perez@gmail.com','Juan Perez'), ('luis.diaz@hotmail.com','Luis Diaz')");

        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        
        List<EntradaForo> lef=ServiciosForosFactory.getInstance().getTestingForumServices().consultarForos();

        
        for (EntradaForo ef:lef){
            System.out.println(ef);
        }
        //assert ...
        //Assert.fail("Pruebas no implementadas aun...");
        
    }    
    
    @Test
    public void pruebaConsultarForosPorId() throws SQLException, ExcepcionServiciosSuscripciones{
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();        
        
        
        stmt.execute("INSERT INTO `COMENTARIOS` (`id`, `fecha_hora`, `contenido`, `ENTRADAS_FOROS_id`, `USUARIOS_email`) VALUES (1,'2017-10-26 08:02:08','Sin comentarios',3,'juan.perez@gmail.com')");

        stmt.execute("INSERT INTO `ENTRADAS_FOROS` (`id`, `fecha_hora`, `contenido`, `USUARIOS_email`) VALUES (3,'2017-10-26 07:19:06','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.','juan.perez@gmail.com')");

        stmt.execute("INSERT INTO `USUARIOS` (`email`, `nombre`) VALUES ('juan.perez@gmail.com','Juan Perez'), ('luis.diaz@hotmail.com','Luis Diaz')");

        conn.commit();
        conn.close();
        //Realizar la operacion de la logica y la prueba
        
        
        List<EntradaForo> lef=ServiciosForosFactory.getInstance().getTestingForumServices().consultarForos();
        EntradaForo foroId=ServiciosForosFactory.getInstance().getTestingForumServices().consultarForosPorId(3);
        
        //assert
        assertEquals("No se pudo realizar la busqueda de foro por Id",lef.get(0).getIdentificador(),foroId.getIdentificador());
        
    }
    
    @Test
    public void pruebasConsularForosConVulgaridades() throws SQLException, ExcepcionServiciosSuscripciones{
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();        
        
        
        stmt.execute("INSERT INTO `COMENTARIOS` (`id`, `fecha_hora`, `contenido`, `ENTRADAS_FOROS_id`, `USUARIOS_email`) VALUES (1,'2017-10-26 08:02:08','Sin comentarios',3,'juan.perez@gmail.com')");

        stmt.execute("INSERT INTO `ENTRADAS_FOROS` (`id`, `fecha_hora`, `contenido`, `USUARIOS_email`) VALUES (3,'2017-10-26 07:19:06','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio recorcholis. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.','juan.perez@gmail.com')");

        stmt.execute("INSERT INTO `USUARIOS` (`email`, `nombre`) VALUES ('juan.perez@gmail.com','Juan Perez'), ('luis.diaz@hotmail.com','Luis Diaz')");

        conn.commit();
        conn.close();
        //Realizar la operacion de la logica y la prueba
        
        List<EntradaForo> lef=ServiciosForosFactory.getInstance().getTestingForumServices().consultarForos();
        List<EntradaForo> foroVulgaridades=ServiciosForosFactory.getInstance().getTestingForumServices().consultarForosConVulgaridades();
        
        //assert
        assertEquals("No se realizo la busqueda de foros con vulgaridades",lef.get(0).getIdentificador(),foroVulgaridades.get(0).getIdentificador());
    }
    

}
