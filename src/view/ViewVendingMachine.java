package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ControlMachine;
import model.SanPham;

public class ViewVendingMachine extends JFrame {
	private JButton btnXucXich, btnC2chanh, btnC2hongtra, btnCafe, btnDrthanh, btnNuocLoc, btnNuti, btnRevive, btnCoca,
			btnOreo, btnPepsi, btnStrong, btnThanhToan, btnNap;
	private ImageIcon imgXucXich, imgC2chanh, imgC2hongtra, imgCafe, imgDrthanh, imgNuocloc, imgNuti, imgRevive,
			imgCoca, imgOreo, imgPepsi, imgStrong;
	private JTextArea txtShow;
	private JLabel lbSodu, lbDong;
	private JTextField txtSoDu;
	private JRadioButton rbt1K, rbt2K, rbt5K, rbt10K;
	private SanPham sanPham;
	private ControlMachine control = new ControlMachine();
	private JPanel pHead, pCenter, pFoot;
	public ViewVendingMachine(String title) {
		super("Vending Machine");
		setLayout(new BorderLayout());
		pHead = new JPanel();
		pHead.add(new JLabel("Vending Machine"));
		add(pHead, BorderLayout.NORTH);

		pCenter = new JPanel();
		pCenter.setLayout(new BorderLayout());
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(4, 3));
		p3.add(btnXucXich = new JButton());
		btnXucXich.setIcon(imgXucXich = new ImageIcon("image/xucxich.jpg"));
		p3.add(btnC2chanh = new JButton());
		btnC2chanh.setIcon(imgC2chanh = new ImageIcon("image/c2_chanh.jpg"));
		p3.add(btnC2hongtra = new JButton());
		btnC2hongtra.setIcon(imgC2hongtra = new ImageIcon("image/c2_hongtra.jpg"));
		p3.add(btnCafe = new JButton());
		btnCafe.setIcon(imgCafe = new ImageIcon("image/cafe.jpg"));
		p3.add(btnCoca = new JButton());
		btnCoca.setIcon(imgCoca = new ImageIcon("image/coca.jpg"));
		p3.add(btnDrthanh = new JButton());
		btnDrthanh.setIcon(imgDrthanh = new ImageIcon("image/drthanh.jpg"));
		p3.add(btnRevive = new JButton());
		btnRevive.setIcon(imgRevive = new ImageIcon("image/revive.jpg"));
		p3.add(btnNuocLoc = new JButton());
		btnNuocLoc.setIcon(imgNuocloc = new ImageIcon("image/nuocloc.jpg"));
		p3.add(btnNuti = new JButton());
		btnNuti.setIcon(imgNuti = new ImageIcon("image/nuti.jpg"));
		p3.add(btnOreo = new JButton());
		btnOreo.setIcon(imgOreo = new ImageIcon("image/oreo.jpg"));
		p3.add(btnPepsi = new JButton());
		btnPepsi.setIcon(imgPepsi = new ImageIcon("image/pepsi.jpg"));
		p3.add(btnStrong = new JButton());
		btnStrong.setIcon(imgStrong = new ImageIcon("image/strong.jpg"));

		pCenter.add(p3);
		add(pCenter, BorderLayout.CENTER);

		JPanel pEast = new JPanel();
		pEast.setLayout(new BoxLayout(pEast, BoxLayout.Y_AXIS));
		JPanel p21 = new JPanel();
		p21.add(lbSodu = new JLabel("Số dư"));
		p21.add(txtSoDu = new JTextField(12));
//		txtSoDu.setPreferredSize(new Dimension(12, 24));
		txtSoDu.setEditable(false);
		txtSoDu.setText("0");
		p21.add(lbDong = new JLabel("đ"));
		pEast.add(p21);

		JPanel p22 = new JPanel();
		ButtonGroup btg = new ButtonGroup();
		btg.add(rbt1K = new JRadioButton("1K"));
		btg.add(rbt2K = new JRadioButton("2K"));
		btg.add(rbt5K = new JRadioButton("5K"));
		btg.add(rbt10K = new JRadioButton("10K"));

		p22.add(rbt1K);
		p22.add(rbt2K);
		p22.add(rbt5K);
		p22.add(rbt10K);

		JPanel p23 = new JPanel();
		p23.add(btnNap = new JButton("Nạp"));

		pEast.add(p22);
		pEast.add(p23);
	
		add(pEast, BorderLayout.EAST);

		pFoot = new JPanel();
		pFoot.setLayout(new BoxLayout(pFoot, BoxLayout.Y_AXIS));
		pFoot.add(txtShow = new JTextArea(3, 20));
		txtShow.setPreferredSize(new Dimension(80, 30));
		txtShow.setEditable(false);
		txtShow.setText("Thông tin sản phẩm");
		pFoot.add(btnThanhToan = new JButton("Thanh toán"));

