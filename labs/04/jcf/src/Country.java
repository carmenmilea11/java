public class Country {
    private int idCountry;
    private String countryName;

    public Country(int idCountry, String countryName) {
        this.idCountry = idCountry;
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "idCountry=" + idCountry +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
