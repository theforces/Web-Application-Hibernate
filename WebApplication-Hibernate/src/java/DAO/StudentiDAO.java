/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.*;
import pojo.Studenti;
/**
 *
 * @author Andrei
 */
public interface StudentiDAO {
    public void adaugaStudent (Studenti student);
    public List<Studenti> afiseazaStudenti();
    public void modificaStudent (int idstudenti, String nume, String prenume, String grupa);
    public void stergeStudent (Studenti student);

}
