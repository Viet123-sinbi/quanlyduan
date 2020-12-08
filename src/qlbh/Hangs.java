package qlbh;

public class Hangs {
	private String MaHang;
	private String TenHang;
	private String SoLuong;
	private String DonGia;
	public Hangs() {

	}
	public Hangs(String maHang, String tenHang, String soLuong, String donGia) {
	
		MaHang = maHang;
		TenHang = tenHang;
		SoLuong = soLuong;
		DonGia = donGia;
	}
	public String getMaHang() {
		return MaHang;
	}
	public void setMaHang(String maHang) {
		MaHang = maHang;
	}
	public String getTenHang() {
		return TenHang;
	}
	public void setTenHang(String tenHang) {
		TenHang = tenHang;
	}
	public String getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(String soLuong) {
		SoLuong = soLuong;
	}
	public String getDonGia() {
		return DonGia;
	}
	public void setDonGia(String donGia) {
		DonGia = donGia;
	}
	

	
}
