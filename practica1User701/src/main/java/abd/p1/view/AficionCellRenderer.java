/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

import abd.p1.model.Aficion;

public class AficionCellRenderer extends ElementoAficion implements ListCellRenderer<Aficion> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Component getListCellRendererComponent(JList<? extends Aficion> list, 
            Aficion value, int index, 
            boolean isSelected, boolean cellHasFocus) {
        this.setAficion(value.getTexto());
        this.setOpaque(true);
        if(isSelected){
            this.setBackground(Color.YELLOW);
        }else {
            this.setBackground(Color.WHITE);
        }
       
        return this;
    }
    
}
