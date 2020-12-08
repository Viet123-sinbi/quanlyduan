package qlbh;

public class KhachHangs {
	private String MaKH;
	private String TenKH;
	private String DiaChi;
	private String SDT;
	
	public KhachHangs() {
		
	}
	
	public KhachHangs(String MaKH, String TenKH, String DiaChi, String SDT) {
		this.MaKH=MaKH;
		this.TenKH=TenKH;
		this.DiaChi=DiaChi;
		this.SDT=SDT;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getTenKH() {
		return TenKH;
	}

	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	

	
}
