/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view;

import abd.p1.model.Pregunta;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class PreguntaCellRenderer extends ElementoListaPanel implements ListCellRenderer<Pregunta>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Component getListCellRendererComponent(JList<? extends Pregunta> list, 
            Pregunta value, int index, 
            boolean isSelected, boolean cellHasFocus) {
        this.setEnunciado(value.getEnunciado());
        this.setNumopciones(value.getOpciones().size());
        this.setOpaque(true);
        if(isSelected){
            this.setBackground(Color.YELLOW);
        }else {
            this.setBackground(Color.WHITE);
        }
        return this;
    }
    
}
