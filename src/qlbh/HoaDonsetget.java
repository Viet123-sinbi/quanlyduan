package HoaDon;

public class HoaDonsetget {
	String MaHD,NgayBan,MaNV,MaKH;
	String TongTien;
	
	public HoaDonsetget() {
		
	}
	
	public HoaDonsetget(String MaHD, String NgayBan, String tongTien, String MaNV, String MaKH) {
		this.MaHD=MaHD;
		this.NgayBan=NgayBan;
		this.TongTien=tongTien;
		this.MaNV=MaNV;
		this.MaKH=MaKH;
	}

	public String getMaHD() {
		return MaHD;
	}

	public void setMaHD(String maHD) {
		MaHD = maHD;
	}

	public String getNgayBan() {
		return NgayBan;
	}

	public void setNgayBan(String ngayBan) {
		NgayBan = ngayBan;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getTongTien() {
		return TongTien;
	}

	public void setTongTien(String tongTien) {
		TongTien = tongTien;
	}
	
}
