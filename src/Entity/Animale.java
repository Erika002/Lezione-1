package Entity;
import java.util.Date;

public class Animale {
   private String specie;
   private String nome;
   private String ciboPreferito;
   private Integer eta;
   private Date dataIngresso;
   private Double peso;
   private Double altezza;
   private Double misura;


   public Animale() {}
    public Animale(String specie, String nome, String ciboPreferito, Integer eta, Date dataIngresso, Double peso, Double altezza, Double misura) {
       this.specie = specie;
       this.nome = nome;
       this.ciboPreferito = ciboPreferito;
       this.eta = eta;
       this.dataIngresso = dataIngresso;
       this.peso = peso;
       this.altezza = altezza;
       this.misura = misura;
    }

   public String getSpecie() {
      return specie;
   }

   public void setSpecie(String specie) {
      this.specie = specie;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCiboPreferito() {
      return ciboPreferito;
   }

   public void setCiboPreferito(String ciboPreferito) {
      this.ciboPreferito = ciboPreferito;
   }

   public Integer getEta() {
      return eta;
   }

   public void setEta(Integer eta) {
      this.eta = eta;
   }

   public Date getDataIngresso() {
      return dataIngresso;
   }

   public void setDataIngresso(Date dataIngresso) {
      this.dataIngresso = dataIngresso;
   }

   public Double getPeso() {
      return peso;
   }

   public void setPeso(Double peso) {
      this.peso = peso;
   }

   public Double getAltezza() {
      return altezza;
   }

   public void setAltezza(Double altezza) {
      this.altezza = altezza;
   }

   public Double getMisura() {
      return misura;
   }

   public void setMisura(Double misura) {
      this.misura = misura;
   }

   @Override
   public String toString() {
      return "Animale{" +
              "specie='" + specie + '\'' +
              ", nome='" + nome + '\'' +
              ", ciboPreferito='" + ciboPreferito + '\'' +
              ", eta=" + eta +
              ", dataIngresso=" + dataIngresso +
              ", peso=" + peso +
              ", altezza=" + altezza +
              ", misura=" + misura +
              '}';
   }
}
