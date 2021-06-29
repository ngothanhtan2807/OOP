package controller;

import model.SanPham;

public class ControlMachine {
//	private SanPham sanPham;
public int tinhTien(int taiKhoan, SanPham sanPham) {
	int soDu = 0;
	soDu = taiKhoan - sanPham.getGia();
	return soDu;
}
public boolean kiemTraSoDu(int soDu, SanPham sanPham) {
	
	if(sanPham.getGia() > soDu) {
		return false;
	}
//	if(sanPham.getGia() <= soDu) {
//	}
	return true;
}
}
