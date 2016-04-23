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

/**
 *
 * @author Guilherme
 */
public class UsuariosCellRenderer extends UsuarioPanel implements ListCellRenderer<Usuario> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Usuario> list, 
            Usuario value, int index, 
            boolean isSelected, boolean cellHasFocus) {
        this.setNombre(value.getNombre());
        this.setEdad(value.getEdad());
        this.setOpaque(true);
        
        if (isSelected){
            this.setBackground(Color.YELLOW);
        }else{
            this.setBackground(Color.WHITE);
        }
        
        return this;
    }
    
}
