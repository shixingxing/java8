package province;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 功能:省市区VO
 * Created By   LiChunWei on 2019/2/18
 */
public class ProvinceVO implements Serializable {

    @SerializedName("name")
    private String province;//省
    @SerializedName("sub")
    private List<CityVO> cityList;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<CityVO> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityVO> cityList) {
        this.cityList = cityList;
    }

    public static class CityVO implements Serializable {
        public CityVO(String city) {
            this.city = city;
        }

        @SerializedName("name")
        private String city;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }


}
