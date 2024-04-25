package tv;

public class TV {
	private int volume;		// 0 ~ 10
	private int channel;	//1~255 
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void status() {
		System.out.println(
				"power: " + power + 
				" channel: " + channel + 
				"  volume: " + volume);
	}
	public void power(boolean power) {
		this.power = power;
	}
	public void channel(int channel) {
		if(isPower()) {
			if(channel > 0 && channel <=255) {
				this.channel = channel;
			}
			else {
				System.out.println("해당 채널이 없습니다.");
			}
		}
	}
	
	public void channel(boolean b) {
		if (isPower()) {
			if(b) {
				if(channel < 255) {
					channel++;
				}
				else {
					channel = 255;
				}
			}
			else {
				if(channel > 1) {
					channel--;
				}
				else {
					channel = 1;
				}
			}
		}
	}
	public void volume(int volume) {
		if(isPower()) {
			if(volume >= 0 && volume <= 100) {
				this.volume = volume;
			}
			else {
				System.out.println("그 수치로는 설정할 수 없습니다.");
			}
		}
	}
	
	
	public void volume(boolean s) {
		if(isPower()) {
			if(s) {
				if(this.volume <= 100) {
					this.volume++;
				}
				else {
					this.volume = 100;
				}
			}
			else {
				if(this.volume <= 0) {
					this.volume = 0;
				}
				else {
					this.volume --;
				}
			}
		}
			
	}
	

	public int getVolume() {
		return volume;
	}
	public int getChannel() {
		return channel;
	}
	public boolean isPower() {
		return power;
	}


}
