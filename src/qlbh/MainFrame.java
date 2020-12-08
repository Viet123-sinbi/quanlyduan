package qlbh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1036, 711);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(0, 0, 1021, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel jpnTrangChu = new JPanel();
		jpnTrangChu.setBackground(new Color(0, 255, 0));
		jpnTrangChu.setBounds(10, 10, 169, 50);
		panel.add(jpnTrangChu);
		jpnTrangChu.setLayout(null);
		
		JLabel jblTrangChu = new JLabel("TRANG CH\u1EE6");
		jblTrangChu.setIcon(new ImageIcon("E:\\Java destop\\Icon\\home.png"));
		jblTrangChu.setBackground(SystemColor.inactiveCaption);
		jblTrangChu.setFont(new Font("Tahoma", Font.BOLD, 20));
		jblTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		jblTrangChu.setBounds(0, 0, 169, 50);
		jpnTrangChu.add(jblTrangChu);
		
		JPanel jpnHoaDon = new JPanel();
		jpnHoaDon.setBackground(new Color(0, 255, 0));
		jpnHoaDon.setLayout(null);
		jpnHoaDon.setBounds(840, 10, 150, 50);
		panel.add(jpnHoaDon);
		
		JLabel lblHoaDon = new JLabel("HO\u00C1 \u0110\u01A0N");
		lblHoaDon.setBackground(SystemColor.activeCaption);
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHoaDon.setBounds(0, 0, 150, 50);
		jpnHoaDon.add(lblHoaDon);
		
		JPanel jpnSanPham = new JPanel();
		jpnSanPham.setBackground(new Color(0, 255, 0));
		jpnSanPham.setLayout(null);
		jpnSanPham.setBounds(644, 10, 150, 50);
		panel.add(jpnSanPham);
		
		JLabel lblHang = new JLabel("S\u1EA2N PH\u1EA8M");
		lblHang.setBackground(SystemColor.activeCaption);
		lblHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHang.setBounds(0, 0, 150, 50);
		jpnSanPham.add(lblHang);
		
		JPanel jpnKhachHang = new JPanel();
		jpnKhachHang.setBackground(Color.GREEN);
		jpnKhachHang.setLayout(null);
		jpnKhachHang.setBounds(442, 10, 180, 50);
		panel.add(jpnKhachHang);
		
		JLabel lblKhachHang = new JLabel("KH\u00C1CH H\u00C0NG");
		lblKhachHang.setBackground(SystemColor.activeCaption);
		lblKhachHang.setIcon(new ImageIcon("E:\\Java destop\\Icon\\peoples.png"));
		lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblKhachHang.setBounds(0, 0, 180, 50);
		jpnKhachHang.add(lblKhachHang);
		
		JPanel jpnNhanVien = new JPanel();
		jpnNhanVien.setBackground(Color.GREEN);
		jpnNhanVien.setLayout(null);
		jpnNhanVien.setBounds(227, 10, 169, 50);
		panel.add(jpnNhanVien);
		
		JLabel jblNhanVien = new JLabel("NH\u00C2N VI\u00CAN");
		jblNhanVien.setBackground(SystemColor.activeCaption);
		jblNhanVien.setIcon(new ImageIcon("E:\\Java destop\\Icon\\people.png"));
		jblNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		jblNhanVien.setFont(new Font("Tahoma", Font.BOLD, 20));
		jblNhanVien.setBounds(0, 0, 169, 50);
		jpnNhanVien.add(jblNhanVien);
		
		JPanel jpnview = new JPanel();
		jpnview.setBackground(new Color(255, 255, 255));
		jpnview.setBounds(10, 77, 1000, 597);
		contentPane.add(jpnview);
		
		List<DanhMuc> listDanhmuc = new ArrayList<>();
       listDanhmuc.add(new DanhMuc("Trangchu", jpnTrangChu, jblTrangChu));
        listDanhmuc.add(new DanhMuc("KhachHang", jpnKhachHang, lblKhachHang));
        listDanhmuc.add(new DanhMuc("Hang", jpnSanPham, lblHang));
        listDanhmuc.add(new DanhMuc("HoaDon", jpnHoaDon, lblHoaDon));

        ChuyenManHinh controller = new ChuyenManHinh(jpnview);
        jpnview.setLayout(null);
        controller.setView(jpnTrangChu, jblTrangChu);
        controller.setEvent(listDanhmuc);
        
	}
}
