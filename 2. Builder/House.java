public class House {
  private String basement;
  private String structure;
  private String roof;
  private String interior;

  private House(HouseBuilder builder) {
    this.basement = builder.basement;
    this.structure = builder.structure;
    this.roof = builder.roof;
    this.interior = builder.interior;
  }

  public static class HouseBuilder {
    private String basement;
    private String structure;
    private String roof;
    private String interior;

    public HouseBuilder withBasement(String basement) {
      this.basement = basement;
      return this;
    }

    public HouseBuilder withStructure(String structure) {
      this.structure = structure;
      return this;
    }

    public HouseBuilder withRoof(String roof) {
      this.roof = roof;
      return this;
    }

    public HouseBuilder withInterior(String interior) {
      this.interior = interior;
      return this;
    }

    public House build() {
      return new House(this);
    }
  }

  @Override
  public String toString() {
    return "House{" +
        "basement='" + basement + '\'' +
        ", structure='" + structure + '\'' +
        ", roof='" + roof + '\'' +
        ", interior='" + interior + '\'' +
        '}';
  }
}
