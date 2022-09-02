/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.ZakazivanjeTermina;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class ModelTabeleZakazaniTermini extends AbstractTableModel{
    
    ArrayList<ZakazivanjeTermina> lista;
    String[] kolone = {"clan", "instruktor"};

    public ModelTabeleZakazaniTermini() {
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
        ZakazivanjeTermina zt = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return zt.getClan();
            case 1: return zt.getInstruktor();
            default: return "Nepostoji kolona!";
        }
    }

    public void setLista(ArrayList<ZakazivanjeTermina> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public ZakazivanjeTermina vratiZakazivanje(int red) {
        return lista.get(red);
    }

    public void ukloni(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    
    
}
