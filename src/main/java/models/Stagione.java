/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;


/**
 *
 * @author leonardo
 */
public interface Stagione {

    public int getNumero();
    public void setNumero(int numero);

    public Immagine getImmagine();
    public void setImmagine(Immagine immagine);
    
    public Programma getProgramma();
    public void setProgramma(Programma programma);

    public List<Episodio> getEpisodi();
    public void setEpisodi(List<Episodio> episodi);

    
    
}
