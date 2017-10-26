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
package edu.eci.pdsw.samples.entities;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author hcadavid
 */
public class EntradaForo {
    
    private int identificador;
    
    private Usuario autor;
    
    private String comentario;
    
    private List<Comentario> respuestas;
    
    private Date fechayHora;

    public EntradaForo() {
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<Comentario> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Comentario> respuestas) {
        this.respuestas = respuestas;
    }

    public Date getFechayHora() {
        return fechayHora;
    }

    public void setFechayHora(Date fechayHora) {
        this.fechayHora = fechayHora;
    }

    @Override
    public String toString() {
        return "EntradaForo{" + "identificador=" + identificador + ", autor=" + autor + ", comentario=" + comentario + ", respuestas=" + respuestas + ", fechayHora=" + fechayHora + '}';
    }
 
    
    
}