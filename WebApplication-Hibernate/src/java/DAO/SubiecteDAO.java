/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.*;
import pojo.Subiecte;
/**
 *
 * @author Andrei
 */
public interface SubiecteDAO {
    public void adaugaSubiect (Subiecte subiect);
    public List<Subiecte> afiseazaSubiecte();
    public void modificaSubiect (int idsubiecte, String tip, String nr_intrebari);
    public void stergeSubiect (Subiecte subiect);

}