		btnThanhToan.setPreferredSize(new Dimension(30, 20));
		add(pFoot, BorderLayout.SOUTH);

		MyEventSP mv = new MyEventSP();
		btnXucXich.addActionListener(mv);
		btnC2chanh.addActionListener(mv);
		btnC2hongtra.addActionListener(mv);
		btnCafe.addActionListener(mv);
		btnDrthanh.addActionListener(mv);
		btnNuocLoc.addActionListener(mv);
		btnNuti.addActionListener(mv);
		btnRevive.addActionListener(mv);
		btnCoca.addActionListener(mv);
		btnOreo.addActionListener(mv);
		btnPepsi.addActionListener(mv);
		btnStrong.addActionListener(mv);

		
		
		MuaHang mh = new MuaHang();
		btnThanhToan.addActionListener(mh);
		
		
		MyEventGia gia = new MyEventGia();
		rbt1K.addActionListener(gia);
		rbt2K.addActionListener(gia);
		rbt5K.addActionListener(gia);
		rbt10K.addActionListener(gia);
		btnNap.addActionListener(gia);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(700, 500);
	}
	
	class MuaHang implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int soDu = Integer.parseInt(txtSoDu.getText());
			if(e.getSource() == btnThanhToan) {
				if(txtShow.getText().equals("Thông tin sản phẩm")) {
					JOptionPane.showMessageDialog(pCenter,
			                "Vui lòng chọn sản phẩm",
			                "Thông báo mua hàng",
			                JOptionPane.INFORMATION_MESSAGE);
				}
				if(!txtShow.getText().equals("Thông tin sản phẩm"))  {
					if(control.kiemTraSoDu(soDu, sanPham) == true) {
						JOptionPane.showMessageDialog(pCenter,
				               "Mua hàng thành công",
				                "Thông báo mua hàng",
				                JOptionPane.INFORMATION_MESSAGE);	
						txtSoDu.setText(control.tinhTien(soDu, sanPham) + "");
						txtShow.setText("Thông tin sản phẩm");
					}
					
					JOptionPane.showMessageDialog(pCenter,
			               "Số dư không đủ",
			                "Thông báo mua hàng",
			                JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		}
		
	}
class MyEventSP implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		int soDu = Integer.parseInt(txtSoDu.getText());
		if(e.getSource() == btnXucXich) {
			sanPham = new SanPham("1", "Xúc xích", 5000);
		}
		if(e.getSource() == btnC2chanh) {
			sanPham = new SanPham("2", "C2 chanh", 10000);
		}
		if(e.getSource() == btnC2hongtra) {
			sanPham = new SanPham("3", "C2 hồng trà", 10000);
		}
		if(e.getSource() == btnCafe) {
			sanPham = new SanPham("4", "Cà phê uống liền", 8000);
		}
		if(e.getSource() == btnCoca) {
			sanPham = new SanPham("5", "Coca ướp lạnh", 10000);
		}
		if(e.getSource() == btnDrthanh) {
			sanPham = new SanPham("6", "Trà xanh không độ", 10000);
		}
		if(e.getSource() == btnNuocLoc) {
			sanPham = new SanPham("7", "Nước lọc tinh khiết", 5000);
		}
		if(e.getSource() == btnNuti) {
			sanPham = new SanPham("8", "Sữa Nuti food", 12000);
		}
		if(e.getSource() == btnOreo) {
			sanPham = new SanPham("9", "Bánh Oreo", 10000);
		}
		if(e.getSource() == btnPepsi) {
			sanPham = new SanPham("10", "Pepsi lạnh", 12000);
		}
		if(e.getSource() == btnRevive) {
			sanPham = new SanPham("11", "Nước khoáng Revive", 10000);
		}
		if(e.getSource() == btnStrong) {
			sanPham = new SanPham("12", "Strongbow ", 15000);
		}
		
		txtShow.setText(sanPham.toString());
	}
	
}
class MyEventGia implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		int napThem = 0;
		int soDu = Integer.parseInt(txtSoDu.getText());
		if(e.getSource() == btnNap) {
			if(rbt1K.isSelected()) {
				napThem = 1000;
			}
			if(rbt2K.isSelected()) {
				napThem = 2000;
			}
			if(rbt5K.isSelected()) {
				napThem = 5000;
			}
			if(rbt10K.isSelected()) {
				napThem = 10000;
			}
		}
		txtSoDu.setText(napThem + soDu + "");
		
	}
	
}
	public static void main(String[] args) {
		new ViewVendingMachine("Vending Machine");
	}
}
