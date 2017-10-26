/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.pdsw.samples.persistence.DaoEntradaForo;
import edu.eci.pdsw.samples.persistence.DaoUsuario;
import edu.eci.pdsw.samples.persistence.mybatisimpl.MyBatisDAOEntradaForo;
import edu.eci.pdsw.samples.persistence.mybatisimpl.MyBatisDAOUsuario;
import edu.eci.pdsw.samples.services.impl.ServiciosForosImpl;

/**
 *
 * @author hcadavid
 */
public class ServiciosForosFactory {

    private static ServiciosForosFactory instance = new ServiciosForosFactory();

    private static Injector injector;
    private static Injector testingInjector;

    private ServiciosForosFactory() {
        injector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setClassPathResource("mybatis-config.xml");
                bind(ServiciosForos.class).to(ServiciosForosImpl.class);
                bind(DaoUsuario.class).to(MyBatisDAOUsuario.class);
                bind(DaoEntradaForo.class).to(MyBatisDAOEntradaForo.class);

            }

        }
        );

        testingInjector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.MySQL);
                setClassPathResource("mybatis-config-h2.xml");
                bind(ServiciosForos.class).to(ServiciosForosImpl.class);
                bind(DaoUsuario.class).to(MyBatisDAOUsuario.class);
                bind(DaoEntradaForo.class).to(MyBatisDAOEntradaForo.class);

            }

        }
        );

    }

    public ServiciosForos getForumsServices() {
        return injector.getInstance(ServiciosForos.class);
    }

    public ServiciosForos getTestingForumServices() {
        return testingInjector.getInstance(ServiciosForos.class);
    }

    public static ServiciosForosFactory getInstance() {
        return instance;
    }

    public static void main(String a[]) throws ExcepcionServiciosSuscripciones {
        System.out.println(ServiciosForosFactory.getInstance().getForumsServices().consultarForos());
    }

}
