package it.beije.beijeAir.dto;

public class RottaConIdDto {
	private Integer volo1_id;
	private Integer volo2_id;
	private Integer volo3_id;
	
	public int getVolo1_id() {
		return volo1_id;
	}
	public void setVolo1_id(int volo1_id) {
		this.volo1_id = volo1_id;
	}
	public int getVolo2_id() {
		return volo2_id;
	}
	public void setVolo2_id(int volo2_id) {
		this.volo2_id = volo2_id;
	}
	public int getVolo3_id() {
		return volo3_id;
	}
	public void setVolo3_id(int volo3_id) {
		this.volo3_id = volo3_id;
	}
	public RottaConIdDto(Integer volo1_id, Integer volo2_id, Integer volo3_id) {
		super();
		this.volo1_id = volo1_id;
		this.volo2_id = volo2_id;
		this.volo3_id = volo3_id;
	}

}
