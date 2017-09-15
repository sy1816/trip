package recommend;

import java.util.Arrays;

public class tourspotStasticVO {
	private int id;
	private String name;
	private int gender_c[];
	private int month_c[];
	private int nation_c[];
	private int purpose_c[];
	private int with_c[];
	private int job_c[];
	
	tourspotStasticVO(){
		id = 0;
		name = null;
		gender_c = new int[2];
		month_c = new int[12];
		nation_c = new int[16];
		purpose_c = new int[7];
		with_c = new int[5];
		job_c = new int[12];
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getGender_c() {
		return gender_c;
	}

	public void setGender_c(int[] gender_c) {
		this.gender_c = gender_c;
	}

	public int[] getMonth_c() {
		return month_c;
	}

	public void setMonth_c(int[] month_c) {
		this.month_c = month_c;
	}

	public int[] getNation_c() {
		return nation_c;
	}

	public void setNation_c(int[] nation_c) {
		this.nation_c = nation_c;
	}

	public int[] getPurpose_c() {
		return purpose_c;
	}

	public void setPurpose_c(int[] purpose_c) {
		this.purpose_c = purpose_c;
	}

	public int[] getWith_c() {
		return with_c;
	}

	public void setWith_c(int[] with_c) {
		this.with_c = with_c;
	}

	public int[] getJob_c() {
		return job_c;
	}

	public void setJob_c(int[] job_c) {
		this.job_c = job_c;
	}

	@Override
	public String toString() {
		return "tourspotStasticVO [id=" + id + ", name=" + name + ", gender_c=" + Arrays.toString(gender_c)
				+ ", month_c=" + Arrays.toString(month_c) + ", nation_c=" + Arrays.toString(nation_c) + ", purpose_c="
				+ Arrays.toString(purpose_c) + ", with_c=" + Arrays.toString(with_c) + ", job_c="
				+ Arrays.toString(job_c) + "]";
	}

}
