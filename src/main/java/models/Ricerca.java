/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


/**
 *
 * @author leonardo
 */
public interface Ricerca {

    public Canale getCanale();
    public void setCanale(Canale canale);

    public Programma getProgramma();
    public void setProgramma(Programma programma);

    public Genere getGenere();
    public void setGenere(Genere genere);

    public Fascia getFascia();
    public void setFascia(Fascia fascia);
    
}
