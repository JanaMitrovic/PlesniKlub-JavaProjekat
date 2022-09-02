/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Tecaj;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class ModelTabeleTecaji extends AbstractTableModel{
    
    ArrayList<Tecaj> lista;
    String[] kolone = {"naziv", "velicina grupe", "sala", "trajanje"};

    public ModelTabeleTecaji() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Tecaj t = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return t.getNaziv();
            case 1: return t.getVelicinaGrupe();
            case 2: return t.getSala();
            case 3: return t.getTrajanje();
            default: return "Nepostoji kolona!";
        }
    }

    public void setLista(ArrayList<Tecaj> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public Tecaj vratiTecaj(int red) {
        return lista.get(red);
    }

    public void ukloniTecaj(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }
    
}
