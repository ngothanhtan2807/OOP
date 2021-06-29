package model;

public class SanPham {
private String maSo;
private String tenSP;
private int gia;
public SanPham(String maSo, String tenSP, int gia) {
	super();
	this.maSo = maSo;
	this.tenSP = tenSP;
	this.gia = gia;
}
public String getMaSo() {
	return maSo;
}
public String getTenSP() {
	return tenSP;
}
public int getGia() {
	return gia;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Sản phẩm bạn chọn là: \n" + "Mã SP: " + maSo + " Tên SP: " + tenSP + " Gía: " + gia;
	}
}
