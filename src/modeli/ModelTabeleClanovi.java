/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Clan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class ModelTabeleClanovi extends AbstractTableModel{
    
    ArrayList<Clan> lista;
    String[] kolone = {"ime", "prezime", "broj telefona", "email", "datum upisa"};

    public ModelTabeleClanovi() {
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
        Clan c = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return c.getIme();
            case 1: return c.getPrezime();
            case 2: return c.getBrojTelefona();
            case 3: return c.getEmail();
            case 4: return c.getDatumUpisa();
            default: return "Nepostoji kolona!";
        }
    }

    public void setLista(ArrayList<Clan> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public Clan vratiClana(int red) {
        return lista.get(red);
    }
    
}
