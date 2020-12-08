package qlbh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChuyenManHinh {

	private JPanel jpnRoot;
	private String kindSelected = "";
	private List<DanhMuc> listDanhMuc;	
	
	public ChuyenManHinh(JPanel jpnRoot) {
		this.jpnRoot = jpnRoot;
	}
	
	public void setView(JPanel jpnItem, JLabel jblItem) {
		kindSelected = "Trangchu";
	    TrangChu node = new TrangChu();
	    jpnRoot.removeAll();
	    jpnRoot.setLayout(new BorderLayout());
	    jpnRoot.add(node);
	    jpnRoot.validate();
	    jpnRoot.repaint();
	}
	
	public void setEvent(List<DanhMuc> listDanhMuc) {
	     this.listDanhMuc = listDanhMuc;
	     for (DanhMuc item : listDanhMuc) {
	           item.getJlb().addMouseListener((MouseListener) new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
	     }
	}

	class LabelEvent implements MouseListener {

	      private JPanel node;
	      private String kind;

	      private JPanel jpnItem;
	      private JLabel jlbItem;

	      public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
	           this.kind = kind;
	           this.jpnItem = jpnItem;
	           this.jlbItem = jlbItem;
	      }

	      @Override
	      public void mouseClicked(MouseEvent e) {
	            switch (kind) {
	                case "Trangchu":
	                    node = new TrangChu();
	                    break;
	                case "KhachHang":
	                    node = new KhachHang();
	                    break;
	                case "Hang":
	                	node = new Hang();
	                	break;
//	                case "HoaDon":
//	                	node = new HoaDon();
//	                	break;
	                default:
	                    break;
	           }
	           jpnRoot.removeAll();
	           jpnRoot.setLayout(new BorderLayout());
	           jpnRoot.add(node);
	           jpnRoot.validate();
	           jpnRoot.repaint();
	           setChangeBackgroud(kind);
	           
	      }

	      public void mousePressed(MouseEvent e) {
	        
	      }

	      public void mouseReleased(MouseEvent e) {

	      }

	      public void mouseEntered(MouseEvent e) {
	          jpnItem.setBackground(new Color(	255,0,0));
	          jlbItem.setBackground(new Color(	255,0,0));
	      }

	      public void mouseExited(MouseEvent e) {
	          if (!kindSelected.equalsIgnoreCase(kind)) {
	                jpnItem.setBackground(new Color(0, 255, 0));
	                jlbItem.setBackground(new Color(0, 255, 0));
	          }
	      }

	      public void setChangeBackgroud(String kind) {
	  		for(DanhMuc item : listDanhMuc) {
	  			if(item.getKind().equalsIgnoreCase(kind)) {
	  				item.getJpn().setBackground(new Color(255,0,0));
	  				item.getJlb().setBackground(new Color(255,0,0));
	  			}else {
	  				item.getJpn().setBackground(new Color(0, 255, 0));
	  				item.getJlb().setBackground(new Color(0, 255, 0));
	  			}
	  		}
	  	}
	      
	}
	
}
