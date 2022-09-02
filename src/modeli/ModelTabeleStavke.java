/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.StavkaZakazivanja;
import domen.Tecaj;
import domen.Termin;
import domen.ZakazivanjeTermina;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author HP
 */
public class ModelTabeleStavke extends AbstractTableModel{
    
    ArrayList<StavkaZakazivanja> lista;
    String[] kolone = {"RB", "Tecaj", "Termin"};

    public ModelTabeleStavke() {
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        StavkaZakazivanja s = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return s.getRb();
            case 1: return s.getTecaj().getNaziv();
            case 2: return sdf.format(s.getTermin().getDatumVreme());
            default: return "Nepostoji kolona!";
        }
    }

    public void dodaj(Tecaj tecaj, Termin termin) {
        int rb = 0;
        for (StavkaZakazivanja stavkaZak : lista) {
            rb++;
        }
        StavkaZakazivanja sz = new StavkaZakazivanja(++rb, new ZakazivanjeTermina(), tecaj, termin);
        lista.add(sz);
        fireTableDataChanged();
    }

    public int vratiRb() {
        int rb = 0;
        for (StavkaZakazivanja stavkaZak : lista) {
            rb++;
        }
        return rb + 1;
    }
    
    public void dodajStavku(StavkaZakazivanja sz) {
        lista.add(sz);
        fireTableDataChanged();
    }

    public void ukloni(int selectedRow) {
        lista.remove(selectedRow);
        
        int rb = 0;
        for (StavkaZakazivanja stavkaZak : lista) {
            stavkaZak.setRb(++rb);
        }
        
        fireTableDataChanged();
    }

    public boolean postoji(Tecaj tecaj, Termin termin) {
        for (StavkaZakazivanja stavkaZak : lista) {
            if(stavkaZak.getTecaj().equals(tecaj) && stavkaZak.getTermin().equals(termin)){
                return true;
            }
            
        }
        return false;
    }

    public ArrayList<StavkaZakazivanja> getLista() {
        return lista;
    }

    public void setLista(ArrayList<StavkaZakazivanja> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public StavkaZakazivanja vratiStavku(Tecaj tecaj, Termin termin) {
        for (StavkaZakazivanja stavkaZakazivanja : lista) {
            if(stavkaZakazivanja.getTecaj().equals(tecaj) && stavkaZakazivanja.getTermin().equals(termin)){
                return stavkaZakazivanja;
            }
        }
        return null;
    }

    public StavkaZakazivanja dajStavku(int selectedRow) {
        return lista.get(selectedRow);
    }
    
}
