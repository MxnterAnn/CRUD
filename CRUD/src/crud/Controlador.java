package crud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener, MouseListener {

    Vista v;
    daoProducto dao;
    Producto p, p1;
    int id = 0;

    public Controlador() {
        v = new Vista();
        v.setVisible(true);
        dao = new daoProducto();
        p1 = new Producto();
        v.btnAgregar.addActionListener(this);
        v.btnEliminar.addActionListener(this);
        v.btnGuardar.addActionListener(this);
        v.btnLimpiar.addActionListener(this);
        v.tblDatos.addMouseListener(this);
        refrescarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == v.btnAgregar) {
            p = new Producto();
            p.setNombre(v.txtNombre.getText());
            p.setPrecio(Integer.parseInt(v.spiPrecio.getValue().toString()));
            p.setCantidad(Integer.parseInt(v.spiCantidad.getValue().toString()));
            p.setProveedor(v.cboProveedor.getSelectedItem().toString());
            if (!dao.create(p)) {

                JOptionPane.showMessageDialog(this.v, "NO SE INSERTO");
            }
            limpiarCampos();
        }
        if (ae.getSource() == v.btnEliminar) {
            int x = JOptionPane.showConfirmDialog(this.v, "ESTAS SEGURO QUE QUIERES ELIMINAR ESTE REGUISTRO");
            if (x == 0 && id > 0) {
                if (!dao.delete(id)) {
                    JOptionPane.showMessageDialog(this.v, "Se elimino registro");
                }
            }

        }
        if (ae.getSource() == v.btnGuardar) {
            if (!dao.update(p1)) {
                p1.setNombre(v.txtNombre.getText());
                p1.setPrecio(Integer.parseInt(v.spiPrecio.getValue().toString()));
                p1.setCantidad(Integer.parseInt(v.spiCantidad.getValue().toString()));
                p1.setProveedor(v.cboProveedor.getSelectedItem().toString());
                if (dao.update(p1)) {
                    JOptionPane.showMessageDialog(this.v, "No se actualizo resgistro");
                }

            }
        }
        if (ae.getSource() == v.btnLimpiar) {
            limpiarCampos();

        }
        if (ae.getSource() == v.btnPDF) {

        }
        refrescarTabla();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == v.tblDatos) {
            int fila = v.tblDatos.getSelectedRow();
            id = Integer.parseInt(v.tblDatos.getValueAt(fila, 0).toString());
            p1 = dao.read(id);
            v.etiidproducto.setText("" + p1.getIdproducto());
            v.txtNombre.setText(p1.getNombre());
            v.spiPrecio.setValue(p1.getPrecio());
            v.spiCantidad.setValue(p1.getCantidad());
            v.cboProveedor.setSelectedItem(p1.getProveedor());
        }

    }

    public void refrescarTabla() {
        while (v.model.getRowCount() > 0) {
            v.model.removeRow(0);
        }
        ArrayList<Producto> lista = dao.read();
        for (Producto p : lista) {
            Object item[] = new Object[5];
            item[0] = p.getIdproducto();
            item[1] = p.getNombre();
            item[2] = p.getPrecio();
            item[3] = p.getCantidad();
            item[4] = p.getProveedor();
            v.model.addRow(item);

        }
        v.tblDatos.setModel(v.model);

    }

    public void limpiarCampos() {
        v.txtNombre.setText("");
        v.spiPrecio.setValue(0);
        v.spiCantidad.setValue(0);

    }

    public void limpiarTabla() {
        v.txtNombre.setText("");
        v.spiPrecio.setValue(0);
        v.spiCantidad.setValue(0);
        v.cboProveedor.setSelectedIndex(0);
        v.cboProveedor.setSelectedIndex(0);
        v.etiidproducto.setText("");
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    public static void main(String[] args) {
        Controlador c = new Controlador();
    }

}
