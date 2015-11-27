package bean;

import java.util.List;

public class weather {
	String error;
	String status;
	String  date;
	List <results> results;
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<results> getResults() {
		return results;
	}

	public void setResults(List<results> results) {
		this.results = results;
	}

	public class results {
		String currentCity;
		String pm25;
		List<index_value> index;
		List<weather_data_value> weather_data;
		
		public String getCurrentCity() {
			return currentCity;
		}
		
		public void setCurrentCity(String currentCity) {
			this.currentCity = currentCity;
		}
		
		public String getPm25() {
			return pm25;
		}
		
		public void setPm25(String pm25) {
			this.pm25 = pm25;
		}
		
		public List<index_value> getIndex() {
			return index;
		}
	
		public void setIndex(List<index_value> index) {
			this.index = index;
		}
	
		public List<weather_data_value> getWeather_data() {
			return weather_data;
		}
	
		public void setWeather_data(List<weather_data_value> weather_data) {
			this.weather_data = weather_data;
		}
	
		public class index_value{
			String title;
			String zs;
			String tipt;
			String des;
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getZs() {
				return zs;
			}
			public void setZs(String zs) {
				this.zs = zs;
			}
			public String getTipt() {
				return tipt;
			}
			public void setTipt(String tipt) {
				this.tipt = tipt;
			}
			public String getDes() {
				return des;
			}
			public void setDes(String des) {
				this.des = des;
			}
		}
		
		
		public class weather_data_value{
			String date;
			String dayPictureUrl;
			String nightPictureUrl;
			String weather;
			String wind;
			String temperature;
			public String getDate() {
				return date;
			}
			public void setDate(String date) {
				this.date = date;
			}
			public String getDayPictureUrl() {
				return dayPictureUrl;
			}
			public void setDayPictureUrl(String dayPictureUrl) {
				this.dayPictureUrl = dayPictureUrl;
			}
			public String getNightPictureUrl() {
				return nightPictureUrl;
			}
			public void setNightPictureUrl(String nightPictureUrl) {
				this.nightPictureUrl = nightPictureUrl;
			}
			public String getWeather() {
				return weather;
			}
			public void setWeather(String weather) {
				this.weather = weather;
			}
			public String getWind() {
				return wind;
			}
			public void setWind(String wind) {
				this.wind = wind;
			}
			public String getTemperature() {
				return temperature;
			}
			public void setTemperature(String temperature) {
				this.temperature = temperature;
			}
		}
		
	}
}
