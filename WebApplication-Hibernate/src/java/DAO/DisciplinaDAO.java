/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.util.*;
import pojo.*;
/**
 *
 * @author Andrei
 */
public interface DisciplinaDAO {
    public void adaugaDisciplina (Disciplina disciplina);
    public List<Disciplina> afiseazaDisciplina();
    public void modificaDisciplina (Integer idDisciplina, Studenti student, Subiecte subiect, Date dataExamen, Integer puncteCredit);
    public void stergeDisciplina (Disciplina disciplina);

}
